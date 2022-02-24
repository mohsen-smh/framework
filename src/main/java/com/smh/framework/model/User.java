package com.smh.framework.model;

import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
@Table(name = "CORE_USER")
public class User extends BaseEntity<Integer> {

    @Column(name = "USERNAME")
    private String userName;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ACTIVE")
    private Boolean active;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles=new ArrayList<>();

    public User() {
    }

    public User(User user) {
        this.active=user.getActive();
        this.email=user.getEmail();
        this.userName=user.getUserName();
        this.password=user.getPassword();
        this.roles=user.getRoles();
    }
}
