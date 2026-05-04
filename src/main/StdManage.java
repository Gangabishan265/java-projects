package main;

import java.sql.*;
import java.util.*;

public class StdManage {
    private static Statement stmt = null;
    private static Connection connet = null;
    private static PreparedStatement pstmt = null;
    private static ResultSet rset = null;

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {

        connet = DbUnite.getConnection();
        boolean running = true;
        try {
            while (running) {
                System.out.println("\nJDBC Student Mangaement System");
                System.out.println("1. add new Student");
                System.out.println("2. view all Students ");
                System.out.println("3. search student ");
                System.out.println("4. update student ");
                System.out.println("5. delete student ");
                System.out.println("6. exit ");
                System.out.print("enter your choice: ");

                int choice = scan.nextInt();
                scan.nextLine();

                switch (choice) {
                    case 1 -> addStudent();

                    case 2 -> readStudent();

                    case 3 -> searchStudent();

                    case 4 -> updateStudent();

                    case 5 -> deleteStudent();

                    case 6 -> running = false;
                    default -> System.out.println("Please enter choice correct");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DbUnite.closeConnetion(connet, stmt, rset);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void printHold() throws SQLException {
        System.out.printf("| %-5s | %-15s | %-5s | %-15s |\n",
                rset.getInt("id"),
                rset.getString("name"),
                rset.getInt("age"),
                rset.getString("email"));
    };

    private static void addStudent() throws SQLException {
        try {
            String quary = "INSERT INTO students (id, name, age, email) VALUES (?, ?, ?, ?)";
            pstmt = connet.prepareStatement(quary);

            System.out.println("\nadd Student ");
            System.out.print("Enter student id: ");
            int id = scan.nextInt();
            scan.nextLine();

            System.out.print("Enter student name: ");
            String name = scan.nextLine();

            System.out.print("Enter student age: ");
            int age = scan.nextInt();
            scan.nextLine();

            System.out.print("Enter student email: ");
            String email = scan.nextLine();

            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);
            pstmt.setString(4, email);

            int rowAffected = pstmt.executeUpdate();
            System.out.println((rowAffected == 0) ? "not add  student data" : "student add successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readStudent() throws SQLException {
        try {
            String quary = "SELECT * FROM students";
            stmt = connet.createStatement();
            rset = stmt.executeQuery(quary);

            if (!rset.next()) {
                System.out.println("student is Empty");
            } else {
                System.out.println("+---------------------------------------------------+");
                System.out.println("|                All Student List                   |");
                System.out.println("+---------------------------------------------------+");
                System.out.printf("| %-5s | %-15s | %-5s | %-15s |\n", "ID", "NAME", "AGE", "EMAIL");
                System.out.println("+---------------------------------------------------+");

                do {
                    printHold();
                } while (rset.next());
                System.out.println("+---------------------------------------------------+");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void searchStudent() throws SQLException {
        try {
            String quary = "SELECT * FROM students WHERE id = ?";
            pstmt = connet.prepareStatement(quary);

            System.out.print("Enter student id: ");
            int sId = scan.nextInt();
            pstmt.setInt(1, sId);

            rset = pstmt.executeQuery();
            if (rset.next()) {

                System.out.println("+---------------------------------------------------+");
                printHold();
                System.out.println("+---------------------------------------------------+");

            } else {
                System.out.println("!! id not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updateStudent() throws SQLException {
        try {
            String quary = "UPDATE students SET age = ? WHERE id = ?";
            pstmt = connet.prepareStatement(quary);

            System.out.println("\nSearch student");
            System.out.print("Enter student id: ");
            int id = scan.nextInt();
            scan.nextLine();

            System.out.print("Enter student new age: ");
            int newAge = scan.nextInt(id);
            scan.nextLine();

            pstmt.setInt(1, newAge);
            pstmt.setInt(2, id);
            pstmt.addBatch();

            int rowAffected = pstmt.executeUpdate();
            System.out.println((rowAffected == 0) ? "student age not update" : "student age update now");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deleteStudent() throws SQLException {
        try {
            String quary = "DELETE FROM students WHERE id = ?";
            pstmt = connet.prepareStatement(quary);

            System.out.println("please enter info that need id delet");
            System.out.print("Enter delete student id: ");
            int id = scan.nextInt();
            scan.nextLine();

            pstmt.setInt(1, id);
            int rowAffected = pstmt.executeUpdate();
            System.out.println((rowAffected == 0) ? "student  not delete" : "student delete now");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
