package DBAPP;
import java.util.Map;
import java.util.Scanner;

public class CourseEnrollmentReportFE {
    Scanner sc = new Scanner(System.in);

    public void displayReportPrompts() {
        System.out.println("\n====================================================");
        System.out.println("    Course Enrollment Report");
        System.out.println("====================================================");
        System.out.print("Enter academic year (e.g., 2024-2025): ");
        String[] academicYear = sc.nextLine().split("-");
        int startYear = Integer.parseInt(academicYear[0].trim());
        int endYear = Integer.parseInt(academicYear[1].trim());

        System.out.print("Enter term (1/2/3): ");
        int termID = Integer.parseInt(sc.nextLine().trim());

        CourseEnrollmentReport report = new CourseEnrollmentReport(termID, startYear, endYear);
        reportEnrollmentCounts(report);
        reportDroppedCounts(report);
    }

    

    private void reportEnrollmentCounts(CourseEnrollmentReport report) {
        System.out.println("\nEnrolled Distributions");
        System.out.println("=====================================================================");
        Map<String, Integer> enrolledCounts = report.generateEnrollmentStats();
        for (Map.Entry<String, Integer> entry : enrolledCounts.entrySet()) {
            System.out.printf("Course Code: %s | Enrolled Count: %d%n", entry.getKey(), entry.getValue());
        }
    }

    private void reportDroppedCounts(CourseEnrollmentReport report) {
        System.out.println("\nDropped Student Distributions");
        System.out.println("=====================================================================");
        Map<String, Integer> enrolledCounts = report.generateDroppedStats();
        for (Map.Entry<String, Integer> entry : enrolledCounts.entrySet()) {
            System.out.printf("Course Code: %s | Enrolled Count: %d%n", entry.getKey(), entry.getValue());
        }
    }
}
