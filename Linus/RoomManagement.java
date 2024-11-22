package DBAPP;
import java.sql.*;

public class RoomManagement {
    // Room attributes
    private int roomID;
    private String roomCode;
    private String campusCode;
    private String bldgCode;
    private String type;
    private int termID; // Foreign key to the Terms table

    public RoomManagement() {
        this.roomID = 0;
        this.roomCode = "";
        this.campusCode = "";
        this.bldgCode = "";
        this.type = "";
        this.termID = 0;
    }

    // Method to retrieve a room record
    public int getRoomRecord() {
        int recordCount = 0;
        try {
            Connection c;
            c = DriverManager.getConnection("--- INPUT LINK TO DB SERVER HERE ---");
            System.out.println(">>> Connection to DB Successful!");

            PreparedStatement sqlStmt = c.prepareStatement(
                    "SELECT * FROM Rooms WHERE RoomID=?"
            );

            sqlStmt.setInt(1, roomID);
            System.out.println(">>> SQL Statement Prepared");

            ResultSet rs = sqlStmt.executeQuery();

            while (rs.next()) {
                recordCount++;
                roomCode = rs.getString("RoomCode");
                campusCode = rs.getString("CampusCode");
                bldgCode = rs.getString("BldgCode");
                type = rs.getString("Type");
                termID = rs.getInt("TermID");
                System.out.println("Record " + roomID + " was retrieved.");
            }

            sqlStmt.close();
            c.close();
            return recordCount;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    // Method to add a new room record
    public int addRoom() {
        try {
            Connection c;
            c = DriverManager.getConnection("--- INPUT LINK TO DB SERVER HERE ---");
            System.out.println(">>> Connection to DB Successful!");

            PreparedStatement sqlStmt = c.prepareStatement(
                    "INSERT INTO Rooms (RoomID, RoomCode, CampusCode, BldgCode, Type, TermID) " +
                            "VALUES (?, ?, ?, ?, ?, ?)"
            );

            sqlStmt.setInt(1, roomID);
            sqlStmt.setString(2, roomCode);
            sqlStmt.setString(3, campusCode);
            sqlStmt.setString(4, bldgCode);
            sqlStmt.setString(5, type);
            sqlStmt.setInt(6, termID);

            System.out.println(">>> SQL Statement Prepared");

            sqlStmt.executeUpdate();
            System.out.println("Room Record was created!");

            sqlStmt.close();
            c.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    // Method to update a room record
    public int updateRoom() {
        try {
            Connection c;
            c = DriverManager.getConnection("--- INPUT LINK TO DB SERVER HERE ---");
            System.out.println(">>> Connection to DB Successful!");

            PreparedStatement sqlStmt = c.prepareStatement(
                    "UPDATE Rooms SET RoomCode=?, CampusCode=?, BldgCode=?, Type=?, TermID=? WHERE RoomID=?"
            );

            sqlStmt.setString(1, roomCode);
            sqlStmt.setString(2, campusCode);
            sqlStmt.setString(3, bldgCode);
            sqlStmt.setString(4, type);
            sqlStmt.setInt(5, termID);
            sqlStmt.setInt(6, roomID);

            System.out.println(">>> SQL Statement Prepared");

            sqlStmt.executeUpdate();
            System.out.println("Room Record was updated!");

            sqlStmt.close();
            c.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    // Method to delete a room record
    public int deleteRoom() {
        try {
            Connection c;
            c = DriverManager.getConnection("--- INPUT LINK TO DB SERVER HERE ---");
            System.out.println(">>> Connection to DB Successful!");

            PreparedStatement sqlStmt = c.prepareStatement(
                    "DELETE FROM Rooms WHERE RoomID=?"
            );

            sqlStmt.setInt(1, roomID);

            System.out.println(">>> SQL Statement Prepared");

            sqlStmt.executeUpdate();
            System.out.println("Room Record was deleted!");

            sqlStmt.close();
            c.close();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    // Getters and setters
    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public String getCampusCode() {
        return campusCode;
    }

    public void setCampusCode(String campusCode) {
        this.campusCode = campusCode;
    }

    public String getBldgCode() {
        return bldgCode;
    }

    public void setBldgCode(String bldgCode) {
        this.bldgCode = bldgCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

//    public int getTermID() {
//        return termID;
//    }
//
//    public void setTermID(int termID) {
//        this.termID = termID;
//    }
}
