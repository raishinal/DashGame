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
public class GameStatistics {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name1;
    private String name2;
    private int score1;
    private int score2;
    private String stime;
    private String etime;

    public GameStatistics() {
    }

    public GameStatistics(String name1, String name2, int score1, int score2, String stime, String etime) {
        this.name1 = name1;
        this.name2 = name2;
        this.score1 = score1;
        this.score2 = score2;
        this.stime = stime;
        this.etime = etime;
    }

    public GameStatistics(int id, String name1, String name2, int score1, int score2, String stime, String etime) {
        this.id = id;
        this.name1 = name1;
        this.name2 = name2;
        this.score1 = score1;
        this.score2 = score2;
        this.stime = stime;
        this.etime = etime;
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

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public String getEtime() {
        return etime;
    }

    public void setEtime(String etime) {
        this.etime = etime;
    }

   
}
