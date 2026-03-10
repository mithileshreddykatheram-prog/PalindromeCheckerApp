import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check palindrome:");
        String input = scanner.nextLine();

        boolean result = isPalindrome(input, 0, input.length() - 1);

        if (result) {
            System.out.println("Result: It is a Palindrome");
        } else {
            System.out.println("Result: It is NOT a Palindrome");
        }

        scanner.close();
    }


    public static boolean isPalindrome(String str, int start, int end) {


        if (start >= end)
            return true;


        if (str.charAt(start) != str.charAt(end))
            return false;


        return isPalindrome(str, start + 1, end - 1);
    }
}