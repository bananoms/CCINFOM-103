package DBAPP;
import java.util.Scanner;

public class RequestLeaveMenu {
    private int menuSelection;

    public RequestLeaveMenu() {
        this.menuSelection = -1;
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\n====================================================");
            System.out.println("         Request Leave for a Student");
            System.out.println("----------------------------------------------------");
            System.out.println("[1] View Remaining Terms and Request Leave");
            System.out.println("[0] Exit");
            System.out.println("====================================================");

            promptForMenuSelection();

            switch (this.menuSelection) {
                case 1:
                    requestLeave();
                    break;
                case 0:
                    System.out.println("Exiting Leave Request Menu.");
                    return;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }

    private void promptForMenuSelection() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter your selection: ");
                this.menuSelection = Integer.parseInt(sc.nextLine());
                if (this.menuSelection >= 0 && this.menuSelection <= 1) break;
                System.out.println("Invalid selection. Enter 0 or 1.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private void requestLeave(){
        Scanner sc = new Scanner(System.in);
        RequestLeave rl = new RequestLeave();

        System.out.print("\nEnter Student ID: ");
        int studentID = sc.nextInt();
        sc.nextLine(); // Consume newline

        if (!rl.studentExists(studentID)) {
            System.out.println("Student ID not found.");
            return;
        }

        int remainingTerms = rl.getRemainingTerms(studentID);
        System.out.println("Remaining Terms: " + remainingTerms);

        String currentStatus = rl.getLOAStatus(studentID);
        System.out.println("Current Leave of Absence Status: " + statusDescription(currentStatus));

        if ("O".equals(currentStatus)) {
            System.out.println("This student is already on an ongoing leave.");
            return;
        }

        // Ask if the user wants to proceed with requesting leave
        System.out.println("\nDo you want to request a Leave of Absence?");
        System.out.println("[1] Yes");
        System.out.println("[0] No");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
            if (rl.updateLOAStatus(studentID, "O")) { // "O" for Ongoing
                System.out.println("Leave of Absence successfully requested.");
            } else {
                System.out.println("Failed to update Leave of Absence status.");
            }
        } else {
            System.out.println("No changes were made.");
        }
    }

    private String statusDescription(String status) {
        if(status == "O")
            return "Ongoing";
        else if(status == "R")
            return "Returning";
        else if(status == "N")
            return "Not Applicable";
        else
            return "Unkown";
    }
}
