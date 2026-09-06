
public class ExamHallSeatDuplicationChecker {

    int[] seatNumbers;

    ExamHallSeatDuplicationChecker(int[] seatNumbers) {
        this.seatNumbers = seatNumbers;
    }

    void checkDuplicateSeats() {
        boolean found = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        int[] seats = {101, 102, 103, 102, 105};

        ExamHallSeatDuplicationChecker obj
                = new ExamHallSeatDuplicationChecker(seats);

        obj.checkDuplicateSeats();
    }
}
