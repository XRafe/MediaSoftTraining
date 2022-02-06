package dateapi;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Data {
    private Integer id;

    private String data;

    private LocalDateTime dateCreate;

    public Data(Integer id, String data, LocalDateTime dateCreate) {
        this.id = id;
        this.data = data;
        this.dateCreate = dateCreate;
    }

    public Integer getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

}
