package DBAPP;

public class degree_demographics_report {
    // attributes
    public int recordcount = 0;

    public degree_demographics_report(){

    }

    public int generate_demographics_report(){
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
