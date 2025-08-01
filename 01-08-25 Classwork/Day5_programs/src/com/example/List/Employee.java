package com.example.List;

public class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor with all fields
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Employee() {
		// TODO Auto-generated constructor stub
	}

	// Display method
    public void display() {
        System.out.println("ID       : " + id);
        System.out.println("Name     : " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary   : " + salary);
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    // Optional: toString method for easy print
    @Override
    public String toString() {
        return "Employee [ID=" + id + ", Name=" + name + ", Department=" + department + ", Salary=" + salary + "]";
    }
}
