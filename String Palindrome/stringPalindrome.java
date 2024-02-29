/* Program to check if a given string is a palindrome or not. */

import java.util.Scanner;

public class stringPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String string = sc.nextLine();

        System.out.println("Is Palindrome?: " + isPalindrome(string));;

        sc.close();
    }

    public static boolean isPalindrome(String str) {

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}