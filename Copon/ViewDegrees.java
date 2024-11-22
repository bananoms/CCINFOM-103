package DBAPP;
import java.sql.*;

public class ViewDegrees {
    // Attributes for Degree table
    private int degreeID;
    private String degreeName;
    private String degreeLevel;
    private int departmentID; // Foreign key to Departments table

    public ViewDegrees() {
        this.degreeID = 0;
        this.degreeName = "";
        this.degreeLevel = "";
        this.departmentID = 0;
    }

    // Method to get a degree record by DegreeID (view-only)
    public int getDegreeRecord() {
        int recordCount = 0;
        try {
            Connection c;
            c = DriverManager.getConnection("--- INPUT LINK TO DB SERVER HERE ---");
            System.out.println(">>> Connection to DB Successful!");

            // SQL SELECT statement for retrieving a degree record based on DegreeID
            PreparedStatement sqlStmt = c.prepareStatement(
                    "SELECT * FROM Degrees WHERE DegreeID=?"
            );

            sqlStmt.setInt(1, degreeID);
            System.out.println(">>> SQL Statement Prepared");

            ResultSet rs = sqlStmt.executeQuery();

            while (rs.next()) {
                recordCount++;
                degreeName = rs.getString("DegreeName");
                degreeLevel = rs.getString("DegreeLevel");
                departmentID = rs.getInt("DepartmentID");
                System.out.println("Record " + degreeID + " was retrieved");
            }

            sqlStmt.close();
            c.close();
            return recordCount; // Return number of records found
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    // Getters for Degree attributes
    public int getDegreeID() {
        return degreeID;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public String getDegreeLevel() {
        return degreeLevel;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    // Setters for Degree attributes (optional, for external use)
    public void setDegreeID(int degreeID) {
        this.degreeID = degreeID;
    }
}
