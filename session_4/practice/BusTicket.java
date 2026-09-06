
import java.util.*;

public class BusTicket {

    String passengerName;
    String destination;
    boolean checkedIn;

    public BusTicket(String passengerName, String destination) {
        if (passengerName == null || passengerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid passenger name");
        }
        if (destination == null || destination.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid destination");
        }

        this.passengerName = passengerName;
        this.destination = destination;
    }

    void markCheckedIn() {
        if (!checkedIn) {
            checkedIn = true;
            System.out.println("Checked in");
        } else {
            System.out.println("Already checked in");
        }
    }

    static void processBatch(String[][] rawBookings) {
        Set<String> accepted = new HashSet<>();
        int valid = 0, rejected = 0, duplicates = 0;

        for (String[] booking : rawBookings) {
            try {
                BusTicket ticket = new BusTicket(booking[0], booking[1]);
                String key = ticket.passengerName + "|" + ticket.destination;

                if (accepted.contains(key)) {
                    duplicates++; 
                }else {
                    accepted.add(key);
                    valid++;
                }
            } catch (Exception e) {
                rejected++;
            }
        }

        System.out.println("Valid: " + valid
                + " | Rejected: " + rejected
                + " | Duplicates skipped: " + duplicates);
    }

    public static void main(String[] args) {
        String[][] bookings = {
            {"Divya", "Chennai"},
            {"", "Bangalore"},
            {"Ravi123", "Pune"},
            {"Divya", "Chennai"},
            {" ", " "}
        };

        processBatch(bookings);
    }
}
