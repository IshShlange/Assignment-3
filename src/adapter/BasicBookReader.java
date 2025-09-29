package adapter;

import model.Book;

public class BasicBookReader implements BookReader {
    @Override
    public void readBook(String title, String author) {
        System.out.println(" Reading physical book: '" + title + "' by " + author);
        System.out.println("   - Turning pages");
        System.out.println("   - Physical book experience");
    }

    @Override
    public String getReaderType() {
        return "Physical Book Reader";
    }

}
