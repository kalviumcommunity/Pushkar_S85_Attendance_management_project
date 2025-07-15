package src.com.school;

public class Student {
  String name;
  int studentId;

  public void SetDetails(int id, String studentName) {
    this.studentId = id;
    this.name = studentName;
  }

  public void displayDetails() {
    System.out.println("Student ID: " + this.studentId + ", Name: " + this.name);
  }
}