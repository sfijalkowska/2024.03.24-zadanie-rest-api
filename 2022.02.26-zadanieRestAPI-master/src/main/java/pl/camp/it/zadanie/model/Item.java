package pl.camp.it.zadanie.model;

public class Item {
    private String idGUID;
    private String name;

    public Item(String idGUID, String name) {
        this.idGUID = idGUID;
        this.name = name;
    }

    public Item() {
    }

    public String getIdGUID() {
        return idGUID;
    }

    public void setIdGUID(String idGUID) {
        this.idGUID = idGUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
