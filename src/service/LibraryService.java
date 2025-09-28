package service;

import adapter.BookReaderAdapter;
import factory.LibraryFactory;
import model.Book;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private final List<Book> library;
    private final BookReaderAdapter readerAdapter;

    public LibraryService() {
        this.library = new ArrayList<>();
        this.readerAdapter = new BookReaderAdapter();
    }

    public LibraryService(double audioSpeed) {
        this.library = new ArrayList<>();
        this.readerAdapter = new BookReaderAdapter(audioSpeed);
    }

    public void addBook(Book book) {
        library.add(book);
        System.out.println("✅ Added to library: " + book);
    }

    public void readBook(Book book) {
        if (library.contains(book)) {
            readerAdapter.readBook(book);
        } else {
            System.out.println("❌ Book not found in library: " + book);
        }
    }

    public void displayAllBooks() {
        System.out.println("\n=== LIBRARY COLLECTION ===");
        if (library.isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }

        for (int i = 0; i < library.size(); i++) {
            System.out.println((i + 1) + ". " + library.get(i));
        }
    }

    // Новый метод для проверки наличия книг
    public boolean hasBooks() {
        return !library.isEmpty();
    }

    // Новый метод для получения книги по индексу
    public Book getBookByIndex(int index) {
        if (index >= 0 && index < library.size()) {
            return library.get(index);
        }
        return null;
    }

    public void changeAudioSpeed(double speed) {
        readerAdapter.setAudioPlaybackSpeed(speed);
    }
}