package factory;

import model.Book;

public class BookFactory implements LibraryFactory {
    @Override
    public Book createBook(String title, String author) {
        return new Book(title, author);
    }
}