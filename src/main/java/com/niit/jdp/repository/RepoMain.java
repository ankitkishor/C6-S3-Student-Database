/*
 * Author : Ankit Kishor
 * Date: 28-11-2022
 * Created with :Intellij IDEA Community Edition
 */


package com.niit.jdp.repository;

import java.sql.SQLException;
import java.util.Scanner;

public class RepoMain {
    public static void main(String[] args) {



            try {
                StudentSalesRepository repository=new StudentSalesRepository();
                Scanner scanner=new Scanner(System.in);
                int choice=0;
                do {
                    System.out.println("\nWelcome Student Date Table");
                    System.out.println("====================================================================");
//                System.out.println("1. Add a new salesperson");
                    System.out.println("1. Update the grades using roll number");
                    System.out.println("2. Delete a student from list");
                    System.out.println("3. Display all salespersons");
//                System.out.println("5. Display the details of a particular Salesperson");
                    System.out.println("4. Exit");
                    System.out.println("====================================================================");
                    System.out.println("Enter your choice: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1:
                            System.out.println("updating the grades using roll number ");
                            System.out.println("enter the roll number");
                            int rollNo = scanner.nextInt();
                            System.out.println("Enter new the grade");
                            String grades = scanner.next();
                            boolean updateStudent = repository.updateStudentByRollNo(rollNo, grades);
                            if (updateStudent) {
                                System.out.println("\u001B[32m student updated successfully \u001B[0m");
                            } else {
                                System.err.println("student could not be updated");
                            }
                            break;

                        case 2:
                            System.out.println("Deleting a student:");
                            System.out.print("Enter the student roll number to be deleted: ");
                            int deleteRollNo = scanner.nextInt();
                            boolean deletedStudent = repository.deleteByRollNo(deleteRollNo);
                            if (deletedStudent) {
                                System.out.println("\u001B[32m student deleted successfully \u001B[0m");
                            } else {
                                System.err.println("student could not be deleted");
                            }
                            break;

                        case 3:
                            System.out.println("Displaying all the student data:");
                            System.out.println(repository.getAllStudentDatabase());
                            break;
                        case 4:
                            System.out.println("Exiting the application");
                            break;

                        default:
                            System.out.println("invalid choice please choose from menu");
                    }
                }while(choice!=6);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }



    }
}
