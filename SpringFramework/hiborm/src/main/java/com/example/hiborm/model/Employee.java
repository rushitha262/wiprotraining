package com.example.hiborm.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;

    // Default constructor
    public Employee() {}

    // Parameterized constructor
    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters & Setters
    public int getId() 
    { 
    	return id;
    }
    public void setId(int id)
    { 
    	this.id = id;
    }

    public String getName() 
    { 
    	return name;
    }
    public void setName(String name) 
    { 
    	this.name = name; 
    }

    public String getEmail()
    {
    	return email; 
    }
    public void setEmail(String email) 
    { 
    	this.email = email;
    }

    
    @Override
    public String toString() {
        return "Employee { " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                " }";
    }
}
