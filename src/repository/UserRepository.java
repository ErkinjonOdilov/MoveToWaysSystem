package repository;

import controller.UserController;
import models.User;
import service.UserService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TimeZone;

public class UserRepository implements UserService {
    private Scanner scanner = new Scanner(System.in);
    private   List<User> users=new ArrayList<>();
    @Override
    public void allUsers() {
        try {
            TimeZone timeZone = TimeZone.getTimeZone("Asia/Tashkent");
            TimeZone.setDefault(timeZone);

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Instializing...");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/move_to_ways?serverTimezone=UTC", "root", "root");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(" select *from user;");
            System.out.printf("%8s\t%12s\t%12s\t%12s\t%20s\t%23s\t%25s\t%12s\t%12s\t%12s\n", ("id"), ("fullname"), ("birthday"), ("number"), ("email"), ("birthPlace"), ("login"), ("password"), ("card_number"), ("card_balance"));
            while (resultSet.next()) {
                System.out.printf("%8s\t%12s\t%12s\t%12s\t%12s\t%15s\t%8s\t%10s\t%12s\t%11s\n",
                        resultSet.getInt("id"),
                        resultSet.getString("fullname"),
                        resultSet.getString("birthday"),
                        resultSet.getString("number"),
                        resultSet.getString("email"),
                        resultSet.getString("birthPlace"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getLong("card_number"),
                        resultSet.getLong("card_balance"));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void registration() {
        try {
            TimeZone timeZone = TimeZone.getTimeZone("Asia/Tashkent");
            TimeZone.setDefault(timeZone);

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/move_to_ways?serverTimezone=UTC", "root", "root");
            System.out.print("Full Name:");
            scanner = new Scanner(System.in);
            String fullName = scanner.nextLine();
            System.out.print("Birthday:");
            scanner = new Scanner(System.in);
            String birthday = scanner.nextLine();
            System.out.print("Phone Number:");
            scanner = new Scanner(System.in);
            String number = scanner.nextLine();
            System.out.print("Email:");
            scanner = new Scanner(System.in);
            String email = scanner.nextLine();
            System.out.print("Birth Place:");
            scanner = new Scanner(System.in);
            String birthPlace = scanner.nextLine();
            System.out.print("Login:");
            scanner = new Scanner(System.in);
            String login = scanner.nextLine();
            System.out.print("Password:");
            scanner = new Scanner(System.in);
            String password = scanner.nextLine();
            System.out.print("Card Number:");
            Long card_number = scanner.nextLong();
            System.out.print("Card Balance:");
            Long card_balance = scanner.nextLong();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user(fullName,birthday,number,email,birthPlace,login,password,card_number,card_balance) VALUE (?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, birthday);
            preparedStatement.setString(3, number);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, birthPlace);
            preparedStatement.setString(6, login);
            preparedStatement.setString(7, password);
            preparedStatement.setLong(8, card_number);
            preparedStatement.setLong(9, card_balance);
            preparedStatement.executeUpdate();
            System.out.println("Successfully added");
            System.out.println("You can entered the system by login and password");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void enterTheSystem() {

        System.out.print("Enter the login: ");
        String login = scanner.next();
        System.out.print("Enter the password: ");
        String password = scanner.next();
        try {
            TimeZone timeZone = TimeZone.getTimeZone("Asia/Tashkent");
            TimeZone.setDefault(timeZone);

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Instializing...");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/move_to_ways?serverTimezone=UTC", "root", "root");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * FROM user;");
            while (resultSet.next()){
                User u1=new User(resultSet.getInt("id"),
                        resultSet.getString("fullname"),
                        resultSet.getString("birthday"),
                        resultSet.getString("number"),
                        resultSet.getString("email"),
                        resultSet.getString("birthPlace"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getLong("card_number"),
                        resultSet.getLong("card_balance"));
                users.add(u1);

            }
            boolean isHave=false;
            int userID;

            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getLogin().equals(login) && users.get(i).getPassword().equals(password)) {
                    isHave=true;
                    userID=users.get(i).getId();
                    break;
                }
            }
           if(isHave){
               UserController u2=new UserController();
               u2.menu();
           }else {
               System.out.println("Password or login incorrect\nOr There is not your information in Data Base");
           }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void myselfInfo() {

    }
}
