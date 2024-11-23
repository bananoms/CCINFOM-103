import java.sql.*;

public class RequestLeave {

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

    // Method to fetch remaining terms for a student
    public int getRemainingTerms(int studentID) {
        try {
            Connection c = DriverManager.getConnection("--- INPUT LINK TO DB SERVER HERE ---");
            System.out.println("Connection to DB Successful!");
    
            PreparedStatement degreeStmt = c.prepareStatement(
                "SELECT d.RequiredUnitsForGrad " +
                "FROM Students s " +
                "JOIN Degrees d ON s.DegreeID = d.DegreeID " +
                "WHERE s.StudentID = ?"
            );
            degreeStmt.setInt(1, studentID);
    
            ResultSet rs = degreeStmt.executeQuery();
            if (!rs.next()) {
                System.out.println("Student not found.");
                rs.close();
                degreeStmt.close();
                c.close();
                return -1; // Student does not exist
            }
            int requiredUnits = rs.getInt("RequiredUnitsForGrad");
    
            rs.close();
            degreeStmt.close();
    
            PreparedStatement unitsStmt = c.prepareStatement(
                "SELECT SUM(rc.Units) AS CompletedUnits " +
                "FROM Grades g " +
                "JOIN Courses c ON g.CourseCode = c.CourseCode " +
                "JOIN REF_Courses rc ON c.CourseCode = rc.CourseCode " +
                "WHERE g.StudentID = ? AND g.GradeUnits >= 1"
            );
            unitsStmt.setInt(1, studentID);
    
            rs = unitsStmt.executeQuery();
            int completedUnits = 0;
            if (rs.next()) {
                completedUnits = rs.getInt("CompletedUnits");
            }
    
            rs.close();
            unitsStmt.close();
            c.close();
    
            int remainingUnits = requiredUnits - completedUnits;
            if (remainingUnits <= 0) {
                return 0; 
            }
    
            int averageUnitsPerTerm = 17; // assume 17 average 
            return (int) Math.ceil((double) remainingUnits / averageUnitsPerTerm);
        } catch (Exception e) {
            System.out.println("Error fetching remaining terms: " + e.getMessage());
            return -1;
        }
    }
    
    

    public String getLOAStatus(int studentID) {
        try {
            Connection c = DriverManager.getConnection("--- INPUT LINK TO DB SERVER HERE ---");
            System.out.println("Connection to DB Successful!");

            PreparedStatement sqlStmt = c.prepareStatement(
                "SELECT LeaveOfAbsenceStatus FROM Students WHERE StudentID = ?"
            );
            sqlStmt.setInt(1, studentID);

            ResultSet rs = sqlStmt.executeQuery();
            if (rs.next()) {
                return rs.getString("LeaveOfAbsenceStatus");
            }

            rs.close();
            sqlStmt.close();
            c.close();

            return "N"; // Default to "Not Applicable" if no status found
        } catch (Exception e) {
            System.out.println("Error fetching LOA status: " + e.getMessage());
            return "N"; // Default to "Not Applicable" if an error occurs
        }
    }

    // Method to update LOA status
    public boolean updateLOAStatus(int studentID, String leaveOfAbsenceStatus) {
        try {
            // Establish connection to the database
            Connection c = DriverManager.getConnection("--- INPUT LINK TO DB SERVER HERE ---");
            System.out.println("Connection to DB Successful!");

            // SQL UPDATE statement to update the LOA status
            PreparedStatement sqlStmt = c.prepareStatement(
                "UPDATE Students SET LeaveOfAbsenceStatus = ? WHERE StudentID = ?"
            );

            // Set values for the placeholders
            sqlStmt.setString(1, leaveOfAbsenceStatus); // LOA status
            sqlStmt.setInt(2, studentID); // Student ID

            System.out.println("SQL Statement Prepared");

            // Execute the update
            int rowsUpdated = sqlStmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Student LOA status updated successfully!");
            } else {
                System.out.println("No records updated. Student ID may not exist.");
            }

            sqlStmt.close();
            c.close();
            return rowsUpdated > 0; // Return true if at least one row was updated
        } catch (Exception e) {
            System.out.println("Error updating LOA status: " + e.getMessage());
            return false; // Return false if an exception occurs
        }
    }
}
