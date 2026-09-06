public class WordReversalEncoder {
    String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words)
            result.append(new StringBuilder(word).reverse()).append(" ");

        return result.toString().trim();
    }

    public static void main(String[] args) {
        WordReversalEncoder obj = new WordReversalEncoder();
        System.out.println(obj.reverseEachWord("hello club"));
    }
}
