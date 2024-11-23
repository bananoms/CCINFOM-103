package DBAPP;
import java.util.Scanner;

public class ViewTeacherRecordsMenu {
    private int menuSelection;
    Scanner sc = new Scanner(System.in);

    public ViewTeacherRecordsMenu() {
        this.menuSelection = -1;
    }

    private static void displayViewTeacherMenu() {
        System.out.println(" ");
        System.out.println("====================================================");
        System.out.println("    Teacher Records Viewer");
        System.out.println("----------------------------------------------------");
        System.out.println("[1] View a Teacher Record");
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

    private void viewTeacherRecords() {
        displayViewTeacherMenu();
        promptForMenuSelection();
        switch (this.menuSelection) {
            case 1:
                viewTeacherRecord();
                break;
            default:
                System.out.println("Exiting Viewer.");
        }
    }

    private void viewTeacherRecord() {
        ViewTeacherRecords tm = new ViewTeacherRecords();

        System.out.print("Enter Teacher ID: ");
        tm.setTeacherID(sc.nextInt());
        sc.nextLine(); // Consume leftover newline

        if (tm.getTeacherRecord() == 0) {
            System.out.println("That teacher does not exist in the records.");
            return;
        }

        System.out.println("\nCurrent Teacher Information");
        System.out.println("---------------------------------------------------");
        System.out.println("First Name                : " + tm.getFirstName());
        System.out.println("Last Name                 : " + tm.getLastName());
        System.out.println("Middle Name               : " + tm.getMiddleName());
        System.out.println("Teacher ID                : " + tm.getTeacherID());
        System.out.println("Department ID             : " + tm.getDepartmentName());
        System.out.println("Email address             : " + tm.getEmail());
        System.out.println("Contact Number            : " + tm.getContactNumber());
        System.out.println("Sex (M/F)                 : " + tm.getSex());
    }
}
