package library.domain;

public class Student {

    private int studentId;
    private String studentName;
    private String department;

    public Student(int studentId, String studentName, String department) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.department = department;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId +
               ", Name: " + studentName +
               ", Department: " + department;
    }
}