import java.util.Scanner;

public class permuteAndCombine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        System.out.print("Enter the value of r: ");
        int r = scanner.nextInt();

        double result = computeResult(n, r);

        System.out.println("Result is " + result);
        scanner.close();
    }

    public static double computeResult(int n, int r) {
        double permutation = factorial(n) / factorial(n-r);
        double combination = permutation / (factorial(r));
        double sumOfSquares = permutation * permutation + combination * combination;
        return Math.sqrt(sumOfSquares);
    }

    public static double factorial(int n) {
        if (n == 0) {
            return 1;
        }
        double result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}