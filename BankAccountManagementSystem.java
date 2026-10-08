import java.util.Scanner;
public class BankAccountManagementSystem {
    

    static Scanner sc = new Scanner(System.in);

    static String accountNumber;
    static String customerName;
    static double balance;

    // Method to enter customer details
    static void entry() {
        System.out.print("Enter Account Number: ");
        accountNumber = sc.nextLine();

        System.out.print("Enter Customer Name: ");
        customerName = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        balance = sc.nextDouble();

        while (balance < 0) {
            System.out.println("Initial balance cannot be negative.");
            System.out.print("Enter Initial Balance: ");
            balance = sc.nextDouble();
        }

        sc.nextLine(); // Clear input buffer

        System.out.println("\nAccount details entered successfully!");
    }

    // Method to deposit money
    static void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();

        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Deposit successful!");
            System.out.println("Deposited Amount: " + amount);
        } else {
            System.out.println("Deposit amount must be greater than 0.");
        }
    }

    // Method to withdraw money
    static void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than 0.");
        } 
        else if (amount <= balance) {
            balance = balance - amount;
            System.out.println("Withdrawal successful!");
            System.out.println("Withdrawn Amount: " + amount);
        } 
        else {
            System.out.println("Insufficient Balance");
        }
    }

    // Method to display current balance
    static void returnBalance() {
        System.out.println("\n----- Account Details -----");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Customer Name  : " + customerName);
        System.out.println("Current Balance: " + balance);
    }

    // Method to exit the application
    static void exit() {
        System.out.println("\nThank you for using the Bank Account Management System!");
    }

    // Main method
    public static void main(String[] args) {

        entry();

        int choice;

        do {
            System.out.println("\n===== BANK ACCOUNT MANAGEMENT SYSTEM =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    deposit();
                    break;

                case 2:
                    withdraw();
                    break;

                case 3:
                    returnBalance();
                    break;

                case 4:
                    exit();
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}

