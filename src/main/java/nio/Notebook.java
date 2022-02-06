package nio;



public class Notebook {

    private Integer id;

    private String firmNotebook;

    private String price;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirmNotebook(String firmNotebook) {
        this.firmNotebook = firmNotebook;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getFirmNotebook() {
        return firmNotebook;
    }

    public String getPrice() {
        return price;
    }

    public String toString () {
        return "\n ID= " + getId() + " | Фирма= " + getFirmNotebook() + " | Цена= " + getPrice();
    }

}
