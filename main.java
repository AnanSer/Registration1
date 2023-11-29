import com.sun.tools.javac.Main;
import org.w3c.dom.ls.LSOutput;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;
public class main {
    public static void main(String arg[]) {
        Scanner scanner = new Scanner(System.in);
        InputRegistration register = new InputRegistration();
        boolean cont = true;

        do {
            try {
                System.out.println("Welcome to registration Demo");
                System.out.println("Enter 1 for new registration: ");
                System.out.println("Enter 2 to display the registered students: ");
                System.out.println("Enter 3 for new registration: ");
                System.out.print(">> ");
                int choose = scanner.nextInt();

                if (choose == 1) {
                    register.newRegistration();
                }
                else if (choose == 2) {
                    register.displayRegisterd();
                }
                else System.exit(0);
                }
            catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer");
                scanner.nextLine();
            }
            System.out.print("Enter 1 to continue or Enter 2 to exit");
            int contiue = scanner.nextInt();
            if(contiue == 1){
                cont = true;
            }else cont = false;
        }while (cont) ;
    }
}




