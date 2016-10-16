package net.topic.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author Vlad Lukjanenko.
 */
@Entity
@Table(name = "Book")
@NamedQueries({

})
public class Book implements Serializable {

    /**
     * Serial version id.
     * */
    private static final long serialVersionUID = -6242465384094982019L;


    /**
     * Unique id.
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private long bookId;

    /**
     * Book name.
     * */
    @Column
    private String bookName;

    /**
     * Book ISBN.
     * */
    @Column
    private String bookISBN;

    /**
     * Number of book pages.
     * */
    @Column
    private int bookPagesNumber;

    /**
     * Many to many relationship mapping: Book - Author.
     * */
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "books")
    private List<Author> authors;

    /**
     * Many to many relationship mapping: Book - Genre.
     * */
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "BookGenre",
        joinColumns = {
            @JoinColumn(name = "BookId")
        },
        inverseJoinColumns = {
            @JoinColumn(name = "GenreId")
        }
    )
    private List<Genre> genres;

    /**
     * One to many relationship mapping: Book - Shelf.
     * */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
    private List<Shelf> shelf;


    /**
     * Default constructor.
     * */
    public Book() {

    }


    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    public int getBookPagesNumber() {
        return bookPagesNumber;
    }

    public void setBookPagesNumber(int bookPagesNumber) {
        this.bookPagesNumber = bookPagesNumber;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Shelf> getShelf() {
        return shelf;
    }

    public void setShelf(List<Shelf> shelf) {
        this.shelf = shelf;
    }


    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || !(o instanceof Book)) {
            return false;
        }

        Book book = (Book) o;

        if (bookId != book.bookId) {
            return false;
        }

        if (bookPagesNumber != book.bookPagesNumber) {
            return false;
        }

        if (bookName != null ? !bookName.equals(book.bookName) : book.bookName != null) {
            return false;
        }

        if (bookISBN != null ? bookISBN.equals(book.bookISBN) : book.bookISBN == null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.bookId, this.bookName);
    }
}
