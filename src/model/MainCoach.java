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


    @Override
    public double marketPrice() {
        return (getSalary() * 10) + (getYearsExperience() * 100) + (getWonChampionships()*50);
    }

    @Override
    public double starLevel() {

        return (5+(getWonChampionships()/10));
    }

    public int getWonChampionships() {
        return wonChampionships;
    }

    @Override
    public String getInfo() {
        return null;
    }
}
