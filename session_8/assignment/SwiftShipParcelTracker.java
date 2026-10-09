import java.util.*;
interface ShippingType  {
    double charge(double kg);
}
class StandardShipping implements ShippingType  {
    public double charge(double kg) {
        return 40+10*kg;
    }
}
class ExpressShipping implements ShippingType  {
    public double charge(double kg) {
        return 80+15*kg;
    }
}
class FragileShipping implements ShippingType  {
    public double charge(double kg) {
        return 40+10*kg+50;
    }
}
interface NotificationChannel  {
    void notify(String parcel, String status);
}
class SmsChannel implements NotificationChannel  {
    public void notify(String p, String s) {
        System.out.println("[SMS] "+p+" is now "+s+".");
    }
}
class EmailChannel implements NotificationChannel  {
    public void notify(String p, String s) {
        System.out.println("[Email] "+p+" is now "+s+".");
    }
}
class Parcel  {
    String id, status="BOOKED";
    double kg;
    ShippingType type;
    List<NotificationChannel> channels;
    Parcel(String i, double w, ShippingType t, List<NotificationChannel> c) {
        id=i;
        kg=w;
        type=t;
        channels=c;
    }
boolean transition(String next) {
        String[] states= {
            "BOOKED", "PICKED_UP", "IN_TRANSIT", "OUT_FOR_DELIVERY", "DELIVERED"
        };
        int i=Arrays.asList(states).indexOf(status);
        if(i<0||i+1>=states.length||!states[i+1].equals(next)) {
            System.out.println("Invalid transition: "+status+" → "+next+" is not allowed.");
            return false;
        }
status=next;
        for(NotificationChannel c:channels)c.notify(id, status);
        return true;
    }
void cancel() {
        if(!status.equals("BOOKED"))System.out.println("Cancellation failed: "+id+" can be cancelled only while BOOKED.");
        else status="CANCELLED";
    }
}
public class SwiftShipParcelTracker  {
    public static void main(String[] args) {
        Parcel p=new Parcel("P101", 2, new ExpressShipping(), Arrays.asList(new SmsChannel(), new EmailChannel()));
        System.out.println("Parcel P101 booked (Express, 2 kg).");
        System.out.printf("Charge: ₹%.2f%n", p.type.charge(p.kg));
        for(NotificationChannel c:p.channels)c.notify(p.id, p.status);
        p.transition("PICKED_UP");
        p.cancel();
        p.transition("IN_TRANSIT");
        p.transition("DELIVERED");
    }
}
