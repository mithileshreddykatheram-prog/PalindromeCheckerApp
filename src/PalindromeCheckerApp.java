import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check palindrome:");
        String input = scanner.nextLine();

        String normalized = input.toLowerCase().replaceAll("\\s+", "");

        boolean result = isPalindrome(normalized);

        if (result) {
            System.out.println("Result: It is a Palindrome");
        } else {
            System.out.println("Result: It is NOT a Palindrome");
        }

        scanner.close();
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
import java.util.Scanner;

        public class PalindromeCheckerApp {

            public static void main(String[] args) {

                Scanner scanner = new Scanner(System.in);

                System.out.println("Enter a string to check palindrome:");
                String input = scanner.nextLine();

                PalindromeChecker checker = new PalindromeChecker();

                boolean result = checker.checkPalindrome(input);

                if (result) {
                    System.out.println("Result: It is a Palindrome");
                } else {
                    System.out.println("Result: It is NOT a Palindrome");
                }

                scanner.close();
            }

            // Service Class (Encapsulation)
            static class PalindromeChecker {

                public boolean checkPalindrome(String input) {

                    if (input == null)
                        return false;

                    // Pre-processing (ignore case & spaces)
                    String normalized = input.toLowerCase().replaceAll("\\s+", "");

                    int left = 0;
                    int right = normalized.length() - 1;

                    while (left < right) {

                        if (normalized.charAt(left) != normalized.charAt(right)) {
                            return false;
                        }

                        left++;
                        right--;
                    }

                    return true;
                }
            }
        }
        return true;
    }
}