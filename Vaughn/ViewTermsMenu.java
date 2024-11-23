import java.util.Scanner;

public class ViewTermsMenu {
    private int menuSelection;
    Scanner sc = new Scanner(System.in);

    public ViewTermsMenu() {
        this.menuSelection = -1;
    }

    // Display the terms menu options
    private static void displayViewTermMenu() {
        System.out.println(" ");
        System.out.println("====================================================");
        System.out.println("    Term Records Viewer");
        System.out.println("----------------------------------------------------");
        System.out.println("[1] View a Term Record");
        System.out.println("----------------------------------------------------");
        System.out.println("[0] EXIT Viewer");
        System.out.println("====================================================");
        System.out.println(" ");
    }

    // Prompt the user for a menu selection
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

    // Manage term records based on user menu selection
    public void viewTermRecords() {
        displayViewTermMenu();
        promptForMenuSelection();
        switch (this.menuSelection) {
            case 1:
                viewTermRecord();
                break;
            default:
                System.out.println("Exiting Viewer.");
        }
    }

    // View term record based on term ID
    public void viewTermRecord() {
        ViewTerms vt = new ViewTerms();

        System.out.print("Enter Term ID: ");
        vt.setTermID(sc.nextInt());
        sc.nextLine(); // Consume leftover newline

        // Check if the term record exists
        if (vt.getTermRecord() == 0) {
            System.out.println("That term does not exist in the records.");
            return;
        }

        // Display the term's information
        System.out.println("\nCurrent Term Information");
        System.out.println("---------------------------------------------------");
        System.out.println("Term ID                  : " + vt.getTermID());
        System.out.println("Academic Year Start      : " + vt.getAcademicYearStart());
        System.out.println("Academic Year End        : " + vt.getAcademicYearEnd());
        System.out.println("Term Start Date          : " + vt.getTermStartDate());
        System.out.println("Term End Date            : " + vt.getTermEndDate());
        System.out.println("Leave of Absence Status  : " + vt.getLeaveOfAbsenceStatus());
    }
}
