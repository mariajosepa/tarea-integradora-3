package model;

import model.AssistantCoach;
import model.Formation;
import model.MainCoach;
import model.Player;

import java.util.ArrayList;

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
        mainCoach = null;
        formations = new ArrayList<Formation>();
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

    public AssistantCoach[] getAssistantCoaches() {
        return assistantCoaches;
    }

    public Player[] getPlayers(){

        return players;


    }

    public ArrayList<Formation> getFormations() {
        return formations;
    }
}
