package DBAPP;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DegreeDemographicsReport {
    private int startYear;
    private int endYear;
    private int term;

    public int generateGenderDemographics() {
        int recordCount = 0;
        try {
            Connection c;
            c = DriverManager.getConnection(" -- INPUT MYSQL CODE --");
            System.out.println("Connection to DB Successful");

            PreparedStatement sqlStmt = c.prepareStatement(
                    ""
            );

            sqlStmt.setInt(1, startYear);
            sqlStmt.setInt(2, endYear);
            sqlStmt.setInt(3, term);

            System.out.println("SQL Statement Prepared");
            ResultSet rs = sqlStmt.executeQuery();

            while (rs.next()) {
                // display results
                System.out.println("Degree Name                          | Male | Female");
                recordCount++;
            }

            sqlStmt.close();
            c.close();
            return recordCount;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int generateAgeDemographics() {
        int recordCount = 0;
        try {
            Connection c;
            c = DriverManager.getConnection(" -- INPUT MYSQL CODE --");
            System.out.println("Connection to DB Successful");

            PreparedStatement sqlStmt = c.prepareStatement(
                    ""
            );

            sqlStmt.setInt(1, startYear);
            sqlStmt.setInt(2, endYear);
            sqlStmt.setInt(3, term);

            System.out.println("SQL Statement Prepared");
            ResultSet rs = sqlStmt.executeQuery();

            while (rs.next()) {
                // display results
                System.out.println("Degree Name                          | Male | Female");
                recordCount++;
            }

            sqlStmt.close();
            c.close();
            return recordCount;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int generateEnrollmentDemographics() {
        int recordCount = 0;
        try {
            Connection c;
            c = DriverManager.getConnection(" -- INPUT MYSQL CODE --");
            System.out.println("Connection to DB Successful");

            PreparedStatement sqlStmt = c.prepareStatement(
                    ""
            );

            sqlStmt.setInt(1, startYear);
            sqlStmt.setInt(2, endYear);
            sqlStmt.setInt(3, term);

            System.out.println("SQL Statement Prepared");
            ResultSet rs = sqlStmt.executeQuery();

            while (rs.next()) {
                // display results
                System.out.println("Degree Name                          | Male | Female");
                recordCount++;
            }

            sqlStmt.close();
            c.close();
            return recordCount;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int generateStatusDemographics () {
        int recordCount = 0;
        try {
            Connection c;
            c = DriverManager.getConnection(" -- INPUT MYSQL CODE --");
            System.out.println("Connection to DB Successful");

            PreparedStatement sqlStmt = c.prepareStatement(
                    ""
            );

            sqlStmt.setInt(1, startYear);
            sqlStmt.setInt(2, endYear);
            sqlStmt.setInt(3, term);

            System.out.println("SQL Statement Prepared");
            ResultSet rs = sqlStmt.executeQuery();

            while (rs.next()) {
                // display results
                System.out.println("Degree Name                       | Regular | Irregular | Graduating ");
                recordCount++;
            }

            sqlStmt.close();
            c.close();
            return recordCount;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int generateAveCGPADemographics () {
        int recordCount = 0;
        try {
            Connection c;
            c = DriverManager.getConnection(" -- INPUT MYSQL CODE --");
            System.out.println("Connection to DB Successful");

            PreparedStatement sqlStmt = c.prepareStatement(
                    ""
            );

            sqlStmt.setInt(1, startYear);
            sqlStmt.setInt(2, endYear);
            sqlStmt.setInt(3, term);

            System.out.println("SQL Statement Prepared");
            ResultSet rs = sqlStmt.executeQuery();

            while (rs.next()) {
                // display results
                System.out.println("Degree Name                           | Average CGPA ");
                recordCount++;
            }

            sqlStmt.close();
            c.close();
            return recordCount;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

}