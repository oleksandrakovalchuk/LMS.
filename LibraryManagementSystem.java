import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        //Create library instances, a book list, and a scanner
        //Створення екземплярів бібліотеки, списку книг та сканера
        Library library = new Library();
        Books bookList = new Books();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Library Management System Menu:");
            System.out.println("1. Add a book");
            System.out.println("2. List available books");
            System.out.println("3. Borrow a book");
            System.out.println("4. Return a book");
            System.out.println("5. Offer 3 random books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            //Read user selection for a menu
            //Зчитування вибору користувача для меню
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline


            //Selecting an action depending on the user
            // Вибір дії в залежності від користувача
            switch (choice) {
                case 1:
                    //Add a book to the library
                    // Додавання книги до бібліотеки
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                    System.out.println("Book added successfully.");
                    break;
                case 2:
                    //Displaying available books in the library
                    //Виведення доступних книг у бібліотеці
                    System.out.println("Available books:");
                    library.listBooks();
                    break;
                case 3:
                    // Borrowing a book from the library
                    // Взяття книги в оренду з бібліотеки
                    System.out.print("Enter the title of the book you want to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    library.borrowBook(borrowTitle);
                    break;
                case 4:
                    //Returning a borrowed book to the library
                    // Повернення взятої в оренду книги в бібліотеку
                    System.out.print("Enter the title of the book you want to return: ");
                    String returnTitle = scanner.nextLine();
                    library.returnBook(returnTitle);
                    break;
                case 5:
                    // Offer 3 random books to the user
                    // Пропозиція 3 випадкових книг користувачеві
                    displayRandomBooks(bookList);
                    break;
                case 6:
                    // Exit the program
                    // Вихід з програми
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    // Handling incorrect choices
                    // Обробка неправильного вибору
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // output of 3 laundry books
    // виведення 3 випрадкових книг
    private static void displayRandomBooks(Books bookList) {
        List<String> books = bookList.getBooks();
        books = Books.getRandomBooks(3);
        System.out.println("Offered books:");
        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }
}

// A class that represents a book
// Klasa, która reprezentuje książkę
// Клас, що представляє книгу
class Book {
    private final String title;
    private final String author;
    private boolean available;

    // Constructor for creating a book
    // Konstruktor do tworzenia książki
    // Конструктор для створення книги
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }
    // Methods for obtaining information about the book
    // Metody uzyskiwania informacji o książce
    // Методи для отримання інформації про книгу
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    // Method for updating book availability
    // Metoda aktualizacji dostępności książek
    // Метод для оновлення доступності книги
    public void setAvailable(boolean available) {
        this.available = available;
    }
}

// A class that represents a library
// Klasa, która reprezentuje bibliotekę
// Клас, що представляє бібліотеку
class Library {
    private final ArrayList<Book> books = new ArrayList<>();

    // Method for adding a book to the library
    // Metoda dodawania książki do biblioteki
    // Метод для додавання книги до бібліотеки
    public void addBook(String title, String author) {
        Book book = new Book(title, author);
        books.add(book);
    }
    // Method for displaying available books in the library
    // Метод для виведення доступних книг у бібліотеці
    public void listBooks() {
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Available: " + (book.isAvailable() ? "Yes" : "No"));
            System.out.println();
        }
    }

    // Method for borrowing a book from the library
    // Metoda wypożyczania książek z biblioteki
    // Метод для взяття книги в оренду з бібліотеки
    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()) {
                book.setAvailable(false);
                System.out.println("You have borrowed the book: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book not found or already borrowed.");
    }

    // Method for returning a borrowed book to the library
    // Sposób zwrotu wypożyczonej książki do biblioteki
    // Метод для повернення взятої в оренду книги в бібліотеку
    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isAvailable()) {
                book.setAvailable(true);
                System.out.println("You have returned the book: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book not found or already returned.");
    }
}












 

