package net.topic.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Vlad Lukjanenko.
 */
@Entity
@Table(name = "BookGenre")
@NamedQueries({

})
public class BookGenre implements Serializable {

    /**
     * Genre id.
     * */
    @Id
    @Column
    private long genreId;

    /**
     * Book id.
     * */
    @Id
    @Column
    private long bookId;


    /**
     * Default constructor.
     * */
    public BookGenre() {

    }


    public long getGenreId() {
        return genreId;
    }

    public void setGenreId(long genreId) {
        this.genreId = genreId;
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

        if (o == null || !(o instanceof BookGenre)) {
            return false;
        }

        BookGenre that = (BookGenre) o;

        if (genreId != that.genreId) {
            return false;
        }

        if (bookId != that.bookId) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.genreId, this.bookId);
    }

    @Override
    public String toString() {
        return "AuthorBook{" +
                "genreId=" + genreId +
                ", bookId=" + bookId +
                '}';
    }
}
