import java.util.*;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = scanner.nextLine();

        System.out.println("Choose Algorithm:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");

        int choice = scanner.nextInt();
import java.util.*;

        public class PalindromeCheckerApp {

            public static void main(String[] args) {

                Scanner scanner = new Scanner(System.in);

                System.out.println("Enter a string:");
                String input = scanner.nextLine();

                List<PalindromeStrategy> strategies = new ArrayList<>();

                strategies.add(new StackStrategy());
                strategies.add(new DequeStrategy());
                strategies.add(new TwoPointerStrategy());

                System.out.println("\nPerformance Comparison:");

                for (PalindromeStrategy strategy : strategies) {

                    long start = System.nanoTime();

                    boolean result = strategy.isPalindrome(input);

                    long end = System.nanoTime();

                    long timeTaken = end - start;

                    System.out.println(
                            strategy.getClass().getSimpleName()
                                    + " → Result: "
                                    + result
                                    + " | Time: "
                                    + timeTaken
                                    + " ns"
                    );
                }

                scanner.close();
            }


            interface PalindromeStrategy {
                boolean isPalindrome(String input);
            }


            static class StackStrategy implements PalindromeStrategy {

                public boolean isPalindrome(String input) {

                    Stack<Character> stack = new Stack<>();

                    for (char c : input.toCharArray())
                        stack.push(c);

                    for (char c : input.toCharArray())
                        if (c != stack.pop())
                            return false;

                    return true;
                }
            }


            static class DequeStrategy implements PalindromeStrategy {

                public boolean isPalindrome(String input) {

                    Deque<Character> deque = new LinkedList<>();

                    for (char c : input.toCharArray())
                        deque.addLast(c);

                    while (deque.size() > 1)
                        if (deque.removeFirst() != deque.removeLast())
                            return false;

                    return true;
                }
            }


            static class TwoPointerStrategy implements PalindromeStrategy {

                public boolean isPalindrome(String input) {

                    int left = 0;
                    int right = input.length() - 1;

                    while (left < right) {

                        if (input.charAt(left) != input.charAt(right))
                            return false;

                        left++;
                        right--;
                    }

                    return true;
                }
            }
        }
        PalindromeStrategy strategy;

        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        PalindromeService service = new PalindromeService(strategy);

        boolean result = service.check(input);

        if (result)
            System.out.println("Palindrome");
        else
            System.out.println("Not a Palindrome");

        scanner.close();
    }

    interface PalindromeStrategy {
        boolean isPalindrome(String input);
    }

    static class PalindromeService {

        private PalindromeStrategy strategy;

        public PalindromeService(PalindromeStrategy strategy) {
            this.strategy = strategy;
        }

        public boolean check(String input) {
            return strategy.isPalindrome(input);
        }
    }

    static class StackStrategy implements PalindromeStrategy {

        public boolean isPalindrome(String input) {

            Stack<Character> stack = new Stack<>();

            for (char c : input.toCharArray())
                stack.push(c);

            for (char c : input.toCharArray()) {
                if (c != stack.pop())
                    return false;
            }

            return true;
        }
    }


    static class DequeStrategy implements PalindromeStrategy {

        public boolean isPalindrome(String input) {

            Deque<Character> deque = new LinkedList<>();

            for (char c : input.toCharArray())
                deque.addLast(c);

            while (deque.size() > 1) {

                if (deque.removeFirst() != deque.removeLast())
                    return false;
            }

            return true;
        }
    }
}