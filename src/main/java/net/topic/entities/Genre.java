package net.topic.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author Vlad Lukjanenko.
 */
@Entity
@Table(name = "Genre")
@NamedQueries({

})
public class Genre implements Serializable {

    /**
     * Serial version id.
     * */
    private static final long serialVersionUID = -6306566153092664988L;


    /**
     * Unique id.
     * */
    @Id
    @Column
    private long genreId;

    /**
     * Genre name.
     * */
    @Column
    private String genreName;

    /**
     * One to many relationship mapping.
     * */
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "genres")
    private List<Book> books;

    /**
     * One to many relationship mapping: Genre - Sketch.
     * */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "genre")
    private List<Sketch> sketches;


    /**
     * Default constructor.
     * */
    public Genre() {

    }


    public long getGenreId() {
        return genreId;
    }

    public void setGenreId(long genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Sketch> getSketches() {
        return sketches;
    }

    public void setSketches(List<Sketch> sketches) {
        this.sketches = sketches;
    }


    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (!(o instanceof Genre)) {
            return false;
        }

        Genre genre = (Genre) o;

        if (genreId != genre.genreId) {
            return false;
        }

        if (genreName != null ? genreName.equals(genre.genreName) : genre.genreName == null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.genreId, this.genreName);
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreId=" + genreId +
                ", genreName='" + genreName + '\'' +
                '}';
    }
}
