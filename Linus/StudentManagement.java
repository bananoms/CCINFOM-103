package DBAPP;
import java.sql.*;

public class StudentManagement {
    // primary key
    private int studentID;
    // native attributes
    private String firstName;
    private String lastName;
    private String middleName;
    private String birthDate;
    private String email;
    private String streetAddress;
    private String barangay;
    private String city;
    private String province;
    private String postalCode;
    private String country;
    private String sex; // this is an enum value
    private String studentType; // this is an enum value
    private String leaveOfAbsence; // this is an enum value
    // foreign keys
    private int termID;
    private int collegeID;
    private int degreeID;

    public StudentManagement() {
        this.studentID = 0;
        this.firstName = "";
        this.lastName = "";
        this.middleName = "";
        this.birthDate = "";
        this.email = "";
        this.streetAddress = "";
        this.barangay = "";
        this.city = "";
        this.province = "";
        this.postalCode = "";
        this.country = "";
        this.studentType = "";
        this.leaveOfAbsence = "";
        this.sex = "";

        // this.termID = 0;
        // this.collegeID = 0;
        // this.degreeID = 0;
    }

    private int addStudent() {
        try {
            Connection c;
            // Establish connection to the database
            // PLACE DB SERVER LINK HERE!
            c = DriverManager.getConnection("--- INPUT LINK TO DB SERVER HERE ---");
            System.out.println(">>> Connection to DB Successful!");

            // Place your SQL INSERT CODE HERE
            PreparedStatement sqlStmt = c.prepareStatement(
                    "INSERT INTO Students " +
                            // NOTE: Shouldn't Student ID be automatically generated instead of user input?
                            "(StudentID, FirstName, LastName, MiddleName, " +
                            "BirthDate, Sex, Email, StreetAddress, Barangay, " +
                            "City, Province, PostalCode, Country, " +
                            "StudentType, LeaveOfAbsence) " +

                            // NOTE: ADJUST STATEMENT TO ADDRESS THE FKs (Term, Degree, and College)

                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );

            // Setting values for the placeholders
            sqlStmt.setInt(1, studentID); // StudentID
            sqlStmt.setString(2, firstName); // FirstName
            sqlStmt.setString(3, lastName); // LastName
            sqlStmt.setString(4, middleName); // MiddleName
            sqlStmt.setString(5, birthDate); // BirthDate
            sqlStmt.setString(6, sex); // Sex
            sqlStmt.setString(7, email); // Email
            sqlStmt.setString(8, streetAddress); // StreetAddress
            sqlStmt.setString(9, barangay); // Barangay
            sqlStmt.setString(10, city); // City
            sqlStmt.setString(11, province); // Province
            sqlStmt.setString(12, postalCode); // PostalCode
            sqlStmt.setString(13, country); // Country
            sqlStmt.setString(14, studentType); // StudentType
            sqlStmt.setString(15, leaveOfAbsence); // LeaveOfAbsence

            // execute statement
            System.out.println("SQL Statement has been prepared.");
            sqlStmt.executeUpdate();
            System.out.println("Student Record was created!");

            sqlStmt.close();
            c.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    private int deleteStudent() {
        try {
            Connection c;
            // Establish connection to the database
            // PLACE DB SERVER LINK HERE!
            c = DriverManager.getConnection("--- INPUT LINK TO DB SERVER HERE ---");
            System.out.println("Connection to DB Successful");

            // Place SQL DELETE statement here!
            PreparedStatement sqlStmt = c.prepareStatement(
                    "DELETE FROM Students WHERE StudentID=?"
                    // Adjust statement to also address FKs
            );
            sqlStmt.setInt(1, studentID);

            // execute statement
            System.out.println("SQL statement has been prepared");
            sqlStmt.executeUpdate();
            System.out.println("Student Record was deleted.");

            sqlStmt.close();
            c.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    private int updateStudent() {
        try {
            Connection c;
            // Establish connection to the database
            // PLACE DB SERVER LINK HERE!
            c = DriverManager.getConnection("--- INPUT LINK TO DB SERVER HERE ---");
            System.out.println("Connection to DB Successful!");

            // SQL UPDATE statement for updating a student's record
            PreparedStatement sqlStmt = c.prepareStatement(
                    "UPDATE Students SET FirstName=?, LastName=?, MiddleName=?, " +
                            "BirthDate=?, Sex=?, Email=?, StreetAddress=?, Barangay=?, " +
                            "City=?, Province=?, PostalCode=?, Country=?, " +
                            "StudentType=?, LeaveOfAbsence=? WHERE StudentID=?"

                    // ADD STATEMENT FOR THE FOREIGN KEYS

            );

            // Setting values for the placeholders
            sqlStmt.setString(1, firstName); // FirstName
            sqlStmt.setString(2, lastName); // LastName
            sqlStmt.setString(3, middleName); // MiddleName
            sqlStmt.setString(4, birthDate); // BirthDate
            sqlStmt.setString(5, sex); // Sex
            sqlStmt.setString(6, email); // Email
            sqlStmt.setString(7, streetAddress); // StreetAddress
            sqlStmt.setString(8, barangay); // Barangay
            sqlStmt.setString(9, city); // City
            sqlStmt.setString(10, province); // Province
            sqlStmt.setString(11, postalCode); // PostalCode
            sqlStmt.setString(12, country); // Country
            sqlStmt.setString(13, studentType); // StudentType
            sqlStmt.setString(14, leaveOfAbsence); // LeaveOfAbsence
            sqlStmt.setInt(15, studentID); // StudentID (for the WHERE clause)

            System.out.println("SQL Statement Prepared");

            // Execute the update
            sqlStmt.executeUpdate();
            System.out.println(" Student Record was updated!");

            sqlStmt.close();
            c.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int getStudentRecord() {
        int recordCount = 0;
        try {
            Connection c;
            // Establish connection to the database
            // PLACE DB SERVER LINK HERE!
            c = DriverManager.getConnection("--- INPUT LINK TO DB SERVER HERE ---");
            System.out.println("Connection to DB Successful");

            // SQL SELECT statement for retrieving a student's record based on StudentID
            PreparedStatement sqlStmt = c.prepareStatement(
                    "SELECT * FROM Students WHERE StudentID=?"
            );

            sqlStmt.setInt(1, studentID);
            System.out.println("SQL Statement Prepared");
            // execute the statement
            ResultSet rs = sqlStmt.executeQuery();

            // Process the result set
            while (rs.next()) {
                recordCount++;
                firstName       = rs.getString("FirstName");
                lastName        = rs.getString("LastName");
                middleName      = rs.getString("MiddleName");
                birthDate       = rs.getString("BirthDate");
                sex             = rs.getString("Sex");
                email           = rs.getString("Email");
                streetAddress   = rs.getString("StreetAddress");
                barangay        = rs.getString("Barangay");
                city            = rs.getString("City");
                province        = rs.getString("Province");
                postalCode      = rs.getString("PostalCode");
                country         = rs.getString("Country");
                studentType     = rs.getString("StudentType");
                leaveOfAbsence  = rs.getString("LeaveOfAbsence");

                System.out.println("Record "+ studentID +" was retrieved");
            }

            sqlStmt.close();
            c.close();
            return recordCount; // return number of records found
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }


    // getters and setters
    public void setStudentID(int studentID) {
        this.studentID = studentID;
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

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setBarangay(String barangay) {
        this.barangay = barangay;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setStudentType(String studentType) {
        this.studentType = studentType;
    }

    public void setLeaveOfAbsence(String leaveOfAbsence) {
        this.leaveOfAbsence = leaveOfAbsence;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getStudentID() {
        return studentID;
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

    public String getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getBarangay() {
        return barangay;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getSex() {
        return  sex;
    }

    public String getProvince() {
        return province;
    }

    public String getPostalCode() {
        return postalCode;
    }

}