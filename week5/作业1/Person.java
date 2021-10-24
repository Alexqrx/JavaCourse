package com.tgt.common.bean;

import java.util.Date;
import java.util.List;

public class Person {
    private String name;
    private int age;
    private Date birthday;

    private List<Double> scores;

    public List<Double> getScores() {
        return scores;
    }

    public void setScores(List<Double> scores) {
        this.scores = scores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        String base = "{name:" + this.name + ",age:" + this.age + ",birthday:" + this.birthday + "}";
        base += "\r\n";
        for (Double score : scores) {
            base += score + "\r\n";
        }
        return base;
    }
}