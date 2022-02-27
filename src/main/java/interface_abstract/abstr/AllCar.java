package interface_abstract.abstr;

public abstract class AllCar {

    private final Integer maxSpeed = 100;

    public void acceleration() throws InterruptedException {}

    public void accelerationTurbo() throws InterruptedException {}

    public Integer getMaxSpeed() {
        return maxSpeed;
    }


}
