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
        return 0;
    }

    @Override
    public double starLevel() {
        return 0;
    }
}
