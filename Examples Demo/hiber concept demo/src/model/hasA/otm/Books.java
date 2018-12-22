package model.hasA.otm;

public class Books {
    private int bookId;
    private String bookName;

    public Books() {
    }

    public Books(String bookName) {

        this.bookName = bookName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
