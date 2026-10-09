class BaseFestTicket {
    final String attendeeId;
    final double price;
    double paid;
    BaseFestTicket(String id, double p) {
        if(id== null||id.trim().length()< 4||p<= 0)throw new IllegalArgumentException("Invalid ticket");
        attendeeId= id;
        price= p;
    }
    double getBalanceDue() {
        return price- paid;
    }
    String printTicket() {
        return "Standard Event Ticket | Balance Due: "+ getBalanceDue();
    }
}
class WorkshopFestTicket extends BaseFestTicket {
    String track;
    WorkshopFestTicket(String id, double p, String t) {
        super(id, p);
        track= t;
    }
    String printTicket() {
        return "Workshop Ticket | Track: "+ track+ " | Balance Due: "+ getBalanceDue();
    }
}
class PremiumFestTicket extends WorkshopFestTicket {
    double kitFee;
    PremiumFestTicket(String id, double p, String t, double k) {
        super(id, p, t);
        kitFee= k;
    }
    String printTicket() {
        return "Premium Workshop Ticket | Track: "+ track+ " | Kit Fee: "+ kitFee+ " | Balance Due: "+ getBalanceDue();
    }
}
class HackathonFestTicket extends BaseFestTicket {
    String team;
    HackathonFestTicket(String id, double p, String t) {
        super(id, p);
        team= t;
    }
    String printTicket() {
        return "Hackathon Ticket | Team: "+ team+ " | Balance Due: "+ getBalanceDue();
    }
}
public class ThreeShapesOfTicketFamily {
    static String classify(BaseFestTicket t) {
        if(t instanceof PremiumFestTicket)return "Multilevel descendant (3 generations deep)";
        if(t instanceof HackathonFestTicket)return "Hierarchical sibling (independent branch)";
        if(t instanceof WorkshopFestTicket)return "Workshop descendant";
        return "Base ticket";
    }
    static double total(BaseFestTicket[] ts) {
        double n= 0;
        for(BaseFestTicket t:ts)n+= t.getBalanceDue();
        return n;
    }
    public static void main(String[] args) {
        BaseFestTicket[] ts= {
            new BaseFestTicket("STU1", 500), new WorkshopFestTicket("STU2", 1200, "AI/ML"), new PremiumFestTicket("STU3", 2000, "Cloud Native", 300), new HackathonFestTicket("STU4", 800, "Byte Force")
        };
        for(BaseFestTicket t:ts)System.out.println(t.printTicket());
        System.out.println(classify(ts[2]));
        System.out.println("Total balance: "+ total(ts));
    }
}
