import java.sql.*;

public class DegreeManagement {
    // Degree attributes
    private String degreeName;
    private String degreeLevel; // ENUM
    private String collegeID; // Foreign key to College table

    public DegreeManagement() {
        this.degreeName = "";
        this.degreeLevel = "";
        this.collegeID = "";
    }

    // Method to get a degree record by DegreeID
    public int getDegreeRecord() {
        int recordCount = 0;
        try {
            Connection c;
            // Establish connection to the database
            // PLACE DB SERVER LINK HERE!
            c = DriverManager.getConnection("--- INPUT LINK TO DB SERVER HERE ---");
            System.out.println(">>> Connection to DB Successful!");

            PreparedStatement sqlStmt = c.prepareStatement(
                    "SELECT * FROM Degrees WHERE DegreeName=?"
            );

            sqlStmt.setString(1, degreeName);
            System.out.println(">>> SQL Statement Prepared");

            ResultSet rs = sqlStmt.executeQuery();

            while (rs.next()) {
                recordCount++;
                degreeLevel = rs.getString("DegreeLevel");
                collegeID = rs.getString("CollegeID");
                System.out.println("Record " + degreeName + " was retrieved");
            }

            sqlStmt.close();
            c.close();
            return recordCount; // Return number of records found
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    // Method to add a degree record
    public int addDegree() {
        try {
            Connection c;
            c = DriverManager.getConnection("--- INPUT LINK TO DB SERVER HERE ---");
            System.out.println(">>> Connection to DB Successful!");

            PreparedStatement sqlStmt = c.prepareStatement(
                    "INSERT INTO Degrees (DegreeName, DegreeLevel, CollegeID) " +
                            "VALUES (?, ?, ?)"
            );

            sqlStmt.setString(1, degreeName);
            sqlStmt.setString(2, degreeLevel);
            sqlStmt.setString(3, collegeID);

            System.out.println(">>> SQL Statement Prepared");

            sqlStmt.executeUpdate();
            System.out.println("Degree Record was created!");

            sqlStmt.close();
            c.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    // Method to update a degree record
    public int updateDegree() {
        try {
            Connection c;
            c = DriverManager.getConnection("--- INPUT LINK TO DB SERVER HERE ---");
            System.out.println(">>> Connection to DB Successful!");

            PreparedStatement sqlStmt = c.prepareStatement(
                    "UPDATE Degrees SET DegreeLevel=?, CollegeID=? WHERE DegreeName=?"
            );

            sqlStmt.setString(1, degreeLevel);
            sqlStmt.setString(2, collegeID);
            sqlStmt.setString(3, degreeName);

            System.out.println(">>> SQL Statement Prepared");

            sqlStmt.executeUpdate();
            System.out.println("Degree Record was updated!");

            sqlStmt.close();
            c.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    // Method to delete a degree record
    public int deleteDegree() {
        try {
            Connection c;
            c = DriverManager.getConnection("--- INPUT LINK TO DB SERVER HERE ---");
            System.out.println(">>> Connection to DB Successful!");

            PreparedStatement sqlStmt = c.prepareStatement(
                    "DELETE FROM Degrees WHERE DegreeName=?"
            );

            sqlStmt.setString(1, degreeName);

            System.out.println(">>> SQL Statement Prepared");

            sqlStmt.executeUpdate();
            System.out.println("Degree Record was deleted!");

            sqlStmt.close();
            c.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    // Getters and setters for Degree attributes

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeLevel(String degreeLevel) {
        this.degreeLevel = degreeLevel;
    }

    public String getDegreeLevel() {
        return degreeLevel;
    }

    public void setCollegeID(String collegeID) {
        this.collegeID = collegeID;
    }

    public String getCollegeID() {
        return collegeID;
    }
}
