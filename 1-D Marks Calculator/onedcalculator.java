// Program to calculate total marks & percentage using input in a 1-D array.
// Also, all the marks are entered in one single input line.

import java.util.Scanner;

public class onedcalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numOfSubjects = Integer.parseInt(sc.nextLine());

        System.out.print("Enter marks seperated by a space (out of 100): ");
        String inputLine = sc.nextLine();

        String[] marksStr = inputLine.split(" ");

        int[] marks = new int[marksStr.length];

        for (int i = 0; i < marks.length; i++) {
            marks[i] = Integer.parseInt(marksStr[i]);
        }

        
        int totalMarks = 0;
        double percentage = 0.0;

        for (int i = 0; i < marks.length; i++) {
            totalMarks += marks[i];
        }

        percentage = (totalMarks / numOfSubjects);

        System.out.printf("You scored a total of %d/%d.%n", totalMarks, (numOfSubjects * 100));
        System.out.println("Percentage: " + percentage + "%");
    }
}
