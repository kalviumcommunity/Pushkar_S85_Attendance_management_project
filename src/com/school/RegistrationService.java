package com.school;

import java.util.ArrayList;
import java.util.List;

public class RegistrationService {
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Staff> staffMembers;
    private List<Course> courses;
    private FileStorageService storageService;

    private static final String STUDENTS_FILE = "students.txt";
    private static final String TEACHERS_FILE = "teachers.txt";
    private static final String STAFF_FILE = "staff.txt";
    private static final String COURSES_FILE = "courses.txt";

    public RegistrationService(FileStorageService storageService) {
        this.storageService = storageService;
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.staffMembers = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public Student registerStudent(String name, String gradeLevel) {
        Student student = new Student(name, gradeLevel);
        students.add(student);
        return student;
    }

    public Teacher registerTeacher(String name, String subject) {
        Teacher teacher = new Teacher(name, subject);
        teachers.add(teacher);
        return teacher;
    }

    public Staff registerStaff(String name, String role) {
        Staff staff = new Staff(name, role);
        staffMembers.add(staff);
        return staff;
    }

    public Course createCourse(String courseName) {
        Course course = new Course(courseName);
        courses.add(course);
        return course;
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public List<Teacher> getTeachers() {
        return new ArrayList<>(teachers);
    }

    public List<Staff> getStaffMembers() {
        return new ArrayList<>(staffMembers);
    }

    public List<Course> getCourses() {
        return new ArrayList<>(courses);
    }

    public Student findStudentById(int id) {
        return students.stream()
                      .filter(s -> s.getId() == id)
                      .findFirst()
                      .orElse(null);
    }

    public Course findCourseById(int id) {
        return courses.stream()
                     .filter(c -> c.getCourseId() == id)
                     .findFirst()
                     .orElse(null);
    }

    public List<Person> getAllPeople() {
        List<Person> allPeople = new ArrayList<>();
        allPeople.addAll(students);
        allPeople.addAll(teachers);
        allPeople.addAll(staffMembers);
        return allPeople;
    }

    public void saveAllRegistrations() {
        storageService.saveData(students, STUDENTS_FILE);
        storageService.saveData(teachers, TEACHERS_FILE);
        storageService.saveData(staffMembers, STAFF_FILE);
        storageService.saveData(courses, COURSES_FILE);
    }
}