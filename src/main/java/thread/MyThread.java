package thread;

import thread.interaction.CargoInteraction;
import thread.interaction.PlaneInteraction;
import thread.num.TypeCargo;
import thread.table.Cargo;
import thread.table.Plane;

public class MyThread extends Thread {

    private final CargoInteraction cargoService;
    private final PlaneInteraction planeService;


    MyThread(String name, CargoInteraction cargoInteraction, PlaneInteraction planeInteraction) {
        super(name);
        this.planeService = planeInteraction;
        this.cargoService = cargoInteraction;
    }


    public void run() {
        System.out.println("Thread: " + Thread.currentThread().getName() + " started");
        try {
            for (Cargo cargo : cargoService.getCargos()) {
                for (Plane plane : planeService.getPlanes()) {
                    if (cargo.getPointACargo().equals(plane.getPointA()) &
                            cargo.getPointBCargo().equals(plane.getPointB())) {
                        if (TypeCargo.JUST.equals(cargo.getTypeCargo())
                                & Thread.currentThread().getName() == "justT") {
                            if (plane.getByName("Just", cargo.getSizeCargo())) {
                                if (planeService.checkFree(plane.getId(), cargo.getSizeCargo(), "Just") &
                                        planeService.checkOtherType(plane.getId(), cargo.getTypeCargo())) {

                                    plane.setCargoInPlane(cargo.getId(), cargo.getTypeCargo(),
                                            cargo.getSizeCargo(), cargo.getPointACargo(),
                                            cargo.getPointBCargo());
                                    cargoService.deleteList(cargo.getId());
                                    System.out.println("Товар номер: " + cargo.getId() +
                                            " помещен на борт: " + plane.getNamePlane());
                                }
                            }
                        } else if (TypeCargo.ANIMAL.equals(cargo.getTypeCargo())
                                & Thread.currentThread().getName() == "animalT") {
                            if (plane.getByName("Tightness", cargo.getSizeCargo())) {
                                if (planeService.checkFree(plane.getId(),
                                        cargo.getSizeCargo(), "Tightness")) {

                                    plane.setCargoInPlane(cargo.getId(), cargo.getTypeCargo(),
                                            cargo.getSizeCargo(), cargo.getPointACargo(),
                                            cargo.getPointBCargo());
                                    cargoService.deleteList(cargo.getId());
                                    System.out.println("Товар номер: " + cargo.getId() +
                                            " помещен на борт: " + plane.getNamePlane());
                                }
                            }
                        } else if (TypeCargo.DANGER.equals(cargo.getTypeCargo())
                                & Thread.currentThread().getName() == "dangerT") {
                            if (plane.getByName("Just", cargo.getSizeCargo())) {
                                if (planeService.checkFree(plane.getId(),
                                        cargo.getSizeCargo(), "Just") &
                                        planeService.checkOtherType(plane.getId(), cargo.getTypeCargo())) {
                                    plane.setCargoInPlane(cargo.getId(), cargo.getTypeCargo(),
                                            cargo.getSizeCargo(), cargo.getPointACargo(),
                                            cargo.getPointBCargo());
                                    cargoService.deleteList(cargo.getId());
                                    System.out.println("Товар номер: " + cargo.getId() +
                                            " помещен на борт: " + plane.getNamePlane());
                                }
                            }
                        } else if (TypeCargo.FOOD.equals(cargo.getTypeCargo())
                                & Thread.currentThread().getName() == "foodT") {
                            if (plane.getByName("Thermal", cargo.getSizeCargo())) {
                                if (planeService.checkFree(plane.getId(),
                                        cargo.getSizeCargo(), "Thermal")) {
                                    plane.setCargoInPlane(cargo.getId(), cargo.getTypeCargo(),
                                            cargo.getSizeCargo(), cargo.getPointACargo(),
                                            cargo.getPointBCargo());
                                    cargoService.deleteList(cargo.getId());
                                    System.out.println("Товар номер: " + cargo.getId() +
                                            " помещен на борт: " + plane.getNamePlane());
                                }
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Thread: " + Thread.currentThread().getName() + " finished");
    }

}
