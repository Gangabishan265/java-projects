package com.example;

public class Students {
    private String id;
    private String name;
    private int age;
    private char grade;

    public Students(String id, String name, int age, char grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "    Id: " + id + "Name: " + name + "   " + "Age: " + age + "   " + "Grade: " + grade;
    }
}
