package net.topic.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author Vlad Lukjanenko.
 */
@Entity
@Table(name = "User")
@NamedQueries({

})
public class User implements Serializable {

    /**
     * Unique id.
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private long userId;

    /**
     * User name.
     * */
    @Column
    private String userName;

    /**
     * User gender.
     * */
    @Column(name = "UserGender")
    private String gender;

    /**
     * User email.
     * */
    @Column(name = "UserEmail")
    private String email;

    /**
     * User photo.
     * */
    @Column(name = "UserPhoto")
    private String photo;

    /**
     * Is author flag.
     * */
    @Column
    private boolean isAuthor;

    /**
     * One to many relationship mapping.
     * */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Shelf> shelves;

    /**
     * One to many relationship mapping.
     * */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Sketch> sketches;

    /**
     * One to many relationship mapping.
     * */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Role> roles;


    /**
     * Default constructor.
     * */
    public User() {

    }


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean isAuthor() {
        return isAuthor;
    }

    public void setAuthor(boolean author) {
        isAuthor = author;
    }

    public List<Shelf> getShelves() {
        return shelves;
    }

    public void setShelves(List<Shelf> shelves) {
        this.shelves = shelves;
    }

    public List<Sketch> getSketches() {
        return sketches;
    }

    public void setSketches(List<Sketch> sketches) {
        this.sketches = sketches;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (!(o instanceof User)) {
            return false;
        }

        User user = (User) o;

        if (userId != user.userId) {
            return false;
        }

        if (isAuthor != user.isAuthor) {
            return false;
        }

        if (userName != null ? !userName.equals(user.userName) : user.userName != null) {
            return false;
        }

        if (gender != null ? !gender.equals(user.gender) : user.gender != null) {
            return false;
        }

        if (email != null ? !email.equals(user.email) : user.email != null) {
            return false;
        }

        if (photo != null ? photo.equals(user.photo) : user.photo == null) {
            return false;
        }

        return true;

    }

    @Override
    public int hashCode() {
        return Objects.hash(this.userId, this.userName);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", photo='" + photo + '\'' +
                ", isAuthor=" + isAuthor +
                '}';
    }
}
