abstract class PaymentMethod {
    private static int count=1000;
    private final String transactionId;
    PaymentMethod() {
        transactionId="TXN-"+(++count);
    }
    public abstract String processPayment(double amount);
    public String processPayment(double amount, String note) {
        return processPayment(amount)+" ("+note+")";
    }
    String getTransactionId() {
        return transactionId;
    }
}
class CreditCardPayment extends PaymentMethod {
    String lastFour;
    CreditCardPayment(String n) {
        lastFour=n;
    }
    public String processPayment(double a) {
        return "Charged $"+a+" to card ending "+lastFour+" - Txn "+getTransactionId();
    }
}
class CashPayment extends PaymentMethod {
    public String processPayment(double a) {
        return "Received $"+a+" in cash - Txn "+getTransactionId();
    }
}
public class CheckoutPaymentHandler {
    static void printConfirmation(PaymentMethod p, double a) {
        System.out.println(p.processPayment(a));
    }
    public static void main(String[] args) {
        CreditCardPayment cc=new CreditCardPayment("4471");
        PaymentMethod ref=cc;
        printConfirmation(ref, 250);
        System.out.println(cc.processPayment(250, "Birthday gift"));
        System.out.println(new CashPayment().processPayment(40));
    }
}
