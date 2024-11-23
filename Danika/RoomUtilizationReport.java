
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RoomUtilizationReport {

    private static final String DB = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "p@ssword1";

    public RoomUtilizationReport() {
    	
    }
    
    public void Report(int termId) 
    {
    	
        String query = """
                SELECT		r.RoomCode,
                    		rt.RoomType,
                    		COUNT(res.ReservationID) AS total_reservations,
                    		SUM(TIMESTAMPDIFF(HOUR, sch.StartTime, sch.EndTime)) AS total_usage_hours
                FROM	 	Rooms r JOIN Schedules sch ON r.RoomCode = sch.RoomCode
        						 	JOIN Reservations res ON res.ScheduleID = sch.ScheduleID
                				 	JOIN REF_RoomTypes rt ON r.RoomTypeID = rt.RoomTypeID
                WHERE		res.TermID = ?
                GROUP BY	r.RoomCode, rt.RoomType
                ORDER BY    total_usage_hours DESC;
                """;

        try(Connection conn = DriverManager.getConnection(DB, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) 
        {

            stmt.setInt(1, termId);

            ResultSet rs = stmt.executeQuery();

            System.out.println("Room Utilization Report for Term ID: " + termId + " and School Year: ");
            System.out.println("-------------------------------------------------------------");
            System.out.printf("%-10s %-20s %-15s %-15s%n", "Reserver", "Room Code", "Room Type", "Reservations", "Total Usage Hours");
            System.out.println("-------------------------------------------------------------");

            while(rs.next()) 
            {
                String roomCode = rs.getString("RoomCode");
                String roomType = rs.getString("RoomType");
                int totalReservations = rs.getInt("total_reservations");
                int totalUsageHours = rs.getInt("total_usage_hours");
                System.out.printf("%-10s %-20s %-15d %-15d%n",roomCode, roomType, totalReservations, totalUsageHours);
            }
            System.out.println("-------------------------------------------------------------");

        }catch(Exception e) 
        {
            System.err.println("Error while generating the report: " + e.getMessage());
        }
    }
}
