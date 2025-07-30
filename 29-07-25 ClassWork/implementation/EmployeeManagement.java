package com.wipro.implementation;


import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagement {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);                      // Scanner for input
     ArrayList<Employee> employees = new ArrayList<>();        // List to store employees
     int choice;

     do {
         // Display 
         System.out.println("Employee Management System ");
         System.out.println("1. Add Employee");
         System.out.println("2. View All Employees");
         System.out.println("3. Search Employee by Name");
         System.out.println("4. Update Employee by ID");
         System.out.println("5. Delete Employee by ID");
         System.out.println("6. Exit");
         System.out.print("Enter your choice: ");
         choice = sc.nextInt();
         sc.nextLine(); 

         switch (choice) {
             case 1:
                 // Add Employee
                 System.out.print("Enter ID: ");
                 int id = sc.nextInt();
                 sc.nextLine();

                 System.out.print("Enter Name: ");
                 String name = sc.nextLine().trim();

                 System.out.print("Enter Position: ");
                 String position = sc.nextLine().trim();

                 System.out.print("Enter Salary: ");
                 double salary = sc.nextDouble();

                 employees.add(new Employee(id, name, position, salary));
                 System.out.println("Employee added.");
                 break;

             case 2:
                 // View All Employees
                 if (employees.size() == 0) {
                     System.out.println("No employees to display.");
                 } else {
                     for (Employee emp : employees) {
                         emp.display();
                     }
                 }
                 break;

             case 3:
                 // Search by Name 
                 System.out.print("Enter name to search: ");
                 String searchName = sc.nextLine().toLowerCase().trim();
                 int matchCount = 0;

                 for (Employee emp : employees) {
                     if (emp.name.toLowerCase().contains(searchName)) {
                         emp.display();
                         matchCount++;
                     }
                 }

                 if (matchCount == 0) {
                     System.out.println("No employee found with that name.");
                 }
                 break;

             case 4:
                 // Update by ID
                 System.out.print("Enter ID to update: ");
                 int updateId = sc.nextInt();
                 sc.nextLine();

                 for (int i = 0; i < employees.size(); i++) {
                     if (employees.get(i).id == updateId) {
                         System.out.print("Enter new Name: ");
                         employees.get(i).name = sc.nextLine().trim();

                         System.out.print("Enter new Position: ");
                         employees.get(i).position = sc.nextLine().trim();

                         System.out.print("Enter new Salary: ");
                         employees.get(i).salary = sc.nextDouble();

                         System.out.println("Employee updated.");
                         break;
                     }

                     
                     if (i == employees.size() - 1) {
                         System.out.println("Employee not found.");
                     }
                 }
                 break;

             case 5:
                 // Delete 
                 System.out.print("Enter ID to delete: ");
                 int deleteId = sc.nextInt();

                 for (int i = 0; i < employees.size(); i++) {
                     if (employees.get(i).id == deleteId) {
                         employees.remove(i);
                         System.out.println("Employee deleted.");
                         break;
                     }

                     if (i == employees.size() - 1) {
                         System.out.println("1Employee not found.");
                     }
                 }
                 break;

             case 6:
                 // Exit
                 System.out.println("Exiting program");
                 break;

             default:
                 System.out.println("Invalid choice. Try again.");
         }

     } while (choice != 6); // Repeat menu until exit

     sc.close(); 
 }
}
