package src.com.school;

public class Course {
  String name;
  String courseId;

  public void SetDetails(String id, String courseName) {
    this.courseId = id;
    this.name = courseName;
  }

  public void displayDetails() {
    System.out.println("Student ID: " + this.courseId + ", Name: " + this.name);
  }
}