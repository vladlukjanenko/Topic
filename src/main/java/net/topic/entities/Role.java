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
public class Role implements Serializable {

    /**
     * Unique id.
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private long roleId;

    /**
     * User name.
     * */
    @Column
    private String username;

    /**
     * Role name.
     */
    @Column
    private String roleName;

    /**
     * Many to one relationship mapping: Role - User.
     * */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId")
    private User user;


    /**
     * Default constructor.
     * */
    public Role() {

    }


    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

        if (o == null || !(o instanceof Role)) {
            return false;
        }

        Role role = (Role) o;

        if (roleId != role.roleId) {
            return false;
        }

        if (username != null ? !username.equals(role.username) : role.username != null) {
            return false;
        }

        if (roleName != null ? roleName.equals(role.roleName) : role.roleName == null) {
            return false;
        }

        return true;

    }

    @Override
    public int hashCode() {
        return Objects.hash(this.roleId, this.roleName);
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", username='" + username + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
