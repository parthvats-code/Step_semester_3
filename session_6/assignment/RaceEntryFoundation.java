import java.util.*;
class RaceEntry {
    protected final String bibNumber;
    protected final double entryFee;
    protected double paid;
    RaceEntry(String bibNumber, double entryFee) {
        if(bibNumber== null||bibNumber.trim().length()< 4)throw new IllegalArgumentException("Invalid bib");
        if(entryFee<= 0)throw new IllegalArgumentException("Fee must be positive");
        this.bibNumber= bibNumber;
        this.entryFee= entryFee;
    }
    void pay(double amount) {
        if(amount<= 0||amount> getBalanceDue())throw new IllegalArgumentException("Invalid payment");
        paid+= amount;
    }
    double getBalanceDue() {
        return entryFee- paid;
    }
    void applyLateFee(double amount) {
        if(amount< 0)throw new IllegalArgumentException();
        paid-= amount;
    }
    String announce() {
        return "Race Entry | Bib: "+ bibNumber+ " | Balance: "+ getBalanceDue();
    }
}
class RunnerEntry extends RaceEntry {
    protected final String category;
    RunnerEntry(String bib, double fee, String category) {
        super(bib, fee);
        this.category= category;
    }
    @Override String announce() {
        return "Runner Entry | Bib: "+ bibNumber+ " | Category: "+ category+ " | Balance: "+ getBalanceDue();
    }
    @Override void applyLateFee(double amount) {
        super.applyLateFee(amount*1.5);
    }
}
class EliteRunnerEntry extends RunnerEntry {
    private final double sponsorBonus;
    EliteRunnerEntry(String bib, double fee, String category, double bonus) {
        super(bib, fee, category);
        sponsorBonus= bonus;
    }
    @Override double getBalanceDue() {
        return Math.max(0, super.getBalanceDue()- sponsorBonus);
    }
    @Override String announce() {
        return "Elite Runner | Bib: "+ bibNumber+ " | Category: "+ category+ " | Sponsor Bonus: "+ sponsorBonus+ " | Balance: "+ getBalanceDue();
    }
}
class RelayTeamEntry extends RaceEntry {
    private final int teamSize;
    RelayTeamEntry(String bib, double fee, int size) {
        super(bib, fee);
        if(size< 2)throw new IllegalArgumentException("Team must have at least 2 members");
        teamSize= size;
    }
    @Override String announce() {
        return "Relay Team | Bib: "+ bibNumber+ " | Team Size: "+ teamSize+ " | Balance: "+ getBalanceDue();
    }
}
public class RaceEntryFoundation {
    static String registerBatch(String[] bibs, double fee) {
        int ok= 0, bad= 0;
        for(String b:bibs)try {
            new RaceEntry(b, fee);
            ok++;
        } catch(IllegalArgumentException e) {
            bad++;
        }
        return "Registered: "+ ok+ " | Rejected: "+ bad;
    }
    static String classifyGeneration(RaceEntry e) {
        if(e instanceof EliteRunnerEntry)return "Multilevel descendant (3 generations deep)";
        if(e instanceof RelayTeamEntry)return "Hierarchical sibling (independent branch)";
        if(e instanceof RunnerEntry)return "Single-inheritance descendant";
        return "Base entry";
    }
    static double getTotalBalanceDue(RaceEntry[] entries) {
        double total= 0;
        for(RaceEntry e:entries)total+= e.getBalanceDue();
        return total;
    }
    public static void main(String[] args) {
        System.out.println(registerBatch(new String[] {
            "BIB1", "B1", "BIB2"
        }, 80));
        RunnerEntry r= new RunnerEntry("BIB2001", 80, "Open 10K");
        r.pay(30);
        System.out.println(r.getBalanceDue());
    }
}
