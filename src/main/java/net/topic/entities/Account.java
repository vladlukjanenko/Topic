package net.topic.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author Vlad Lukjanenko.
 */
@Entity
@Table(name = "Account")
@NamedQueries({

})
public class Account implements Serializable {

    /**
     * Serial version id.
     * */
    private static final long serialVersionUID = -2387791672552944370L;


    /**
     * Unique id.
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private long accountId;

    /**
     * Account name.
     * */
    @Column
    private String userName;

    /**
     * Account gender.
     * */
    @Column(name = "UserGender")
    private String gender;

    /**
     * Account email.
     * */
    @Column(name = "UserEmail")
    private String email;

    /**
     * Account photo.
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
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    private List<Shelf> shelves;

    /**
     * One to many relationship mapping.
     * */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    private List<Sketch> sketches;

    /**
     * One to many relationship mapping.
     * */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    private List<Role> roles;


    /**
     * Default constructor.
     * */
    public Account() {

    }


    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
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

        if (!(o instanceof Account)) {
            return false;
        }

        Account user = (Account) o;

        if (accountId != user.accountId) {
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
        return Objects.hash(this.accountId, this.userName);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", userName='" + userName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", photo='" + photo + '\'' +
                ", isAuthor=" + isAuthor +
                '}';
    }
}
