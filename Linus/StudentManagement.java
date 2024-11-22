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

    public int deleteStudent() {
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
}