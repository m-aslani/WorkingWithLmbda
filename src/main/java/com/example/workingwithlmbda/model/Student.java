package com.example.workingwithlmbda.model;

public class Student extends Person{
    private double grade;

    public Student(String firstName, String lastName, int age, double grade) {
        super(firstName, lastName, age);
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }
    public void setGrade(double grade) {
        this.grade = grade;
    }
}
