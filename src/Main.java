import repository.AdminRepository;
import repository.UserRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("\t\t\t\tWelcome Move To System");
            System.out.println("Continue by...");
            System.out.println("1->As Admin\n2->As User\n3->Registration\n0->Exit");
            Scanner scanner=new Scanner(System.in);
            int n=scanner.nextInt();
            switch (n){
                case 0->{isTrue=false;}
                case 1->{
                    AdminRepository a1=new AdminRepository();
                    a1.enterTheSystem();
                }
                case 2->{
                    UserRepository u1=new UserRepository();
                    u1.enterTheSystem();
                }
                case 3->{  UserRepository u1=new UserRepository();
                u1.registration();}
            }
        }
    }
}
