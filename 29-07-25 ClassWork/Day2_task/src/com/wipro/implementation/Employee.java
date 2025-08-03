package com.wipro.implementation;
//import model;

//This class represents an Employee with ID, Name, Position, and Salary
public class Employee {

 // Declare instance variables to store employee details
 int id;             // Employee ID (unique identifier)
 String name;        // Employee name
 String position;    // Employee job position
 double salary;      // Employee salary

 // Constructor to initialize employee details
 public Employee(int id, String name, String position, double salary) {
     this.id = id;                           // Assign the given id to the employee's id field
     this.name = name.trim();               // Assign trimmed name to avoid unwanted spaces
     this.position = position.trim();       // Assign trimmed position to clean input
     this.salary = salary;                  // Assign salary directly
 }

 // Method to display the employee details in a readable format
 public void display() {
     System.out.println("ID       : " + id);           // Print employee ID
     System.out.println("Name     : " + name);         // Print employee name
     System.out.println("Position : " + position);     // Print job title/role
     System.out.println("Salary   : " + salary);       // Print salary
    
 }
 
}
