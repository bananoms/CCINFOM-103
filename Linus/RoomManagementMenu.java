package DBAPP;
import java.util.*;

public class RoomManagementMenu {
    private int menuSelection;

    public RoomManagementMenu() {
        this.menuSelection = -1;
    }

    private static void displayRoomManagementMenu() {
        System.out.println(" ");
        System.out.println("====================================================");
        System.out.println("    Room Management Menu");
        System.out.println("----------------------------------------------------");
        System.out.println("[1] Create a new Room Record");
        System.out.println("[2] Update a Room Record");
        System.out.println("[3] Delete a Room Record");
        System.out.println("[4] View a Room Record");
        System.out.println("----------------------------------------------------");
        System.out.println("[0]EXIT Room Management");
        System.out.println("====================================================");
        System.out.println(" ");
    }

    private void manageRoomRecords() {
        displayRoomManagementMenu();
        promptForMenuSelection();
        switch (this.menuSelection) {
            case 1:
                addRoomRecord();
                break;
            case 2:
                updateRoomRecord();
                break;
            case 3:
                deleteRoomRecord();
                break;
            case 4:
                viewRoomRecord();
                break;
            default:
                System.out.println("Exiting Room Management.");
        }
    }

    //    FOR TESTING
    public static void main(String args[]) {
        RoomManagementMenu smm = new RoomManagementMenu();
        smm.manageRoomRecords();
    }

    private void promptForMenuSelection() {
        this.menuSelection = -1;
        Scanner sc = new Scanner(System.in);

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

    private int getMenuSelection() {
        return this.menuSelection;
    }

    // implement backend aspect
    // requires code to check if valid inputs (relative to reference table)
    private void addRoomRecord() {
        Scanner sc = new Scanner(System.in);
        String userInput = "";

        System.out.println("\nEnter Room Information");
        System.out.println("---------------------------------------------------");
        System.out.println("Room Code                : ");
        System.out.println("Campus Code              : ");
        System.out.println("Building Code            : ");
        System.out.println("Room Type Code           : ");
        // possible additional field
        System.out.println("Room Capacity            : ");
        System.out.println("---------------------------------------------------");
        System.out.println("Room Created!");
        System.out.println("Term availability currently set to current term.");
        System.out.println("Schedule automatically set to available 24/7.");
        System.out.println("No section assignment yet (NULL) till further adjustment.");
        System.out.println("---------------------------------------------------");
        System.out.println("\nWould you like to adjust the term availability, section, and schedule? [y/n]");

        while (!userInput.equalsIgnoreCase("y") && !userInput.equalsIgnoreCase("n")) {
            System.out.println("Please enter 'y' or 'n':");
            userInput = sc.nextLine().trim();

            if (!userInput.equalsIgnoreCase("y") && !userInput.equalsIgnoreCase("n")) {
                System.out.println("Invalid input. Please enter 'y' for yes or 'n' for no.");
            }
        }

        // Remark: Should we adjust schedule availability and section assignment model?
        if (userInput.equalsIgnoreCase("y")) {
           // call methods for schedule and section management here
            return;
        }
    }

    private void deleteRoomRecord() {
        // search for room record given room ID
        System.out.println("Enter Room ID: ");

        // check if record exists
        System.out.println("---------------------------------------------------");
        System.out.println("Deleting [ROOM CODE] ID: [ID NUMBER] Record from [BUILDING], [CAMPUS].");
    }

    private void viewRoomRecord() {
        // search for room record given room ID
        System.out.println("Enter Room ID: ");
        // check if it exists

        System.out.println("\nCurrent Room Information");
        System.out.println("---------------------------------------------------");
        System.out.println("Room Code                : ");
        System.out.println("Campus Code              : ");
        System.out.println("Building Code            : ");
        System.out.println("Room Type Code           : ");
        // possible additional field
        System.out.println("Room Capacity            : ");
        System.out.println("Term availability        : ");
        System.out.println("Section Assignment       : ");
        System.out.println("Schedule                 : ");
    }

    private void updateRoomRecord() {
        Scanner sc = new Scanner(System.in);
        String userInput = "";

        // search for room record given room ID
        System.out.println("Enter Room ID: ");

        System.out.println("\nCurrent Room Information");
        System.out.println("---------------------------------------------------");
        System.out.println("Room Code                : ");
        System.out.println("Campus Code              : ");
        System.out.println("Building Code            : ");
        System.out.println("Room Type Code           : ");
        // possible additional field
        System.out.println("Room Capacity            : ");
        System.out.println("Term availability        : ");
        System.out.println("Section Assignment       : ");
        System.out.println("Schedule                 : ");
        System.out.println("---------------------------------------------------");
        System.out.println("New Room Information");
        System.out.println("Room Code                : ");
        System.out.println("Campus Code              : ");
        System.out.println("Building Code            : ");
        System.out.println("Room Type Code           : ");
        System.out.println("Room Capacity            : ");

        System.out.println("\nWould you also like to update the term availability, section, and schedule?");

        while (!userInput.equalsIgnoreCase("y") && !userInput.equalsIgnoreCase("n")) {
            System.out.println("Please enter 'y' or 'n':");
            userInput = sc.nextLine().trim();

            if (!userInput.equalsIgnoreCase("y") && !userInput.equalsIgnoreCase("n")) {
                System.out.println("Invalid input. Please enter 'y' for yes or 'n' for no.");
            }
        }

        // Remark: Should we adjust schedule availability and section assignment model?
        if (userInput.equalsIgnoreCase("y")) {
            System.out.println("\n---------------------------------------------------");
            System.out.println("Term availability        : ");
            System.out.println("Section Assignment       : ");
            System.out.println("Schedule                 : ");
            // call methods for schedule and section management here
            System.out.println("\nRoom updated!");
            return;
        }
    }

}