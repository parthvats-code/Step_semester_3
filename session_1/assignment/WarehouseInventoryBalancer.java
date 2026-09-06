
public class WarehouseInventoryBalancer {

    int[] section1;
    int[] section2;

    WarehouseInventoryBalancer(int[] section1, int[] section2) {
        this.section1 = section1;
        this.section2 = section2;
    }

    void analyzeInventory() {
        int total1 = 0;
        int total2 = 0;

        for (int i = 0; i < section1.length; i++) {
            total1 += section1[i];
            total2 += section2[i];
        }

        System.out.println("Section 1 Total: " + total1);
        System.out.println("Section 2 Total: " + total2);

        if (total1 == total2) {
            System.out.println("Inventory Balanced");
        } else {
            System.out.println("Inventory Not Balanced");
        }

        int highest = section1[0];
        int index = 0;

        for (int i = 1; i < section1.length; i++) {
            if (section1[i] > highest) {
                highest = section1[i];
                index = i;
            }
        }

        for (int i = 0; i < section2.length; i++) {
            if (section2[i] > highest) {
                highest = section2[i];
                index = i;
            }
        }

        System.out.println("Highest Quantity: " + highest);
        System.out.println("Section Index: " + index);
    }

    public static void main(String[] args) {
        int[] section1 = {20, 30, 40};
        int[] section2 = {25, 35, 30};

        WarehouseInventoryBalancer obj
                = new WarehouseInventoryBalancer(section1, section2);

        obj.analyzeInventory();
    }
}
