package models;

public class User {
    private int id;
    private String fullName;
    private String birthday;
    private String number;
    private String email;
    private String birthPlace;
    private String login;
    private String password;
    private Long card;
    private Long balance;

    public User(int id, String fullName, String birthday, String number, String email, String birthPlace, String login, String password, Long  card, Long balance) {
        this.id = id;
        this.fullName = fullName;
        this.birthday = birthday;
        this.number = number;
        this.email = email;
        this.birthPlace = birthPlace;
        this.login = login;
        this.password = password;
        this.card = card;
        this.balance = balance;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", number='" + number + '\'' +
                ", email='" + email + '\'' +
                ", birthPlace='" + birthPlace + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", card=" + card +
                ", balance=" + balance +
                '}';
    }
}
