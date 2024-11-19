// package DBAPP;
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
        mainMenu.displayMenu();
        mainMenu.promptForMenuSelection();
        System.out.println(mainMenu.getMenuSelection());
    }
}