package com.school;
import java.util.*;

public class Main {
    public static void displaySchoolDirectory(RegistrationService regService) {
        System.out.println("\n--- School Directory ---");
        List<Person> people = regService.getAllPeople();
        if (people.isEmpty()) {
            System.out.println("No people in the directory.");
            return;
        }
        for (Person person : people) {
            person.displayDetails();
        }
    }

    public static void main(String[] args) {
        System.out.println("--- School System (Part 9) ---");

        // Initialize services
        FileStorageService storageService = new FileStorageService();
        RegistrationService regService = new RegistrationService(storageService);
        AttendanceService attendanceService = new AttendanceService(storageService, regService);

        // Register people and courses
        Student alice = regService.registerStudent("Alice Wonderland", "Grade 10");
        Student bob = regService.registerStudent("Bob The Builder", "Grade 9");
        Student charlie = regService.registerStudent("Charlie Chaplin", "Grade 10");

        Teacher emily = regService.registerTeacher("Dr. Emily Carter", "Physics");
        Staff john = regService.registerStaff("John Smith", "Librarian");

        Course programming = regService.createCourse("Intro to Programming");
        Course dataStructures = regService.createCourse("Data Structures");

        // Display directory
        displaySchoolDirectory(regService);

        // Mark attendance using new method
        attendanceService.markAttendance(alice.getId(), programming.getCourseId(), "Present");
        attendanceService.markAttendance(bob.getId(), programming.getCourseId(), "Absent");
        attendanceService.markAttendance(charlie.getId(), dataStructures.getCourseId(), "Present");

        // Display attendance
        attendanceService.displayAttendanceLog();

        // Save all data
        regService.saveAllRegistrations();
        attendanceService.saveAttendanceData();

        System.out.println("\nPart 9: Registration Service Implementation Complete.");
    }
}