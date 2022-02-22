package thread.interaction;

import thread.table.Plane;
import thread.table.PlaneParts;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PlaneInteraction {

    private final List<Plane> planes = new ArrayList<>();

    private List<PlaneParts> planeParts;

    public void addPlane(Integer id, String namePlane, String pointA, String pointB, LocalDateTime timePlane) {
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

    public boolean choicePlane(Integer id, Enum type, Integer size, String A, String B) {
        String name = "";
        for (Plane plane : planes) {
            if (A.equals(plane.getPointA()) & B.equals(plane.getPointB())) {
                if (type.toString().equals("JUST")) {
                    name = checkOtherType(plane.getId(), type);
                } else if (type.toString().equals("ANIMAL")) {
                    name = "Tightness";
                } else if (type.toString().equals("DANGER")) {
                    name = checkOtherType(plane.getId(), type);
                } else if (type.toString().equals("FOOD")) {
                    name = "Thermal";
                }
                if (checkFree(plane.getId(), size, name)) {
                    plane.setCargoInPlane(id, type, size, A, B);
                    return true;
                }
            }
        }
        return false;
    }

    public String checkOtherType(Integer id, Enum type) {
        for (Plane plane : planes) {
            if (plane.getId().equals(id)) {
                for (PlaneParts planePart : plane.getPlaneParts()) {
                    for (Integer i = 0; i < planePart.getCount(); i++) {
                        if (planePart.getSize()[i].equals(planePart.getCheckSize())) {
                            return planePart.getName();
                        } else {
                            System.out.println("Проверяем следующий отсек");
                        }
                    }
                }
            }
        }
        System.out.println("Нет места для добавления груза!");
        return null;
    }

    public boolean checkFree(Integer id, Integer weight, String name) {
        for (Plane plane : planes) {
            if (plane.getId().equals(id)) {
                for (PlaneParts planePart : plane.getPlaneParts()) {
                    for (Integer i = 0; i < planePart.getCount(); i++) {
                        if (planePart.getName().equals(name)) {
                            if (planePart.getSize()[i] > weight) {
                                System.out.println("Груз был добавлен в самолёт " + plane.getNamePlane() + " в отсек: " + planePart.getName() + " номер: " + i);
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
