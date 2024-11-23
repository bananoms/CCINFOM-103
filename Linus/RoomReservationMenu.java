package DBAPP;
import java.util.Scanner;

public class RoomReservationMenu {
    private int menuSelection;
    Scanner sc = new Scanner(System.in);

    public RoomReservationMenu() {
        this.menuSelection = -1;
    }

    public static void displayRoomManagementMenu() {
        System.out.println(" ");
        System.out.println("====================================================");
        System.out.println("    Room Reservation Transaction");
        System.out.println("----------------------------------------------------");
        System.out.println("[1] View Available Rooms");
        System.out.println("[2] Make a Reservation");
        System.out.println("[3] View Reservations");
        System.out.println("[4] Cancel a Reservation");
        System.out.println("----------------------------------------------------");
        System.out.println("[0] EXIT Room Reservation");
        System.out.println("====================================================");
        System.out.println(" ");
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

    public void transactWithRooms() {
        displayRoomManagementMenu();
        promptForMenuSelection();
        switch (this.menuSelection) {
            case 1:
                viewAvailableRooms();
                break;
            case 2:
                makeReservation();
                break;
            case 3:
                viewReservations();
                break;
            case 4:
                cancelReservation();
                break;
            default:
                System.out.println("Exiting Room Management.");
        }
    }

    public void viewAvailableRooms() {
        System.out.println("\nView Available Rooms For");
        System.out.println("----------------------------------------------------");
        System.out.println("Enter building code     :");
        // read input
        System.out.println("Enter room type         :");
        // read input

        // check if the building code and room types are legitimate

        System.out.println("\nAvailable Rooms for [BUILDING], [CAMPUS]:");
        System.out.println("----------------------------------------------------");
        System.out.println(" [0] | Room ID | Room Code | Day | Duration |");

        // add iterative display
    }

    public void makeReservation() {
        System.out.println("\nRoom Reservation");
        System.out.println("----------------------------------------------------");

        viewAvailableRooms();

        System.out.println("\nEnter a row for reservation                   : ");
        int selection = sc.nextInt();
        System.out.println("Are you a student or teacher? [S/T]  : ");
        String studentOrTeacher = sc.nextLine();
        System.out.println("Enter ID Number of person reserving  : ");
        int id = sc.nextInt();
        System.out.println("----------------------------------------------------");
        // add code to reserve a room that matches the day and duration
    }

    public void viewReservations() {
        System.out.println("\nViewing Reservations");
        System.out.println("----------------------------------------------------");
        System.out.println("Are you a student or teacher? [S/T]   : ");
        String studentOrTeacher = sc.nextLine();
        System.out.println("Enter ID Number of person transacting  : ");
        int id = sc.nextInt();

        System.out.println("\nReserved Rooms for [FULL NAME]");
        System.out.println("----------------------------------------------------------");
        System.out.println(" [0] | Room ID | Room Code | Day | Duration |  Location  |");
        // add code that displays a teacher/student's booked rooms
    }

    public void cancelReservation() {
        System.out.println("====================================================");
        System.out.println("\nCancelling Reservations");
        System.out.println("====================================================");

        viewReservations();

        System.out.println("\nEnter a row for cancellation                  : ");
        int selection = sc.nextInt();
        // add code that cancels the reservation
    }

//    public static void main(String[] args) {
//        RoomReservationMenu rrm = new RoomReservationMenu();
//        rrm.makeReservation();
//        rrm.cancelReservation();
//    }
}
