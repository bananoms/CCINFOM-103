package DBAPP;
import java.util.Scanner;

public class ViewDegreesMenu {
    private int menuSelection;
    Scanner sc = new Scanner(System.in);

    public ViewDegreesMenu() {
        this.menuSelection = -1;
    }

    private static void displayDegreeManagementMenu() {
        System.out.println(" ");
        System.out.println("====================================================");
        System.out.println("    Degree Records Viewer");
        System.out.println("----------------------------------------------------");
        System.out.println("[1] View a Degree Record");
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

    private void manageDegreeRecords() {
        displayDegreeManagementMenu();
        promptForMenuSelection();
        switch (this.menuSelection) {
            case 1:
                viewDegreeRecord();
                break;
            default:
                System.out.println("Exiting Viewer.");
        }
    }

    private void viewDegreeRecord() {
        ViewDegrees dm = new ViewDegrees();
        System.out.print("Enter Degree ID to view: ");
        dm.setDegreeID(sc.nextInt());
        sc.nextLine(); // Consume leftover newline

        if (dm.getDegreeRecord() == 0) {
            System.out.println("That degree does not exist in the records.");
            return;
        }

        System.out.println("\nCurrent Degree Information");
        System.out.println("---------------------------------------------------");
        System.out.println("Degree Name               : " + dm.getDegreeName());
        System.out.println("Degree Level              : " + dm.getDegreeLevel());
        System.out.println("Department ID             : " + dm.getDepartmentID());
    }

    public static void main(String[] args) {
        ViewDegreesMenu dmm = new ViewDegreesMenu();
        dmm.manageDegreeRecords();
    }
}
