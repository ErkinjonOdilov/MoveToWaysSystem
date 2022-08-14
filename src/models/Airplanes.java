package models;

public class Airplanes {
    private int id;
    private String name;
    private Enum planeclass;
    private boolean isactive;

    public Airplanes(int id, String name, Enum planeclass, boolean isactive) {
        this.id = id;
        this.name = name;
        this.planeclass = planeclass;
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

    public Enum getPlaneclass() {
        return planeclass;
    }

    public void setPlaneclass(Enum planeclass) {
        this.planeclass = planeclass;
    }

    public boolean isIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    @Override
    public String toString() {
        return "Airplanes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", planeclass=" + planeclass +
                ", isactive=" + isactive +
                '}';
    }
}
