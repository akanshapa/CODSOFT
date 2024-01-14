// (GRADE CALCULATOR..)
import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // Input: Marks obtained in each subject
            System.out.println("Enter marks for each subject (out of 100):");
            int totalMarks = 0;

            System.out.print("Enter the number of subjects: ");
            int subjectCount= sc.nextInt();

            for (int i = 1; i <=subjectCount; i++) {
                System.out.print("Enter marks for Subject " +i + ": ");
                int marks = sc.nextInt();

                // Validate if marks are in the valid range (0 to 100)
                if (marks < 0 || marks > 100) {
                    System.out.println("Invalid marks... Please enter marks in the range 0 to 100.");
                    return;
                }

                totalMarks += marks;
            }

            // Calculate Total Marks
            double averagePercentage = (double)totalMarks/subjectCount;

            // Grade Calculation
            char grade;
            if (averagePercentage >= 90) {
                grade = 'A';
            } else if (averagePercentage >= 80) {
                grade = 'B';
            } else if (averagePercentage >= 70) {
                grade = 'C';
            } else if (averagePercentage >= 60) {
                grade = 'D';
            } else {
                grade = 'F';
            }

            // Displaying  Results.....
            System.out.println("Results...");
            System.out.println("Total Marks=" + totalMarks);
            System.out.println("Average Percentage=" + averagePercentage + "%");
            System.out.println("Grade=" + grade);

            sc.close();//closing scanner 
        }
    }
}
