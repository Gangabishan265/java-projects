import java.util.Scanner;

public class BookManage {

   static Book[] theBook = new Book[50];
   static Scanner input = new Scanner(System.in);
   static int count;
   static int i = 0;

   // common book print data
     static void bookData(){
        System.out.printf("%-5s %-15s %-15s %-10s %-10s%n", "Sno", "Name", "Author", "Available Qty",
                "Total Qty");

        for (; i < count; i++) {
            System.out.printf(
                    "%-5s  %-15s  %-15s  %-10s  %-10s%n",
                    theBook[i].sNo,
                    theBook[i].bookName,
                    theBook[i].bookAuthorName,
                    theBook[i].bookCopyQty,
                    theBook[i].bookQty
            );
        }
    }

    // To compare book
    public int compareBookObjects(Book b1, Book b2)
    {
        if (b1.sNo == b2.sNo) {
            System.out.println("!! already Serial number declare book !!");
            return 0;
        } else if ((b1.bookName).equalsIgnoreCase(b2.bookName)) {
            System.out.println("!! Book name is already declare !!");
            return 0;
        }
        return 1;
    }

    // TO add book
    public void addBook(Book b)
    {
        for (int i = 0; i < count; i++) {
            if (this.compareBookObjects(b, theBook[i]) == 0) {
                return;
            }
        }
        if (count <= theBook.length) {
            theBook[count] = b;
            count++;
        } else {
            System.out.println("!! no space add more books !!");
        }
    }

    // TO search book by serial number
    public void searchBySNo()
    {
        System.out.println("\t\t\t\t\t search book by serial number \n");

        System.out.print("Enter sNo. of book: ");
        int sNo = input.nextInt();

        boolean found = false;

        if (sNo == theBook[i].sNo) {
                bookData();
                return;
            }
        if (!found) {
            System.out.println("!! No available " + sNo + "book Notfound !!");
        }
    }

    // To search book by author name
    public void searchByAuthor()
    {
        System.out.println("\t\t\t\t\t Search book by Author name \n");

        System.out.print("Enter Author name: ");
        String author = input.nextLine();

        boolean found = false;

            if (author.equalsIgnoreCase(theBook[i].bookAuthorName)) {
                bookData();
                return;
            }

        if (!found) {
            System.out.println("!! No available " + author + "name book Notfound !!");
        }
    }

    // To display all book
    public void showAllBook()
    {
        System.out.println("\t\t\t\t\t Show All Books \n");
        if (count == 0) {
            System.out.println("No books available!");
        }
        else {
            bookData();
        }
    }

    // To Upgrade quantity of a book
    public void upgradeBookQty()
    {
        System.out.println("\t\t\t\t\t Upgrade quantity of a book \n");

        System.out.print("Enter book sNo: ");
        int sNo = input.nextInt();

        for (int i = 0; i < count; i++) {
            if (sNo == theBook[i].sNo) {
                System.out.print("Enter add books quantity: ");
                int addOty = input.nextInt();

                theBook[i].bookQty += addOty;
                theBook[i].bookCopyQty += addOty;
                System.out.println("added successfully books quantity");
                return;
            } else {
                System.out.println("!! Serial number not found !!");
            }
        }
    }

    // To search serial number by book
    public int isAvailable(int sNo)
    {
        for (int i = 0; i < count; i++) {
            if (sNo == theBook[i].sNo) {
                if (theBook[i].bookCopyQty > 0) {
                    System.out.println("Book is available");
                    return i;
                }
                System.out.println("Book is Unavailable");
                return -1;
            }
        }
        System.out.println("No Book available of serial number");
        return -1;
    }

    // To remove book from library
    public Book checkOutBook()
    {
        System.out.print("Enter sNo to check out book: ");
        int sNo = input.nextInt();

        int bookIndex = isAvailable(sNo);

        if (bookIndex != -1) {
            theBook[bookIndex].bookCopyQty--;
            return theBook[bookIndex];
        }
        return null;
    }

    // To add book from library
    public void chekInBook(Book b)
    {
        for (int i = 0; i < count; i++) {
            if (b.equals(theBook[i])) {
                theBook[i].bookCopyQty++;
                return;
            }
        }
    }

}
