import java.util.Scanner;

public class ViewDepartmentsMenu {
    private int menuSelection;
    Scanner sc = new Scanner(System.in);

    public ViewDepartmentsMenu() {
        this.menuSelection = -1;
    }

    private static void displayDepartmentsMenu() {
        System.out.println(" ");
        System.out.println("====================================================");
        System.out.println("    Department Records Viewer");
        System.out.println("----------------------------------------------------");
        System.out.println("[1] View a Department Record");
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

    private void manageDepartmentRecords() {
        displayDepartmentsMenu();
        promptForMenuSelection();
        switch (this.menuSelection) {
            case 1:
                viewDepartmentRecord();
                break;
            default:
                System.out.println("Exiting Viewer.");
        }
    }

    private void viewDepartmentRecord() {
        ViewDepartments vd = new ViewDepartments();
        System.out.print("Enter Department ID to view: ");
        vd.setDepartmentID(sc.nextInt());
        sc.nextLine(); // Consume leftover newline

        if (vd.getDepartmentRecord() == 0) {
            System.out.println("That department does not exist in the records.");
            return;
        }

        System.out.println("\nCurrent Department Information");
        System.out.println("---------------------------------------------------");
        System.out.println("Department ID            : " + vd.getDepartmentID());
        System.out.println("Department Name          : " + vd.getDepartmentName());
        System.out.println("Department Acronym       : " + vd.getDepartmentAcronym());
        System.out.println("College ID               : " + vd.getCollegeID());
    }
}
