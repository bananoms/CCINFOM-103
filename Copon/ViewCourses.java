package DBAPP;
import java.sql.*;

public class ViewCourses {
    // Course attributes
    private String courseCode;
    private String courseName;
    private int departmentID; // Foreign key to the Departments table
    private int units;

    public ViewCourses() {
        this.courseCode = "";
        this.courseName = "";
        this.departmentID = 0;
        this.units = 0;
    }

    // Method to get a course record by CourseCode (view-only)
    public int getCourseRecord() {
        int recordCount = 0;
        try {
            Connection c;
            c = DriverManager.getConnection("--- INPUT LINK TO DB SERVER HERE ---");
            System.out.println(">>> Connection to DB Successful!");

            // SQL SELECT statement for retrieving a course record based on CourseCode
            PreparedStatement sqlStmt = c.prepareStatement(
                    "SELECT s.studentID, c.CourseCode, g.GradeUnits, 
                     
                     
                     FROM Students s LEFT JOIN Terms t ON s.TermID = t.TermID 
                                     LEFT JOIN Courses c ON t.TermId = c.TermId
                                     LEFT JOIN Grades g ON c.CourseCode = g.CourseCode
                                     LEFT JOIN REF_COURSES rc c.CourseCode = rc.CourseCode
                    "
            );

            sqlStmt.setString(1, courseCode);
            System.out.println(">>> SQL Statement Prepared");

            ResultSet rs = sqlStmt.executeQuery();

            while (rs.next()) {
                recordCount++;
                courseName = rs.getString("CourseName");
                departmentID = rs.getInt("DepartmentID");
                units = rs.getInt("Units");
                System.out.println("Record " + courseCode + " was retrieved");
            }

            sqlStmt.close();
            c.close();
            return recordCount; // Return number of records found
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    // Getters for Course attributes
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public int getUnits() {
        return units;
    }

    // Setters for Course attributes (optional)
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
