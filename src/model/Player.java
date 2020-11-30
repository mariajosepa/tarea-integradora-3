package model;

import model.Employee;

public class Player extends Employee implements Valuable {

    private int jerseyNumber;
    private int scoredGoals;
    private double averageRating;
    private Position position;


    public Player(String name, String id, double salary, int jerseyNumber, int scoredGoals, int averageRating, int position) {
        super(name, id, salary);
        this.jerseyNumber = jerseyNumber;
        this.scoredGoals = scoredGoals;
        this.averageRating = averageRating;
        this.position = Position.values()[position];
    }

    @Override
    public double marketPrice() {

      double marketPrice = 0.0;

       if (getPosition().equals("PORTERO")){
          marketPrice = (getSalary()*12) + (this.averageRating*150);
       }
       if (getPosition().equals("DEFENSOR")){
           marketPrice = (getSalary()*13) + (this.averageRating * 125) + (this.scoredGoals*100);
       }
       if (getPosition().equals("VOLANTE")){
           marketPrice = (getSalary()*14) + (this.averageRating * 135) + (this.scoredGoals*125);
       }
       if (getPosition().equals("DELANTERO")){
           marketPrice = (getSalary()*15) + (this.averageRating * 145) + (this.scoredGoals*150);
       }

        return marketPrice;
    }

    @Override
    public double starLevel() {

        double starLevel = 0.0;

        if (getPosition().equals("PORTERO")){
            starLevel = (this.averageRating*0.9);
        }
        if (getPosition().equals("DEFENSOR")){
            starLevel = (this.averageRating * 0.9) + (this.scoredGoals/100);
        }
        if (getPosition().equals("VOLANTE")){
            starLevel = (this.averageRating * 0.9) + (this.scoredGoals/90);
        }
        if (getPosition().equals("DELANTERO")){
            starLevel =  (this.averageRating * 0.9) + (this.scoredGoals/80);
        }

        return starLevel;
    }


    public String getPosition() {
        return position.name();
    }

    public double getAverageRating() {
        return averageRating;
    }

    public int getScoredGoals() {
        return scoredGoals;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    @Override
    public String getInfo() {

       String msg = super.getInfo();
       msg += "Numero: " + getJerseyNumber()+ "\n";
       msg +=  "Goles anotados: " + getScoredGoals()+ "\n";
       msg +=  "Calificacion promedio: " + getAverageRating()+ "\n";
       msg +=  "Nivel de Estrella: " + starLevel()+ "\n";
       msg +=  "Valor de Mercado: " + marketPrice()+ "\n";
       msg += "------------------------------------" + "\n";
        return msg;
    }
}