import java.util.ArrayList;
import java.util.Arrays;

public class Team {

    private String name;
    private MainCoach mainCoach;
    private AssistantCoach[] assistantCoaches;
    private Player[] players;
    private ArrayList<Formation> formations;


    public Team(String name) {
        this.name = name;
        assistantCoaches = new AssistantCoach[3];
        players = new Player[25];
    }

    public void assignMainCoach(MainCoach mainCoach) {

        this.mainCoach = mainCoach;


    }

    public boolean addAssistantCoach(AssistantCoach assistantCoach) {

        boolean added = false;

        for (int i = 0; i < assistantCoaches.length && !added; i++) {

            if (assistantCoaches[i] == null) {

                assistantCoaches[i] = assistantCoach;
                added = true;
            }

        }
        return added;

    }

    public boolean addPlayer(Player player) {

        boolean added = false;

        for (int i = 0; i < players.length && !added; i++) {

            if (players[i] == null) {

                players[i] = player;
                added = true;
            }

        }
        return added;



    }

    public void addFormation(Formation formation){

        formations.add(formation);

    }

    public String getName() {
        return name;
    }

    public String getMainCoach() {
        return mainCoach.getName();
    }

    public String getAssitantCoaches() {
        return Arrays.toString(assistantCoaches);
    }


}
