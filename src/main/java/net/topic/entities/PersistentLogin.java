package net.topic.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Vlad Lukjanenko.
 */
@Entity
@Table(name = "Genre")
@NamedQueries({

})
public class PersistentLogin implements Serializable {

    /**
     * Serial version id.
     * */
    private static final long serialVersionUID = 1259907112738282305L;


    /**
     * Unique id.
     * */
    @Id
    @Column
    private String username;

    /**
     * Series.
     * */
    @Column
    private String series;

    /**
     * Token
     * */
    @Column
    private String token;

    /**
     * Last used.
     * */
    @Column
    private long last_used;


    /**
     * Default constructor.
     * */
    public PersistentLogin() {

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getLast_used() {
        return last_used;
    }

    public void setLast_used(long last_used) {
        this.last_used = last_used;
    }


    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || !(o instanceof PersistentLogin)) {
            return false;
        }

        PersistentLogin that = (PersistentLogin) o;

        if (last_used != that.last_used) {
            return false;
        }

        if (username != null ? !username.equals(that.username) : that.username != null) {
            return false;
        }

        if (series != null ? !series.equals(that.series) : that.series != null) {
            return false;
        }

        if (token != null ? token.equals(that.token) : that.token == null) {
            return false;
        }

        return true;

    }

    @Override
    public int hashCode() {
        return Objects.hash(this.username);
    }

    @Override
    public String toString() {
        return "PersistentLogin{" +
                "username='" + username + '\'' +
                ", series='" + series + '\'' +
                ", token='" + token + '\'' +
                ", last_used=" + last_used +
                '}';
    }
}
