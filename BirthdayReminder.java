import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class BirthdayReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter birth year: ");
        int year = sc.nextInt();

        System.out.print("Enter birth month: ");
        int month = sc.nextInt();

        System.out.print("Enter birth day: ");
        int day = sc.nextInt();

        LocalDate dob = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();

        int age = Period.between(dob, today).getYears();

        LocalDate nextBirthday =
            dob.withYear(today.getYear());

        if (nextBirthday.isBefore(today)) {
            nextBirthday = nextBirthday.plusYears(1);
        }
        

        long days = ChronoUnit.DAYS.between(
            today, nextBirthday);

        System.out.println("\n--- Birthday Details ---");
        System.out.println("Name: " + name);
        System.out.println("Current Date: " + today);
        System.out.println("Date of Birth: " + dob);
        System.out.println("Born On: " + dob.getDayOfWeek());
        System.out.println("Age: " + age);
        System.out.println("Days until birthday: " + days);

        if (today.getMonthValue() == month &&
            today.getDayOfMonth() == day) {
            System.out.println("Happy Birthday, " + name + "!");
        }

        sc.close();
    }
}

