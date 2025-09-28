package factory;

import model.AudioBook;
import model.Book;

public class AudioBookFactory implements LibraryFactory {
    private final double duration;

    public AudioBookFactory(double duration) {
        this.duration = duration;
    }

    public AudioBookFactory() {
        this(5.0);
    }

    @Override
    public Book createBook(String title, String author) {
        return new AudioBook(title, author, duration);
    }
}