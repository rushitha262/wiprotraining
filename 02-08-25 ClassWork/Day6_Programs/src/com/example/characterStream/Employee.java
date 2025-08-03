package com.example.characterStream;

public class Employee {

    private int id;              // Employee ID
    private String name;         // Employee name
    private double salary;       // Employee salary

    // ✅ Correct constructor to initialize values
    public Employee(int id, String name, double salary) {
        this.id = id;            // Set ID
        this.name = name;        // Set name
        this.salary = salary;    // Set salary
    }

    // Getter and setter methods
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    // Convert object to string for storing in file
    @Override
    public String toString() {
        return id + " " + name + " " + salary;
    }
}
