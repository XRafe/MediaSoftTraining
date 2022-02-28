package interface_abstract;

import interface_abstract.abstr.AbstractCar;


public class IA {

    public static void main(String args[]) {
        new IA().init();
    }

    private void init() {
        Race sportCar = new Race("sportCar", new SportCar());
        Race defaultCar = new Race("defaultCar", new DefaultCar());

        sportCar.start();
        defaultCar.start();
    }

    private class Race extends Thread {

        private AbstractCar abstractCar;

        public Race(String name, AbstractCar abstractCar) {
            super(name);
            this.abstractCar = abstractCar;
        }

        @Override
        public void run() {
            try {
                if (Thread.currentThread().getName().equals("sportCar")) {
                    abstractCar.accelerationTurbo();
                    System.out.println(abstractCar.right());
                    System.out.println(abstractCar.left());
                    System.out.println(abstractCar.stopCar() + " car: " + Thread.currentThread().getName());
                }
                if (Thread.currentThread().getName().equals("defaultCar")) {
                    abstractCar.acceleration();
                    System.out.println(abstractCar.right());
                    System.out.println(abstractCar.left());
                    System.out.println(abstractCar.stopCar() + " car: " + Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
