import java.util.Scanner;

public class Book {
    int sNo;
    String bookName;
    String bookAuthorName;
    int bookQty;
    int bookCopyQty;

    Scanner input = new Scanner(System.in);

    public void book()
    {
        System.out.println("\n\t\t\t\t\t Enter Book details");
        System.out.print("Enter Book sNO.: ");
        this.sNo = input.nextInt();
        input.nextLine();   

        System.out.print("Enter Book Name: ");
        this.bookName = input.nextLine();

        System.out.print("Enter Book Author Name: ");
        this.bookAuthorName = input.nextLine();

        System.out.print("Enter Book Quantity: ");
        this.bookQty = input.nextInt();
        this.bookCopyQty = this.bookQty;
    }

}
