package thread.table;

import thread.num.TypeCargo;

public class Cargo {

    private final Integer id;

    private final TypeCargo typeCargo;

    private final Integer sizeCargo;

    private final String pointACargo;

    private final String pointBCargo;

    private boolean statusOnDelete;

    public Cargo(Integer id, Integer typeCargo,
                 Integer sizeCargo, String pointACargo,
                 String pointBCargo) {
        this.id = id;
        this.typeCargo = TypeCargo.values()[typeCargo];
        this.sizeCargo = sizeCargo;
        this.pointACargo = pointACargo;
        this.pointBCargo = pointBCargo;
        this.statusOnDelete = false;
    }

    public void setStatusOnDelete(boolean statusOnDelete) {
        this.statusOnDelete = statusOnDelete;
    }

    public boolean isStatusOnDelete() {
        return statusOnDelete;
    }

    public Integer getId() {
        return id;
    }

    public TypeCargo getTypeCargo() {
        return typeCargo;
    }

    public Integer getSizeCargo() {
        return sizeCargo;
    }

    public String getPointACargo() {
        return pointACargo;
    }

    public String getPointBCargo() {
        return pointBCargo;
    }

}
