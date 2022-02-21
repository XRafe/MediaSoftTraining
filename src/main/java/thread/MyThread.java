package thread;

import thread.interaction.CargoInteraction;
import thread.interaction.PlaneInteraction;
import thread.num.TypeCargo;
import thread.table.Cargo;
import thread.table.Plane;

import java.time.LocalDateTime;
import java.util.Iterator;

public class MyThread extends Thread {

    private final CargoInteraction cargoService;
    private final PlaneInteraction planeService;

    MyThread(String name, CargoInteraction cargoInteraction, PlaneInteraction planeInteraction) {
        super(name);
        this.planeService = planeInteraction;
        this.cargoService = cargoInteraction;
    }


    public void addNewPlain() {
        for (Cargo cargo : cargoService.getCargos()) {
                if (!cargo.isStatusOnDelete()) {
                    Integer temp = Math.toIntExact(planeService.getPlanes().stream().count() + 1);
                    planeService.addPlane(temp, "Plane_Full", cargo.getPointACargo(),
                            cargo.getPointBCargo(), LocalDateTime.now());
                    System.out.println("Добавлен самолёт");
                }
        }

    }


    public void run() {
        Iterator it = cargoService.queueOnDelete.iterator();

        System.out.println("Thread: " + Thread.currentThread().getName() + " started");
        try {
            while (cargoService.getCargos().stream().count() != cargoService.queueOnDelete.stream().count()) {
                for (Cargo cargo : cargoService.getCargos()) {
                    if (!cargo.isStatusOnDelete()) {
                        for (Plane plane : planeService.getPlanes()) {
                            if (cargo.getPointACargo().equals(plane.getPointA()) &
                                    cargo.getPointBCargo().equals(plane.getPointB())) {
                                if (TypeCargo.JUST.equals(cargo.getTypeCargo())) {
                                    if (plane.getByName("Just", cargo.getSizeCargo())) {
                                        if (planeService.checkFree(plane.getId(),
                                                cargo.getSizeCargo(), "Just")) {
                                            plane.setCargoInPlane(cargo.getId(), cargo.getTypeCargo(),
                                                    cargo.getSizeCargo(), cargo.getPointACargo(),
                                                    cargo.getPointBCargo());
                                            cargo.setStatusOnDelete(true);
                                            cargoService.queueOnDelete.add(cargo);
                                            System.out.println("Товар номер: " + cargo.getId() +
                                                    " помещен на борт: " + plane.getNamePlane());
                                        }
                                    }
                                } else if (TypeCargo.ANIMAL.equals(cargo.getTypeCargo())) {
                                    if (plane.getByName("Tightness", cargo.getSizeCargo())) {
                                        if (planeService.checkFree(plane.getId(),
                                                cargo.getSizeCargo(), "Tightness")) {

                                            plane.setCargoInPlane(cargo.getId(), cargo.getTypeCargo(),
                                                    cargo.getSizeCargo(), cargo.getPointACargo(),
                                                    cargo.getPointBCargo());
                                            cargo.setStatusOnDelete(true);
                                            cargoService.queueOnDelete.add(cargo);
                                            System.out.println("Товар номер: " + cargo.getId() +
                                                    " помещен на борт: " + plane.getNamePlane());
                                        }
                                    }
                                } else if (TypeCargo.DANGER.equals(cargo.getTypeCargo())) {
                                    if (plane.getByName("Just", cargo.getSizeCargo())) {
                                        if (planeService.checkFree(plane.getId(),
                                                cargo.getSizeCargo(), "Just")) {
                                            plane.setCargoInPlane(cargo.getId(), cargo.getTypeCargo(),
                                                    cargo.getSizeCargo(), cargo.getPointACargo(),
                                                    cargo.getPointBCargo());
                                            cargo.setStatusOnDelete(true);
                                            cargoService.queueOnDelete.add(cargo);
                                            System.out.println("Товар номер: " + cargo.getId() +
                                                    " помещен на борт: " + plane.getNamePlane());
                                        }
                                    }
                                } else if (TypeCargo.FOOD.equals(cargo.getTypeCargo())) {
                                    if (plane.getByName("Thermal", cargo.getSizeCargo())) {
                                        if (planeService.checkFree(plane.getId(),
                                                cargo.getSizeCargo(), "Thermal")) {
                                            plane.setCargoInPlane(cargo.getId(), cargo.getTypeCargo(),
                                                    cargo.getSizeCargo(), cargo.getPointACargo(),
                                                    cargo.getPointBCargo());
                                            cargo.setStatusOnDelete(true);
                                            cargoService.queueOnDelete.add(cargo);
                                            System.out.println("Товар номер: " + cargo.getId() +
                                                    " помещен на борт: " + plane.getNamePlane());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (cargoService.getCargos().stream().count() != cargoService.queueOnDelete.stream().count()) {
                    addNewPlain();
                }
            }
            while (it.hasNext()) {
                cargoService.deleteList(it);
                it.next();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Thread: " + Thread.currentThread().getName() + " finished");
    }

}
