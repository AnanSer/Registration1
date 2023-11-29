import java.util.Scanner;
public class GPA_Calculator {
    public static double main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of courses that you had learned last semester : ");
        int numCourses = scanner.nextInt();

        double totalCreditHours = 0.0;
        double totalGradePoints = 0.0;

        for (int i = 1; i <= numCourses; i++) {
            System.out.println("Course #" + i + ":");
            System.out.println("Enter your mark: ");
            int mark = scanner.nextInt();
            System.out.print("Enter the credit hours for the course: ");
            int creditHours = scanner.nextInt();
            String grade = gradeCalculater(mark);
            double gradePoints = getGradePoints(grade);
            double courseGradePoints = gradePoints * creditHours;
            totalGradePoints += courseGradePoints;
            totalCreditHours += creditHours;
        }

        double gpa = totalGradePoints / totalCreditHours;
        System.out.println("Your GPA is: " + gpa);
        return gpa;
    }
    public void getGPA(double gpa){
        System.out.println("dd");
    }

    public static String gradeCalculater(int markInInt){
        String grade , oneGrade;
        if (markInInt >= 90 && markInInt <= 100){
            oneGrade = "B";
            return grade ="A";
        }
        else if (markInInt >= 80){
            return grade = "B";
        }
        else if (markInInt >= 70 ){

            return grade =  "C";

        }
        else if (markInInt >= 60 ){
            return grade = "D";

        }
        else{
            return grade = "invalid input or less than 60";}
    }

    public static double getGradePoints(String grade) {
        double gradePoints;

        switch (grade) {
            case "A" -> gradePoints = 4.0;
            case "B" -> gradePoints = 3.0;
            case "C" -> gradePoints = 2.0;
            case "D" -> gradePoints = 1.0;
            case "F" -> gradePoints = 0.0;
            default  -> gradePoints = 0.0;
        }
        return gradePoints;
    }
}