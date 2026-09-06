
import java.util.Arrays;

public class FareSplitter {

    String tripId;
    double totalFare;
    int passengerCount;

    public FareSplitter(String tripId, double totalFare, int passengerCount) {
        if (totalFare < 0 || passengerCount <= 0) {
            throw new IllegalArgumentException("Invalid fare or passenger count");
        }

        this.tripId = tripId;
        this.totalFare = totalFare;
        this.passengerCount = passengerCount;
    }

    public FareSplitter(String tripId, double totalFare) {
        this(tripId, totalFare, 2);
    }

    public FareSplitter(String tripId) {
        this(tripId, 0, 2);
    }

    double[] fareBreakdown() {
        double[] result = new double[passengerCount];
        double share = Math.floor(totalFare / passengerCount * 100) / 100;

        Arrays.fill(result, share);

        double used = share * passengerCount;
        result[passengerCount - 1] += totalFare - used;

        return result;
    }

    boolean isConfirmationOverdue(int confirmed, int expected) {
        return confirmed < expected;
    }

    public static void main(String[] args) {
        FareSplitter obj = new FareSplitter("TRIP001", 100000, 3);
        System.out.println(Arrays.toString(obj.fareBreakdown()));
    }
}
