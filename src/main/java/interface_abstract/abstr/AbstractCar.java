package interface_abstract.abstr;

import interface_abstract.interfaces.Car;

public abstract class AbstractCar implements Car {

    private final Integer maxSpeed = 100;

    public void acceleration() throws InterruptedException {
    }

    public void accelerationTurbo() throws InterruptedException {
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

}
