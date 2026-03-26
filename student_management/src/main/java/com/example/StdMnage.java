package com.example;

import java.util.*;

public class StdMnage {

    private static ArrayList<Students> students = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View All Student");
            System.out.println("3. Serch Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter Your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudent();
                    break;
                case 3:
                    serchStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice pleage try again");
            }
        }
        System.out.println("GoodBye");
        scanner.close();
    }

    // new student add method
    private static void addStudent() {
        System.out.print("Enter Student Id: ");
        String id = scanner.nextLine();

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter student Grade: ");
        char grade = scanner.nextLine().charAt(0);

        Students student = new Students(id, name, age, grade);
        students.add(student);
        System.out.println("Add Student successfully");
    }

    // view method all student
    private static void viewAllStudent() {
        if (students.isEmpty()) {
            System.out.println("student not found");
        } else {
            System.out.println("\nstudents list");
            for (Students std : students) {
                System.out.println(std);
            }
        }
    }

    // search method student by id
    private static void serchStudent() {
        System.out.print("Enter Student Id to search: ");
        String id = scanner.nextLine();

        boolean found = false;
        for (Students std2 : students) {
            if (std2.getId().equals(id)) {
                System.out.println("Student found");
                System.out.println(std2);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student " + id + "not found");
        }
    }

    // deleted mathod by id
    private static void deleteStudent() {
        System.out.print("Enter Student id to delete: ");
        String id = scanner.nextLine();

        boolean remove = students.removeIf(student -> student.getId().equals(id));

        if (remove) {
            System.out.println("Student " + id + "is deleted");
        } else {
            System.out.println("Student " + id + "is not found");
        }
    }
};