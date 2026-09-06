public class ProductInventoryCSVParser {
    void parseInventoryRecord(String csvLine) {
        String[] data = csvLine.split(",");

        if (data.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.println("Product: " + data[0] +
                " | SKU: " + data[1] +
                " | Qty: " + data[2]);
    }

    public static void main(String[] args) {
        new ProductInventoryCSVParser()
                .parseInventoryRecord("Wireless Mouse,WM-2201,150");
    }
}
