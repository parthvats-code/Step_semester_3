class RegistrationPolicy  {
    protected double rate= .05;
    void applyPenalty(Registrant r, double fee) {
        r.penalty+= fee*rate;
    }
}
class Registrant  {
    String id;
    double penalty;
    Registrant(String i) {
        id= i;
    }
}
class LateRegistrantPolicy extends RegistrationPolicy  {
    @Override void applyPenalty(Registrant r, double fee) {
        super.applyPenalty(r, fee);
        r.penalty+= fee*.10;
    }
}
public class LateRegistrationPenaltyAudit  {
    public static void main(String[]x) {
        Registrant a= new Registrant("STU1001"), b= new Registrant("STU1002");
        new RegistrationPolicy().applyPenalty(a, 100);
        new LateRegistrantPolicy().applyPenalty(b, 100);
        System.out.println(a.id+ " penalty: "+ a.penalty);
        System.out.println(b.id+ " penalty: "+ b.penalty);
    }
}
