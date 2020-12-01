package model;

import java.util.Arrays;

public class Formation {

    private String date;
    private Tactic tactic;
    private String fieldFormation;
    private int[][] field;
    private int[] line1;
    private int[] line2;
    private int[] line3;
    private int[] line4;
    private int[] line5;
    private int[] line6;
    private int[] line7;


    public Formation(String date, int tactic, String fieldFormation) {

        this.date = date;
        this.tactic = Tactic.values()[tactic-1];

        this.fieldFormation = fieldFormation;
        field = new int[][]
                {{0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}, //forward
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}, //mid
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}, //defense
                {0, 0, 0, 0, 0, 0, 0}};


        line1 = new int[]{0, 0, 0, 1, 0, 0, 0};
        line2 = new int[]{0, 1, 0, 0, 0, 1, 0};
        line3 = new int[]{0, 1, 0, 1, 0, 1, 0};
        line4 = new int[]{0, 1, 1, 0, 1, 1, 0};
        line5 = new int[]{0, 1, 1, 1, 1, 1, 0};
        line6 = new int[]{0, 1, 1, 1, 1, 1, 1};
        line7 = new int[]{1, 1, 1, 1, 1, 1, 1};

    }

    /**
     * Takes user's input (eg. 4-4-2) and distributes the players evenly across the field matrix
     * <b>Pre: </b>
     * @return The matrix playing field with all players distributed in the specified formation
     */

    public int[][] assignFormationLines() {

        String[] splitFormation = fieldFormation.split("-");

        int formationLines = splitFormation.length;
        int playerDistribution = (int) 10 / formationLines;

        int counter = 0;

        if (formationLines % 2 == 0) {

            for (int i = 8; i > 0 && counter < formationLines; i = i - playerDistribution) {

                if (assignFormation(splitFormation[counter]) != null) {

                    field[i] = assignFormation(splitFormation[counter]);

                    counter++;


                }
            }

        } else {

            for (int i = 8; i > 0 && counter < formationLines; i = i - playerDistribution) {

                if (assignFormation(splitFormation[counter]) != null) {

                    field[i] = assignFormation(splitFormation[counter]);

                    counter++;

                }
            }


        }


        return field;

    }

    /**
     * Takes a number (string) and returns a particular line formation array to match said number
     * @param position
     * @return formation line
     */

    public int[] assignFormation(String position) {

        if (position.equals("1")) {
            return line1;

        } else if (position.equals("2")) {
            return line2;

        } else if (position.equals("3")) {
            return line3;

        } else if (position.equals("4")) {

            return line4;

        } else if (position.equals("5")) {

            return line5;

        } else if (position.equals("6")) {

            return line6;

        } else if (position.equals("7")) {

            return line7;

        } else {
            return null;

        }


    }

    /**
     * Return's the formation, formatted and with information about its tactic, distribution and players
     * <b>Pre: </b> A valid formation has to be created
     * @return field formation information
     */

    public String getFieldFormation() {

        int[][] finalFormation = assignFormationLines();

        String playersInField = "TACTICA: " + getTactic() + "\n";
        playersInField += "FECHA: " + getDate() + "\n";

        for (int i = 0; i <= 9; i++) {

            playersInField += Arrays.toString(finalFormation[i]) + "\n";

        }

        playersInField+= "DEFENSA: " + countDefense() + "\n";
        playersInField+= "MEDIO CAMPO: " + countMidfield() + "\n";
        playersInField+= "DELANTEROS: " + countForwards() + "\n";
        playersInField+= "FORMACION: " + formatName() + "\n";

        playersInField += "---------------------------------------" + "\n";


        return playersInField;

    }

    /**
     * Return's the formation's tactic
     * @return formation's tactic
     */

    public String getTactic() {
        return tactic.name();
    }

    /**
     * Return's the formation's added date
     * @return Formation's date
     */

    public String getDate() {
        return date;
    }

    /**
     * Counts how many players are in the lower half of the field matrix
     * @return how many defense are in the field
     */

    public int countDefense() {

        int counter = 0;

        for (int i = 9; i > 5; i--) {

            for (int j = 0; j < 7; j++) {

                counter += field[i][j];

            }

        }

        return counter;
    }

    /**
     * Counts number of players in the mid field matrix
     * @return number of midfielders
     */

    public int countMidfield() {

        int counter = 0;

        for(int i = 5; i > 2; i--) {

            for(int j = 0; j < 7; j++) {

                counter += field[i][j];


            }

        }

        return counter;
    }

    /**
     * Counts number of players in the upper half of the field matrix
     * @return number of forwards
     */

    public int countForwards(){

        int counter = 0;

        for(int i = 2; i > -1; i--) {

            for(int j = 0; j < 7; j++) {

                counter += field[i][j];


            }

        }

        return counter;





    }

    /**
     * Transform's the matrix into its equivalent format (A-B-C)
     * @return Matrix in A-A-A form
     */

    public String formatName() {

        boolean keepCounting = true;
        String formation = "";
        int sum = 0;
        int validRows = 0;
        int count = 0;
        int index = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 7; j++) {

                sum += field[i][j];

            }
            if (sum > 0) {

                validRows++;
                sum = 0;
            }

        }

        sum = 0;

       if(validRows>0) {
        for (int i = 9; i > -1 && keepCounting; i--) {

            if (count != validRows-1) {

                for (int j = 0; j < 7 && keepCounting; j++) {
                    sum += field[i][j];
                }

                if (sum != 0) {

                    formation += sum + "-";
                    sum = 0;
                    count++;
                }
            } else {

                keepCounting = false;
                index = i;
            }
        }

        sum = 0;
        keepCounting = true;


        for (int i = index; i > -1 && keepCounting; i--) {

            for (int j = 0; j < 7 && keepCounting; j++) {

                sum += field[i][j];

            }
            if (sum > 0) {

                formation += sum;
                keepCounting = false;

            }
        }
    }

        return formation;

    }



}
