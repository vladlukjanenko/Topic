package net.topic.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Vlad Lukjanenko.
 */
@Entity
@Table(name = "AuthorBook")
@NamedQueries({

})
public class AuthorBook implements Serializable {

    /**
     * Serial version id.
     * */
    private static final long serialVersionUID = 3570757799528394290L;


    /**
     * Author id.
     * */
    @Id
    @Column
    private long authorId;

    /**
     * Book id.
     * */
    @Id
    @Column
    private long bookId;


    /**
     * Default constructor.
     * */
    public AuthorBook() {

    }


    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }


    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || !(o instanceof AuthorBook)) {
            return false;
        }

        AuthorBook that = (AuthorBook) o;

        if (authorId != that.authorId) {
            return false;
        }

        if (bookId != that.bookId) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.authorId, this.bookId);
    }

    @Override
    public String toString() {
        return "AuthorBook{" +
                "authorId=" + authorId +
                ", bookId=" + bookId +
                '}';
    }
}
