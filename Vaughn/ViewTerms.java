package DBAPP;
import java.sql.*;

public class ViewTerms {
    // Term attributes
    private int termID;
    private int studentID;
    private String academicYearStart;
    private String academicYearEnd;
    private String termStartDate;
    private String termEndDate;
    private String leaveOfAbsenceStatus; // Corrected capitalization

    public ViewTerms() {
        this.termID = 0;
        this.studentID = 0;
        this.academicYearStart = "";
        this.academicYearEnd = "";
        this.termStartDate = "";
        this.termEndDate = "";
        this.leaveOfAbsenceStatus = "";
    }

    // Method to get a term record by TermID and StudentID (view-only)
    public int getTermRecord() {
        int recordCount = 0;
        try (Connection c = DriverManager.getConnection("--- INPUT LINK TO DB SERVER HERE ---")) {
            System.out.println(">>> Connection to DB Successful!");

            PreparedStatement sqlStmt = c.prepareStatement(
                "SELECT * FROM Terms WHERE TermID = ? AND StudentID = ?"
            );

            sqlStmt.setInt(1, termID);
            sqlStmt.setInt(2, studentID);
            System.out.println(">>> SQL Statement Prepared");

            ResultSet rs = sqlStmt.executeQuery();

            while (rs.next()) {
                recordCount++;
                academicYearStart = rs.getString("AcademicYearStart");
                academicYearEnd = rs.getString("AcademicYearEnd");
                termStartDate = rs.getString("TermStartDate");
                termEndDate = rs.getString("TermEndDate");
                leaveOfAbsenceStatus = rs.getString("LeaveOfAbsenceStatus");
                System.out.println("Record for TermID " + termID + " and StudentID " + studentID + " was retrieved");
            }

            return recordCount; // Return the number of records retrieved
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return 0; // Return 0 if no records found or an error occurs
        }
    }

    // Getters for Term attributes
    public int getTermID() {
        return termID;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getAcademicYearStart() {
        return academicYearStart;
    }

    public String getAcademicYearEnd() {
        return academicYearEnd;
    }

    public String getTermStartDate() {
        return termStartDate;
    }

    public String getTermEndDate() {
        return termEndDate;
    }

    public String getLeaveOfAbsenceStatus() {
        return leaveOfAbsenceStatus;
    }

    // Setters for Term attributes
    public void setTermID(int termID) {
        this.termID = termID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setAcademicYearStart(String academicYearStart) {
        this.academicYearStart = academicYearStart;
    }

    public void setAcademicYearEnd(String academicYearEnd) {
        this.academicYearEnd = academicYearEnd;
    }

    public void setTermStartDate(String termStartDate) {
        this.termStartDate = termStartDate;
    }

    public void setTermEndDate(String termEndDate) {
        this.termEndDate = termEndDate;
    }

    public void setLeaveOfAbsenceStatus(String leaveOfAbsenceStatus) {
        this.leaveOfAbsenceStatus = leaveOfAbsenceStatus;
    }
}
