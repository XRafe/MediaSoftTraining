package interface_abstract;

import interface_abstract.abstr.AbstractCar;

import java.util.concurrent.TimeUnit;

public class SportCar extends AbstractCar {

    private Integer timeAcceleration = 6000;

    @Override
    public void accelerationTurbo() throws InterruptedException {
        System.out.println("Speed: ");
        for (Integer i = 0; i <= getMaxSpeed(); i++) {
            TimeUnit.MILLISECONDS.sleep(timeAcceleration / getMaxSpeed());
            if (i % 20 == 0) {
                System.out.println(i + " km/h :: SportCar");
            }
        }
    }

    @Override
    public String stopCar() {

        return "Sport car stopped";

    }

    @Override
    public String left() {

        return "Sport car driving turned left";

    }

    @Override
    public String right() {

        return "Sport car driving turned right";

    }
}
