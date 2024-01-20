package com.aamir.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Test {

    @Id
    private int id;
    private String test;
}
