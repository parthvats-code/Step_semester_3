
public class TypingSpeedTestAccuracyChecker {

    String original;
    String typed;

    TypingSpeedTestAccuracyChecker(String original, String typed) {
        this.original = original;
        this.typed = typed;
    }

    void checkTypingAccuracy() {
        int matched = 0;
        int firstMismatch = -1;

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        double accuracy = (matched * 100.0) / original.length();

        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%%n",
                matched, original.length(), accuracy);

        if (firstMismatch == -1) {
            System.out.println("No Mismatches");
        } else {
            System.out.println("First Mismatch at position "
                    + (firstMismatch + 1) + " ('"
                    + original.charAt(firstMismatch) + "' vs '"
                    + typed.charAt(firstMismatch) + "')");
        }
    }

    public static void main(String[] args) {
        TypingSpeedTestAccuracyChecker obj
                = new TypingSpeedTestAccuracyChecker("hello world", "hello worlt");

        obj.checkTypingAccuracy();
    }
}
