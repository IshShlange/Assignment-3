package model;

public class AudioBook extends Book {
    private final double duration; // in hours

    public AudioBook(String title, String author, double duration) {
        super(title, author);
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "AudioBook: " + super.toString() + " [Duration: " + duration + "h]";
    }
}