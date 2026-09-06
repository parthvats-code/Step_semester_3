public class ATMPINLengthValidator {
    void checkPinLength(String pin) {
        if (pin.length() == 4)
            System.out.println("PIN length OK.");
        else
            System.out.println("Invalid PIN — must be exactly 4 digits.");
    }

    public static void main(String[] args) {
        new ATMPINLengthValidator().checkPinLength("4820");
    }
}
