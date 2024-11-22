package DBAPP;
import java.io.*;
import java.util.*;

public class StudentManagementMenu {
    private int menuSelection;
    Scanner sc = new Scanner(System.in);

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
        StudentManagement sm = new StudentManagement();
        System.out.println("\nEnter Student Information");
        System.out.println("---------------------------------------------------");

        // Prompt and set First Name
        System.out.print("First Name                : ");
        sm.setFirstName(sc.nextLine());

        // Prompt and set Last Name
        System.out.print("Last Name                 : ");
        sm.setLastName(sc.nextLine());

        // Prompt and set Middle Name
        System.out.print("Middle Name               : ");
        sm.setMiddleName(sc.nextLine());

        // Prompt and set Student ID
        System.out.print("Student ID                : ");
        sm.setStudentID(sc.nextInt());
        sc.nextLine(); // Consume leftover newline

        // Prompt and set Degree
        System.out.print("Degree                    : ");
        int degreeID = sc.nextInt();

        // Prompt and set Email address
        System.out.print("Email address             : ");
        sm.setEmail(sc.nextLine());

        // Prompt and set Sex (M/F)
        System.out.print("Sex (M/F)                 : ");
        sm.setSex(sc.nextLine().toUpperCase());

        // Prompt and set Street Address
        System.out.print("Street Address            : ");
        sm.setStreetAddress(sc.nextLine());

        // Prompt and set Barangay
        System.out.print("Barangay                  : ");
        sm.setBarangay(sc.nextLine());

        // Prompt and set City
        System.out.print("City                      : ");
        sm.setCity(sc.nextLine());

        // Prompt and set Province
        System.out.print("Province                  : ");
        sm.setProvince(sc.nextLine());

        // Prompt and set Country
        System.out.print("Country                   : ");
        sm.setCountry(sc.nextLine());

        System.out.println("Current Term Enrolled in  : ");
        // What is RIG?
        System.out.println("Student Type (R,I,G)      : ");
        // What is RON in Leave of Absence?
        System.out.println("Activity                  : ");
    }

    // implement backend aspect
    private void deleteStudentRecord() {
        StudentManagement sm = new StudentManagement();
        // search for a record given student ID
        System.out.println("Enter Student ID for deletion:");
        // Add code to check if record exists
        sm.setStudentID(sc.nextInt());
        sc.nextLine(); // Consume leftover newline
        System.out.println("---------------------------------------------------");

        System.out.println("Deleting [STUDENT NAME] ID: [ID NUMBER] Record.");
    }

    // implement backend aspect
    private void updateStudentRecord() {
        StudentManagement sm = new StudentManagement();
        // search for a record given student ID
        System.out.println("Enter Student ID:");
        sm.setStudentID(sc.nextInt());
        sc.nextLine(); // Consume leftover newline

        // Check if record exists
        if (sm.getStudentRecord() == 0) {
            System.out.println("That student does not exist in the records");
            return;
        }

        // display current record info
        System.out.println("\nCurrent Student Information");
        System.out.println("---------------------------------------------------");
        System.out.println("First Name                : " + sm.getFirstName());
        System.out.println("First Name                : " + sm.getFirstName());
        System.out.println("Last Name                 : " + sm.getLastName());
        System.out.println("Middle Name               : " + sm.getMiddleName());
        System.out.println("Student ID                : " + sm.getStudentID());
        System.out.println("Degree                    : ");
        System.out.println("Email address             : " + sm.getEmail());
        System.out.println("Sex (M/F)                 : " + sm.getSex());
        System.out.println("Street Address            : " + sm.getStreetAddress());
        System.out.println("Barangay                  : " + sm.getBarangay());
        System.out.println("City                      : " + sm.getCity());
        System.out.println("Province                  : " + sm.getProvince());
        System.out.println("Country                   : " + sm.getCountry());
        System.out.println("Current Term Enrolled in  : ");
        // What is RIG?
        System.out.println("Student Type (R,I,G)      : ");
        // What is RON in Leave of Absence?
        System.out.println("Activity                  : ");

        // prompt for new record info
        System.out.println("\nNew Student Information");
        System.out.println("---------------------------------------------------");
        // Prompt and set First Name
        System.out.print("First Name                : ");
        sm.setFirstName(sc.nextLine());

        // Prompt and set Last Name
        System.out.print("Last Name                 : ");
        sm.setLastName(sc.nextLine());

        // Prompt and set Middle Name
        System.out.print("Middle Name               : ");
        sm.setMiddleName(sc.nextLine());

        // Prompt and set Student ID
        System.out.print("Student ID                : ");
        sm.setStudentID(sc.nextInt());
        sc.nextLine(); // Consume leftover newline

        // Prompt and set Degree
        System.out.print("Degree                    : ");
        int degreeID = sc.nextInt();

        // Prompt and set Email address
        System.out.print("Email address             : ");
        sm.setEmail(sc.nextLine());

        // Prompt and set Sex (M/F)
        System.out.print("Sex (M/F)                 : ");
        sm.setSex(sc.nextLine().toUpperCase());

        // Prompt and set Street Address
        System.out.print("Street Address            : ");
        sm.setStreetAddress(sc.nextLine());

        // Prompt and set Barangay
        System.out.print("Barangay                  : ");
        sm.setBarangay(sc.nextLine());

        // Prompt and set City
        System.out.print("City                      : ");
        sm.setCity(sc.nextLine());

        // Prompt and set Province
        System.out.print("Province                  : ");
        sm.setProvince(sc.nextLine());

        // Prompt and set Country
        System.out.print("Country                   : ");
        sm.setCountry(sc.nextLine());
        // What is RIG?
        System.out.println("Student Type (R,I,G)      : ");
        // What is RON in Leave of Absence?
        System.out.println("Activity                  : ");
    }

    private void viewStudentRecord() {
        StudentManagement sm = new StudentManagement();
        // search for a record given student ID
        System.out.println("Enter Student ID:");
        sm.setStudentID(sc.nextInt());
        sc.nextLine(); // Consume leftover newline

        // Check if record exists
        if (sm.getStudentRecord() == 0) {
            System.out.println("That student does not exist in the records");
            return;
        }

        // display current record info
        System.out.println("\nCurrent Student Information");
        System.out.println("---------------------------------------------------");
        System.out.println("First Name                : " + sm.getFirstName());
        System.out.println("First Name                : " + sm.getFirstName());
        System.out.println("Last Name                 : " + sm.getLastName());
        System.out.println("Middle Name               : " + sm.getMiddleName());
        System.out.println("Student ID                : " + sm.getStudentID());
        System.out.println("Degree                    : ");
        System.out.println("Email address             : " + sm.getEmail());
        System.out.println("Sex (M/F)                 : " + sm.getSex());
        System.out.println("Street Address            : " + sm.getStreetAddress());
        System.out.println("Barangay                  : " + sm.getBarangay());
        System.out.println("City                      : " + sm.getCity());
        System.out.println("Province                  : " + sm.getProvince());
        System.out.println("Country                   : " + sm.getCountry());
        System.out.println("Current Term Enrolled in  : ");
        // What is RIG?
        System.out.println("Student Type (R,I,G)      : ");
        // What is RON in Leave of Absence?
        System.out.println("Activity                  : ");
    }
}
