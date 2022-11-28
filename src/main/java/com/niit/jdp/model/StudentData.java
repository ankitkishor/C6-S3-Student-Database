/*
 * Author : Ankit Kishor
 * Date: 28-11-2022
 * Created with :Intellij IDEA Community Edition
 */


package com.niit.jdp.model;

public class StudentData {
    private int  rollNo;
    private String name;
    private String grades;

    public StudentData(int rollNo, String name, String grades) {
        this.rollNo = rollNo;
        this.name = name;
        this.grades = grades;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrades() {
        return grades;
    }

    public void setGrades(String grades) {
        this.grades = grades;
    }

}
