//multithreading


package com.wipro;

import java.util.Scanner;

public class Student1 {

    int id;
    String name;

    // Constructor
    public Student1(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Method to display student details along with marks
    public void displayInfo(int[] marks) {
        System.out.println("Student ID   : " + id);
        System.out.println("Student Name : " + name);
        System.out.print("Marks        : ");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println("\n-----------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int totalStudents = sc.nextInt();

        // Arrays to hold student data and marks
        Student1[] students = new Student1[totalStudents];
        int[][] marks = new int[totalStudents][];  // Jagged 2D array

        // Input loop
        for (int i = 0; i < totalStudents; i++) {
            System.out.println("\nEnter details for Student " + (i + 1));

            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            System.out.print("Enter Name: ");
            String name = sc.next();

            students[i] = new Student1(id, name);

            System.out.print("Enter number of subjects: ");
            int subjectCount = sc.nextInt();

            marks[i] = new int[subjectCount]; // Assigning column length for each student

            System.out.println("Enter marks:");
            for (int j = 0; j < subjectCount; j++) {
                System.out.print("Subject " + (j + 1) + ": ");
                marks[i][j] = sc.nextInt();
            }
        }

        // Output loop
        System.out.println("\n==== Student Details ====");
        for (int i = 0; i < totalStudents; i++) {
            students[i].displayInfo(marks[i]);
        }

        sc.close();
    }
}
