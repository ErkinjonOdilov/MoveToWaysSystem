package controller;

import java.util.Scanner;

public class UserController {
    private Scanner scanner=new Scanner(System.in);

    public void menu() {
        boolean isTrue=true;
        while (isTrue){
            System.out.println("  WELCOME MOVE TO WAYS SYSTEM");
            System.out.println("-----------------------------");
            System.out.println("| Select the option:         |");
            System.out.print("| 1->USE AIR WAYS SYSTEM     |\n" +
                    "| 2->USE TRAIN WAYS SYSTEM   |\n" +
                    "| 3->USE BUS WAYS SYSTEM     |\n" +
                    "| 4->USE CAR WAYS SYSTEM     |\n" +
                    "| 5->ABOUT MYSELF            |\n" +
                    "| 6->HISTORY                 |\n" +
                    "| 0->EXIT                    |\n" +
                    "-----------------------------\n"+
                    "| -> ");
                    int n=scanner.nextInt();
                    System.out.println("-----------------------------\n");
                    switch (n){
                        case 0:{isTrue=false;break;}
                        case 1:{}
                        case 2:{}
                        case 3:{}
                        case 4:{}
                        case 5:{}
                        case 6:{}
                    }

        }
    }

}
