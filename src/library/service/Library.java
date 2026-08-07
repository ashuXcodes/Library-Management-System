package library.service;

import java.util.ArrayList;
import library.domain.*;
import java.time.LocalDate;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Loan> loans = new ArrayList<>();

    public void addBook(Book book) {
        if(findBookById(book.getBookId()) != null){
            System.out.println("Book ID already exists!");
            return;
        }
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void addStudent(Student student) {

        if(findStudentById(student.getStudentId()) != null){
            System.out.println("Student ID already exists!");
            return;
        }
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void issueBook(Librarian librarian,Student student, Book book) {

        if(student == null){
            System.out.println("Student not found.");
            return;
        }

        if(book == null){
            System.out.println("book not found.");
            return;
        }

        if(!book.isAvailable()){
            System.out.println("Book is already issued");
            return;
        }

        LocalDate issueDate = LocalDate.now();
        Loan loan = new Loan(librarian,student, book,issueDate);

        loans.add(loan);

        book.setAvailable(false);

        System.out.println("Book issued successfully.");
    
    }

    public void returnBook(Student student, Book book) {


        if(student == null || book == null){
            System.out.println("Invalid student or book.");
            return;
        }

        Loan loanToRemove = null;

        for (Loan loan : loans) {

            if (loan.getStudent().getStudentId() == student.getStudentId() &&
                loan.getBook().getBookId() == book.getBookId()) {

                loanToRemove = loan;
                break;
            }

        }

        if (loanToRemove == null) {

            System.out.println("Loan record not found!");
            return;

        }

        loans.remove(loanToRemove);

        book.setAvailable(true);

        System.out.println("\nBook returned successfully.");
    }


    public Student findStudentById(int studentId) {

        for (Student student : students) {

            if (student.getStudentId() == studentId) {
                return student;
            }

        }

        return null;
    }

    public Book findBookById(int bookId) {

        for (Book book : books) {

            if (book.getBookId() == bookId) {
                return book;
            }

        }

        return null;
    }

    public void showBooks() {
        if(books.isEmpty()){
            System.out.println("No books found!");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void showStudents() {

        if(students.isEmpty()){
            System.out.println("No students found!");
            return;
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void showLoans() {

        if(loans.isEmpty()){
            System.out.println("No loan records found!");
            return;
        }
        for (Loan loan : loans) {
            System.out.println(loan);
        }
    }
}