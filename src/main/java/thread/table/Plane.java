package thread.table;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Plane {

    private final Integer id;

    private final String namePlane;

    private final String pointA;

    private final String pointB;

    private final LocalDateTime timePlane;

    private final List<PlaneParts> planeParts;

    private List<Cargo> cargoInPlane = new ArrayList<>();

    public Plane(Integer id, String namePlane, String pointA,
                 String pointB, LocalDateTime timePlane,
                 List<PlaneParts> planeParts) {
        this.id = id;
        this.namePlane = namePlane;
        this.pointA = pointA;
        this.pointB = pointB;
        this.timePlane = timePlane;
        this.planeParts = planeParts;
    }

    public Integer getId() {
        return id;
    }

    public void setCargoInPlane(Integer id, Enum type, Integer size, String A, String B) {
        this.cargoInPlane.add(new Cargo(id, type.ordinal(), size, A, B));
    }

    public String getNamePlane() {
        return namePlane;
    }

    public String getPointA() {
        return pointA;
    }

    public String getPointB() {
        return pointB;
    }

    public LocalDateTime getTimePlane() {
        return timePlane;
    }

    public List<PlaneParts> getPlaneParts() {
        return planeParts;
    }

    public List<Cargo> getCargoInPlane() {
        return cargoInPlane;
    }


    public boolean getByName(String name, Integer count) {
        for (PlaneParts planeParts : planeParts) {
            if (planeParts.getName().equals(name)) {
                for (Integer i = 0; i < Arrays.stream(planeParts.getSize()).count(); i++) {
                    if (planeParts.getSize()[i] > count) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


}

