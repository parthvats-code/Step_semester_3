interface BonusPolicy  {
    double bonus(double salary, double performance);
}
class StandardBonus implements BonusPolicy  {
    public double bonus(double s, double p) {
        return s*p;
    }
}
class SalesBonus implements BonusPolicy  {
    public double bonus(double s, double p) {
        return s*p+5000;
    }
}
public class QuarterlyBonusCalculator  {
    public static void main(String[] args) {
        BonusPolicy[] policies= {
            new StandardBonus(), new SalesBonus()
        };
        for(BonusPolicy p:policies)System.out.println(p.bonus(50000, .1));
    }
}
