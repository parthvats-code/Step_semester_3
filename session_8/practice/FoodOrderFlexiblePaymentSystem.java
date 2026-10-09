import java.util.*;
interface PaymentMethod2 {
    boolean pay(double a);
}
class CardPay implements PaymentMethod2 {
    public boolean pay(double a) {
        return a>0;
    }
}
class WalletPay implements PaymentMethod2 {
    double balance;
    WalletPay(double b) {
        balance=b;
    }
public boolean pay(double a) {
        if(a<=0||a>balance)return false;
        balance-=a;
        return true;
    }
}
class FoodOrder {
    Map<String, Integer> items=new LinkedHashMap<>();
    void add(String item, int q) {
        if(q>0)items.put(item, items.getOrDefault(item, 0)+q);
    }
boolean place(double total, PaymentMethod2 p) {
        if(items.isEmpty())throw new IllegalStateException("Order must contain at least one item");
        return p.pay(total);
    }
}
public class FoodOrderFlexiblePaymentSystem {
    public static void main(String[]x) {
        FoodOrder o=new FoodOrder();
        o.add("Sandwich", 2);
        o.add("Juice", 1);
        System.out.println(o.place(250, new CardPay())?"Order placed successfully":"Payment failed; order not placed");
    }
}
