import java.util.Scanner;

public class AttendanceManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        String[] names = new String[n];
        int[] present = new int[n];
        int totalClasses;

        System.out.print("Enter total classes conducted: ");
        totalClasses = sc.nextInt();

        for (int i = 0; i < n; i++) {
            sc.nextLine();
            System.out.print("Enter student name: ");
            names[i] = sc.nextLine();

            System.out.print("Classes attended: ");
            present[i] = sc.nextInt();
        }

        System.out.println("\n--- Attendance Report ---");

        for (int i = 0; i < n; i++) {
            double percentage =
                (present[i] * 100.0) / totalClasses;

            System.out.println("Name: " + names[i]);
            System.out.println("Attendance: "
                               + percentage + "%");

            if (percentage < 75) {
                System.out.println("Low Attendance");
            } else {
                System.out.println("Attendance Sufficient");
            }
            System.out.println();
        }

        sc.close();
    }
}


