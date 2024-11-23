import java.util.Scanner;

public class ViewCollegesMenu {
    private int menuSelection;
    Scanner sc = new Scanner(System.in);

    public ViewCollegesMenu() {
        this.menuSelection = -1;
    }

    private static void displayCollegeManagementMenu() {
        System.out.println(" ");
        System.out.println("====================================================");
        System.out.println("    College Records Viewer");
        System.out.println("----------------------------------------------------");
        System.out.println("[1] View a College Record");
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

    private void manageCollegeRecords() {
        displayCollegeManagementMenu();
        promptForMenuSelection();
        switch (this.menuSelection) {
            case 1:
                viewCollegeRecord();
                break;
            default:
                System.out.println("Exiting Viewer.");
        }
    }

    private void viewCollegeRecord() {
        ViewColleges cm = new ViewColleges();
        System.out.print("Enter College ID to view: ");
        cm.setCollegeID(sc.nextInt());
        sc.nextLine(); // Consume leftover newline

        if (cm.getCollegeRecord() == 0) {
            System.out.println("That college does not exist in the records.");
            return;
        }

        System.out.println("\nCurrent College Information");
        System.out.println("---------------------------------------------------");
        System.out.println("College ID               : " + cm.getCollegeID());
        System.out.println("College Name             : " + cm.getCollegeName());
        System.out.println("College Acronym          : " + cm.getCollegeAcronym());
    }

    public static void main(String[] args) {
        ViewCollegesMenu cmm = new ViewCollegesMenu();
        cmm.manageCollegeRecords();
    }
}
