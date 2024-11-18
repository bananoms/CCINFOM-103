package DBAPP;

import java.util.Scanner;

public class reserve_book_room_menu {
    
    public reserve_book_room_menu(){

    }

    public int menu(){
        int menuselection = 0;
        Scanner console = new Scanner(System.in);

        System.out.println("  ");
		System.out.println("  ");
		System.out.println("=======================================================");
		System.out.println("    Reservation and Booking of Room            	     ");
		System.out.println("-------------------------------------------------------");
		System.out.println("[1] Create a new Room Record						     ");
		System.out.println("[2] Update a Room Record							     ");
		System.out.println("[3] Delete a Room Record							     ");
		System.out.println("[4] View a Room Record							     ");
		System.out.println("[0] Exit Reservation and Booking of Room               ");
		System.out.println("=======================================================");
		
		System.out.println("Enter Selected Function: ");
		menuselection = Integer.parseInt(console.nextLine());

        if (menuselection == 1){
            // add course
        }
        else if (menuselection == 2){
            // update course
        }
        else if (menuselection == 3){

        }
        else if (menuselection == 4){

        }

        return menuselection;
    }
}
