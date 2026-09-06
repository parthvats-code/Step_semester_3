
public final class BoardingPenaltyCalculator {

    private final double minimumPenaltyPercent;

    public BoardingPenaltyCalculator(double minimumPenaltyPercent) {
        this.minimumPenaltyPercent = minimumPenaltyPercent;
    }

    public final double calculatePenalty(double ticketFare, int minutesLate) {
        if (ticketFare < 0 || minutesLate < 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        if (minutesLate == 0) {
            return 0;
        }

        int first = Math.min(minutesLate, 5);
        int second = Math.min(Math.max(minutesLate - 5, 0), 10);
        int third = Math.max(minutesLate - 15, 0);

        double penalty = ticketFare
                * (first * 0.005 + second * 0.01 + third * 0.02);

        double minimum = ticketFare * minimumPenaltyPercent / 100;

        return Math.max(penalty, minimum);
    }

    public static void main(String[] args) {
        BoardingPenaltyCalculator obj
                = new BoardingPenaltyCalculator(1);

        System.out.println(obj.calculatePenalty(1000, 0));
        System.out.println(obj.calculatePenalty(1000, 1));
        System.out.println(obj.calculatePenalty(1000, 16));
    }
}
