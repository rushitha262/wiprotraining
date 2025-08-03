package com.example.queue;

import java.util.*;

//Patient class
class Patient implements Comparable<Patient> {
 String name;
 String condition;
 int priority; // 1 = Emergency, 2 = Serious, 3 = General

 public Patient(String name, String condition, int priority) {
     this.name = name;
     this.condition = condition;
     this.priority = priority;
 }

 @Override
 public int compareTo(Patient other) {
     return Integer.compare(this.priority, other.priority); // lower priority value = higher importance
 }

 @Override
 public String toString() {
     return "Name: " + name + ", Condition: " + condition + ", Priority: " + priority;
 }
}

//Main class
public class QueueExampleTask {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     PriorityQueue<Patient> queue = new PriorityQueue<>();

     System.out.print("Enter number of patients: ");
     int n = sc.nextInt();
     sc.nextLine(); // Consume the newline

     for (int i = 0; i < n; i++) {
         System.out.println("\nEnter details of patient " + (i + 1) + ":");
         System.out.print("Name: ");
         String name = sc.nextLine();
         System.out.print("Condition: ");
         String condition = sc.nextLine();
         System.out.print("Priority (1 - Emergency, 2 - Serious, 3 - General): ");
         int priority = sc.nextInt();
         sc.nextLine(); // Consume the newline

         queue.offer(new Patient(name, condition, priority));
     }

     System.out.println("\n--- Patients will be treated in order of priority ---");
     while (!queue.isEmpty()) {
         Patient p = queue.poll();
         System.out.println(p);
     }

     sc.close();
 }
}
