import java.util.Scanner;

public class Student {
     int regNum;
     String studetName;

    Book[]  borrewedbook = new Book[3];
    int bookCount = 0;
    Scanner input = new Scanner(System.in);

    public void student()
    {
        System.out.println("Enter Student details\n");
        System.out.print("Enter Student registration Number: ");
        this.regNum = input.nextInt();
        input.nextLine();

        System.out.print("Enter student name: ");
        this.studetName = input.nextLine();
    }
}
