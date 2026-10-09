import java.time.*;
import java.util.*;
class HotelRoom {
    String name;
    double rate;
    List<Booking> bookings=new ArrayList<>();
    HotelRoom(String n, double r) {
        name=n;
        rate=r;
    }
boolean available(LocalDate s, LocalDate e) {
        for(Booking b:bookings)if(!b.cancelled&&s.isBefore(b.end)&&e.isAfter(b.start))return false;
        return true;
    }
}
class Booking {
    HotelRoom room;
    LocalDate start, end;
    boolean cancelled;
    Booking(HotelRoom r, LocalDate s, LocalDate e) {
        room=r;
        start=s;
        end=e;
    }
}
public class HotelBookingCancellationSystem {
    public static void main(String[]x) {
        HotelRoom r=new HotelRoom("Deluxe Room 101", 200);
        LocalDate s=LocalDate.of(2024, 12, 1), e=LocalDate.of(2024, 12, 5);
        Booking b=null;
        if(r.available(s, e)) {
            b=new Booking(r, s, e);
            r.bookings.add(b);
            System.out.printf("%s booked from %s to %s. Total price: $%.2f%n", r.name, s, e, r.rate*4);
        }
LocalDate s2=LocalDate.of(2024, 12, 3), e2=LocalDate.of(2024, 12, 7);
        System.out.println(r.available(s2, e2)?"Available":"Booking failed: "+r.name+" is not available for "+s2+" to "+e2);
        if(b!=null) {
            b.cancelled=true;
            System.out.println("Reservation for "+r.name+" cancelled successfully.");
        }
    }
}
