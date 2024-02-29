import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LMS_poPolsku {
    public static void main(String[] args) {
        Library library = new Library();
        Books bookList = new Books();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu systemu zarządzania biblioteką:");
            System.out.println("1. Dodaj książkę");
            System.out.println("2. Lista dostępnych książek");
            System.out.println("3. Pożycz książkę");
            System.out.println("4. Zwrócić książkę");
            System.out.println("5. Zaoferuj 3 losowe książki");
            System.out.println("6. Wyjście");
            System.out.print("Wprowadź swój wybor: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Wprowadz tytuł książki: ");
                    String title = scanner.nextLine();
                    System.out.print("Wpisz autora książki: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                    System.out.println("Książka dodana pomyślnie.");
                    break;
                case 2:
                    System.out.println("Dostępne książki:");
                    library.listBooks();
                    break;
                case 3:
                    System.out.print("Wprowadź tytuł książki, którą chczesz wypozyczyć: ");
                    String borrowTitle = scanner.nextLine();
                    library.borrowBook(borrowTitle);
                    break;
                case 4:
                    System.out.print("Wprowadź tytuł książki, którą chczesz powrócic: ");
                    String returnTitle = scanner.nextLine();
                    library.returnBook(returnTitle);
                    break;
                case 5:
                    displayRandomBooks(bookList);
                    break;
                case 6:
                    System.out.println("Do widzenia!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }
    }

    private static void displayRandomBooks(Books bookList) {
        List<String> books = bookList.getRandomBooks(3);
        System.out.println("Oferowane książki:");
        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }
}

class Book {
    private String title;
    private String author;
    private boolean available;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(String title, String author) {
        Book book = new Book(title, author);
        books.add(book);
    }

    public void listBooks() {
        for (Book book : books) {
            System.out.println("Tytuł: " + book.getTitle());
            System.out.println("Autor: " + book.getAuthor());
            System.out.println("Dostępny: " + (book.isAvailable() ? "Yes" : "No"));
            System.out.println();
        }
    }

    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()) {
                book.setAvailable(false);
                System.out.println("Wypożyczyleś książkę: " + book.getTitle());
                return;
            }
        }
        System.out.println("Książka nie została znalezona lub zostałą już wypożyczona.");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isAvailable()) {
                book.setAvailable(true);
                System.out.println("Książka została zwrócona: " + book.getTitle());
                return;
            }
        }
        System.out.println("Książka nie została znaleziona lub już zwrócona.");
    }



 private static void displayRandomBooks(Books bookList) {
        List<String> books = bookList.getBooks();
        List<String> randomBooks = Books.getRandomBooks(3);

        System.out.println("Proponowane książki:");

        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + ". " + randomBooks.get(i));
        }
    }
}

/*
class Books {
   
    private static List<String> books;

    public Books() {
        this.books = createBookList();
    }

    private List<String> createBookList() {
        List<String> books = new ArrayList<>();
        books.add("Computer Organization and Design: The Hardware/Software Interface by David A. Patterson, John L. Hennessy");
        books.add("Digital Design and Computer Architecture by David Money Harris, Sarah L. Harris");
        books.add("Introduction to the Theory of Computation by Michael Sipser");
        books.add("Computer Systems: A Programmer's Perspective by Randal E. Bryant, David R. O'Hallaron");
        books.add("Logic and Computer Design Fundamentals by M. Morris Mano, Charles R. Kime");
        books.add("Computer Architecture: A Quantitative Approach by John L. Hennessy, David A. Patterson");
        books.add("Computer Organization and Architecture: Designing for Performance by William Stallings");
        books.add("Computer Networks by Andrew S. Tanenbaum, David J. Wetherall");
        books.add("Modern Operating Systems by Andrew S. Tanenbaum");
        books.add("Computer Graphics: Principles and Practice by John F. Hughes, Andries van Dam, Morgan McGuire, David F. Sklar, James D. Foley, Steven K. Feiner, Kurt Akeley");

        return books;
    }

    public List<String> getBooks() {
        return books;
    }

    public static List<String> getRandomBooks(int count) {
        List<String> shuffledBooks = new ArrayList<>(books);
        Collections.shuffle(shuffledBooks);
        return shuffledBooks.subList(0, count);

    }
}

*/