package model;

import model.Coach;

public class MainCoach extends Coach implements Valuable {

    private int teamsInCharge;
    private int wonChampionships;

    public MainCoach(String name, String id, double salary, int teamsInCharge, int wonChampionships) {
        super(name, id, salary);
        this.teamsInCharge = teamsInCharge;
        this.wonChampionships = wonChampionships;
    }

    /**
     * Return's number of teams in charge
     * @return teams in charge
     */

    public int getTeamsInCharge() {
        return teamsInCharge;
    }

    @Override
    public double marketPrice() {
        return (getSalary() * 10) + (getYearsExperience() * 100) + (getWonChampionships()*50);
    }

    @Override
    public double starLevel() {

        return (5+(getWonChampionships()/10));
    }

    /**
     * Return's number of won championships
     * @return
     */

    public int getWonChampionships() {
        return wonChampionships;
    }

    @Override
    public String getInfo() {

        String msg = super.getInfo();
        msg += "Equipos a Cargo: " + getTeamsInCharge()+ "\n";
        msg +=  "Campeonatos Ganados " + getWonChampionships()+ "\n";
        msg +=  "Nivel de Estrella: " + starLevel()+ "\n";
        msg +=  "Valor de Mercado: " + marketPrice()+ "\n";
        msg += "------------------------------------" + "\n";
        return msg;



    }


}
