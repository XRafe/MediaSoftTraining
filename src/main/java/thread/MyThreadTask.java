package thread;

import thread.interaction.CargoInteraction;
import thread.interaction.PlaneInteraction;

import java.time.LocalDateTime;

public class MyThreadTask {

    LocalDateTime timePlane = LocalDateTime.now();

    private final PlaneInteraction planeInteraction = new PlaneInteraction();
    private final CargoInteraction cargoInteraction = new CargoInteraction();

    public static void main(String[] args) {
        new MyThreadTask().init();
    }


    public void init() {
        addPlane();
        addCargo();
        actionWithCargo();
    }

    /*
    Типы груза:
    1 - обычный
    2 - животные
    3 - опасные вещества
    4 - продукты
    */
    public void addCargo() {
        cargoInteraction.addCargo(0, 0, 5, "Москва", "Самара");
        cargoInteraction.addCargo(1, 1, 10, "Москва", "Самара");
        cargoInteraction.addCargo(2, 2, 15, "Москва", "Ульяновск");
        cargoInteraction.addCargo(3, 3, 20, "Москва", "Санкт-Петербург");
        cargoInteraction.addCargo(4, 0, 45, "Москва", "Самара");
        cargoInteraction.addCargo(5, 1, 45, "Москва", "Самара");
        cargoInteraction.addCargo(6, 2, 45, "Москва", "Ульяновск");
        cargoInteraction.addCargo(7, 3, 45, "Москва", "Санкт-Петербург");

    }

    public void addPlane() {
        planeInteraction.addPlane(1, "Plane_Full", "Москва",
                "Самара", timePlane);
        planeInteraction.addPlane(2, "Plane_Medium", "Москва",
                "Ульяновск", timePlane);
        planeInteraction.addPlane(3, "Plane_Little", "Москва",
                "Санкт-Петербург", timePlane);
    }

    public void actionWithCargo() {
        MyThread justT = new MyThread("justT", cargoInteraction, planeInteraction);
        MyThread animalT = new MyThread("animalT", cargoInteraction, planeInteraction);
        MyThread dangerT = new MyThread("dangerT", cargoInteraction, planeInteraction);
        MyThread foodT = new MyThread("foodT", cargoInteraction, planeInteraction);

        animalT.setPriority(10);
        foodT.setPriority(7);
        dangerT.setPriority(4);
        justT.setPriority(1);

        animalT.start();
        foodT.start();
        dangerT.start();
        justT.start();
    }
}
