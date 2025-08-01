package com.example.customexceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.List.Employee;

public class Main {

    private static List<Employee> list = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add  2. Delete  3. Search  4. View All 5. Add at Position ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> deleteEmployee();
                case 3 -> searchEmployee();
                case 4 -> viewAll();
                case 5 -> addEmployeeAtPosition();
                case 6 -> sortEmployee();
            }
        }
    }

    private static Object sortEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	static void addEmployee() {
        System.out.println("Enter id, name, salary:");
        int id = sc.nextInt();
        String name = sc.next();
        double salary = sc.nextDouble();
        list.add(new Employee(id, name, salary));
        System.out.println("Employee added at end.");
    }

    //static void addEmployeeAtPosition() {
       // System.out.println("Enter id, name, salary:");
        //int id = sc.nextInt();
        //String name = sc.next();
        //double salary = sc.nextDouble();

       // System.out.println("Enter position to add the employee (0 to " + list.size() + "):");
        //int position = sc.nextInt();

      //  if (position < 0 || position > list.size()) {
        //    System.out.println("Invalid position. Employee not added.");
        //} else {
          //  list.add(position, new Employee(id, name, salary));
            //System.out.println("Employee added at position " + position);
        //}
    //}

    static void deleteEmployee() {
        System.out.println("Enter employee id to delete:");
        int id = sc.nextInt();
        int indexToDelete = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                indexToDelete = i;
            }
        }
        if (indexToDelete != -1) {
            list.remove(indexToDelete);
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    static void searchEmployee() {
        System.out.println("Enter employee id to search:");
        int id = sc.nextInt();
        Employee found = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                found = list.get(i);
            }
        }
        if (found != null) {
            System.out.println("Employee found: " + found);
        } else {
            System.out.println("Employee not found.");
        }
    }
    static void addEmployeeAtPosition() {
   	 
   	 System.out.println("Enter the position where you want to add the employee:");
   	 int position = sc.nextInt();
   	 System.out.println("Enter id  , Name , salary");
   	 int id=sc.nextInt();
   	 String name= sc.next();
   	 double salary = sc.nextDouble();
   	 if(position>=0 && position<=list.size())
   	 list.add(position , new Employee(id,name,salary));
   	 else
   		 System.out.println("Invalid Position");
   	 
    }
    
    static void viewAll() {
        System.out.println("Employee Data:");
        for (Employee e : list) {
            System.out.println(e);
        }
        System.exit(0);    }
}
