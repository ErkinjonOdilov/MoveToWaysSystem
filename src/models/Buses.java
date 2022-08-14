package models;

public class Buses {
    private int id;
    private String name;
    private Enum busclass;
    private boolean isactive;

    public Buses(int id, String name, Enum busclass, boolean isactive) {
        this.id = id;
        this.name = name;
        this.busclass = busclass;
        this.isactive = isactive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Enum getBusclass() {
        return busclass;
    }

    public void setBusclass(Enum busclass) {
        this.busclass = busclass;
    }

    public boolean isIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    @Override
    public String toString() {
        return "Buses{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", busclass=" + busclass +
                ", isactive=" + isactive +
                '}';
    }
}
