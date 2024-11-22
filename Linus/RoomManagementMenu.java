package DBAPP;

import java.util.Scanner;

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
        System.out.println("[0] EXIT Room Management");
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

//    public static void main(String[] args) {
//        RoomManagementMenu rmm = new RoomManagementMenu();
//        rmm.manageRoomRecords();
//    }

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

    private void addRoomRecord() {
        Scanner sc = new Scanner(System.in);
        RoomManagement rm = new RoomManagement();

        System.out.println("\nEnter Room Information");
        System.out.println("---------------------------------------------------");

        System.out.print("Room Code                : ");
        rm.setRoomCode(sc.nextLine());

        System.out.print("Campus Code              : ");
        rm.setCampusCode(sc.nextLine());

        System.out.print("Building Code            : ");
        rm.setBldgCode(sc.nextLine());

        System.out.print("Room Type Code           : ");
        rm.setType(sc.nextLine());

        System.out.print("Term ID                  : ");
        // rm.setTermID(sc.nextInt());

        if (rm.addRoom() == 1) {
            System.out.println("Room Record Created Successfully!");
        } else {
            System.out.println("Failed to create Room Record.");
        }
    }

    private void deleteRoomRecord() {
        Scanner sc = new Scanner(System.in);
        RoomManagement rm = new RoomManagement();

        System.out.print("Enter Room ID to delete: ");
        rm.setRoomID(sc.nextInt());

        if (rm.getRoomRecord() == 0) {
            System.out.println("That Room does not exist in the records.");
            return;
        }

        if (rm.deleteRoom() == 1) {
            System.out.println("Room Record Deleted Successfully!");
        } else {
            System.out.println("Failed to delete Room Record.");
        }
    }

    private void viewRoomRecord() {
        Scanner sc = new Scanner(System.in);
        RoomManagement rm = new RoomManagement();

        System.out.print("Enter Room ID to view: ");
        rm.setRoomID(sc.nextInt());

        if (rm.getRoomRecord() == 0) {
            System.out.println("That Room does not exist in the records.");
            return;
        }

        System.out.println("\nCurrent Room Information");
        System.out.println("---------------------------------------------------");
        System.out.println("Room ID                  : " + rm.getRoomID());
        System.out.println("Room Code                : " + rm.getRoomCode());
        System.out.println("Campus Code              : " + rm.getCampusCode());
        System.out.println("Building Code            : " + rm.getBldgCode());
        System.out.println("Room Type Code           : " + rm.getType());
        // System.out.println("Term ID                  : " + rm.getTermID());
    }

    private void updateRoomRecord() {
        Scanner sc = new Scanner(System.in);
        RoomManagement rm = new RoomManagement();

        System.out.print("Enter Room ID to update: ");
        rm.setRoomID(sc.nextInt());
        sc.nextLine(); // Consume leftover newline

        if (rm.getRoomRecord() == 0) {
            System.out.println("That Room does not exist in the records.");
            return;
        }

        System.out.println("\nCurrent Room Information");
        System.out.println("---------------------------------------------------");
        System.out.println("Room Code                : " + rm.getRoomCode());
        System.out.println("Campus Code              : " + rm.getCampusCode());
        System.out.println("Building Code            : " + rm.getBldgCode());
        System.out.println("Room Type Code           : " + rm.getType());
        // System.out.println("Term ID                  : " + rm.getTermID());

        System.out.println("\nEnter New Room Information");
        System.out.println("---------------------------------------------------");

        System.out.print("Room Code                : ");
        rm.setRoomCode(sc.nextLine());

        System.out.print("Campus Code              : ");
        rm.setCampusCode(sc.nextLine());

        System.out.print("Building Code            : ");
        rm.setBldgCode(sc.nextLine());

        System.out.print("Room Type Code           : ");
        rm.setType(sc.nextLine());

        System.out.print("Term ID                  : ");
        // rm.setTermID(sc.nextInt());

        if (rm.updateRoom() == 1) {
            System.out.println("Room Record Updated Successfully!");
        } else {
            System.out.println("Failed to update Room Record.");
        }
    }
}
