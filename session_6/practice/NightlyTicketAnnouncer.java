public class NightlyTicketAnnouncer  {
    interface Announceable {
        String announce();
    }
static class Ticket implements Announceable {
        String id;
        Ticket(String i) {
            id= i;
        }
public String announce() {
            return "Ticket "+ id;
        }
    }
static class Workshop extends Ticket {
        Workshop(String i) {
            super(i);
        }
public String announce() {
            return "Workshop ticket "+ id;
        }
    }
static class Hackathon extends Ticket {
        Hackathon(String i) {
            super(i);
        }
public String announce() {
            return "Hackathon ticket "+ id;
        }
    }
static void announceAll(Announceable[] a) {
        for(Announceable x:a)System.out.println(x.announce());
    }
public static void main(String[] args) {
        announceAll(new Announceable[] {
            new Ticket("T1001"), new Workshop("T1002"), new Hackathon("T1003")
        });
    }
}
