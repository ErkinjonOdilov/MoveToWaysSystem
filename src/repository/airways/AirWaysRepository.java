package repository.airways;

import repository.UserRepository;
import service.AirWayService.AirWaysService;

import java.sql.*;
import java.util.Scanner;
import java.util.TimeZone;

public class AirWaysRepository implements AirWaysService {
private Scanner scanner=new Scanner(System.in);

    @Override
    public void menu() {
        boolean IsTrue = true;
        while (IsTrue) {
            System.out.println("\t\t\tWELCOME TO AIRWAYS MANAGE SYSTEM");
            System.out.println("Choose option: ");
            System.out.println("1->AIRWAYS MENU\n2->ORDER MENU\n3->PLANES MENU\n4->USER MENU\n0->EXIT");
            System.out.print(" -> ");
            int n = scanner.nextInt();
            switch (n) {
                case 0: {
                    IsTrue = false;
                    break;
                }
                case 1: {
                    airwaysMenu();
                    break;
                }
                case 2: {
                  orderedMenu();
                    break;
                }
                case 3: {
                  planeMenu();
                    break;
                }
                case 4: {
                    AirWaysUserRepository u1=new AirWaysUserRepository();
                    u1.userMenu();
                    break;
                }
            }
        }
    }


    @Override
    public void airwaysMenu() {
        boolean IsTrue = true;
        while (IsTrue) {
            System.out.println("\t\t\tWELCOME TO AIRWAYS MANAGE SYSTEM");
            System.out.println("Choose option: ");
            System.out.println("1->ADD AIRWAYS\n2->EDIT AIRWAYS\n3->DELETE AIRWAYS\n4->LIST OF AIRWAYS\n0->EXIT");
            System.out.print(" -> ");
            int n = scanner.nextInt();
            switch (n) {
                case 0: {
                    IsTrue = false;
                    break;
                }
                case 1: {
                    addAirWays();
                    break;
                }
                case 2: {
                    editAirWays();
                    break;
                }
                case 3: {
                    deleteAirWays();
                    break;
                }
                case 4: {
                    listOfAirWayPlanes();
                    break;
                }
            }
        }
    }
    @Override
    public void listOfAirWayPlanes() {
        try {
            TimeZone timeZone=TimeZone.getTimeZone("Asia/Tashkent");
            TimeZone.setDefault(timeZone);

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Instializing...");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/move_to_ways?serverTimezone=UTC", "root", "root");
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(" select a.*,p.name,p.planeclass,p.isactive from airways a inner join airplane p on a.which_plane=p.id; ");
            System.out.printf("%8s\t%8s\t%8s\t%8s\t%8s\t%8s\t%8s\t%8s\n",("id"), ("current_place"), ("to_place"), ("which_plane"), ("money"), ("name"), ("planeclass"), ("isactive"));
            while (resultSet.next()){
                System.out.printf("%8s\t%10s\t%10s\t%10s\t%12s\t%9s\t%9s\t%7s\n",
                        resultSet.getInt("id"),
                        resultSet.getString("current_place"),
                        resultSet.getString("to_place"),
                        resultSet.getInt("which_plane"),
                        resultSet.getDouble("money"),
                        resultSet.getString("name"),
                        resultSet.getString("planeclass"),
                        resultSet.getBoolean("isactive"));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void addAirWays() {
        try {
            TimeZone timeZone = TimeZone.getTimeZone("Asia/Tashkent");
            TimeZone.setDefault(timeZone);

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/move_to_ways?serverTimezone=UTC", "root", "root");
            System.out.print("Current place:");
            scanner=new Scanner(System.in);
            String current_place=scanner.nextLine();
            System.out.print("To Place:");
            scanner=new Scanner(System.in);
            String to_place=scanner.nextLine();
            planesList();
            System.out.print("Select plane ID:");
            int which_plane=scanner.nextInt();
            System.out.print("Enter the Money: ");
            long money=scanner.nextLong();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO airways(current_place,to_place,which_plane,money) VALUE (?,?,?,?)");
            preparedStatement.setString(1, current_place);
            preparedStatement.setString(2, to_place);
            preparedStatement.setInt(3,which_plane);
            preparedStatement.setLong(4, money);
            preparedStatement.executeUpdate();
            System.out.println("Successfully added");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void editAirWays() {
        try {
            TimeZone timeZone = TimeZone.getTimeZone("Asia/Tashkent");
            TimeZone.setDefault(timeZone);

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/move_to_ways?serverTimezone=UTC", "root", "root");

            Statement updStatement=connection.createStatement();
            listOfAirWayPlanes();
            System.out.print("Choose ID: ");
            int id=scanner.nextInt();
            PreparedStatement statement=connection.prepareStatement("UPDATE airways SET current_place=?,to_place=?,which_plane=?,money=? WHERE id=?");
            System.out.print("Current place: ");
            scanner=new Scanner(System.in);
            String current_place=scanner.nextLine();
            System.out.print("To place: ");
            scanner=new Scanner(System.in);
            String to_place=scanner.nextLine();
            planesList();
            System.out.print("Select plane ID: ");
            scanner=new Scanner(System.in);
            int which_plane=scanner.nextInt();
            System.out.print("Money: ");
            scanner=new Scanner(System.in);
            Long money=scanner.nextLong();
            statement.setString(1,current_place);
            statement.setString(2,to_place);
            statement.setInt(3,which_plane);
            statement.setLong(4, money);
            statement.setInt(5,id);
            statement.executeUpdate();
            System.out.println("Successfully changed");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void deleteAirWays() {
        try {
            TimeZone timeZone = TimeZone.getTimeZone("Asia/Tashkent");
            TimeZone.setDefault(timeZone);

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Instializing...");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/move_to_ways?serverTimezone=UTC", "root", "root");

            Statement statement = connection.createStatement(java.sql.ResultSet.TYPE_SCROLL_SENSITIVE, java.sql.ResultSet.CONCUR_UPDATABLE);
            java.sql.ResultSet resultSet = statement.executeQuery("SELECT * FROM airways;");
            System.out.printf("%8s\t%8s\t%8s\t%8s\t%8s\n",("id"), ("current_place"), ("to_place"), ("which_plane"), ("money"));
            while (resultSet.next()){
                System.out.printf("%8s\t%10s\t%10s\t%10s\t%12s\n",
                        resultSet.getInt("id"),
                        resultSet.getString("current_place"),
                        resultSet.getString("to_place"),
                        resultSet.getInt("which_plane"),
                        resultSet.getDouble("money"));
            }
            System.out.print("Choose ID: ");
            int id=scanner.nextInt();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM airways WHERE id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("Successfully deleted!!!");


            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void orderedMenu() {
        boolean IsTrue = true;
        while (IsTrue) {
            System.out.println("\t\t\tWELCOME TO ORDERED MANAGE SYSTEM");
            System.out.println("Choose option: ");
            System.out.println("1->ADD ORDER\n2->EDIT ORDER\n3->DELETE ORDER\n4->LIST OF ORDERS\n0->EXIT");
            System.out.print(" -> ");
            int n = scanner.nextInt();
            switch (n) {
                case 0: {
                    IsTrue = false;
                    break;
                }
                case 1: {
                    addOrder();
                    break;
                }
                case 2: {
                    editOrder();
                    break;
                }
                case 3: {
                    deleteOrder();
                    break;
                }
                case 4: {
                    orderedList();
                    break;
                }
            }
        }
    }
    @Override
    public void addOrder() {
        try {
            TimeZone timeZone = TimeZone.getTimeZone("Asia/Tashkent");
            TimeZone.setDefault(timeZone);

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/move_to_ways?serverTimezone=UTC", "root", "root");
            UserRepository u1=new UserRepository();
            u1.allUsers();
            System.out.print("Choose User ID: ");
            int user_id=scanner.nextInt();
            listOfAirWayPlanes();
            System.out.print("Choose Airways ID: ");
            int airways_id=scanner.nextInt();
            System.out.print("Enter the Fly date yyyy-mm-dd: ");
            String fly_date=scanner.next();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO order_plane (user_id,airways_id,fly_date) VALUE (?,?,?)");
            preparedStatement.setInt(1,user_id);
            preparedStatement.setInt(2,airways_id);
            preparedStatement.setString(3,fly_date);
            preparedStatement.executeUpdate();
            System.out.println("Successfully added");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void editOrder() {
        try {
            TimeZone timeZone = TimeZone.getTimeZone("Asia/Tashkent");
            TimeZone.setDefault(timeZone);

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/move_to_ways?serverTimezone=UTC", "root", "root");

            Statement updStatement=connection.createStatement();
            orderedList();
            System.out.print("Choose ID: ");
            int id=scanner.nextInt();
            PreparedStatement statement=connection.prepareStatement("UPDATE order_plane SET user_id=?,airways_id=?,fly_date=? WHERE id=?");
            UserRepository u1=new UserRepository();
            u1.allUsers();
            System.out.print("Choose User ID: ");
            int user_id=scanner.nextInt();
            listOfAirWayPlanes();
            System.out.print("Choose Airways ID: ");
            int airways_id=scanner.nextInt();
            System.out.print("Enter the Flay date yyyy-mm-dd: ");
            String fly_date=scanner.next();
            statement.setInt(1,user_id);
            statement.setInt(2,airways_id);
            statement.setString(3,fly_date);
            statement.setInt(4,id);
            statement.executeUpdate();
            System.out.println("Successfully changed");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void deleteOrder() {
        try {
            TimeZone timeZone=TimeZone.getTimeZone("Asia/Tashkent");
            TimeZone.setDefault(timeZone);

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Instializing...");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/move_to_ways?serverTimezone=UTC", "root", "root");
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select o.id, u.fullname,u.birthday,u.number,a.current_place,a.to_place,a.which_plane,a.money,p.name,p.planeclass,o.isactive,o.fly_date from order_plane o inner join airways a on a.id=o.airways_id inner join user u on u.id=o.user_id inner join airplane p on a.which_plane=p.id;");
            System.out.printf("%8s\t%12s\t%12s\t%12s\t%12s\t%12s\t%12s\t%12s\t%12s\t%12s\t%12s\t%12s\n",("id"), ("fullname"),("birthday"),("number"),("current_place"), ("to_place"), ("which_plane"), ("money"), ("name"), ("planeclass"), ("isactive"),("fly_date"));
            while (resultSet.next()){
                System.out.printf("%8s\t%12s\t%12s\t%12s\t%12s\t%12s\t%12s\t%12s\t%12s\t%12s\t%12s\t%12s\n",
                        resultSet.getInt("id"),
                        resultSet.getString("fullname"),
                        resultSet.getString("birthday"),
                        resultSet.getString("number"),
                        resultSet.getString("current_place"),
                        resultSet.getString("to_place"),
                        resultSet.getInt("which_plane"),
                        resultSet.getDouble("money"),
                        resultSet.getString("name"),
                        resultSet.getString("planeclass"),
                        resultSet.getBoolean("isactive"),
                        resultSet.getDate("fly_date"));
            }
            System.out.print("Choose ID: ");
            int id=scanner.nextInt();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM order_plane WHERE id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Successfully deleted!!!");
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void orderedList() {
        try {
            TimeZone timeZone=TimeZone.getTimeZone("Asia/Tashkent");
            TimeZone.setDefault(timeZone);

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Instializing...");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/move_to_ways?serverTimezone=UTC", "root", "root");
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select o.id, u.fullname,u.birthday,u.number,a.current_place,a.to_place,a.which_plane,a.money,p.name,p.planeclass,o.isactive,o.fly_date from order_plane o inner join airways a on a.id=o.airways_id inner join user u on u.id=o.user_id inner join airplane p on a.which_plane=p.id;");
            System.out.printf("%8s\t%12s\t%12s\t%12s\t%12s\t%12s\t%12s\t%12s\t%12s\t%12s\t%12s\t%12s\n",("id"), ("fullname"),("birthday"),("number"),("current_place"), ("to_place"), ("which_plane"), ("money"), ("name"), ("planeclass"), ("isactive"),("fly_date"));
            while (resultSet.next()){
                System.out.printf("%8s\t%12s\t%12s\t%12s\t%12s\t%12s\t%12s\t%12s\t%12s\t%12s\t%12s\t%12s\n",
                        resultSet.getInt("id"),
                        resultSet.getString("fullname"),
                        resultSet.getString("birthday"),
                        resultSet.getString("number"),
                        resultSet.getString("current_place"),
                        resultSet.getString("to_place"),
                        resultSet.getInt("which_plane"),
                        resultSet.getDouble("money"),
                        resultSet.getString("name"),
                        resultSet.getString("planeclass"),
                        resultSet.getBoolean("isactive"),
                        resultSet.getDate("fly_date"));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void planeMenu() {
        boolean IsTrue = true;
        while (IsTrue) {
            System.out.println("\t\t\tWELCOME TO PLANES MANAGE SYSTEM");
            System.out.println("Choose option: ");
            System.out.println("1->ADD PLANE\n2->EDIT PLANE\n3->DELETE PLANE\n4->LIST OF PLANES\n0->EXIT");
            System.out.print(" -> ");
            int n = scanner.nextInt();
            switch (n) {
                case 0: {
                    IsTrue = false;
                    break;
                }
                case 1: {
                   addPlane();
                    break;
                }
                case 2: {
                    editPlane();
                    break;
                }
                case 3: {
                   deletePlane();
                    break;
                }
                case 4: {
                  planesList();
                    break;
                }
            }
        }
    }
    @Override
    public void addPlane() {
        try {
            TimeZone timeZone = TimeZone.getTimeZone("Asia/Tashkent");
            TimeZone.setDefault(timeZone);

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/move_to_ways?serverTimezone=UTC", "root", "root");
            System.out.print("Plane name:");
            scanner=new Scanner(System.in);
            String name=scanner.nextLine();
            System.out.println("simple\n" +
                    "business\n" +
                    "master");
            System.out.print("Enter plane class:");
            String planeclass=scanner.next();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO airplane(name,planeclass) VALUE (?,?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, planeclass);
            preparedStatement.executeUpdate();
            System.out.println("Successfully added");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void editPlane() {
        try {
            TimeZone timeZone = TimeZone.getTimeZone("Asia/Tashkent");
            TimeZone.setDefault(timeZone);

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/move_to_ways?serverTimezone=UTC", "root", "root");

            Statement updStatement=connection.createStatement();
            planesList();
            System.out.print("Choose ID: ");
            int id=scanner.nextInt();
            PreparedStatement statement=connection.prepareStatement("UPDATE airplane SET name=?,planeclass=? WHERE id=?");
            System.out.print("Plane name: ");
            scanner=new Scanner(System.in);
            String name=scanner.nextLine();
            System.out.println("simple\nbusiness\nmaster");
            System.out.print("Enter the plane class: ");
            scanner=new Scanner(System.in);
            String planeclass=scanner.nextLine();
            statement.setString(1,name);
            statement.setString(2,planeclass);
            statement.setInt(3,id);
            statement.executeUpdate();
            System.out.println("Successfully changed");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void deletePlane() {
            try {
                TimeZone timeZone=TimeZone.getTimeZone("Asia/Tashkent");
                TimeZone.setDefault(timeZone);

                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Instializing...");
                Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/move_to_ways?serverTimezone=UTC", "root", "root");
                Statement statement=connection.createStatement();
                ResultSet resultSet=statement.executeQuery(" select *from airplane;");
                System.out.printf("%8s\t%8s\t%8s\t%8s\n",("id"), ("name"), ("planeclass"),("isactive"));
                while (resultSet.next()){
                    System.out.printf("%8s\t%8s\t%8s\t%8s\n",
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("planeclass"),
                            resultSet.getBoolean("isactive"));
                }
            System.out.print("Choose ID: ");
            int id=scanner.nextInt();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM airplane WHERE id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Successfully deleted!!!");
            connection.close();
            }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void planesList() {

        try {
            TimeZone timeZone=TimeZone.getTimeZone("Asia/Tashkent");
            TimeZone.setDefault(timeZone);

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Instializing...");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/move_to_ways?serverTimezone=UTC", "root", "root");
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(" select *from airplane;");
            System.out.printf("%8s\t%8s\t%8s\t%8s\n",("id"), ("name"), ("planeclass"),("isactive"));
            while (resultSet.next()){
                System.out.printf("%8s\t%8s\t%8s\t%8s\n",
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("planeclass"),
                        resultSet.getBoolean("isactive"));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
