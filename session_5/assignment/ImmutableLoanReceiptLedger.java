
import java.util.Arrays;

class LoanReceipt {

    private final String memberId;
    private final String[] bookIds;

    public LoanReceipt(String memberId, String[] bookIds) {
        if (memberId == null || bookIds == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        for (String id : bookIds) {
            if (!isValidBookId(id)) {
                throw new IllegalArgumentException(
                        "Invalid book ID");
            }
        }

        this.memberId = memberId;
        this.bookIds = bookIds.clone();
    }

    private boolean isValidBookId(String id) {
        if (id == null || id.length() != 6) {
            return false;
        }

        if (id.charAt(0) != 'B'
                || id.charAt(1) != 'K'
                || id.charAt(2) != '-') {
            return false;
        }

        for (int i = 3; i < 6; i++) {
            if (!Character.isDigit(id.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public String getMemberId() {
        return memberId;
    }

    public String[] getBookIds() {
        return bookIds.clone();
    }

    public LoanReceipt withCorrectedBookId(
            int index, String newId) {

        if (index < 0 || index >= bookIds.length) {
            throw new IndexOutOfBoundsException();
        }

        if (!isValidBookId(newId)) {
            throw new IllegalArgumentException(
                    "Invalid book ID");
        }

        String[] corrected = bookIds.clone();
        corrected[index] = newId;

        return new LoanReceipt(memberId, corrected);
    }
}

class ReferenceOnlyLoanReceipt extends LoanReceipt {

    private final String roomNumber;

    public ReferenceOnlyLoanReceipt(
            String memberId,
            String[] bookIds,
            String roomNumber) {

        super(memberId, bookIds);
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }
}

public class ImmutableLoanReceiptLedger {

    static String systemName;

    static {
        systemName = "PageTurner Library";
    }

    static String processNightlyCirculation(
            LoanReceipt[] receipts) {

        int processed = 0;
        int nullSkipped = 0;
        int referenceOnly = 0;
        int regular = 0;

        for (LoanReceipt receipt : receipts) {

            if (receipt == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (receipt instanceof ReferenceOnlyLoanReceipt) {
                referenceOnly++;
            } else {
                regular++;
            }
        }

        return processed + " processed | "
                + nullSkipped + " null skipped | "
                + referenceOnly + " reference-only | "
                + regular + " regular";
    }

    public static void main(String[] args) {

        try {
            new LoanReceipt(
                    "LIB-8841",
                    new String[]{"BK-100", "bad"});
        } catch (Exception e) {
            System.out.println("Construction rejected");
        }

        LoanReceipt receipt
                = new LoanReceipt(
                        "LIB-8841",
                        new String[]{"BK-100", "BK-101"});

        String[] ids = receipt.getBookIds();
        ids[0] = "HACKED";

        System.out.println(
                receipt.getBookIds()[0]);

        LoanReceipt corrected
                = receipt.withCorrectedBookId(
                        0, "BK-999");

        System.out.println(
                Arrays.toString(
                        corrected.getBookIds()));

        LoanReceipt[] receipts = {
            new ReferenceOnlyLoanReceipt(
            "LIB-001",
            new String[]{"BK-200"},
            "Reading Room 3"),
            null,
            new LoanReceipt(
            "LIB-002",
            new String[]{"BK-201"})
        };

        System.out.println(
                processNightlyCirculation(receipts));
    }
}
