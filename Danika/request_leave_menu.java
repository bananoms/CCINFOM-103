package DBAPP;

import java.util.Scanner;

public class request_leave_menu {
    
    public request_leave_menu(){

    }

    public int menu(){
        int menuselection = 0;
        Scanner console = new Scanner(System.in);

        System.out.println("  ");
		System.out.println("  ");
		System.out.println("=======================================================");
		System.out.println("    Request of Leave of Absence and Return    	     ");
		System.out.println("-------------------------------------------------------");
		System.out.println("[1] Create a new Leave Record						     ");
		System.out.println("[2] Update a Leave Record							     ");
		System.out.println("[3] Delete a Leave Record							     ");
		System.out.println("[4] View a Leave Record							     ");
		System.out.println("[0] Exit Request of Leave of Absence and Return        ");
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

