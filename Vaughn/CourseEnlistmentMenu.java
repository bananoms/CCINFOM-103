package DBAPP;
import java.sql.*;
import java.util*
public class CourseEnlistmentMenu {

    private int menuSelection;

    public CourseEnlistmentMenu() {
        this.menuSelection = -1;
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\n====================================================");
            System.out.println("    Course Enlistment for a Student");
            System.out.println("----------------------------------------------------");
            System.out.println("[1] Enlist Courses");
            System.out.println("[2] View Enlisted Courses");
            System.out.println("[3] Drop a Course");
            System.out.println("[0] Exit");
            System.out.println("====================================================");

            promptForMenuSelection();

            switch (this.menuSelection) {
                case 1:
                    courseEnlist();
                    break;
                case 2:
                    viewEnlist();
                    break;
                case 3:
                    dropCourse();
                    break;
                case 0:
                    System.out.println("Exiting Course Enlistment Menu.");
                    return;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }

    private void promptForMenuSelection() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter your selection: ");
                this.menuSelection = Integer.parseInt(sc.nextLine());
                if (this.menuSelection >= 0 && this.menuSelection <= 3) break;
                System.out.println("Invalid selection. Enter 0-3.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private void courseEnlist() {
        Scanner sc = new Scanner(System.in);
        CourseEnlistment ce = new CourseEnlistment();

        System.out.print("\nEnter Student ID: ");
        int studentID = sc.nextInt();
        sc.nextLine(); // Consume newline

        if (!ce.studentExists(studentID)) {
            System.out.println("Student ID not found.");
            return;
        }

        System.out.print("\nEnter Term ID: ");
        int termID = sc.nextInt();
        sc.nextLine(); // Consume newline

        if (!ce.termExists(termID)) {
            System.out.println("Term ID not found.");
            return;
        }

        System.out.print("\nEnter Course Code: ");
        String courseCode = sc.nextLine().toUpperCase(); // Assuming course codes are in uppercase

        if (!ce.courseExists(courseCode)) {
            System.out.println("Course code not found.");
            return;
        }

        if (ce.isEnlisted(studentID, termID, courseCode)) {
            System.out.println("Student is already enlisted for this course.");
            return;
        }

        if (ce.enlistStudentInCourse(studentID, termID, courseCode)) {
            System.out.println("Student successfully enlisted in course " + courseCode + " for Term " + termID);
        } else {
            System.out.println("Error occurred during course enlistment.");
        }
    }

    private void viewEnlist() {
        Scanner sc = new Scanner(System.in);
        CourseEnlistment ce = new CourseEnlistment();
    
        System.out.print("\nEnter Student ID: ");
        int studentID = sc.nextInt();
        sc.nextLine(); // Consume newline
    
        if (!ce.studentExists(studentID)) {
            System.out.println("Student ID not found.");
            return;
        }

        System.out.print("\nEnter Term ID: ");
        int termID = sc.nextInt();
        sc.nextLine(); // Consume newline

        if (!ce.termExists(termID)) {
            System.out.println("Term ID not found.");
            return;
        }
    
        try {
            Connection c = DriverManager.getConnection("--- INPUT LINK TO DB SERVER HERE ---");
            System.out.println("Connection to DB Successful!");
    
            PreparedStatement sqlStmt = c.prepareStatement(
                "SELECT CourseCode, EnrollmentStatus FROM CourseEnlistments WHERE StudentID = ? AND TermID = ?"
            );
            sqlStmt.setInt(1, studentID);
            sqlStmt.setInt(2, termID);
    
            ResultSet rs = sqlStmt.executeQuery();
    
            if (!rs.isBeforeFirst()) {
                System.out.println("No courses found for this student in this term.");
            } else {
                System.out.println("\nEnlisted Courses for Student ID " + studentID + " in Term " + termID + ":");
                while (rs.next()) {
                    String courseCode = rs.getString("CourseCode");
                    String enrollmentStatus = rs.getString("EnrollmentStatus");
                    System.out.println("- " + courseCode + " (Enrollment Status: " + enrollmentStatus + ")");
                }
            }
    
            rs.close();
            sqlStmt.close();
            c.close();
        } catch (Exception e) {
            System.out.println("Error retrieving enlisted courses: " + e.getMessage());
        }
    }

    private void dropCourse() {
        Scanner sc = new Scanner(System.in);
        CourseEnlistment ce = new CourseEnlistment();
    
        System.out.print("\nEnter Student ID: ");
        int studentID = sc.nextInt();
        sc.nextLine(); // Consume newline
    
        if (!ce.studentExists(studentID)) {
            System.out.println("Student ID not found.");
            return;
        }
    
        System.out.print("\nEnter Term ID: ");
        int termID = sc.nextInt();
        sc.nextLine(); // Consume newline
    
        if (!ce.termExists(termID)) {
            System.out.println("Term ID not found.");
            return;
        }
    
        try {
            Connection c = DriverManager.getConnection("--- INPUT LINK TO DB SERVER HERE ---");
            System.out.println("Connection to DB Successful!");
    
            PreparedStatement sqlStmt = c.prepareStatement(
                "SELECT CourseCode FROM CourseEnlistments WHERE StudentID = ? AND TermID = ?"
            );
            sqlStmt.setInt(1, studentID);
            sqlStmt.setInt(2, termID);
    
            ResultSet rs = sqlStmt.executeQuery();
    
            if (!rs.isBeforeFirst()) {
                System.out.println("No courses found for this student in this term.");
            } else {
                System.out.println("\nEnlisted Courses for Student ID " + studentID + " in Term " + termID + ":");
                while (rs.next()) {
                    String courseCode = rs.getString("CourseCode");
                    System.out.println("- " + courseCode);
                }
    
                System.out.print("\nEnter Course Code to drop: ");
                String courseCodeToDrop = sc.nextLine().toUpperCase();
    
                if (ce.isEnlisted(studentID, termID, courseCodeToDrop)) {
                    if (ce.dropStudentFromCourse(studentID, termID, courseCodeToDrop)) {
                        System.out.println("Successfully dropped the course: " + courseCodeToDrop);
                    } else {
                        System.out.println("Error occurred during course drop.");
                    }
                } else {
                    System.out.println("Student is not enrolled in this course.");
                }
            }
    
            rs.close();
            sqlStmt.close();
            c.close();
        } catch (Exception e) {
            System.out.println("Error retrieving enrolled courses: " + e.getMessage());
        }
    }
}
