public class PalindromeChecker {
    boolean isPalindromeIterative(String text) {
        int i = 0, j = text.length() - 1;

        while (i < j) {
            if (text.charAt(i) != text.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;
    }

    boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1)
            return true;

        if (text.charAt(0) != text.charAt(text.length() - 1))
            return false;

        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    boolean isPalindromeArrayReversal(String text) {
        char[] arr = text.toCharArray();

        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        return text.equals(new String(arr));
    }

    public static void main(String[] args) {
        PalindromeChecker obj = new PalindromeChecker();
        String text = "madam";

        System.out.println("Iterative: " +
                (obj.isPalindromeIterative(text) ? "Palindrome" : "Not Palindrome"));

        System.out.println("Recursive: " +
                (obj.isPalindromeRecursive(text) ? "Palindrome" : "Not Palindrome"));

        System.out.println("Array Reversal: " +
                (obj.isPalindromeArrayReversal(text) ? "Palindrome" : "Not Palindrome"));
    }
}
