import java.util.Scanner;

public class TravelBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] packages = {
            "Hyderabad", "Goa", "Bangalore"
        };

        int[] prices = {2000, 5000, 3000};

        System.out.println("--- Travel Packages ---");

        for (int i = 0; i < packages.length; i++) {
            System.out.println((i + 1) + ". "
                + packages[i] + " - Rs." + prices[i]);
        }

        System.out.print("Choose package (1-3): ");
        int choice = sc.nextInt();

        if (choice < 1 || choice > 3) {
            System.out.println("Invalid package");
        } else {
            System.out.print("Number of travellers: ");
            int people = sc.nextInt();

            System.out.println("Package: "
                + packages[choice - 1]);
            System.out.println("Total cost: Rs."
                + (prices[choice - 1] * people));
            System.out.println("Booking successful!");
        }

        sc.close();
    }
}

