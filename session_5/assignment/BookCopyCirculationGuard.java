
public class BookCopyCirculationGuard {

    private int copiesTotal;
    private int copiesAvailable;

    public BookCopyCirculationGuard(int copiesTotal) {
        if (copiesTotal <= 0) {
            throw new IllegalArgumentException(
                    "Total copies must be positive");
        }

        this.copiesTotal = copiesTotal;
        this.copiesAvailable = copiesTotal;
    }

    public void checkOut() {
        if (copiesAvailable > 0) {
            copiesAvailable--;
        }
    }

    public void checkIn() {
        if (copiesAvailable < copiesTotal) {
            copiesAvailable++;
        }
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public static void main(String[] args) {

        try {
            new BookCopyCirculationGuard(0);
        } catch (Exception e) {
            System.out.println("Construction rejected");
        }

        BookCopyCirculationGuard book
                = new BookCopyCirculationGuard(3);

        book.checkOut();
        book.checkOut();
        book.checkOut();
        book.checkOut();

        System.out.println(
                "Available after checkouts: "
                + book.getCopiesAvailable());

        book.checkIn();
        book.checkIn();
        book.checkIn();
        book.checkIn();

        System.out.println(
                "Available after checkins: "
                + book.getCopiesAvailable());
    }
}
