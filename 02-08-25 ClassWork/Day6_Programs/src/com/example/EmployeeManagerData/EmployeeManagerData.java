package com.example.EmployeeManagerData;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import com.example.characterStream.Employee;

public class EmployeeManagerData {

    private static final Path Dir = Paths.get("FileData");                  // Directory path
    private static final Path File = Dir.resolve("employee.txt");          // File path inside directory
    private static final Scanner sc = new Scanner(System.in);              // Scanner for input

    public static void main(String[] args) throws IOException {

        Files.createDirectories(Dir);                                      // Create directory if not exists
        if (!Files.exists(File))                                           // Create file if not exists
            Files.createFile(File);

        while (true) {
            System.out.println("1. Add  2. Delete  3. Search  4. View All  5. Save & Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> deleteEmployee();
                case 3 -> searchEmployee();
                case 4 -> viewAll();
                case 5 -> {
                    saveAndExit();
                    return;
                }
                default -> System.out.println("Invalid choice, try again.");
            }
        }
    }

    private static void addEmployee() {
        try (BufferedWriter writer = Files.newBufferedWriter(File, StandardOpenOption.APPEND)) {
            System.out.println("Enter ID, Name, and Salary:");
            int id = sc.nextInt();
            String name = sc.next();
            double salary = sc.nextDouble();

            Employee e = new Employee(id, name, salary);      // Create employee object
            writer.write(e.toString());                       // Write to file
            writer.newLine();                                 // Move to next line
            System.out.println("Employee added.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void deleteEmployee() {
        System.out.println("Enter Employee ID to delete:");
        int deleteId = sc.nextInt();

        List<String> updatedLines = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(File)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                if (Integer.parseInt(parts[0]) != deleteId) {
                    updatedLines.add(line);   // Add only lines that don't match the ID
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        try (BufferedWriter writer = Files.newBufferedWriter(File, StandardOpenOption.TRUNCATE_EXISTING)) {
            for (String updatedLine : updatedLines) {
                writer.write(updatedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
            return;
        }

        System.out.println("If employee existed, they are now deleted.");
    }

    private static void searchEmployee() {
        System.out.println("Enter Employee ID to search:");
        int searchId = sc.nextInt();

        try (BufferedReader reader = Files.newBufferedReader(File)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                if (Integer.parseInt(parts[0]) == searchId) {
                    System.out.println("Employee Found: " + line);
                    return;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        System.out.println("Employee not found.");
    }

    private static void viewAll() {
        System.out.println("Employee Records:");
        try (BufferedReader reader = Files.newBufferedReader(File)) {
            String line;
            boolean empty = true;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                empty = false;
            }
            if (empty) {
                System.out.println("No records found.");
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    private static void saveAndExit() {
        System.out.println("Saved and exiting...");
    }
}
