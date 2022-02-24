package com.smh.framework.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CORE_ROLE")
public class Role extends BaseEntity<Integer> {

    @Column(name = "CODE")
    private String code;

    @Column(name = "TITLE")
    private String title;

    public Role() {
    }
}
