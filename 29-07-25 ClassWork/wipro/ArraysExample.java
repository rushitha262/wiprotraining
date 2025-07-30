package com.wipro;

public class ArraysExample {

    // Inner Student class
    static class Student {
        int id;
        String name;
        int[] marks;

        // Constructor
        public Student(int id, String name, int[] marks) {
            this.id = id;
            this.name = name;
            this.marks = marks;
        }

        // Method to display student details and marks
        public void display() {
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.print("Marks: ");
            for (int mark : marks) {
                System.out.print(mark + " ");
            }
            System.out.println(); // Move to next line after marks
        }
    }

    // Main method
    public static void main(String[] args) {
        // Creating an array of marks
        int[] marks = {85, 90, 78};

        // Creating a Student object
        Student student = new Student(101, "Rushitha", marks);

        // Displaying student info and marks
        student.display();
    }
}