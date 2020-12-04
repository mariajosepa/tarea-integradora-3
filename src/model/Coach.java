package model;

public abstract class Coach extends Employee {

    private int experience;

    public Coach(String name, String id, double salary, int experience) {

        super(name, id, salary);
        this.experience = experience;
    }

    /**
     * Return's coach's years of experience
     * @return years of experience
     */

    public int getYearsExperience() {
        return experience;
    }
}
