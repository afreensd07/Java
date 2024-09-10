// StudentManagementSystem.java
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    // Method to add a new student
    private static void addStudent() {
        System.out.print("Enter Roll Number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Course: ");
        String course = scanner.nextLine();

        Student newStudent = new Student(rollNumber, name, course);
        studentList.add(newStudent);
        System.out.println("Student added successfully!");
    }

    // Method to view all students
    private static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }

    // Method to update a student record
    private static void updateStudent() {
        System.out.print("Enter Roll Number of the student to update: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Student student : studentList) {
            if (student.getRollNumber() == rollNumber) {
                System.out.print("Enter New Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter New Course: ");
                String course = scanner.nextLine();

                student.setName(name);
                student.setCourse(course);
                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // Method to delete a student record
    private static void deleteStudent() {
        System.out.print("Enter Roll Number of the student to delete: ");
        int rollNumber = scanner.nextInt();

        for (Student student : studentList) {
            if (student.getRollNumber() == rollNumber) {
                studentList.remove(student);
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }
}
