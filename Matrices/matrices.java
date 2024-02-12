import java.util.Scanner;

public class Matrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        int[][] matrix_1 = new int[rows][cols];
        int[][] matrix_2 = new int[rows][cols];
        int[][] matrix_3 = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter the element to be present at intersection of "+ j +"th Column and "+ i +"th Row of matrix_1: ");
                matrix_1[i][j] = scanner.nextInt();
                System.out.print("Enter the element to be present at intersection of "+ j +"th Column and "+ i +"th Row of matrix_2: ");
                matrix_2[i][j] = scanner.nextInt();
                matrix_3[i][j] = matrix_1[i][j] + matrix_2[i][j];
                System.out.println("Element that will be present at intersection of "+ j +"th Column and "+ i +"th Row of matrix_3 will be: " + matrix_3[i][j]);
            }
        }

        scanner.close();
    }
}
