package controller;

import repository.AdminRepository;
import repository.airways.AirWaysRepository;
import service.AdminService;

import java.util.Scanner;

public class AdminController  {

    private Scanner scanner=new Scanner(System.in);

    public void menu() {
        boolean isTrue=true;
        while (isTrue){
            System.out.println("  WELCOME MOVE TO WAYS SYSTEM ADMIN PANEL");
            System.out.println("-----------------------------");
            System.out.println("| Select the option:         |");
            System.out.print("| 1->MANAGE AIRWAYS SYSTEM   |\n" +
                    "| 2->MANAGE TRAINWAYS SYSTEM |\n" +
                    "| 3->MANAGE BUSWAYS SYSTEM   |\n" +
                    "| 4->MANAGE CARWAYS SYSTEM   |\n" +
                    "| 5->MANAGE USERS SYSTEM     |\n" +
                    "| 6->MANAGE ADMINS SYSTEM    |\n" +
                    "| 0->EXIT                    |\n" +
                    "-----------------------------\n"+
                    "| -> ");
            int n=scanner.nextInt();
            System.out.println("-----------------------------\n");
            switch (n){
                case 0->{isTrue=false;}
                case 1->{
                    AirWaysRepository a1=new AirWaysRepository();
                    a1.menu();
                }
                case 2->{}
                case 3->{}
                case 4->{}
                case 5->{}
                case 6->{
                    AdminRepository a1=new AdminRepository();
                    a1.menu();
                }
            }

        }
    }



}
