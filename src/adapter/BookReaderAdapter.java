package adapter;

import model.Book;
import model.AudioBook;

public class BookReaderAdapter {
    private final BasicBookReader basicReader;
    private final AudioBookReader audioReader;

    public BookReaderAdapter() {
        this.basicReader = new BasicBookReader();
        this.audioReader = new AudioBookReader();
    }

    public BookReaderAdapter(double audioSpeed) {
        this.basicReader = new BasicBookReader();
        this.audioReader = new AudioBookReader(audioSpeed);
    }

    public void readBook(Book book) {
        System.out.println("\n--- Starting Reading Session ---");

        if (book instanceof AudioBook) {
            // Для AudioBook извлекаем название из toString()
            String bookInfo = book.toString();
            String title = bookInfo.substring(bookInfo.indexOf(":") + 1, bookInfo.indexOf("[")).trim();
            audioReader.readBook(title, "");
            System.out.println("Format: " + audioReader.getReaderType());
        } else {
            // Для обычной книги извлекаем название из toString()
            String bookInfo = book.toString();
            String title = bookInfo.substring(bookInfo.indexOf(":") + 1).trim();
            basicReader.readBook(title, "");
            System.out.println("Format: " + basicReader.getReaderType());
        }

        System.out.println("--- Reading Session Ended ---\n");
    }

    public void setAudioPlaybackSpeed(double speed) {
        System.out.println("🎚️ Changing audio playback speed to: " + speed + "x");
    }
}