package net.topic.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Vlad Lukjanenko.
 */
@Entity
@Table(name = "Shelf")
@NamedQueries({

})
public class Shelf implements Serializable {

    /**
     * Serial version id.
     * */
    private static final long serialVersionUID = -5791125864666795196L;


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
     * Many to one relationship mapping: Shelf - Account.
     * */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AccountId")
    private Account account;


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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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
