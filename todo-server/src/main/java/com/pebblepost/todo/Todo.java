package com.pebblepost.todo;

import javax.persistence.*;

@Entity
public class Todo {
    @Id
    @Column(name="id", updatable=false, nullable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(name="text")
    public String text;

    public Todo() {
    }

    public Todo(String text) {
        this.text = text;
    }
}
