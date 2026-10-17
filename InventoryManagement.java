import java.util.Scanner;
public class InventoryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] items = {"Pen", "Book", "Bag"};
        int[] stock = {50, 30, 10};
        double[] prices = {10, 50, 500};

        double subtotal = 0;

        System.out.println("--- Available Products ---");

        for (int i = 0; i < items.length; i++) {
            System.out.println((i + 1) + ". " + items[i]
                + " | Price: Rs." + prices[i]
                + " | Stock: " + stock[i]);
        }

        for (int i = 0; i < items.length; i++) {
            System.out.print("Enter quantity of "
                + items[i] + ": ");
            int quantity = sc.nextInt();

            if (quantity < 0 || quantity > stock[i]) {
                System.out.println("Invalid quantity!");
            } else {
                subtotal += quantity * prices[i];
                stock[i] -= quantity;
            }
        }

        double discount = 0;

        if (subtotal >= 1000) {
            discount = subtotal * 0.05;
        }

        double taxableAmount = subtotal - discount;
        double gst = taxableAmount * 0.05;
        double total = taxableAmount + gst;

        System.out.println("\n--- Customer Bill ---");
        System.out.println("Subtotal: Rs." + subtotal);
        System.out.println("Discount: Rs." + discount);
        System.out.println("GST (5%): Rs." + gst);
        System.out.println("Final Bill: Rs." + total);

        System.out.println("\n--- Remaining Stock ---");

        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i] + ": " + stock[i]);
        }

        sc.close();
    }
}