
public class GhostOrderValidator {

    String studentName;
    String dishName;
    boolean delivered;

    public GhostOrderValidator(String studentName, String dishName) {
        if (studentName == null || studentName.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid student name");
        }
        if (dishName == null || dishName.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid dish name");
        }

        this.studentName = studentName;
        this.dishName = dishName;
    }

    void markDelivered() {
        if (!delivered) {
            delivered = true;
            System.out.println("Order delivered");
        } else {
            System.out.println("Order already delivered");
        }
    }

    static void processBatch(String[][] rawOrders) {
        int valid = 0, rejected = 0;

        for (String[] order : rawOrders) {
            try {
                new GhostOrderValidator(order[0], order[1]);
                valid++;
            } catch (Exception e) {
                rejected++;
            }
        }

        System.out.println("Valid: " + valid + " | Rejected: " + rejected);
    }

    public static void main(String[] args) {
        String[][] orders = {
            {"Ravi", "Paneer Butter Masala"},
            {"", "Chole Bhature"},
            {"Meera", " "},
            {"Divya", "Veg Biryani"}
        };

        processBatch(orders);

        GhostOrderValidator obj = new GhostOrderValidator("Ravi", "Paneer");
        obj.markDelivered();
        obj.markDelivered();
    }
}
