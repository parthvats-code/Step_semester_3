
class DeliveryAccount {

    static String systemName;

    static {
        systemName = "Campus Delivery";
    }

    String studentId;
    double orderValue;

    public DeliveryAccount(String studentId, double orderValue) {
        this.studentId = studentId;
        this.orderValue = orderValue;
    }

    public DeliveryAccount(String studentId) {
        this(studentId, 0);
    }

    final double calculateSurgeFee(int delayMinutes) {
        if (orderValue < 0 || delayMinutes < 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int first = Math.min(delayMinutes, 5);
        int second = Math.min(Math.max(delayMinutes - 5, 0), 10);
        int third = Math.max(delayMinutes - 15, 0);

        return orderValue * (first * 0.005 + second * 0.01 + third * 0.02);
    }
}

class PremiumAccount extends DeliveryAccount {

    PremiumAccount(String studentId, double orderValue) {
        super(studentId, orderValue);
    }
}

public class NightlyReconciliationEngine {

    void processAccount(DeliveryAccount account, double amount, int delayMinutes) {
        account.orderValue = amount;

        double fee = account.calculateSurgeFee(delayMinutes);

        if (account instanceof PremiumAccount) {
            System.out.println(account.studentId + " Premium: Rs " + fee); 
        }else {
            System.out.println(account.studentId + " Regular: Rs " + fee);
        }
    }

    static void processBatch(DeliveryAccount[] accounts,
            double[] amounts, int[] delayMinutesArray) {
        int n = Math.min(accounts.length,
                Math.min(amounts.length, delayMinutesArray.length));

        int processed = 0, nulls = 0, premium = 0, regular = 0;
        double total = 0;

        NightlyReconciliationEngine obj = new NightlyReconciliationEngine();

        for (int i = 0; i < n; i++) {
            if (accounts[i] == null) {
                nulls++;
                continue;
            }

            accounts[i].orderValue = amounts[i];
            double fee = accounts[i].calculateSurgeFee(delayMinutesArray[i]);

            if (accounts[i] instanceof PremiumAccount) {
                premium++; 
            }else {
                regular++;
            }

            processed++;
            total += fee;
            obj.processAccount(accounts[i], amounts[i], delayMinutesArray[i]);
        }

        System.out.println(processed + " processed | " + nulls
                + " null skipped | " + premium + " premium | "
                + regular + " regular");
        System.out.println("Grand total surge fees: Rs " + total);
    }

    public static void main(String[] args) {
        DeliveryAccount[] accounts = {
            new PremiumAccount("STU001", 500),
            null,
            new DeliveryAccount("STU002", 300)
        };

        double[] amounts = {500, 400, 300};
        int[] delays = {10, 5, 0};

        processBatch(accounts, amounts, delays);
    }
}
