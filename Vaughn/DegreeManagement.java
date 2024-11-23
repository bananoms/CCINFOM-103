import java.sql.*;

public class DegreeManagement {
    private String degreeID;
    private String degreeName;
    private String degreeLevel; // ENUM
    private String departmentName; // Added department name as per schema
    private int requiredUnitsForGrad; // Added required units for graduation

    public DegreeManagement() {
        this.degreeID = "";
        this.degreeName = "";
        this.degreeLevel = "";
        this.departmentName = "";
        this.requiredUnitsForGrad = 0;
    }

    // Method to get a degree record by DegreeName
    public int getDegreeRecord() {
        int recordCount = 0;
        try (Connection c = DriverManager.getConnection("--- INPUT LINK TO DB SERVER HERE ---")) {
            System.out.println(">>> Connection to DB Successful!");

            PreparedStatement sqlStmt = c.prepareStatement(
                    "SELECT * FROM Degrees WHERE DegreeID=?"
            );
            sqlStmt.setString(1, degreeID);

            ResultSet rs = sqlStmt.executeQuery();

            while (rs.next()) {
                recordCount++;
                degreeName = rs.getString("DegreeName");
                degreeLevel =   rs.getString("DegreeLevel");
                departmentName = rs.getString("DepartmentName");
                requiredUnitsForGrad = rs.getInt("RequiredUnitsForGrad");
                System.out.println("Record " + degreeName + " was retrieved");
            }

            return recordCount; // Return number of records found
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    // Method to add a degree record
    public int addDegree() {
        try (Connection c = DriverManager.getConnection("--- INPUT LINK TO DB SERVER HERE ---")) {
            System.out.println(">>> Connection to DB Successful!");

            PreparedStatement sqlStmt = c.prepareStatement(
                    "INSERT INTO Degrees (DegreeID, DegreeName, DegreeLevel, DepartmentName, RequiredUnitsForGrad) " +
                            "VALUES (?, ?, ?, ?, ?)"
            );
            sqlStmt.setString(1, degreeID);
            sqlStmt.setString(2, degreeName);
            sqlStmt.setString(3, degreeLevel);
            sqlStmt.setString(4, departmentName);
            sqlStmt.setInt(5, requiredUnitsForGrad);

            sqlStmt.executeUpdate();
            System.out.println("Degree Record was created!");

            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    // Method to update a degree record
    public int updateDegree() {
        try (Connection c = DriverManager.getConnection("--- INPUT LINK TO DB SERVER HERE ---")) {
            System.out.println(">>> Connection to DB Successful!");

            PreparedStatement sqlStmt = c.prepareStatement(
                    "UPDATE Degrees SET DegreeName=?, DegreeLEvel=?, DepartmentName=?, RequiredUnitsForGrad=? WHERE DegreeName=?"
            );
            sqlStmt.setString(1, degreeName);
            sqlStmt.setString(2, degreeLevel);
            sqlStmt.setString(3, departmentName);
            sqlStmt.setInt(4, requiredUnitsForGrad);
            sqlStmt.setString(5, degreeID);

            sqlStmt.executeUpdate();
            System.out.println("Degree Record was updated!");

            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    // Method to delete a degree record
    public int deleteDegree() {
        try (Connection c = DriverManager.getConnection("--- INPUT LINK TO DB SERVER HERE ---")) {
            System.out.println(">>> Connection to DB Successful!");

            PreparedStatement sqlStmt = c.prepareStatement(
                    "DELETE FROM Degrees WHERE DegreeID=?"
            );
            sqlStmt.setString(1, degreeID);

            sqlStmt.executeUpdate();
            System.out.println("Degree Record was deleted!");

            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    // Getters and setters for Degree attributes

    public void setDegreeID(String degreeID) {
        this.degreeID = degreeID;
    }

    public String getDegreeID() {
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
    
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setRequiredUnitsForGrad(int requiredUnitsForGrad) {
        this.requiredUnitsForGrad = requiredUnitsForGrad;
    }

    public int getRequiredUnitsForGrad() {
        return requiredUnitsForGrad;
    }
    
}