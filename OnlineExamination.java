import java.util.Scanner;

public class OnlineExamination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] questions = {
            "1. Which language is used for Java programs?",
            "2. Which keyword creates an object?",
            "3. Which loop runs while a condition is true?"
        };

        String[][] options = {
            {"A. Java", "B. HTML", "C. CSS", "D. SQL"},
            {"A. class", "B. new", "C. void", "D. static"},
            {"A. if", "B. switch", "C. while", "D. break"}
        };

        char[] answers = {'A', 'B', 'C'};
        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println("\n" + questions[i]);

            for (int j = 0; j < 4; j++) {
                System.out.println(options[i][j]);
            }

            System.out.print("Enter answer (A/B/C/D): ");
            char answer = Character.toUpperCase(
                sc.next().charAt(0));

            if (answer == answers[i]) {
                score++;
            }
        }

        System.out.println("\n--- Examination Result ---");
        System.out.println("Total Questions: " + questions.length);
        System.out.println("Correct Answers: " + score);
        System.out.println("Marks: " + score + "/" + questions.length);

        sc.close();
    }
}
