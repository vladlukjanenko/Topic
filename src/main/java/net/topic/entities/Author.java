package net.topic.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author Vlad Lukjanenko.
 */
@Entity
@Table(name = "Author")
@NamedQueries({

})
public class Author implements Serializable {
    /**
     * Serial version id.
     * */
    private static final long serialVersionUID = 6223940653636240919L;


    /**
     * Unique id.
     * */
    @Id
    @Column
    private long authorId;

    /**
     * Author name.
     * */
    @Column
    private String authorName;

    /**
     * Many to many relationship mapping: Author - Book.
     * */
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "AuthorBook",
        joinColumns = {
            @JoinColumn(name = "BookId" )
        },
        inverseJoinColumns = {
            @JoinColumn(name = "AuthorId")
        }
    )
    private List<Book> books;


    /**
     * Default constructor.
     * */
    public Author() {

    }


    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (!(o instanceof Author)) {
            return false;
        }

        Author author = (Author) o;

        if (authorId != author.authorId) {
            return false;
        }

        if (this.authorName != null ? this.authorName.equals(author.authorName) : author.authorName != null) {
            return false;
        }

        return true;

    }

    @Override
    public int hashCode() {
        return Objects.hash(this.authorId, this.authorName);
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                '}';
    }
}
