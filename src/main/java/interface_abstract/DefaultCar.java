package interface_abstract;

import interface_abstract.abstr.AllCar;
import interface_abstract.interfaces.Car;

import java.util.concurrent.TimeUnit;

public class DefaultCar extends AllCar implements Car {

    private Integer timeAcceleration = 16000;

    public DefaultCar() {
    }

    @Override
    public void acceleration() throws InterruptedException {
        System.out.println("Speed: ");
        for (Integer i=0; i<=getMaxSpeed(); i++) {
            TimeUnit.MILLISECONDS.sleep(timeAcceleration/getMaxSpeed());
            if (i % 20 == 0) {
                System.out.println(i + " km/h :: DefCar");
            }
        }
    }

    @Override
    public String stopCar() {
        return "Just car stopped";
    }

    @Override
    public String left() {
        return "Just car driving turned left";
    }

    @Override
    public String right() {
        return "Just car driving turned right";
    }
}
