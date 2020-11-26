import java.util.Arrays;

public class Formation {

    private String date;
    private Tactic tactic;
    private String fieldFormation;
    private int [][] field;
    private int [] line1;
    private int [] line2;
    private int [] line3;
    private int [] line4;
    private int [] line5;


    public Formation(String date, int tactic, String fieldFormation){

        this.date = date;
        this.tactic = Tactic.values()[tactic];
        this.fieldFormation = fieldFormation;
        field = new int[][]{{0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0}, //defense
                            {0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0}, //mid
                            {0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0}, //forward
                            {0,0,0,0,0,0,0}};


        line1 = new int[] {0,0,0,1,0,0,0};
        line2 = new int[] {0,1,0,0,0,1,0};
        line3 = new int[] {0,1,0,1,0,1,0};
        line4 = new int[] {0,1,1,0,1,1,0};
        line5 = new int[] {0,1,1,1,1,1,0};
    }

    public int[][] assignFormationLines(){

        String [] splitFormation = fieldFormation.split("-");

        String defense = splitFormation[0];
        String mid = splitFormation[1];
        String offense = splitFormation[2];


        assignDefense(defense);
        assignMid(mid);
        assignOffense(offense);


        return field;

    }

    public void assignDefense(String defense){

        if(defense.equals("1")){
            field[2] = line1;

        }
       else if(defense.equals("2")){
            field[2] = line2;

        }

        else if(defense.equals("3")){
            field[2] = line3;

        }

        else if (defense.equals("4")){

            field[2] = line4;

        }

        else if (defense.equals("5")){

            field[3] = line5;

        }




    }

    public void assignMid(String mid){

        if(mid.equals("1")){
            field[5] = line1;

        }
        else if(mid.equals("2")){
            field[5] = line2;

        }

        else if(mid.equals("3")){
            field[5] = line3;

        }

        else if (mid.equals("4")){

            field[5] = line4;

        }

        else if (mid.equals("5")){

            field[5] = line5;

        }



    }

    public void assignOffense(String offense){

        if(offense.equals("1")){
            field[8] = line1;

        }
        else if(offense.equals("2")){
            field[8] = line2;

        }

        else if(offense.equals("3")){
            field[8] = line3;

        }

        else if (offense.equals("4")){

            field[8] = line4;

        }

        else if (offense.equals("5")){

            field[8] = line5;

        }






    }

    public String getFieldFormation(){

        int [][] finalFormation = assignFormationLines();

        String playersInField = Arrays.toString(finalFormation[0]) + "\n";

        for (int i = 1; i <= 9 ; i++) {

           playersInField += Arrays.toString(finalFormation[i]) + "\n";

        }


        return playersInField;

    }




}
