package app;

import factory.AudioBookFactory;
import factory.BookFactory;
import factory.LibraryFactory;
import model.Book;
import service.LibraryService;

import java.util.Scanner;

public class LibraryApp {
    private final LibraryService libraryService;
    private final Scanner scanner;

    public LibraryApp() {
        this.libraryService = new LibraryService(1.5); // Audio speed 1.5x
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        printWelcomeMessage();

        while (true) {
            printMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> showBooks();
                case "2" -> addBook(new BookFactory());
                case "3" -> addBook(new AudioBookFactory());
                case "4" -> readBookFromLibrary();
                case "5" -> changeAudioSpeed();
                case "0" -> exit();
                default -> System.out.println("Unknown option. Try again.");
            }
        }
    }

    private void printWelcomeMessage() {
        System.out.println("🏛️  Welcome to Enhanced Library System!");
        System.out.println("   Now with Adapter Pattern for different book formats!\n");
    }

    private void printMenu() {
        System.out.println("\n--- Library Menu ---");
        System.out.println("1. Show all books");
        System.out.println("2. Add Regular Book");
        System.out.println("3. Add Audio Book");
        System.out.println("4. Read a Book");
        System.out.println("5. Change Audio Speed");
        System.out.println("0. Exit");
        System.out.print("Choose: ");
    }

    private void showBooks() {
        libraryService.displayAllBooks();
    }

    private void addBook(LibraryFactory factory) {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        Book book = factory.createBook(title, author);
        libraryService.addBook(book);
    }

    private void readBookFromLibrary() {
        // Сначала показываем книги
        libraryService.displayAllBooks();

        // Проверяем, есть ли книги для чтения
        if (libraryService.hasBooks()) {
            System.out.print("Enter book number to read: ");
            try {
                int bookNumber = Integer.parseInt(scanner.nextLine());
                // Получаем книгу по номеру и читаем её
                Book bookToRead = libraryService.getBookByIndex(bookNumber - 1);
                if (bookToRead != null) {
                    libraryService.readBook(bookToRead);
                } else {
                    System.out.println("❌ Invalid book number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Please enter a valid number.");
            }
        } else {
            System.out.println("❌ No books available to read.");
        }
    }

    private void changeAudioSpeed() {
        System.out.print("Enter new audio speed (0.5 - 3.0): ");
        try {
            double speed = Double.parseDouble(scanner.nextLine());
            if (speed >= 0.5 && speed <= 3.0) {
                libraryService.changeAudioSpeed(speed);
            } else {
                System.out.println("❌ Speed must be between 0.5 and 3.0");
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Please enter a valid number.");
        }
    }

    private void exit() {
        System.out.println("Thank you for using the Library System!");
        System.out.println("Goodbye! 👋");
        System.exit(0);
    }
}