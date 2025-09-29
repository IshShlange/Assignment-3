package adapter;

import model.AudioBook;

public class AudioBookReader implements BookReader {
    private final double playbackSpeed;

    public AudioBookReader(double playbackSpeed) {
        this.playbackSpeed = playbackSpeed;
    }

    public AudioBookReader() {
        this(1.0);
    }

    @Override
    public void readBook(String title, String author) {
        System.out.println(" Listening to audiobook: '" + title + "' by " + author);
        System.out.println("   - Playback speed: " + playbackSpeed + "x");
        System.out.println("   - Audio streaming");
        System.out.println("   - Chapter navigation");
    }

    @Override
    public String getReaderType() {
        return "Audio Book Reader (Speed: " + playbackSpeed + "x)";
    }

}
