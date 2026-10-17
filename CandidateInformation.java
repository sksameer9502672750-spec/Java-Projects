import java.util.Scanner;
public class CandidateInformation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of candidates: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] names = new String[n];
        String[] skills = new String[n];
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nCandidate " + (i + 1));

            System.out.print("Enter name: ");
            names[i] = sc.nextLine();

            System.out.print("Enter skill: ");
            skills[i] = sc.nextLine();

            System.out.print("Interview status: ");
            status[i] = sc.nextLine();
        }

        System.out.print("\nEnter skill to search: ");
        String search = sc.nextLine();

        System.out.println("\n--- Candidate Report ---");
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (skills[i].equalsIgnoreCase(search)) {
                System.out.println("Name: " + names[i]);
                System.out.println("Skill: " + skills[i]);
                System.out.println("Status: " + status[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching candidate found.");
        }

        sc.close();
    }
}