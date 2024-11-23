package DBAPP;

import java.sql.*;

public class ViewTeacherRecords {
    // Attributes for Teacher table
    private int teacherID;
    private String firstName;
    private String lastName;
    private String middleName;
    private String departmentName; // Foreign key to Departments table
    private String email;
    private String contactNumber;
    private String sex; // Enum value

    public ViewTeacherRecords() {
        this.teacherID = 0;
        this.firstName = "";
        this.lastName = "";
        this.middleName = "";
        this.departmentName = "";
        this.email = "";
        this.contactNumber = "";
        this.sex = "";
    }

    public int getTeacherRecord() {
        int recordCount = 0;
        try {
            Connection c;
            // Establish connection to the database
            c = DriverManager.getConnection("--- INPUT LINK TO DB SERVER HERE ---");
            System.out.println(">>> Connection to DB Successful!");

            // SQL SELECT statement for retrieving a teacher's record based on TeacherID
            PreparedStatement sqlStmt = c.prepareStatement(
                    "SELECT TeacherID, LastName, FirstName, MiddleName, Email, Sex, ContactNumber 
                     
                     FROM Teachers t LEFT JOIN DepartmentName dn t.DepartmentName = dn.DepartmentName
                    "
            );

            sqlStmt.setInt(1, teacherID);
            System.out.println(">>> SQL Statement Prepared");

            // Execute the statement
            ResultSet rs = sqlStmt.executeQuery();

            // Process the result set
            while (rs.next()) {
                recordCount++;
                firstName = rs.getString("FirstName");
                lastName = rs.getString("LastName");
                middleName = rs.getString("MiddleName");
                departmentName = rs.getString("DeparmentName");
                email = rs.getString("Email");
                contactNumber = rs.getString("ContactNumber");
                sex = rs.getString("Sex");
                System.out.println("Record " + teacherID + " was retrieved");
            }

            sqlStmt.close();
            c.close();
            return recordCount; // Return number of records found
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    // Getters and setters
    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public String getEmail() {
        return email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setDepartmentID(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
