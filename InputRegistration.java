import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputRegistration {
    private String firstName;
    private String lastName;
    private String id;
    private int age;
    private String department;
    private String college;
    private double gpa;

    InputRegistration(){}

    public InputRegistration(String firstName, String lastName, String id, int age,
                             String department, String college, double gpa) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.age = age;
        this.department = department;
        this.college = college;
        this.gpa = gpa;
    }

    public void newRegistration() {
        boolean  continueLoop = false;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter your first name: ");
            firstName = scanner.nextLine();
            if (firstName.isEmpty()) {
                System.out.println("Enter a non-null, non-empty value:");
            }
        }while (firstName.isEmpty() || firstName.matches(".*\\d.*"));

        do {
            System.out.print("Enter your Last name: ");
            lastName = scanner.nextLine();
            if (lastName.isEmpty()) {
                System.out.println("Enter a non-null, non-empty value:");
            }
        }while (lastName.isEmpty() || lastName.matches(".*\\d.*"));

        do {
            System.out.print("ID: ");
            id = scanner.nextLine();
        }while (id.isEmpty() );

        do {
            System.out.print("Enter your department: ");
            department = scanner.nextLine();
        }while (department.isEmpty() );

        do {
            System.out.print("Enter your college: ");
            college = scanner.nextLine();
        }while (college.isEmpty());

        do {try{
            System.out.print("Enter your age: ");
            age = scanner.nextInt();
            continueLoop = true;
            }catch(InputMismatchException e){
                System.out.println("Invalid input! Please enter an integer");
                scanner.nextLine();
            }
        }while (!continueLoop);

        boolean continueLoop2 = false;
        do {
            try {
                System.out.println("Enter 1 to write your GPA or Enter 2 to calculate your GPA");
                int gpaOption = scanner.nextInt();

                if (gpaOption == 1) {
                    System.out.print("Enter your GPA: ");
                    double gpa = scanner.nextDouble();
                    validateGPA(gpa);

                } else {
                    gpa = GPA_Calculator.main(null);
                    validateGPA(gpa);
                }
                System.out.println("your are successfully registered!");
                continueLoop2 = true;
            } catch (InvalidGPAException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            } catch (InputMismatchException e) {
                System.out.print("the input is mismatched! please Enter your GPA:  ");
                scanner.nextLine();
            }
        }while(!continueLoop2);

    }
    public void displayRegisterd(){
        ArrayList<InputRegistration> students = new ArrayList<>();
            InputRegistration student = new InputRegistration(firstName,lastName, id , age,
                                                            department, college, gpa);
            students.add(student);

        for (InputRegistration st : students) {
            System.out.println("First Name: " + firstName + "  Last Name: "  + lastName + "  ID" + id + "  Age: " + age +
                    "  department: " + department + "  college: " + college + "  GPA" +  gpa);
        }
    }

    public static void validateGPA(double GPA) throws InvalidGPAException {
        if (GPA < 0) throw new InvalidGPAException("Negative GPA is invalid");
        else if(GPA < 1.6) throw new InvalidGPAException("Your grade cannot make you register because it is less than 1.6 ");
        else if(GPA > 4) throw new InvalidGPAException("invalid input");
    }

}

     class InvalidGPAException extends Exception {
         InvalidGPAException(String message) {
             super(message);
         }
     }


