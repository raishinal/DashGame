/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgame.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author roslm
 */
@Entity
public class RunningGame {
     @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
     
   private String name1;
   private String name2;
   private int points1;
   private int points2;
   private String time;

    public RunningGame() {
    }

    public RunningGame(String name1, String name2, int points1, int points2, String time) {
        this.name1 = name1;
        this.name2 = name2;
        this.points1 = points1;
        this.points2 = points2;
        this.time = time;
    }

    public RunningGame(int id, String name1, String name2, int points1, int points2, String time) {
        this.id = id;
        this.name1 = name1;
        this.name2 = name2;
        this.points1 = points1;
        this.points2 = points2;
        this.time = time;
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

    public int getPoints1() {
        return points1;
    }

    public void setPoints1(int points1) {
        this.points1 = points1;
    }

    public int getPoints2() {
        return points2;
    }

    public void setPoints2(int points2) {
        this.points2 = points2;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

   
     
}
