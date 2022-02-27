package interface_abstract;

import interface_abstract.abstr.AllCar;
import interface_abstract.interfaces.Car;

public class IA {

    public static void main(String args[]) {
        new IA().init();
    }

    private void init () {
        Race sportCar = new Race("sportCar", new SportCar(), new SportCar());
        Race defaultCar = new Race("defaultCar", new DefaultCar(), new DefaultCar());

        sportCar.start();
        defaultCar.start();
    }

    private class Race extends Thread {

        private AllCar allCar;

        private Car car;

        public Race(String name, AllCar allCar, Car car) {
            super(name);
            this.allCar = allCar;
            this.car = car;
        }

        @Override
        public void run() {
            try {
                if (Thread.currentThread().getName().equals("sportCar")) {
                    allCar.accelerationTurbo();
                    System.out.println(car.right());
                    System.out.println(car.left());
                    System.out.println(car.stopCar() + " car: " + Thread.currentThread().getName());
                }
                if (Thread.currentThread().getName().equals("defaultCar")) {
                    allCar.acceleration();
                    System.out.println(car.right());
                    System.out.println(car.left());
                    System.out.println(car.stopCar() + " car: " + Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
