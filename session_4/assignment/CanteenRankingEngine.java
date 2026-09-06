
public class CanteenRankingEngine {

    String canteenCode;
    String canteenName;
    int trustScore;

    public CanteenRankingEngine(String canteenCode, String canteenName, int trustScore) {
        this.canteenCode = canteenCode;
        this.canteenName = canteenName;
        this.trustScore = trustScore;
    }

    public CanteenRankingEngine(String canteenCode, String canteenName) {
        this(canteenCode, canteenName, 3);
    }

    int compareTo(CanteenRankingEngine other) {
        if (trustScore != other.trustScore) {
            return other.trustScore - trustScore;
        }

        int code = canteenCode.compareToIgnoreCase(other.canteenCode);
        if (code != 0) {
            return code;
        }

        return canteenName.length() - other.canteenName.length();
    }

    static CanteenRankingEngine[] rankCanteens(CanteenRankingEngine[] canteens) {
        for (int i = 0; i < canteens.length - 1; i++) {
            for (int j = 0; j < canteens.length - i - 1; j++) {
                if (canteens[j].compareTo(canteens[j + 1]) > 0) {
                    CanteenRankingEngine temp = canteens[j];
                    canteens[j] = canteens[j + 1];
                    canteens[j + 1] = temp;
                }
            }
        }
        return canteens;
    }

    public static void main(String[] args) {
        CanteenRankingEngine[] canteens = {
            new CanteenRankingEngine("HB3-C", "Spice Junction", 3),
            new CanteenRankingEngine("hb1-c", "Grand Mess", 5),
            new CanteenRankingEngine("HB2-C", "Southern Treats")
        };

        rankCanteens(canteens);

        for (CanteenRankingEngine c : canteens) {
            System.out.println(c.canteenCode);
        }
    }
}
