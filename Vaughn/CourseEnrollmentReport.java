package DBAPP;
import java.sql.*;
import java.util.*;

public class CourseEnrollmentReport {
    private int termID;
    private int startYear;
    private int endYear;

    public CourseEnrollmentReport(int termID, int startYear, int endYear) {
        this.termID = termID;
        this.startYear = startYear;
        this.endYear = endYear;
    }

    public Map<String, Integer> generateEnrollmentStats() {
        // This method will be used to generate enrollment statistics for per course
        Map<String, Integer> enrolledCount= new HashMap<>();
        try {
            Connection c;
            c = DriverManager.getConnection(" -- INPUT MYSQL CODE --");
            System.out.println("Connection to DB Successful");

            PreparedStatement sqlStmt = c.prepareStatement(
                """
                SELECT 
                    c.CourseCode,
                    COUNT(*) AS EnrolledCount
                FROM 
                    Courses c
                JOIN 
                    Terms t ON c.TermID = t.TermID
                WHERE 
                    c.TermID = ? 
                    AND t.AcademicYearStart = ? 
                    AND t.AcademicYearEnd = ? 
                    AND c.CourseStatus = 'E'
                GROUP BY 
                    c.CourseCode
                ORDER BY 
                    c.CourseCode
                """
            );

            sqlStmt.setInt(1, termID);
            sqlStmt.setInt(2, startYear);
            sqlStmt.setInt(3, endYear);

            System.out.println("SQL Statement Prepared");
            ResultSet rs = sqlStmt.executeQuery();

            while (rs.next()) {
                String courseCode = rs.getString("CourseCode");
                int count = rs.getInt("EnrolledCount");
                enrolledCount.put(courseCode, count);
            }

            sqlStmt.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }        
        return enrolledCount;
    }

    public Map<String, Integer> generateDroppedStats(){
        // This method will be used to generate dropped statistics for per course
        Map<String, Integer> droppedCount = new HashMap<>();
        try {
            Connection c;
            c = DriverManager.getConnection(" -- INPUT MYSQL CODE --");
            System.out.println("Connection to DB Successful");

            PreparedStatement sqlStmt = c.prepareStatement(
                """
                SELECT 
                    c.CourseCode,
                    COUNT(*) AS DroppedCount
                FROM 
                    Courses c
                JOIN 
                    Terms t ON c.TermID = t.TermID
                WHERE 
                    c.TermID = ? 
                    AND t.AcademicYearStart = ? 
                    AND t.AcademicYearEnd = ? 
                    AND c.CourseStatus = 'D'
                GROUP BY 
                    c.CourseCode
                ORDER BY 
                    c.CourseCode
                """
            );

            sqlStmt.setInt(1, termID);
            sqlStmt.setInt(2, startYear);
            sqlStmt.setInt(3, endYear);

            System.out.println("SQL Statement Prepared");
            ResultSet rs = sqlStmt.executeQuery();

            System.out.printf("Dropped Course Statistics for Term %d (%d-%d):%n", termID, startYear, endYear);
            while (rs.next()) {
                String courseCode = rs.getString("CourseCode");
                int count = rs.getInt("DroppedCount");
                droppedCount.put(courseCode, count);
            }

            sqlStmt.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }     
        return droppedCount;
    }
}
