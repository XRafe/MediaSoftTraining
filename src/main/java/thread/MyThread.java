package thread;

import thread.interaction.CargoInteraction;
import thread.interaction.PlaneInteraction;
import thread.table.Cargo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyThread extends Thread {

    private List<Cargo> threadCargo = new ArrayList<>();

    private List<Cargo> queueOnDelete = new ArrayList<>();

    private final CargoInteraction cargoService;
    private final PlaneInteraction planeService;

    MyThread(String name, CargoInteraction cargoInteraction, PlaneInteraction planeInteraction) {
        super(name);
        this.planeService = planeInteraction;
        this.cargoService = cargoInteraction;
    }

    public void choiceCargo() {
        for (Cargo cargo : cargoService.getCargos()) {
            if (Thread.currentThread().getName().equals(cargo.getTypeCargo().toString())) {
                threadCargo.add(cargo);
            }
        }
    }

    public void addNewPlain() {
        for (Cargo cargo : threadCargo) {
            if (!cargo.isStatusOnDelete()) {
                Integer temp = Math.toIntExact(planeService.getPlanes().stream().count() + 1);
                planeService.addPlane(temp, "Plane_Full", cargo.getPointACargo(),
                        cargo.getPointBCargo(), LocalDateTime.now());
                System.out.println("Добавлен самолёт");
            }
        }
    }

    public void run() {
        Iterator it = queueOnDelete.iterator();

        System.out.println("Thread: " + Thread.currentThread().getName() + " started");
        try {
            choiceCargo();
            while (threadCargo.stream().count() != queueOnDelete.stream().count()) {
                for (Cargo cargo : threadCargo) {
                    if (!cargo.isStatusOnDelete()) {
                        if (planeService.choicePlane(cargo.getId(), cargo.getTypeCargo(),
                                cargo.getSizeCargo(), cargo.getPointACargo(),
                                cargo.getPointBCargo())) {
                            cargo.setStatusOnDelete(true);
                            queueOnDelete.add(cargo);
                            System.out.println("Товар номер: " + cargo.getId() +
                                    " помещен на борт");
                        }

                    }
                }
                if (cargoService.getCargos().stream().count() != queueOnDelete.stream().count()) {
                    addNewPlain();
                }
            }
            while (it.hasNext()) {
                cargoService.deleteList(it);
                it.next();
            }

        } catch (java.util.ConcurrentModificationException e) {
            System.out.println("Foreach не любит изменения размера коллекции(ТутТипаОшибка), " +
                    "в будущем пофиксим)");
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Thread: " + Thread.currentThread().getName() + " finished");
    }

}
