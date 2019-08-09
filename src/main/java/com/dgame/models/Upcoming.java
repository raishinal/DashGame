/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgame.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author roslm
 */
@Entity
public class Upcoming {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name1;
    private String name2;
    private LocalDateTime start;

    public Upcoming() {
    }

    public Upcoming(String name1, String name2, LocalDateTime start) {
        this.name1 = name1;
        this.name2 = name2;
        this.start = start;
    }

    public Upcoming(int id, String name1, String name2, LocalDateTime start) {
        this.id = id;
        this.name1 = name1;
        this.name2 = name2;
        this.start = start;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }
    
}
