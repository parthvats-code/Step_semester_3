class RaceBase {
    final String bib;
    final double fee;
    double paid;
    RaceBase(String b, double f) {
        if(b== null||b.trim().length()< 4||f<= 0)throw new IllegalArgumentException();
        bib= b;
        fee= f;
    }
    void pay(double x) {
        if(x<= 0||x> getBalanceDue())throw new IllegalArgumentException();
        paid+= x;
    }
    double getBalanceDue() {
        return fee- paid;
    }
    String announce() {
        return "Entry "+ bib+ " | Balance: "+ getBalanceDue();
    }
}
class RegularRunner extends RaceBase {
    String category;
    RegularRunner(String b, double f, String c) {
        super(b, f);
        category= c;
    }
    String announce() {
        return "Runner Entry | Bib: "+ bib+ " | Category: "+ category+ " | Balance: "+ getBalanceDue();
    }
}
class EliteRunner extends RegularRunner {
    double sponsorBonus;
    EliteRunner(String b, double f, String c, double bonus) {
        super(b, f, c);
        sponsorBonus= bonus;
    }
    double getBalanceDue() {
        return Math.max(0, super.getBalanceDue()- sponsorBonus);
    }
    String announce() {
        return "Elite Runner | Bib: "+ bib+ " | Category: "+ category+ " | Sponsor Bonus: "+ sponsorBonus+ " | Balance: "+ getBalanceDue();
    }
}
class RelayTeam extends RaceBase {
    int size;
    RelayTeam(String b, double f, int n) {
        super(b, f);
        if(n< 2)throw new IllegalArgumentException();
        size= n;
    }
    String announce() {
        return "Relay Team | Bib: "+ bib+ " | Team Size: "+ size+ " | Balance: "+ getBalanceDue();
    }
}
public class ThreeShapesOfRaceFamily {
    static String classifyGeneration(RaceBase e) {
        if(e instanceof EliteRunner)return "Multilevel descendant (3 generations deep)";
        if(e instanceof RelayTeam)return "Hierarchical sibling (independent branch)";
        if(e instanceof RegularRunner)return "Runner descendant";
        return "Base entry";
    }
    static double total(RaceBase[] a) {
        double s= 0;
        for(RaceBase e:a)s+= e.getBalanceDue();
        return s;
    }
    public static void main(String[]x) {
        RaceBase[] a= {
            new RegularRunner("BIB2001", 80, "Open 10K"), new EliteRunner("BIB3001", 150, "Elite", 500), new RelayTeam("BIB4001", 300, 4)
        };
        for(RaceBase e:a)System.out.println(e.announce());
        System.out.println(classifyGeneration(a[1]));
        System.out.println("Total balance: "+ total(a));
    }
}
