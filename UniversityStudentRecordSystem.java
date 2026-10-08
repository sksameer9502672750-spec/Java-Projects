 import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    String branch;
    int semester;

    double attendance;
    double subject1;
    double subject2;
    double subject3;
    double subject4;
    double subject5;

    Student(int rollNo, String name, String branch, int semester) {
        this.rollNo = rollNo;
        this.name = name;
        this.branch = branch;
        this.semester = semester;
    }

    void enterAcademicDetails(Scanner sc) {
        System.out.print("Enter attendance percentage: ");
        attendance = sc.nextDouble();

        System.out.print("Enter Subject 1 marks: ");
        subject1 = sc.nextDouble();

        System.out.print("Enter Subject 2 marks: ");
        subject2 = sc.nextDouble();

        System.out.print("Enter Subject 3 marks: ");
        subject3 = sc.nextDouble();

        System.out.print("Enter Subject 4 marks: ");
        subject4 = sc.nextDouble();

        System.out.print("Enter Subject 5 marks: ");
        subject5 = sc.nextDouble();
    }

    double getTotal() {
        return subject1 + subject2 + subject3 + subject4 + subject5;
    }

    double getAverage() {
        return getTotal() / 5;
    }

    String getGrade() {
        double average = getAverage();

        if (average >= 90)
            return "A+";
        else if (average >= 80)
            return "A";
        else if (average >= 70)
            return "B";
        else if (average >= 60)
            return "C";
        else if (average >= 50)
            return "D";
        else
            return "F";
    }

    void displayStudent() {
        System.out.println("\n-------------------------------");
        System.out.println("       STUDENT PROFILE");
        System.out.println("-------------------------------");

        System.out.println("Roll Number : " + rollNo);
        System.out.println("Name        : " + name);
        System.out.println("Branch      : " + branch);
        System.out.println("Semester    : " + semester);
    }

    void generateReportCard() {
        double total = getTotal();
        double average = getAverage();

        System.out.println("\n================================");
        System.out.println("          REPORT CARD");
        System.out.println("================================");

        System.out.println("Roll Number : " + rollNo);
        System.out.println("Name        : " + name);
        System.out.println("Branch      : " + branch);
        System.out.println("Semester    : " + semester);

        System.out.println("--------------------------------");
        System.out.println("Attendance  : " + attendance + "%");
        System.out.println("--------------------------------");

        System.out.println("Subject 1   : " + subject1);
        System.out.println("Subject 2   : " + subject2);
        System.out.println("Subject 3   : " + subject3);
        System.out.println("Subject 4   : " + subject4);
        System.out.println("Subject 5   : " + subject5);

        System.out.println("--------------------------------");
        System.out.println("Total Marks : " + total + "/500");
        System.out.println("Average     : " + average + "%");
        System.out.println("Grade       : " + getGrade());

        if (attendance >= 75 && !getGrade().equals("F")) {
            System.out.println("Result      : PASS");
        } else {
            System.out.println("Result      : FAIL");
        }

        System.out.println("================================");
    }
}

public class UniversityStudentRecordSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void addStudent() {

        System.out.println("\n--- ADD STUDENT ---");

        System.out.print("Enter Roll Number: ");
        int rollNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Branch: ");
        String branch = sc.nextLine();

        System.out.print("Enter Semester: ");
        int semester = sc.nextInt();

        Student student =
                new Student(rollNo, name, branch, semester);

        student.enterAcademicDetails(sc);

        students.add(student);

        System.out.println("\nStudent added successfully!");
    }

    static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("\nNo student records found.");
            return;
        }

        System.out.println("\n--- ALL STUDENTS ---");

        for (Student student : students) {
            student.displayStudent();
        }
    }

    static void searchStudent() {

        System.out.print("\nEnter Roll Number to search: ");
        int rollNo = sc.nextInt();

        for (Student student : students) {

            if (student.rollNo == rollNo) {

                student.displayStudent();
                student.generateReportCard();

                return;
            }
        }

        System.out.println("Student not found.");
    }

    static void generateReport() {

        System.out.print("\nEnter Roll Number: ");
        int rollNo = sc.nextInt();

        for (Student student : students) {

            if (student.rollNo == rollNo) {

                student.generateReportCard();

                return;
            }
        }

        System.out.println("Student not found.");
    }

    static void deleteStudent() {

        System.out.print("\nEnter Roll Number to delete: ");
        int rollNo = sc.nextInt();

        for (Student student : students) {

            if (student.rollNo == rollNo) {

                students.remove(student);

                System.out.println("Student deleted successfully!");

                return;
            }
        }

        System.out.println("Student not found.");
    }

    static void menu() {

        while (true) {

            System.out.println("\n=================================");
            System.out.println(" UNIVERSITY STUDENT RECORD SYSTEM");
            System.out.println("=================================");

            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Generate Report Card");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("\nEnter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    generateReport();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    System.out.println(
                            "\nThank you for using the system!");
                    return;

                default:
                    System.out.println(
                            "Invalid choice. Try again.");
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Welcome to University Student Record System");

        menu();

        sc.close();
    }
}

