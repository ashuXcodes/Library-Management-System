package library.domain;

import java.time.LocalDate;

import library.service.Librarian;

public class Loan {

    private Student student;
    private Book book;
    private LocalDate issueDate;
    private Librarian librarian;

    public Loan(Librarian librarian,Student student, Book book, LocalDate issueDate) {
        this.librarian = librarian;
        this.student = student;
        this.book = book;
        this.issueDate = issueDate;
    }

    public Student getStudent() {
        return student;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    @Override
    public String toString() {
        return "Student: " + student.getStudentName() +
               ", Book: " + book.getTitle() + ", Issued by: " + librarian.getLibrarianName()+
               ", Issue Date: " + issueDate;
    }
}