package src.com.school;

public class Main {
  public static void main(String[] args) {

    System.out.println("\nWelcome to the School Attendance System Project!");

    Student[] students = new Student[2];
    students[0] = new Student();
    students[0].SetDetails(1, "Pushkar");
    students[1] = new Student();
    students[1].SetDetails(2, "Rahul");

    Course[] courses = new Course[2];
    courses[0] = new Course();
    courses[0].SetDetails("CS101", "Computer Science");
    courses[1] = new Course();
    courses[1].SetDetails("PS102", "Physics");

    System.out.println("\nStudents:");
    for (Student s : students) {
      if (s != null)
        s.displayDetails();
    }

    System.out.println("\nCourses:");
    for (Course c : courses) {
      if (c != null)
        c.displayDetails();
    }
  }
}