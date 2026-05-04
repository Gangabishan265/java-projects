import java.util.Scanner;

    static BookManage objBook = new BookManage();
    static StudentManage objStudent = new StudentManage();
    static Scanner input = new Scanner(System.in);

void main(String[] ignoredArgs) {

    System.out.println("\t\t\t\t\t+----------------------------------------------------------+");
    System.out.println("\t\t\t\t\t|                welcome to the library                   |");
    System.out.println("\t\t\t\t\t+----------------------------------------------------------+");

    boolean running = true;
    while (running)
    {
        System.out.println("\n--------------------------------------------------------------------------------------" +
                "------------------------------------------------------------------------------------------");
        System.out.println("1: Add new Book");
        System.out.println("2: Upgrade quantity of a Book");
        System.out.println("3: Search a Book");
        System.out.println("4: Show All Book");
        System.out.println("5: Register student");
        System.out.println("6: Show all Registered Students");
        System.out.println("7: Check Out Book");
        System.out.println("8: Check In Book");
        System.out.println("9: Exit");
        System.out.print("Please enter a key: ");

        int choice = input.nextInt();
        input.nextLine();
        System.out.println("----------------------------------------------------------------------------------------" +
                "--------------------------------------------------------------------------------------------");

        switch (choice) {
            case 1:
                Book b = new Book();
                b.book();
                objBook.addBook(b);
                break;
            case 2:
                objBook.upgradeBookQty();
                break;
            case 3:
                System.out.println("1: search book by serial number");
                System.out.println("2: search book by author name");
                System.out.print("Please enter a key: ");

                int searchChoice = input.nextInt();
                input.nextLine();
                switch (searchChoice) {
                    case 1 -> objBook.searchBySNo();
                    case 2 -> objBook.searchByAuthor();
                }
                break;
            case 4:
                objBook.showAllBook();
                break;
            case 5:
                Student s = new Student();
                s.student();
                objStudent.addStudent(s);
                break;
            case 6:
                objStudent.shwoAllStudent();
                break;
            case 7:
                objStudent.checkOutBook(objBook);
                break;
            case 8:
                objStudent.checkInBook(objBook);
                break;
            case 9:
                running = false;
                break;
            default:
                System.out.println("Enter Between  1 To 9");
        }
    }
}
