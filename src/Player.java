public class Player extends Employee implements Valuable {

    private int jerseyNumber;
    private int scoredGoals;
    private int averageRating;
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

        return 0;
    }

    @Override
    public double starLevel() {
        return 0;
    }


}