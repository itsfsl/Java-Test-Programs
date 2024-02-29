/* Program to find the length of longest palindromic substring in a given string. */

import java.util.Scanner;

public class longestPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String string = sc.nextLine();

        System.out.println("Length of longest palindrome?: " + LongestPalindromeSubstring(string));;
        sc.close();
    }

    public static int LongestPalindromeSubstring(String str) {
        if (str == null || str.length() < 1) return 0;

        int start = 0;
        int end = 0;

        for (int i = 0; i < str.length(); i++) {
            int len1 = expandFromCenter(str, i, i);
            int len2 = expandFromCenter(str, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - ((len - 1) / 2);
                end = i + (len / 2);
            }
        }
        return (end - start) + 1;
    }

    public static int expandFromCenter(String str, int left, int right) {
        if (str == null || left > right) return 0;

        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}