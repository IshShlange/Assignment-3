package adapter;

public interface BookReader {
    void readBook(String title, String author);
    String getReaderType();
}