package DBAPP;
import java.util.Scanner;

public class ViewCoursesMenu {
    private int menuSelection;
    Scanner sc = new Scanner(System.in);

    public ViewCoursesMenu() {
        this.menuSelection = -1;
    }

    private static void displayCourseManagementMenu() {
        System.out.println(" ");
        System.out.println("====================================================");
        System.out.println("    Course Records Viewer");
        System.out.println("----------------------------------------------------");
        System.out.println("[1] View a Course Record");
        System.out.println("----------------------------------------------------");
        System.out.println("[0] EXIT Viewer");
        System.out.println("====================================================");
        System.out.println(" ");
    }

    private void promptForMenuSelection() {
        this.menuSelection = -1;

        while (this.menuSelection < 0 || this.menuSelection > 1) {
            try {
                System.out.println("Please enter number for selection:");
                this.menuSelection = Integer.parseInt(sc.nextLine());

                if (this.menuSelection < 0 || this.menuSelection > 1) {
                    System.out.println("Invalid selection. [0-1]");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter 0 or 1.");
            }
        }
    }

    private void manageCourseRecords() {
        displayCourseManagementMenu();
        promptForMenuSelection();
        switch (this.menuSelection) {
            case 1:
                viewCourseRecord();
                break;
            default:
                System.out.println("Exiting Viewer.");
        }
    }

    private void viewCourseRecord() {
        ViewCourses cm = new ViewCourses();
        System.out.print("Enter Course Code to view: ");
        cm.setCourseCode(sc.nextLine());

        if (cm.getCourseRecord() == 0) {
            System.out.println("That course does not exist in the records.");
            return;
        }

        System.out.println("\nCurrent Course Information");
        System.out.println("---------------------------------------------------");
        System.out.println("Course Code              : " + cm.getCourseCode());
        System.out.println("Course Name              : " + cm.getCourseName());
        System.out.println("Department ID            : " + cm.getDepartmentID());
        System.out.println("Units                    : " + cm.getUnits());
    }
}
