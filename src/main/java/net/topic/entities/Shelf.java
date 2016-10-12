package net.topic.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Vlad Lukjanenko.
 */
@Entity
@Table
@NamedQueries({

})
public class Shelf implements Serializable {

    /**
     * Unique id.
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private long shelfId;

    /**
     * Shelf name.
     * */
    @Column
    private String shelfName;

    /**
     * Many to one relationship mapping: Shelf - Book.
     * */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ShelfId")
    private Book book;

    /**
     * Many to one relationship mapping: Shelf - User.
     * */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId")
    private User user;


    /**
     * Default constructor.
     * */
    public Shelf() {

    }


    public long getShelfId() {
        return shelfId;
    }

    public void setShelfId(long shelfId) {
        this.shelfId = shelfId;
    }

    public String getShelfName() {
        return shelfName;
    }

    public void setShelfName(String shelfName) {
        this.shelfName = shelfName;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || !(o instanceof Shelf)) {
            return false;
        }

        Shelf shelf = (Shelf) o;

        if (shelfId != shelf.shelfId) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.shelfId);
    }

    @Override
    public String toString() {
        return "Shelf{" +
                "shelfId=" + shelfId +
                ", shelfName='" + shelfName + '\'' +
                '}';
    }
}
