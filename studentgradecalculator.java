import java.util.*;
class studentgradecalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input: Take marks obtained (out of 100) in each subject
        System.out.println("Enter marks obtained in each subject (out of 100):");
        int numOfSubjects;
        do {
            System.out.print("Number of subjects: ");
            numOfSubjects = scanner.nextInt();
        } while (numOfSubjects <= 0);

        int[] marks = new int[numOfSubjects];
        int totalMarks = 0;
        for (int i = 0; i < numOfSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
            totalMarks += marks[i];
        }
        
        // Calculate Total Marks
        System.out.println("\nTotal Marks: " + totalMarks);
        
        // Calculate Average Percentage
        double averagePercentage = (double) totalMarks / numOfSubjects;
        System.out.println("Average Percentage: " + averagePercentage + "%");
        
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
        } else if (averagePercentage >= 50) {
            grade = 'E';
        } else {
            grade = 'F';
        }
        
        // Display Results
        System.out.println("Grade: " + grade);
        
        scanner.close();
    }
}