package DBAPP;
import java.util.Scanner;

public class DegreeManagementMenu {
    private int menuSelection;
    Scanner sc = new Scanner(System.in);

    public DegreeManagementMenu() {
        this.menuSelection = -1;
    }

    private static void displayDegreeManagementMenu() {
        System.out.println(" ");
        System.out.println("====================================================");
        System.out.println("    Degree Management Menu");
        System.out.println("----------------------------------------------------");
        System.out.println("[1] View a Degree Record");
        System.out.println("[2] Add a New Degree Record");
        System.out.println("[3] Update a Degree Record");
        System.out.println("[4] Delete a Degree Record");
        System.out.println("----------------------------------------------------");
        System.out.println("[0] EXIT Degree Management");
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

    private void manageDegreeRecords() {
        displayDegreeManagementMenu();
        promptForMenuSelection();
        switch (this.menuSelection) {
            case 1:
                viewDegreeRecord();
                break;
            case 2:
                addDegreeRecord();
                break;
            case 3:
                updateDegreeRecord();
                break;
            case 4:
                deleteDegreeRecord();
                break;
            default:
                System.out.println("Exiting Degree Management.");
        }
    }

    private void viewDegreeRecord() {
        DegreeManagement dm = new DegreeManagement();
        System.out.print("Enter Degree ID to view: ");
        dm.setDegreeID(sc.nextInt());
        sc.nextLine(); // Consume leftover newline

        if (dm.getDegreeRecord() == 0) {
            System.out.println("That degree does not exist in the records.");
            return;
        }

        System.out.println("\nCurrent Degree Information");
        System.out.println("---------------------------------------------------");
        System.out.println("Degree ID                : " + dm.getDegreeID());
        System.out.println("Degree Name              : " + dm.getDegreeName());
        System.out.println("Degree Level             : " + dm.getDegreeLevel());
        System.out.println("Department ID            : " + dm.getDepartmentID());
    }

    private void addDegreeRecord() {
        DegreeManagement dm = new DegreeManagement();
        System.out.println("\nEnter Degree Information");
        System.out.println("---------------------------------------------------");

        System.out.print("Degree Name               : ");
        dm.setDegreeName(sc.nextLine());

        System.out.print("Degree Level              : ");
        dm.setDegreeLevel(sc.nextLine());

        System.out.print("Department ID             : ");
        dm.setDepartmentID(sc.nextInt());

        if (dm.addDegree() == 1) {
            System.out.println(">>> Degree Record has been added!");
        }
    }

    private void updateDegreeRecord() {
        DegreeManagement dm = new DegreeManagement();
        System.out.println("Enter Degree ID to update:");
        dm.setDegreeID(sc.nextInt());
        sc.nextLine(); // Consume leftover newline

        if (dm.getDegreeRecord() == 0) {
            System.out.println("That degree does not exist in the records.");
            return;
        }

        System.out.println("\nCurrent Degree Information");
        System.out.println("---------------------------------------------------");
        System.out.println("Degree ID                : " + dm.getDegreeID());
        System.out.println("Degree Name              : " + dm.getDegreeName());
        System.out.println("Degree Level             : " + dm.getDegreeLevel());
        System.out.println("Department ID            : " + dm.getDepartmentID());

        System.out.println("\nNew Degree Information");
        System.out.println("---------------------------------------------------");

        System.out.print("Degree Name               : ");
        dm.setDegreeName(sc.nextLine());

        System.out.print("Degree Level              : ");
        dm.setDegreeLevel(sc.nextLine());

        System.out.print("Department ID             : ");
        dm.setDepartmentID(sc.nextInt());

        if (dm.updateDegree() == 1) {
            System.out.println(">>> Degree Record has been updated!");
        }
    }

    private void deleteDegreeRecord() {
        DegreeManagement dm = new DegreeManagement();
        System.out.println("Enter Degree ID to delete:");
        dm.setDegreeID(sc.nextInt());
        sc.nextLine(); // Consume leftover newline

        if (dm.getDegreeRecord() == 0) {
            System.out.println("That degree does not exist in the records.");
            return;
        }

        if (dm.deleteDegree() == 1) {
            System.out.println(">>> Degree Record has been deleted!");
        }
    }
}
