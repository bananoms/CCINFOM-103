package DBAPP;
import java.sql.*;

public class ViewTerms {
    // Term attributes
    private int termID;
    private String termNumber;
    private String academicYearStart;
    private String academicYearEnd;
    private String termStartDate;
    private String termEndDate;
    private int holidayID; // Foreign key to the Holidays table

    public ViewTerms() {
        this.termID = 0;
        this.termNumber = "";
        this.academicYearStart = "";
        this.academicYearEnd = "";
        this.termStartDate = "";
        this.termEndDate = "";
        this.holidayID = 0;
    }

    // Method to get a term record by TermID (view-only)
    public int getTermRecord() {
        int recordCount = 0;
        try {
            Connection c;
            c = DriverManager.getConnection("--- INPUT LINK TO DB SERVER HERE ---");
            System.out.println(">>> Connection to DB Successful!");

            PreparedStatement sqlStmt = c.prepareStatement(
                    "SELECT * FROM Terms WHERE TermID=?"
            );

            sqlStmt.setInt(1, termID);
            System.out.println(">>> SQL Statement Prepared");

            ResultSet rs = sqlStmt.executeQuery();

            while (rs.next()) {
                recordCount++;
                termNumber = rs.getString("TermNumber");
                academicYearStart = rs.getString("AcademicYearStart");
                academicYearEnd = rs.getString("AcademicYearEnd");
                termStartDate = rs.getString("TermStartDate");
                termEndDate = rs.getString("TermEndDate");
                holidayID = rs.getInt("HolidayID");
                System.out.println("Record " + termID + " was retrieved");
            }

            sqlStmt.close();
            c.close();
            return recordCount;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    // Getters for Term attributes
    public int getTermID() {
        return termID;
    }

    public String getTermNumber() {
        return termNumber;
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

    public int getHolidayID() {
        return holidayID;
    }

    // Setters for Term attributes (optional)
    public void setTermID(int termID) {
        this.termID = termID;
    }
}
