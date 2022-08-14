package models;

public class Trains {
    private int id;
    private String name;
    private Enum trainclass;
    private boolean isactive;

    public Trains(int id, String name, Enum trainclass, boolean isactive) {
        this.id = id;
        this.name = name;
        this.trainclass = trainclass;
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

    public Enum getTrainclass() {
        return trainclass;
    }

    public void setTrainclass(Enum trainclass) {
        this.trainclass = trainclass;
    }

    public boolean isIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    @Override
    public String toString() {
        return "Trains{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", trainclass=" + trainclass +
                ", isactive=" + isactive +
                '}';
    }
}
