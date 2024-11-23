package DBAPP;
import java.util.*;

public class MainMenu {
    private int menuSelection;

    public MainMenu() {
        this.menuSelection = -1;
    }

    private static void displayMenu() {
        System.out.println(" ");
        System.out.println("====================================================");
        System.out.println("----------------------------------------------------");
        System.out.println("Manage:\n[1] Student Management");
        System.out.println("[2] Degree Management");
        System.out.println("[3] Room Management");
        System.out.println("----------------------------------------------------");
        System.out.println("Transact:\n[4] Course Enlistment");
        System.out.println("[5] Course Enrollment & Dropping");
        System.out.println("[6] Reserve and Book a Room");
        System.out.println(
                "[7] Request for Leave of Absence or Notice of Return");
        System.out.println("----------------------------------------------------");
        System.out.println("Generate Report:");
        System.out.println("[8] Room Utilization Report");
        System.out.println("[9] Course Enrollment Statistics");
        System.out.println("[10] Batch Completion Rate per Degree");
        System.out.println("[11] Degree Demographic Report");
        System.out.println("----------------------------------------------------");
        System.out.println("[0]EXIT Application");
        System.out.println("====================================================");
        System.out.println(" ");
    }

    private void promptForMenuSelection() {
        this.menuSelection = -1;
        Scanner sc = new Scanner(System.in);

        while (this.menuSelection < 0 || this.menuSelection > 11) {
            try {
                System.out.println("Please enter number for selection:");
                this.menuSelection = Integer.parseInt(sc.nextLine());

                if (this.menuSelection < 0 || this.menuSelection > 11) {
                    System.out.println("Invalid selection. [0-11]");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a number between 0 and 11.");
            }
        }
    }

    private int getMenuSelection() {
        return this.menuSelection;
    }

    public static void main(String args[]) {
        MainMenu mainMenu = new MainMenu();
        while (true) {
            mainMenu.displayMenu();
            mainMenu.promptForMenuSelection();
            int selection = mainMenu.getMenuSelection();

            switch (selection) {
                case 1:
                    StudentManagementMenu studentMenu = new StudentManagementMenu();
                    studentMenu.manageStudentRecords();
                    break;
                case 2:
                    DegreeManagementMenu degreeMenu = new DegreeManagementMenu();
                    degreeMenu.manageDegreeRecords();
                    break;
                case 3:
                    RoomManagementMenu roomMenu = new RoomManagementMenu();
                    roomMenu.manageRoomRecords();
                    break;
                case 4:
                    CourseEnlistmentMenu courseEnlistmentMenu = new CourseEnlistmentMenu();
                    courseEnlistmentMenu.displayMenu();
                    break;
                case 5:
                    // Add Course Enrollment & Dropping handling here
                    break;
                case 6:
                    // Add Reserve and Book a Room handling here
                    break;
                case 7:
                    RequestLeaveMenu requestLeaveMenu = new RequestLeaveMenu();
                    requestLeaveMenu.displayMenu();
                    break;
                case 8:
                    // Add Room Utilization Report handling here
                    break;
                case 9:
                    CourseEnrollmentReportFE courseEnrollmentReportFE = new CourseEnrollmentReportFE();
                    courseEnrollmentReportFE.displayReportPrompts();
                    break;
                case 10:
                    // Add Batch Completion Rate per Degree handling here
                    break;
                case 11:
                    // Add Degree Demographic Report handling here
                    break;
                case 0:
                    System.out.println("Exiting Application.");
                    return; // Exit the application
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }
}
