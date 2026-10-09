import java.util.*;
class SmartCard  {
    String id;
    double balance;
    SmartCard(String i, double b) {
        id=i;
        balance=b;
    }
void topUp(double a) {
        if(a>0)balance+=a;
    }
boolean pay(double a) {
        if(a<=0||a>balance)return false;
        balance-=a;
        return true;
    }
}
public class CampusCanteenSmartCard  {
    public static void main(String[] args) {
        SmartCard c=new SmartCard("SC101", 200);
        System.out.println("Card "+c.id+" balance: ₹"+c.balance);
        System.out.println(c.pay(65)?"Payment successful":"Payment declined");
        System.out.println("Remaining balance: ₹"+c.balance);
        c.topUp(100);
        System.out.println("After top-up: ₹"+c.balance);
    }
}
