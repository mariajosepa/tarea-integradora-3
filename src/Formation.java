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
    private int [] line6;
    private int [] line7;


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
        line6 = new int[] {0,1,1,1,1,1,1};
        line7 = new int[] {1,1,1,1,1,1,1};

    }

    public int[][] assignFormationLines(){

        String [] splitFormation = fieldFormation.split("-");

        int formationLines = splitFormation.length;
        int playerDistribution =  (int) 10/formationLines;

        int counter = 0;

        if(formationLines % 2 == 0){

            for(int i = 1; i < 10 && counter < formationLines; i= i + playerDistribution) {

                if(assignFormation(splitFormation[counter]) != null) {

                    field[i] = assignFormation(splitFormation[counter]);

                    counter++;

                    System.out.println("EVEN");

                }
            }

        }

        else{

            for(int i = 1; i < 10 && counter < formationLines; i = i + playerDistribution) {

                if(assignFormation(splitFormation[counter]) != null) {

                    field[i] = assignFormation(splitFormation[counter]);

                    counter++;

                    System.out.println("ODD");
                }
            }




        }









        return field;

    }

    public int[] assignFormation(String position){

        if(position.equals("1")){
            return line1;

        }
       else if(position.equals("2")){
            return line2;

        }

        else if(position.equals("3")){
            return line3;

        }

        else if (position.equals("4")){

            return line4;

        }

        else if (position.equals("5")){

          return line5;

        }

        else if(position.equals("6")){

            return line6;

        }

        else if(position.equals("7")){

            return line7;

        }

        else{
            return null;

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


    public String getTactic() {
        return tactic.name();
    }

    public String getDate() {
        return date;
    }
}
