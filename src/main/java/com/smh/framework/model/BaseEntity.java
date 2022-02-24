package com.smh.framework.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class BaseEntity<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = 95231478632145632L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private T id;
}
