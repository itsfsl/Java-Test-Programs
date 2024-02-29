// A tiny program to calculate the middle character of a
// given string.
import java.util.Scanner;

public class middlecharfinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String str = sc.nextLine();
        System.out.println(middleCharacter(str));
    }

    public static String middleCharacter(String str) {
        int length = str.length();
        int middle = length / 2;

        if (length % 2 == 0) {
            return str.substring(middle - 1, middle + 1);
        } else {
            return str.substring(middle, middle + 1);
        }
    }
}
