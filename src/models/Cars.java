package models;

public class Cars {
    private int id;
    private String name;
    private Enum carclass;
    private boolean isactive;

    public Cars(int id, String name, Enum carclass, boolean isactive) {
        this.id = id;
        this.name = name;
        this.carclass = carclass;
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

    public Enum getCarclass() {
        return carclass;
    }

    public void setCarclass(Enum carclass) {
        this.carclass = carclass;
    }

    public boolean isIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", carclass=" + carclass +
                ", isactive=" + isactive +
                '}';
    }
}
