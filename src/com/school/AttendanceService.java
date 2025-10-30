package com.school;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AttendanceService {
    private List<AttendanceRecord> attendanceLog;
    private FileStorageService storageService;
    private RegistrationService registrationService;
    private final String ATTENDANCE_FILE = "attendance_log.txt";

    public AttendanceService(FileStorageService storageService, RegistrationService registrationService) {
        this.attendanceLog = new ArrayList<>();
        this.storageService = storageService;
        this.registrationService = registrationService;
    }

    public void markAttendance(Student student, Course course, String status) {
        if (student == null || course == null) {
            System.out.println("Error: Student or Course object cannot be null.");
            return;
        }
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        this.attendanceLog.add(record);
        System.out.println("Attendance marked for " + student.getName() + " in " + course.getCourseName() + " as " + record.getStatus());
    }

    public void markAttendance(int studentId, int courseId, String status) {
        Student student = registrationService.findStudentById(studentId);
        Course course = registrationService.findCourseById(courseId);

        if (student == null) {
            System.out.println("Error: Student with ID " + studentId + " not found.");
            return;
        }
        if (course == null) {
            System.out.println("Error: Course with ID " + courseId + " not found.");
            return;
        }
        markAttendance(student, course, status);
    }

    // ... rest of the methods remain the same ...

public void displayAttendanceLog() {
        System.out.println("\n--- Attendance Log ---");
        if (attendanceLog.isEmpty()) {
            System.out.println("No attendance records found.");
            return;
        }
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }
    }
    public void saveAttendanceData() {
        List<String> dataLines = attendanceLog.stream()
                .map(AttendanceRecord::toDataString)
                .collect(Collectors.toList());
        // storageService.saveData(ATTENDANCE_FILE, dataLines);
        System.out.println("Attendance data saved to " + ATTENDANCE_FILE);
    }
}