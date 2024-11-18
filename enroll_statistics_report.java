package DBAPP;

public class enroll_statistics_report {
    // attributes
    public int recordcount = 0;

    public enroll_statistics_report(){

    }

    public int generate_statistics_report(){
        // code to generate statistics report
        recordcount = 0;
        try{

        return recordcount;
        } catch(Exception e){
            System.out.println(e.getMessage());
			return 0;
        }

    }
}
