
public class MovieReviewWordLengthProfiler {

    String review;

    MovieReviewWordLengthProfiler(String review) {
        this.review = review;
    }

    void classifyWordLengths() {
        String[] words = review.split(" ");

        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;

        for (String word : words) {
            int length = word.length();

            if (length <= 4) {
                shortWords++;
            } else if (length <= 8) {
                mediumWords++;
            } else {
                longWords++;
            }
        }

        System.out.println("Short: " + shortWords);
        System.out.println("Medium: " + mediumWords);
        System.out.println("Long: " + longWords);
    }

    public static void main(String[] args) {
        MovieReviewWordLengthProfiler obj
                = new MovieReviewWordLengthProfiler(
                        "This movie was absolutely fantastic and thrilling");

        obj.classifyWordLengths();
    }
}
