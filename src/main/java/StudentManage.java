import java.util.Scanner;

public class StudentManage {
     Student[] theStudent = new Student[50];
     Scanner input = new Scanner(System.in);
     int count;


    // To add students
    public void addStudent(Student s)
    {
        for (int i = 0; i < count; i++) {
            if (s.regNum == theStudent[i].regNum) {
                System.out.println("!! Student registered " + s.regNum + "is already declare !!");
                return;
            }
        }
        if (count <= 50){
            theStudent[count] = s;
            count++;
        }
    }

    // To display all students
    public void shwoAllStudent()
    {
        System.out.println("\t\t\t\t\t Show all students list \n");
        System.out.printf("%-15s %-15s%n", "Reg number", "Student name");

        for (int i = 0; i < count; i++) {
            System.out.printf("%-15s %-15s%n", theStudent[i].regNum, theStudent[i].studetName);
        }
    }

    // To search student by regNumber
    public int isStudent()
    {
        System.out.print("Enter Student regNum: ");
        int regNum = input.nextInt();

        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (regNum == theStudent[i].regNum){
                System.out.printf("%-15s %-15s%n", theStudent[i].regNum, theStudent[i].studetName);
                return i;
            }
        }
        if (!found) {
            System.out.println("student not registered ");
            System.out.println("first register student");
        }
        return -1;
    }

    // To remove the book
    public void checkOutBook(BookManage book)
    {
        int studentIndex = this.isStudent();

        if(studentIndex != -1){
            System.out.println("chacking out !");

            book.showAllBook();
            Book b = book.checkOutBook();

            System.out.println("chacking out !");
            if (b != null){
                if (theStudent[studentIndex].bookCount <= 3){
                    System.out.println("adding book");
                    theStudent[studentIndex].borrewedbook[theStudent[studentIndex].bookCount] = b;

                    theStudent[studentIndex].bookCount++;
                    return;
                }
            }
            else {
                System.out.println("student can not borrow more than 3 books");
            }
        }
        System.out.println("!! book is not available !!");
    }

    // To add the book
    public void checkInBook(BookManage book)
    {
        int studentIndex = this.isStudent();

        if (studentIndex != -1){
            System.out.printf("%-5s %-15s %-15s%n", "sNo", "Book Name", "Author Name");

            Student s = theStudent[studentIndex];
            for (int i = 0; i < s.bookCount ; i++) {
                System.out.printf(
                        "%-5s %-15s %-15s%n",
                        s.borrewedbook[i].sNo,
                        s.borrewedbook[i].bookName,
                        s.borrewedbook[i].bookAuthorName
                        );
            }
            System.out.print("Enter serial number in book chacked: ");
            int sNo = input.nextInt();

            for (int i = 0; i < s.bookCount; i++) {
                if (sNo == s.bookCount){
                    book.chekInBook(s.borrewedbook[i]);
                    s.borrewedbook[i] = null;

                    return;
                }
            }
            System.out.println("!! Book serial no. " + sNo + " not found !!");
        }
    }
}
