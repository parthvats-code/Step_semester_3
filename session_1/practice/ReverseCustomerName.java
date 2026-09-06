public class ReverseCustomerName {
    String reverseCustomerName(String customerName) {
        String reversed = "";

        for (int i = customerName.length() - 1; i >= 0; i--)
            reversed += customerName.charAt(i);

        return reversed;
    }

    public static void main(String[] args) {
        ReverseCustomerName obj = new ReverseCustomerName();

        String name = "Sunil";

        System.out.println("Original Name: " + name);
        System.out.println("Reversed Name: " + obj.reverseCustomerName(name));
    }
}
