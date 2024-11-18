package DBAPP;

public class room_utilization_report {
    // attributes
    public int recordcount = 0;

    public room_utilization_report(){

    }

    public int generate_room_report(){
        // code to generate room report
        recordcount = 0;
        try{

        return recordcount;
        } catch(Exception e){
            System.out.println(e.getMessage());
			return 0;
        }

    }
}

