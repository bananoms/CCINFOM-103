package DBAPP;
import java.io.*;
import java.util.*;

public class StudentManagementMenu {
    private int menuSelection;

    public StudentManagementMenu() {
        this.menuSelection = -1;
    }

    private static void displayStudentManagementMenu() {
        System.out.println(" ");
        System.out.println("====================================================");
        System.out.println("    Student Management Menu");
        System.out.println("----------------------------------------------------");
        System.out.println("[1] Create a new Student Record");
        System.out.println("[2] Update a Student Record");
        System.out.println("[3] Delete a Student Record");
        System.out.println("[4] View a Student Record");
        System.out.println("----------------------------------------------------");
        System.out.println("[0]EXIT Student Management");
        System.out.println("====================================================");
        System.out.println(" ");
    }

    private void promptForMenuSelection() {
        this.menuSelection = -1;
        Scanner sc = new Scanner(System.in);

        while (this.menuSelection < 0 || this.menuSelection > 4) {
            try {
                System.out.println("Please enter number for selection:");
                this.menuSelection = Integer.parseInt(sc.nextLine());

                if (this.menuSelection < 0 || this.menuSelection > 4) {
                    System.out.println("Invalid selection. [0-4]");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a number from 0 to 4.");
            }
        }
    }

    private void manageStudentRecords() {
        displayStudentManagementMenu();
        promptForMenuSelection();
        switch (this.menuSelection) {
            case 1:
                addStudentRecord();
                break;
            case 2:
                updateStudentRecord();
                break;
            case 3:
                deleteStudentRecord();
                break;
            case 4:
                viewStudentRecord();
                break;
            default:
                System.out.println("Exiting Student Management.");
        }
    }

//    FOR TESTING
//    public static void main(String args[]) {
//        StudentManagementMenu smm = new StudentManagementMenu();
//        smm.manageStudentRecords();
//    }

    private int getMenuSelection() {
        return this.menuSelection;
    }

    // implement backend aspect
    // requires code to check if valid inputs (relative to reference table)
    private void addStudentRecord() {
        System.out.println("\nEnter Student Information");
        System.out.println("---------------------------------------------------");
        System.out.println("First Name                : ");
        System.out.println("Last Name                 : ");
        System.out.println("Middle Name               : ");
        System.out.println("Student ID                : ");
        System.out.println("Degree                    : ");
        System.out.println("Email address             : ");
        System.out.println("Sex (M/F)                 : ");
        System.out.println("Street Address            : ");
        System.out.println("Barangay                  : ");
        System.out.println("City                      : ");
        System.out.println("Province                  : ");
        System.out.println("Country                   : ");
        System.out.println("Current Term Enrolled in  : ");
        // What is RIG?
        System.out.println("Student Type (R,I,G)      : ");
        // What is RON in Leave of Absence?
        System.out.println("Activity                  : ");
    }

    // implement backend aspect
    private void deleteStudentRecord() {
        // search for a record given student ID
        System.out.println("Enter Student ID for deletion:");
        // check if record exists
        System.out.println("---------------------------------------------------");

        System.out.println("Deleting [STUDENT NAME] ID: [ID NUMBER] Record.");
    }

    // implement backend aspect
    private void updateStudentRecord() {
        // search for a record given student ID
        System.out.println("Enter Student ID:");
        // check if record exists

        // display current record info
        System.out.println("\nCurrent Student Information");
        System.out.println("---------------------------------------------------");
        System.out.println("First Name                : ");
        System.out.println("Last Name                 : ");
        System.out.println("Middle Name               : ");
        System.out.println("Student ID                : ");
        System.out.println("Degree                    : ");
        System.out.println("Email address             : ");
        System.out.println("Sex (M/F)                 : ");
        System.out.println("Street Address            : ");
        System.out.println("Barangay                  : ");
        System.out.println("City                      : ");
        System.out.println("Province                  : ");
        System.out.println("Country                   : ");
        System.out.println("Current Term Enrolled in  : ");
        // What is RIG?
        System.out.println("Student Type (R,I,G)      : ");
        // What is RON in Leave of Absence?
        System.out.println("Activity                  : ");

        // prompt for new record info
        System.out.println("\nNew Student Information");
        System.out.println("---------------------------------------------------");
        System.out.println("First Name                : ");
        System.out.println("Last Name                 : ");
        System.out.println("Middle Name               : ");
        System.out.println("Student ID                : ");
        System.out.println("Degree                    : ");
        System.out.println("Email address             : ");
        System.out.println("Sex (M/F)                 : ");
        System.out.println("Street Address            : ");
        System.out.println("Barangay                  : ");
        System.out.println("City                      : ");
        System.out.println("Province                  : ");
        System.out.println("Country                   : ");
        System.out.println("Current Term Enrolled in  : ");
        // What is RIG?
        System.out.println("Student Type (R,I,G)      : ");
        // What is RON in Leave of Absence?
        System.out.println("Activity                  : ");
    }

    private void viewStudentRecord() {
        // search for a record given student ID
        System.out.println("Enter Student ID:");
        // check if record exists

        // display current record info
        System.out.println("\nCurrent Student Information");
        System.out.println("---------------------------------------------------");
        System.out.println("First Name                : ");
        System.out.println("Last Name                 : ");
        System.out.println("Middle Name               : ");
        System.out.println("Student ID                : ");
        System.out.println("Degree                    : ");
        System.out.println("Email address             : ");
        System.out.println("Sex (M/F)                 : ");
        System.out.println("Street Address            : ");
        System.out.println("Barangay                  : ");
        System.out.println("City                      : ");
        System.out.println("Province                  : ");
        System.out.println("Country                   : ");
        System.out.println("Current Term Enrolled in  : ");
        // What is RIG?
        System.out.println("Student Type (R,I,G)      : ");
        // What is RON in Leave of Absence?
        System.out.println("Activity                  : ");
    }
}
