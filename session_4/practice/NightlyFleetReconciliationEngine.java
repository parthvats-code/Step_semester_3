
class BusTicketAccount {

    static String systemName;

    static {
        systemName = "Bus Fleet";
    }

    String bookingId;
    double ticketFare;

    public BusTicketAccount(String bookingId, double ticketFare) {
        this.bookingId = bookingId;
        this.ticketFare = ticketFare;
    }

    public BusTicketAccount(String bookingId) {
        this(bookingId, 0);
    }

    final double calculatePenalty(int minutesLate) {
        if (ticketFare < 0 || minutesLate < 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int first = Math.min(minutesLate, 5);
        int second = Math.min(Math.max(minutesLate - 5, 0), 10);
        int third = Math.max(minutesLate - 15, 0);

        return ticketFare
                * (first * 0.005 + second * 0.01 + third * 0.02);
    }
}

class Sleeper extends BusTicketAccount {

    Sleeper(String bookingId, double ticketFare) {
        super(bookingId, ticketFare);
    }
}

public class NightlyFleetReconciliationEngine {

    void processAccount(BusTicketAccount account,
            double amount, int minutesLate) {
        account.ticketFare = amount;
        double penalty = account.calculatePenalty(minutesLate);

        if (account instanceof Sleeper) {
            System.out.println(account.bookingId
                    + " Sleeper: Rs " + penalty); 
        }else {
            System.out.println(account.bookingId
                    + " Regular: Rs " + penalty);
        }
    }

    static void processBatch(BusTicketAccount[] accounts,
            double[] amounts,
            int[] minutesLateArray) {
        int n = Math.min(accounts.length,
                Math.min(amounts.length, minutesLateArray.length));

        int processed = 0, nulls = 0, sleeper = 0, regular = 0;
        double total = 0;

        NightlyFleetReconciliationEngine obj
                = new NightlyFleetReconciliationEngine();

        for (int i = 0; i < n; i++) {
            if (accounts[i] == null) {
                nulls++;
                continue;
            }

            obj.processAccount(accounts[i], amounts[i],
                    minutesLateArray[i]);

            double penalty = accounts[i].calculatePenalty(
                    minutesLateArray[i]);

            total += penalty;
            processed++;

            if (accounts[i] instanceof Sleeper) {
                sleeper++; 
            }else {
                regular++;
            }
        }

        System.out.println(processed + " processed | "
                + nulls + " null skipped | "
                + sleeper + " sleeper | " + regular + " regular");

        System.out.println("Grand total penalties: Rs " + total);
    }

    public static void main(String[] args) {
        BusTicketAccount[] accounts = {
            new Sleeper("BK001", 2000),
            null,
            new BusTicketAccount("BK002", 1200)
        };

        double[] amounts = {1200, 900, 700};
        int[] delays = {10, 5, 0};

        processBatch(accounts, amounts, delays);
    }
}
