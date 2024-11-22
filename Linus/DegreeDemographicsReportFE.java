package DBAPP;
import java.util.Scanner;

public class DegreeDemographicsReportFE {
    Scanner sc = new Scanner(System.in);

    public void displayReportPrompts() {
        System.out.println("\n====================================================");
        System.out.println("    Degree Demographics Report");
        System.out.println("----------------------------------------------------");

        System.out.println("Enter academic year    : ");
        String academicYear = sc.nextLine();
        System.out.println("Enter term (1/2/3)     : ");
        String term = sc.nextLine();

        reportGenderDistribution();
        reportAgeRange();
        reportEnrollmentCounts();
        reportStudentStatuses();
        reportAverageCGPA();
    }

    private void reportGenderDistribution() {
        System.out.println("\nGender Distribution");
        System.out.println("====================================================");
        System.out.println("Degree Name                          | Male | Female");
        System.out.println("----------------------------------------------------");
        // add backend functionality

    }

    private void reportAgeRange() {
        System.out.println("\nAge Range");
        System.out.println("====================================================");
        System.out.println("Degree Name                          |   Age Range  ");
        System.out.println("----------------------------------------------------");
        // add backend functionality
    }

    private void reportEnrollmentCounts() {
        System.out.println("\nEnrollment Distributions");
        System.out.println("=====================================================================");
        System.out.println("Degree Name                    | Y1 | Y2 | Y3 | Y4 | Y5 | Y5+ | Total");
        System.out.println("---------------------------------------------------------------------");
        // add backend functionality
    }

    private void reportStudentStatuses() {
        System.out.println("\nStudent Statuses");
        System.out.println("=====================================================================");
        System.out.println("Degree Name                       | Regular | Irregular | Graduating ");
        System.out.println("---------------------------------------------------------------------");
        // add backend functionality
    }

    private void reportAverageCGPA() {
        System.out.println("\nAverageCGPA");
        System.out.println("====================================================");
        System.out.println("Degree Name                          | Average CGPA ");
        System.out.println("----------------------------------------------------");
        // add backend functionality
    }

}