
    import java.util.ArrayList;
import java.util.Scanner;

class Patient {
    int id;
    String name;
    int age;
    String disease;
    String doctor;
    String appointment;
    double bill;

    Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
        this.doctor = "Not Assigned";
        this.appointment = "Not Booked";
        this.bill = 0.0;
    }

    void display() {
        System.out.println("\n----------------------------");
        System.out.println("Patient ID   : " + id);
        System.out.println("Name         : " + name);
        System.out.println("Age          : " + age);
        System.out.println("Disease      : " + disease);
        System.out.println("Doctor       : " + doctor);
        System.out.println("Appointment  : " + appointment);
        System.out.println("Bill Amount  : Rs. " + bill);
        System.out.println("----------------------------");
    }
}

public class HospitalManagementSystem {

    static ArrayList<Patient> patients = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static Patient findPatient(int id) {
        for (Patient p : patients) {
            if (p.id == id) {
                return p;
            }
        }
        return null;
    }

    static void registerPatient() {
        System.out.println("\n--- Patient Registration ---");

        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (findPatient(id) != null) {
            System.out.println("Patient ID already exists!");
            return;
        }

        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        if (age <= 0 || age > 120) {
            System.out.println("Please enter a valid age.");
            return;
        }

        System.out.print("Enter Disease / Health Complaint: ");
        String disease = sc.nextLine();

        Patient p = new Patient(id, name, age, disease);
        patients.add(p);

        System.out.println("Patient registered successfully!");
    }

    static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patient records available.");
            return;
        }

        System.out.println("\n--- All Patient Records ---");
        for (Patient p : patients) {
            p.display();
        }
    }

    static void searchPatient() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();

        Patient p = findPatient(id);

        if (p != null) {
            p.display();
        } else {
            System.out.println("Patient not found!");
        }
    }

    static void bookAppointment() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Patient p = findPatient(id);

        if (p == null) {
            System.out.println("Patient not found!");
            return;
        }

        System.out.print("Enter Doctor Name: ");
        p.doctor = sc.nextLine();

        System.out.print("Enter Appointment Date and Time: ");
        p.appointment = sc.nextLine();

        System.out.println("Appointment booked successfully!");
    }

    static void generateBill() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();

        Patient p = findPatient(id);

        if (p == null) {
            System.out.println("Patient not found!");
            return;
        }

        System.out.print("Enter Consultation Fee (Rs.): ");
        double consultation = sc.nextDouble();

        System.out.print("Enter Medicine Charges (Rs.): ");
        double medicine = sc.nextDouble();

        System.out.print("Enter Test Charges (Rs.): ");
        double tests = sc.nextDouble();

        if (consultation < 0 || medicine < 0 || tests < 0) {
            System.out.println("Charges cannot be negative.");
            return;
        }

        p.bill = consultation + medicine + tests;

        System.out.println("\n======= HOSPITAL BILL =======");
        System.out.println("Patient ID  : " + p.id);
        System.out.println("Patient Name: " + p.name);
        System.out.println("Consultation: Rs. " + consultation);
        System.out.println("Medicines   : Rs. " + medicine);
        System.out.println("Tests       : Rs. " + tests);
        System.out.println("-----------------------------");
        System.out.println("Total Bill  : Rs. " + p.bill);
        System.out.println("=============================");
    }

    static void menu() {
        while (true) {
            System.out.println("\n================================");
            System.out.println("   HOSPITAL MANAGEMENT SYSTEM");
            System.out.println("================================");
            System.out.println("1. Register Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Search Patient / History");
            System.out.println("4. Book Appointment");
            System.out.println("5. Generate Bill");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    registerPatient();
                    break;
                case 2:
                    viewPatients();
                    break;
                case 3:
                    searchPatient();
                    break;
                case 4:
                    bookAppointment();
                    break;
                case 5:
                    generateBill();
                    break;
                case 6:
                    System.out.println("Thank you for using the system!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Hospital Management System");
        menu();
        sc.close();
    }
}

