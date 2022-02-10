package thread.interaction;

import thread.table.Cargo;

import java.util.ArrayList;
import java.util.List;

public class CargoInteraction {

    List<Cargo> cargos = new ArrayList<>();

    public void addCargo(Integer id, Integer type, Integer sizeCargo,
                         String pointA, String pointB) {
        cargos.add(new Cargo(id, type, sizeCargo, pointA, pointB));
    }

    public List<Cargo> getCargos() {
        return cargos;
    }

    public void deleteList(Object o) {
        cargos.remove(o);
    }
}
