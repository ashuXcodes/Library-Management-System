package library.service;

import library.domain.Book;
import library.domain.Student;

public class Librarian {

    private int librarianId;
    private String librarianName;

    public Librarian(int librarianId, String librarianName) {
        this.librarianId = librarianId;
        this.librarianName = librarianName;
    }

    public int getLibrarianId() {
        return librarianId;
    }

    public String getLibrarianName() {
        return librarianName;
    }

    // Register Student
    public void registerStudent(Library library, Student student) {
        library.addStudent(student);
    }

    // Register Book
    public void registerBook(Library library, Book book) {
        library.addBook(book);
    }

    // Issue Book
    public void issueBook(Library library, Student student, Book book) {

        System.out.println("\nLibrarian " + librarianName + " is issuing the book...");

        library.issueBook(this,student, book);

    }

    // Return Book
    public void returnBook(Library library, Student student, Book book) {

        System.out.println("\nLibrarian " + librarianName + " is accepting the returned book...");

        library.returnBook(student, book);

    }

    @Override
    public String toString() {
        return "Librarian ID: " + librarianId +
                ", Name: " + librarianName;
    }

}