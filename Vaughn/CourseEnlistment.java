import java.sql.*;

public class CourseEnlistment {
    // Check if a student exists in the database
    public boolean studentExists(int studentID) {
        try {
            Connection c = DriverManager.getConnection("--- INPUT LINK TO DB SERVER HERE ---");
            System.out.println("Connection to DB Successful!");

            PreparedStatement sqlStmt = c.prepareStatement(
                "SELECT COUNT(*) FROM Students WHERE StudentID = ?"
            );
            sqlStmt.setInt(1, studentID);

            ResultSet rs = sqlStmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            rs.close();
            sqlStmt.close();
            c.close();

            return count > 0;
        } catch (Exception e) {
            System.out.println("Error checking student existence: " + e.getMessage());
            return false;
        }
    }

    // Check if a term exists in the database
    public boolean termExists(int termID) {
        try {
            Connection c = DriverManager.getConnection("--- INPUT LINK TO DB SERVER HERE ---");
            System.out.println("Connection to DB Successful!");

            PreparedStatement sqlStmt = c.prepareStatement(
                "SELECT COUNT(*) FROM Terms WHERE TermID = ?"
            );
            sqlStmt.setInt(1, termID);

            ResultSet rs = sqlStmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            rs.close();
            sqlStmt.close();
            c.close();

            return count > 0;
        } catch (Exception e) {
            System.out.println("Error checking term existence: " + e.getMessage());
            return false;
        }
    }

    // Check if a course exists in the database
    public boolean courseExists(String courseCode) {
        try {
            Connection c = DriverManager.getConnection("--- INPUT LINK TO DB SERVER HERE ---");
            System.out.println("Connection to DB Successful!");

            PreparedStatement sqlStmt = c.prepareStatement(
                "SELECT COUNT(*) FROM Courses WHERE CourseCode = ?"
            );
            sqlStmt.setString(1, courseCode);

            ResultSet rs = sqlStmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            rs.close();
            sqlStmt.close();
            c.close();

            return count > 0;
        } catch (Exception e) {
            System.out.println("Error checking course existence: " + e.getMessage());
            return false;
        }
    }

    // Check if a student is already enlisted for a specific course and term
    public boolean isEnlisted(int studentID, int termID, String courseCode) {
        try {
            Connection c = DriverManager.getConnection("--- INPUT LINK TO DB SERVER HERE ---");
            System.out.println("Connection to DB Successful!");
    
            PreparedStatement sqlStmt = c.prepareStatement(
                "SELECT COUNT(*) FROM CourseEnlistments WHERE StudentID = ? AND TermID = ? AND CourseCode = ? AND EnrollmentStatus = 'E'"
            );
            sqlStmt.setInt(1, studentID);
            sqlStmt.setInt(2, termID);
            sqlStmt.setString(3, courseCode);
    
            ResultSet rs = sqlStmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);
    
            rs.close();
            sqlStmt.close();
            c.close();
    
            return count > 0;
        } catch (Exception e) {
            System.out.println("Error checking enlistment status: " + e.getMessage());
            return false;
        }
    }

    // Enlist a student in a specific course and term
    public boolean enlistStudentInCourse(int studentID, int termID, String courseCode) {
        try {
            Connection c = DriverManager.getConnection("--- INPUT LINK TO DB SERVER HERE ---");
            System.out.println("Connection to DB Successful!");
    
            // Insert the student-course enrollment into CourseEnlistments table
            PreparedStatement sqlStmt = c.prepareStatement(
                "INSERT INTO CourseEnlistments (StudentID, TermID, CourseCode, EnrollmentStatus) VALUES (?, ?, ?, ?)"
            );
            sqlStmt.setInt(1, studentID);
            sqlStmt.setInt(2, termID);
            sqlStmt.setString(3, courseCode);
            sqlStmt.setString(4, "E"); // Enrollment Status: "E" for Enrolled
    
            int rowsAffected = sqlStmt.executeUpdate();
            sqlStmt.close();
            c.close();
    
            return rowsAffected > 0;
        } catch (Exception e) {
            System.out.println("Error during course enlistment: " + e.getMessage());
            return false;
        }
    }

    public boolean dropStudentFromCourse(int studentID, int termID, String courseCode) {
        try {
            Connection c = DriverManager.getConnection("--- INPUT LINK TO DB SERVER HERE ---");
            System.out.println("Connection to DB Successful!");
    
            PreparedStatement sqlStmt = c.prepareStatement(
                "DELETE FROM CourseEnlistments WHERE StudentID = ? AND TermID = ? AND CourseCode = ?"
            );
            sqlStmt.setInt(1, studentID);
            sqlStmt.setInt(2, termID);
            sqlStmt.setString(3, courseCode);
    
            int rowsAffected = sqlStmt.executeUpdate();
            sqlStmt.close();
            c.close();
    
            return rowsAffected > 0;
        } catch (Exception e) {
            System.out.println("Error during course drop: " + e.getMessage());
            return false;
        }
    }
}
