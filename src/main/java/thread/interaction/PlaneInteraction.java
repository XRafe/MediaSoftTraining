package thread.interaction;

import thread.table.Cargo;
import thread.table.Plane;
import thread.table.PlaneParts;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PlaneInteraction {

    private final List<Plane> planes = new ArrayList<>();

    private List<PlaneParts> planeParts;

    public void addPlane(Integer id, String namePlane, String pointA,
                         String pointB, LocalDateTime timePlane) {
        configPlane(namePlane);
        planes.add(new Plane(id, namePlane, pointA, pointB, timePlane, this.planeParts));
    }

    public void configPlane(String name) {
        planeParts = new ArrayList<>();
        Integer count = 0;
        switch (name) {
            case ("Plane_Full"):
                count = 3;
                break;
            case ("Plane_Medium"):
                count = 2;
                break;
            case ("Plane_Little"):
                count = 1;
                break;
        }
        planeParts.add(new PlaneParts("Just", 50, count));
        planeParts.add(new PlaneParts("Thermal", 50, count));
        planeParts.add(new PlaneParts("Tightness", 50, count));
    }

    public List<Plane> getPlanes() {
        return planes;
    }

    public boolean checkOtherType(Integer id, Enum type) {
        for (Plane plane : planes) {
            if (plane.getId().equals(id)) {
                for (PlaneParts planePart : plane.getPlaneParts()) {
                    for (Integer i = 0; i < planePart.getCount(); i++)
                        if (planePart.getSize()[i].equals(planePart.getCheckSize())) {
                            for (Cargo cargo : plane.getCargoInPlane()) {
                                if (cargo.getTypeCargo().equals(type)) {
                                    return true;
                                }
                            }
                        }
                }
            }
        }
        System.out.println("Нет места для добавления груза!");
        return false;
    }

    public boolean checkFree(Integer id, Integer weight, String name) {
        for (Plane plane : planes) {
            if (plane.getId().equals(id)) {
                for (PlaneParts planePart : plane.getPlaneParts()) {
                    for (Integer i = 0; i < planePart.getCount(); i++) {
                        if (planePart.getName().equals(name)) {
                            if (planePart.getSize()[i] > weight) {
                                System.out.println("Грузы был добавлен в самолёт" + plane.getNamePlane() +
                                        " в отсек: " + planePart.getName() + " номер: " + i);
                                planePart.setSize(planePart.getSize()[i] - weight, i);
                                System.out.println("Осталось места: " + planePart.getSize()[i]);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Место в самолете:" + id + " найдено не было!");
        return false;
    }
}