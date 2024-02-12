import java.util.Scanner;

class HelloWorld {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number: ");
        
        int n = scanner.nextInt();
        
        double result = computeNaturalLog2(n);
        System.out.println("Natural log of 2 up to " + n + " terms: " + result);
        scanner.close();
    }
    
    public static double computeNaturalLog2(int n) {
        
        int x = 2;
        double result = 0;
        
        for (int i = 1; i <= n; i++) {
            if(i % 2 == 1) {
                System.out.println("I is Odd");
                result += Math.pow((x-1), i) / i;
            }
            else {
                System.out.println("I is Even");
                result -= Math.pow((x-1), i) / i;
            }
        }
        return result;
    }
}