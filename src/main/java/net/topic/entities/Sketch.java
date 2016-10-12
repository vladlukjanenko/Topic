package net.topic.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Vlad Lukjanenko.
 */
@Entity
@Table
@NamedQueries({

})
public class Sketch implements Serializable {

    /**
     * Unique id.
     * */
    private long sketchId;

    /**
     * Many to one relationship mapping.
     * */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId")
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
