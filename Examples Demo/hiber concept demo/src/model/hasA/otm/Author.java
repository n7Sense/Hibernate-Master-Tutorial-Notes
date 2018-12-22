package model.hasA.otm;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.Set;

public class Author {

    private int authorId;
    private String authorName;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Books> books;

    public Author() {}

    public Author(String authorName, Set<Books> books) {
        this.authorName = authorName;
        this.books = books;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Set<Books> getBooks() {
        return books;
    }

    public void setBooks(Set<Books> books) {
        this.books = books;
    }
}
