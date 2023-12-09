package ru.rishaleva.springBootSecurity.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name_of_role")
    private String nameOfRole;
    @ManyToMany(mappedBy = "roles")
    private Set<User> userSet = new HashSet<>();

    public Role() {
    }

    public Role(long id, String nameOfRole) {
        this.id = id;
        this.nameOfRole = nameOfRole;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameOfRole() {
        return nameOfRole;
    }

    public void setNameOfRole(String nameOfRole) {
        this.nameOfRole = nameOfRole;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", nameOfRole='" + nameOfRole + '\'' +
                ", userSet=" + userSet +
                '}';
    }

    @Override
    public String getAuthority() {
        return getNameOfRole();
    }
}
