package repository;

import controller.AdminController;
import controller.UserController;
import models.Admin;
import models.User;
import service.AdminService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TimeZone;

public class AdminRepository implements AdminService {
    private Scanner scanner=new Scanner(System.in);

    public void enterTheSystem(){
        List<Admin> admins=new ArrayList<>();
        System.out.println();
        System.out.print("Enter the Admin login: ");
        String login = scanner.next();
        System.out.print("Enter the Admin password: ");
        String password = scanner.next();
        try {
            TimeZone timeZone = TimeZone.getTimeZone("Asia/Tashkent");
            TimeZone.setDefault(timeZone);

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Instializing...");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/move_to_ways?serverTimezone=UTC", "root", "root");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * FROM admin;");
            while (resultSet.next()){
                Admin u1=new Admin(resultSet.getInt("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("birthday"),
                        resultSet.getString("login"),
                        resultSet.getString("password"));
                admins.add(u1);

            }
            boolean isHave=false;
            int adminID;
            for (int i = 0; i < admins.size(); i++) {
                if (admins.get(i).getLogin().equals(login) && admins.get(i).getPassword().equals(password)) {
                    isHave=true;
                    adminID=admins.get(i).getId();
                    break;
                }
            }
            if(isHave){
               AdminController u2=new AdminController();
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
    public void menu() {
        boolean IsTrue = true;
        while (IsTrue) {
            System.out.println("\t\t\tWELCOME TO USERS MANAGE SYSTEM");
            System.out.println("Choose option: ");
            System.out.println("1->ADD ADMIN\n2->EDIT ADMIN\n3->DELETE ADMIN\n4->LIST OF ADMIN\n0->EXIT");
            System.out.print(" -> ");
            int n = scanner.nextInt();
            switch (n) {
                case 0: {
                    IsTrue = false;
                    break;
                }
                case 1: {
                   addAdmin();
                    break;
                }
                case 2: {
                 editAdmin();
                    break;
                }
                case 3: {
                    deleteAdmin();
                    break;
                }
                case 4: {
                   listAdmin();
                    break;
                }
            }
        }
    }

    @Override
    public void addAdmin() {

    }

    @Override
    public void editAdmin() {

    }

    @Override
    public void deleteAdmin() {

    }

    @Override
    public void listAdmin() {
        try {
            TimeZone timeZone = TimeZone.getTimeZone("Asia/Tashkent");
            TimeZone.setDefault(timeZone);

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Instializing...");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/move_to_ways?serverTimezone=UTC", "root", "root");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(" select *from admin;");
            System.out.printf("%8s\t%12s\t%12s\t%12s\t%15s\t%12s\n", ("id"), ("firstName"),("lastName"), ("birthday"),("login"), ("password"));
            while (resultSet.next()) {
                System.out.printf("%8s\t%12s\t%12s\t%12s\t%15s\t%12s\n",
                        resultSet.getInt("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("birthday"),
                        resultSet.getString("login"),
                        resultSet.getString("password"));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
