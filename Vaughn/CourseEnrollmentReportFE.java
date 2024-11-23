import java.util.Scanner;

public class CourseEnrollmentReportFE {
    Scanner sc = new Scanner(System.in);

    public void displayReportPrompts() {
        System.out.println("\n====================================================");
        System.out.println("    Course Enrollment Report");
        System.out.println("----------------------------------------------------");
        // should i ask for acad year and term?
        // do in such a way to provide academic year and term?
        System.out.println("Enter academic year    : ");
        String academicYear = sc.nextLine();
        System.out.println("Enter term (1/2/3)     : ");
        String term = sc.nextLine();


        reportEnrollmentCounts();
        reportDroppedCounts();
    }

    

    private void reportEnrollmentCounts() {
        System.out.println("\nEnrollment Distributions");
        System.out.println("=====================================================================");
        System.out.println("Enrollment Count: Total");
        System.out.println("---------------------------------------------------------------------");
        // add backend functionality
    }

    private void reportDroppedCounts() {
        System.out.println("\nDropped Student Distributions");
        System.out.println("=====================================================================");
        System.out.println("Dropped Count: Total");
        System.out.println("---------------------------------------------------------------------");
        // add backend functionality
    }
}