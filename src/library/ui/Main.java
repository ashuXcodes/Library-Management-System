package library.ui;

import library.domain.*;
import library.service.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();
        Librarian librarian = new Librarian(1, "Mr sharma");
        
        Scanner sc = new Scanner(System.in);

       int choice;

       do{
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Show Students");
            System.out.println("6. Show Books");
            System.out.println("7. Show Loan Records");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.print("Enter Student ID: ");
                    int studentId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String studentName = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();

                    Student student = new Student(studentId, studentName, department);

                    librarian.registerStudent(library, student);

                    break;

                case 2:
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();

                    Book book = new Book(bookId, title, author);

                    librarian.registerBook(library, book);

                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    int issueStudentId = sc.nextInt();

                    System.out.print("Enter Book ID: ");
                    int issueBookId = sc.nextInt();
                    sc.nextLine();

                    Student issueStudent = library.findStudentById(issueStudentId);
                    Book issueBook = library.findBookById(issueBookId);

                    librarian.issueBook(library,issueStudent, issueBook);

                    break;

                case 4:
                    System.out.print("Enter Student ID: ");
                    int returnStudentId = sc.nextInt();

                    System.out.print("Enter Book ID: ");
                    int returnBookId = sc.nextInt();

                    Student returnStudent = library.findStudentById(returnStudentId);
                    Book returnBook = library.findBookById(returnBookId);

                    librarian.returnBook(library,returnStudent, returnBook);

                    break;

                case 5:
                    System.out.println("\n-------Student list--------");
                    library.showStudents();

                    break;

                case 6:
                    System.out.println("\n---------Book list---------");
                    library.showBooks();

                    break;
                
                case 7:
                    System.out.println("--------Loan Records---------");
                    library.showLoans();

                    break;

                case 8:

                    System.out.println("Thankyou for using library Management System.");

                    break;
                default:

                    System.out.println("Invalid choice! Please try again.");


            }
       }while(choice != 8);

       sc.close();
    }
}