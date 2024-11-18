package DBAPP;

import java.util.Scanner;

public class course_enroll_drop_menu {
    
    public course_enroll_drop_menu(){

    }

    public int menu(){
        int menuselection = 0;
        Scanner console = new Scanner(System.in);

        System.out.println("  ");
		System.out.println("  ");
		System.out.println("=======================================================");
		System.out.println("    Course Enrollment and Dropping    		     	 ");
		System.out.println("-------------------------------------------------------");
		System.out.println("[1] Create a new Enrollment Record			         ");
		System.out.println("[2] Update an Enrollment Record					     ");
		System.out.println("[3] Delete an Enrollment Record						 ");
		System.out.println("[4] View an Enrollment Record							 ");
		System.out.println("[0] Exit Course Enlistment and Dropping				 ");
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

