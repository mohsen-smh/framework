package com.smh.framework.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CORE_ROLE")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "TITLE")
    private String title;

    public Role() {
    }
}
