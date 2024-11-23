import java.sql.*;

public class ViewColleges {
    // College attributes
    private int collegeID;
    private String collegeName;
    private String collegeAcronym;

    public ViewColleges() {
        this.collegeID = 0;
        this.collegeName = "";
        this.collegeAcronym = "";
    }

    // Method to get a college record by CollegeID
    public int getCollegeRecord() {
        int recordCount = 0;
        try {
            Connection c;
            c = DriverManager.getConnection("--- INPUT LINK TO DB SERVER HERE ---");
            System.out.println(">>> Connection to DB Successful!");

            PreparedStatement sqlStmt = c.prepareStatement(
                    "SELECT * FROM Colleges WHERE CollegeID=?"
            );

            sqlStmt.setInt(1, collegeID);
            System.out.println(">>> SQL Statement Prepared");

            ResultSet rs = sqlStmt.executeQuery();

            while (rs.next()) {
                recordCount++;
                collegeName = rs.getString("CollegeName");
                collegeAcronym = rs.getString("CollegeAcronym");
                System.out.println("Record " + collegeID + " was retrieved");
            }

            sqlStmt.close();
            c.close();
            return recordCount;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    // Getters for College attributes
    public int getCollegeID() {
        return collegeID;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public String getCollegeAcronym() {
        return collegeAcronym;
    }

    // Setters for College attributes (optional)
    public void setCollegeID(int collegeID) {
        this.collegeID = collegeID;
    }
}
