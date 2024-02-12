import java.util.Scanner;

public class CompoundInterestCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the Principal as Integer: ");
        int principal = scanner.nextInt();

        System.out.print("Enter the rate of interest as Integer: ");
        int rate = scanner.nextInt();

        System.out.print("Enter the time as Integer: ");
        int time = scanner.nextInt();

        double compoundInterest = calculateCompoundInterest(principal, rate, time);

        System.out.printf("The Compound Interest is: %.2f\n", compoundInterest);
        scanner.close();
    }
    
    public static double calculateCompoundInterest(int principal, int rate, int time) {
        double amount = principal;
        double rateDecimal = rate / 100.0;

        while (time > 0) {
            amount = amount * (1 + rateDecimal);
            time--;
        }

        double compoundInterest = amount - principal;
        return compoundInterest;
    }
}