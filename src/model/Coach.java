package model;

public abstract class Coach extends Employee {

    private int yearsExperience;

    public Coach(String name, String id, double salary) {

        super(name, id, salary);
    }

    public int getYearsExperience() {
        return yearsExperience;
    }
}
