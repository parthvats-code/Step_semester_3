public class RaceDayAnnouncerBoard  {
    interface Announceable  {
        String announce();
    }
static class Entry implements Announceable  {
        final String name;
        Entry(String n) {
            name= n;
        }
public String announce() {
            return "Entry: "+ name;
        }
    }
static class Runner extends Entry  {
        Runner(String n) {
            super(n);
        }
public String announce() {
            return "Runner: "+ name;
        }
    }
static class Relay extends Entry  {
        final int members;
        Relay(String n, int m) {
            super(n);
            members= m;
        }
public String announce() {
            return "Relay: "+ name+ " ("+ members+ " members)";
        }
    }
static void announceAll(Announceable[] entries) {
        for(Announceable e:entries)System.out.println(e.announce());
    }
public static void main(String[] args) {
        announceAll(new Announceable[] {
            new Runner("Asha"), new Relay("FastFour", 4)
        });
    }
}
