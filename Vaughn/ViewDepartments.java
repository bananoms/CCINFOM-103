import java.sql.*;

public class ViewDepartments {
    // Department attributes
    private int departmentID;
    private String departmentName;
    private String departmentAcronym;
    private int collegeID; // Foreign key to the Colleges table

    public ViewDepartments() {
        this.departmentID = 0;
        this.departmentName = "";
        this.departmentAcronym = "";
        this.collegeID = 0;
    }

    // Method to get a department record by DepartmentID
    public int getDepartmentRecord() {
        int recordCount = 0;
        try {
            Connection c;
            c = DriverManager.getConnection("--- INPUT LINK TO DB SERVER HERE ---");
            System.out.println(">>> Connection to DB Successful!");

            PreparedStatement sqlStmt = c.prepareStatement(
                    "SELECT * FROM Departments WHERE DepartmentID=?"
            );

            sqlStmt.setInt(1, departmentID);
            System.out.println(">>> SQL Statement Prepared");

            ResultSet rs = sqlStmt.executeQuery();

            while (rs.next()) {
                recordCount++;
                departmentName = rs.getString("DepartmentName");
                departmentAcronym = rs.getString("DepartmentAcronym");
                collegeID = rs.getInt("CollegeID");
                System.out.println("Record " + departmentID + " was retrieved");
            }

            sqlStmt.close();
            c.close();
            return recordCount;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    // Getters for Department attributes
    public int getDepartmentID() {
        return departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDepartmentAcronym() {
        return departmentAcronym;
    }

    public int getCollegeID() {
        return collegeID;
    }

    // Setters for Department attributes (optional)
    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }
}
