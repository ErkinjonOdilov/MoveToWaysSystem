package models.Ways;

public class AirWays {
    private int id;
    private String current_place;
    private String to_place;
    private int which_plane;
    private double money;

    public AirWays(int id, String current_place, String to_place, int which_plane, double money) {
        this.id = id;
        this.current_place = current_place;
        this.to_place = to_place;
        this.which_plane = which_plane;
        this.money = money;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurrent_place() {
        return current_place;
    }

    public void setCurrent_place(String current_place) {
        this.current_place = current_place;
    }

    public String getTo_place() {
        return to_place;
    }

    public void setTo_place(String to_place) {
        this.to_place = to_place;
    }

    public int getWhich_plane() {
        return which_plane;
    }

    public void setWhich_plane(int which_plane) {
        this.which_plane = which_plane;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "AirWays{" +
                "id=" + id +
                ", current_place='" + current_place + '\'' +
                ", to_place='" + to_place + '\'' +
                ", which_plane=" + which_plane +
                ", money=" + money +
                '}';
    }
}
