package DBAPP;
import java.sql.*;

public class DegreeManagement {
    // Degree attributes
    private int degreeID;
    private String degreeName;
    private String degreeLevel;
    private int departmentID; // Foreign key to Departments table

    public DegreeManagement() {
        this.degreeID = 0;
        this.degreeName = "";
        this.degreeLevel = "";
        this.departmentID = 0;
    }

    // Method to get a degree record by DegreeID
    public int getDegreeRecord() {
        int recordCount = 0;
        try {
            Connection c;
            c = DriverManager.getConnection("--- INPUT LINK TO DB SERVER HERE ---");
            System.out.println(">>> Connection to DB Successful!");

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

    // Method to add a degree record
    public int addDegree() {
        try {
            Connection c;
            c = DriverManager.getConnection("--- INPUT LINK TO DB SERVER HERE ---");
            System.out.println(">>> Connection to DB Successful!");

            PreparedStatement sqlStmt = c.prepareStatement(
                    "INSERT INTO Degrees (DegreeID, DegreeName, DegreeLevel, DepartmentID) " +
                            "VALUES (?, ?, ?, ?)"
            );

            sqlStmt.setInt(1, degreeID);
            sqlStmt.setString(2, degreeName);
            sqlStmt.setString(3, degreeLevel);
            sqlStmt.setInt(4, departmentID);

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
                    "UPDATE Degrees SET DegreeName=?, DegreeLevel=?, DepartmentID=? WHERE DegreeID=?"
            );

            sqlStmt.setString(1, degreeName);
            sqlStmt.setString(2, degreeLevel);
            sqlStmt.setInt(3, departmentID);
            sqlStmt.setInt(4, degreeID);

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
                    "DELETE FROM Degrees WHERE DegreeID=?"
            );

            sqlStmt.setInt(1, degreeID);

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
    public void setDegreeID(int degreeID) {
        this.degreeID = degreeID;
    }

    public int getDegreeID() {
        return degreeID;
    }

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

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public int getDepartmentID() {
        return departmentID;
    }
}
