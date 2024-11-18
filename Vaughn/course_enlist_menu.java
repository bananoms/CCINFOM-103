package DBAPP;

import java.util.Scanner;

public class course_enlist_menu {
    
    public course_enlist_menu(){

    }

    public int menu(){
        int menuselection = 0;
        Scanner console = new Scanner(System.in);

        System.out.println("  ");
		System.out.println("  ");
		System.out.println("=======================================================");
		System.out.println("    Course Enlisment    							     ");
		System.out.println("-------------------------------------------------------");
		System.out.println("[1] Create a new Enlistment Record					 ");
		System.out.println("[2] Update an Enlistment Record					     ");
		System.out.println("[3] Delete an Enlistment Record				         ");
		System.out.println("[4] View an Enlistment Record						     ");
		System.out.println("[0] Exit Course Enlistment						     ");
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
