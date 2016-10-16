package net.topic.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Vlad Lukjanenko.
 */
@Entity
@Table(name = "Sketch")
@NamedQueries({

})
public class Sketch implements Serializable {

    /**
     * Serial version id.
     * */
    private static final long serialVersionUID = -9165189556263296192L;


    /**
     * Unique id.
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long sketchId;

    /**
     * Many to one relationship mapping.
     * */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AccountId")
    private Account account;

    /**
     * Many to one relationship mapping.
     * */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GenreId")
    private Genre genre;


    /**
     * Default constructor.
     * */
    public Sketch() {

    }


    public long getSketchId() {
        return sketchId;
    }

    public void setSketchId(long sketchId) {
        this.sketchId = sketchId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }


    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || !(o instanceof Sketch)) {
            return false;
        }

        Sketch sketch = (Sketch) o;

        if (sketchId == sketch.sketchId) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (sketchId ^ (sketchId >>> 32));
    }

    @Override
    public String toString() {
        return "Sketch{" +
                "sketchId=" + sketchId +
                '}';
    }
}
