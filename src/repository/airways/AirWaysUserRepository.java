package repository.airways;

import service.AirWayService.AirWaysUserService;

import java.sql.*;
import java.util.Scanner;
import java.util.TimeZone;

public class AirWaysUserRepository implements AirWaysUserService {
    private Scanner scanner=new Scanner(System.in);

    @Override
    public void userMenu() {
        boolean IsTrue = true;
        while (IsTrue) {
            System.out.println("\t\t\tWELCOME TO USERS MANAGE SYSTEM");
            System.out.println("Choose option: ");
            System.out.println("1->ADD USER\n2->EDIT USER\n3->DELETE USER\n4->LIST OF USER\n0->EXIT");
            System.out.print(" -> ");
            int n = scanner.nextInt();
            switch (n) {
                case 0: {
                    IsTrue = false;
                    break;
                }
                case 1: {
                   addUser();
                    break;
                }
                case 2: {
                  editUser();
                    break;
                }
                case 3: {
                   deleteUser();
                    break;
                }
                case 4: {
                    userList();
                    break;
                }
            }
        }
    }
    @Override
    public void addUser() {
        try {
            TimeZone timeZone = TimeZone.getTimeZone("Asia/Tashkent");
            TimeZone.setDefault(timeZone);

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/move_to_ways?serverTimezone=UTC", "root", "root");
            System.out.print("Full Name:");
            scanner=new Scanner(System.in);
            String fullName=scanner.nextLine();
            System.out.print("Birthday:");
            scanner=new Scanner(System.in);
            String birthday=scanner.nextLine();
            System.out.print("Phone Number:");
            scanner=new Scanner(System.in);
            String number=scanner.nextLine();
            System.out.print("Email:");
            scanner=new Scanner(System.in);
            String email=scanner.nextLine();
            System.out.print("Birth Place:");
            scanner=new Scanner(System.in);
            String birthPlace=scanner.nextLine();
            System.out.print("Login:");
            scanner=new Scanner(System.in);
            String login=scanner.nextLine();
            System.out.print("Password:");
            scanner=new Scanner(System.in);
            String password=scanner.nextLine();
            System.out.print("Card Number:");
            Long card_number=scanner.nextLong();
            System.out.print("Card Balance:");
            Long card_balance=scanner.nextLong();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user(fullName,birthday,number,email,birthPlace,login,password,card_number,card_balance) VALUE (?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, birthday);
            preparedStatement.setString(3,number);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, birthPlace);
            preparedStatement.setString(6, login);
            preparedStatement.setString(7, password);
            preparedStatement.setLong(8, card_number);
            preparedStatement.setLong(9, card_balance);
            preparedStatement.executeUpdate();
            System.out.println("Successfully added");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void editUser() {
        try {
            TimeZone timeZone = TimeZone.getTimeZone("Asia/Tashkent");
            TimeZone.setDefault(timeZone);

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/move_to_ways?serverTimezone=UTC", "root", "root");

            Statement updStatement=connection.createStatement();
            userList();
            System.out.print("Choose ID: ");
            int id=scanner.nextInt();
            PreparedStatement statement=connection.prepareStatement("UPDATE airways SET current_place=?,to_place=?,which_plane=?,money=? WHERE id=?");
            System.out.print("Full Name:");
            scanner=new Scanner(System.in);
            String fullName=scanner.nextLine();
            System.out.print("Birthday:");
            scanner=new Scanner(System.in);
            String birthday=scanner.nextLine();
            System.out.print("Phone Number:");
            scanner=new Scanner(System.in);
            String number=scanner.nextLine();
            System.out.print("Email:");
            scanner=new Scanner(System.in);
            String email=scanner.nextLine();
            System.out.print("Birth Place:");
            scanner=new Scanner(System.in);
            String birthPlace=scanner.nextLine();
            System.out.print("Login:");
            scanner=new Scanner(System.in);
            String login=scanner.nextLine();
            System.out.print("Password:");
            scanner=new Scanner(System.in);
            String password=scanner.nextLine();
            System.out.print("Card Number:");
            Long card_number=scanner.nextLong();
            System.out.print("Card Balance:");
            Long card_balance=scanner.nextLong();
            statement.setString(1, fullName);
            statement.setString(2, birthday);
            statement.setString(3,number);
            statement.setString(4, email);
            statement.setString(5, birthPlace);
            statement.setString(6, login);
            statement.setString(7, password);
            statement.setLong(8, card_number);
            statement.setLong(9, card_balance);
            statement.executeUpdate();
            System.out.println("Successfully changed");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void deleteUser() {
        try {
            TimeZone timeZone=TimeZone.getTimeZone("Asia/Tashkent");
            TimeZone.setDefault(timeZone);

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Instializing...");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/move_to_ways?serverTimezone=UTC", "root", "root");
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(" select *from user u inner join order_plane o on u.id=o.user_id;");
            System.out.printf("%8s\t%12s\t%12s\t%12s\t%20s\t%23s\t%25s\t%12s\t%12s\t%12s\n",("id"), ("fullname"),("birthday"),("number"),("email"),("birthPlace"),("login"),("password"),("card_number"),("card_balance"));
            while (resultSet.next()){
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
            System.out.print("Choose ID: ");
            int id=scanner.nextInt();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM user WHERE id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Successfully deleted!!!");
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void userList() {
        try {
            TimeZone timeZone=TimeZone.getTimeZone("Asia/Tashkent");
            TimeZone.setDefault(timeZone);

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Instializing...");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/move_to_ways?serverTimezone=UTC", "root", "root");
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(" select *from user u inner join order_plane o on u.id=o.user_id;");
            System.out.printf("%8s\t%12s\t%12s\t%12s\t%20s\t%23s\t%25s\t%12s\t%12s\t%12s\n",("id"), ("fullname"),("birthday"),("number"),("email"),("birthPlace"),("login"),("password"),("card_number"),("card_balance"));
            while (resultSet.next()){
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


}
