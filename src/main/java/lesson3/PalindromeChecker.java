package lesson3;

public class PalindromeChecker {

    public static void main(String[] args) {

        PalindromeChecker palindrome = new PalindromeChecker();

        String input = "A roza upala na Lapu Azora";

        if (palindrome.isPalindrome(input))
            System.out.println("\"" + input + "\" является палиндромом.");
        else
            System.out.println("\"" + input + "\" не является палиндромом.");

    }

    boolean isPalindrome(String input) {

        input = input.toLowerCase().replaceAll("\\s+", "");

        int length = input.length();

        if (!input.matches("^([a-z0-9]+)?$")) {
            return false;
        }

        for (int i = 0; i < length / 2; i++) {
            if (input.charAt(i) != input.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}