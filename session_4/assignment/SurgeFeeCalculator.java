
public final class SurgeFeeCalculator {

    private final double minimumSurgePercent;

    public SurgeFeeCalculator(double minimumSurgePercent) {
        this.minimumSurgePercent = minimumSurgePercent;
    }

    public final double calculateSurgeFee(double orderValue, int delayMinutes) {
        if (orderValue < 0 || delayMinutes < 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        if (delayMinutes == 0) {
            return 0;
        }

        int first = Math.min(delayMinutes, 5);
        int second = Math.min(Math.max(delayMinutes - 5, 0), 10);
        int third = Math.max(delayMinutes - 15, 0);

        double fee = orderValue * (first * 0.005 + second * 0.01 + third * 0.02);
        double minimum = orderValue * minimumSurgePercent / 100;

        return Math.max(fee, minimum);
    }

    public static void main(String[] args) {
        SurgeFeeCalculator obj = new SurgeFeeCalculator(1);

        System.out.println(obj.calculateSurgeFee(500, 0));
        System.out.println(obj.calculateSurgeFee(500, 1));
        System.out.println(obj.calculateSurgeFee(500, 16));
    }
}
