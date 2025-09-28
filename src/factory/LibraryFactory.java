package factory;

import model.Book;

public interface LibraryFactory {
    Book createBook(String title, String author);
}