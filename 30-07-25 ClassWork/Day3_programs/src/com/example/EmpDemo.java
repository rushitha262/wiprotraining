package com.example;

public class EmpDemo {


 static class Emp {
     // Private fields for encapsulation
     private int id;
     private String name;
     private double salary;

     // Constructor to initialize id, name, and salary
     public Emp(int id, String name, double salary) {
         this.id = id;
         this.name = name.trim();  // Trim spaces from the name

         // Validate salary
         if (salary < 50000) {
             this.salary = salary;
         } else {
             System.out.println("Salary must be below 50000. Setting salary to 0.");
             this.salary = 0;
         }
     }

     // Setter for ID
     public void setId(int id) {
         this.id = id;
     }

     // Setter for name with trim
     public void setName(String name) {
         this.name = name.trim();
     }

     // Setter for salary with validation
     public void setSalary(double salary) {
         if (salary < 50000) {
             this.salary = salary;
         } else {
             System.out.println("Salary must be below 50000. Not set.");
         }
     }

     // Display employee details
     public void display() {
         System.out.println("Employee ID: " + id);
         System.out.println("Employee Name: " + name);
         System.out.println("Employee Salary: " + salary);
     }
 }


 public static void main(String[] args) {
     // Create employee with valid data
     Emp emp1 = new Emp(101, "  rushitha  ", 47000);
     emp1.display();

     System.out.println(); 

     // Create employee with invalid salary
     Emp emp2 = new Emp(102, "  Sri", 52000); 
     emp2.display();
 }
}