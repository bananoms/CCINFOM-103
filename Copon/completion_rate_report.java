package DBAPP;

public class completion_rate_report {
    // attributes
    public int recordcount = 0;

    public completion_rate_report(){

    }

    public int generate_completion_report(){
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
