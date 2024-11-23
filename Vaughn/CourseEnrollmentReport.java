import java.sql.*;

public class CourseEnrollmentReport {
    private int termID;
    private int startYear;
    private int endYear;
    private String courseCode;
    // private String courseStatus;

    public int generateEnrollmentStats(){
        // This method will be used to generate enrollment statistics for per course
        int recordCount = 0;
        try {
            Connection c;
            c = DriverManager.getConnection(" -- INPUT MYSQL CODE --");
            System.out.println("Connection to DB Successful");

            PreparedStatement sqlStmt = c.prepareStatement(
                    ""
            );

            sqlStmt.setInt(1, termID);
            sqlStmt.setInt(2, startYear);
            sqlStmt.setInt(3, endYear);
            sqlStmt.setString(4, courseCode);

            System.out.println("SQL Statement Prepared");
            ResultSet rs = sqlStmt.executeQuery();

            while (rs.next()) {
                // display results
                System.out.println("Enrolled Count:                         ");
                recordCount++;
            }

            sqlStmt.close();
            c.close();
            return recordCount;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }        
    }

    public int generateDroppedStats(){
        // This method will be used to generate dropped statistics for per course
        int recordCount = 0;
        try {
            Connection c;
            c = DriverManager.getConnection(" -- INPUT MYSQL CODE --");
            System.out.println("Connection to DB Successful");

            PreparedStatement sqlStmt = c.prepareStatement(
                    ""
            );

            sqlStmt.setInt(1, termID);
            sqlStmt.setInt(2, startYear);
            sqlStmt.setInt(3, endYear);
            sqlStmt.setString(4, courseCode);

            System.out.println("SQL Statement Prepared");
            ResultSet rs = sqlStmt.executeQuery();

            while (rs.next()) {
                // display results
                System.out.println("Dropped Count:                         ");
                recordCount++;
            }

            sqlStmt.close();
            c.close();
            return recordCount;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }     
    }
}
