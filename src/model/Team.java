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

    /**
     * Assigns a main coach to the team
     * <b>Pre: </b>
     * @param mainCoach main coach being assigned
     */

    public void assignMainCoach(MainCoach mainCoach) {

        this.mainCoach = mainCoach;


    }

    /**
     * Assigns an assistant coach to the team
     * <b>Pre: </b>
     * @param assistantCoach assistant coach being assigned
     * @return boolean stating if coach was assigned
     */

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

    /**
     * Adds a new player to the team
     * <b>Pre: </b>
     * @param player player being added to the team
     * @return boolean stating if player was added or not
     */

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

    /**
     * Adds a new formation to the team
     * <b>Pre: </b>
     * @param formation formation being added to the team
     */

    public void addFormation(Formation formation){

        formations.add(formation);

    }

    /**
     * Removes current main coach from the team
     * @param name coach's name
     * @return Message stating if coach was removed or not
     */

    public String removeMainCoach(String name){

      String msg = "Tecnico no despedido";

        if(getMainCoach().getName().equalsIgnoreCase(name)){

            mainCoach = null;
           msg = "Tecnico despedido";

        }

        return msg;

    }

    /**
     * Removes an assistant coach
     * @param name assistant coach's name
     * @return Message stating if coach was removed
     */

    public String removeAssistantCoach(String name){

        String msg = "Tecnico asistente no despedido";
        boolean removed = false;

        for (int i = 0; i < assistantCoaches.length && !removed; i++) {

            if(assistantCoaches[i].getName().equalsIgnoreCase(name)){

                assistantCoaches[i] = null;
                removed = true;
                msg = "Tecnico despedido";

            }

        }
        return msg;

    }

    /**
     * Removes a player from the team
     * @param name name of the player
     * @return Message stating if player was removed
     */

    public String removePlayer(String name){

       String msg = "Jugador no despedido";
      boolean removed = false;

        for (int i = 0; i < players.length && !removed; i++) {
            if(players[i].getName().equalsIgnoreCase(name)){

                players[i] = null;
                removed = true;
                msg = "Jugador despedido";

            }
        }
        return msg;

    }

    /**
     * Returns team's name
     * @return team's name
     */

    public String getName() {
        return name;
    }

    /**
     * Returns the team's main coach (if any)
     * @return team's main coach
     */

    public MainCoach getMainCoach() {
        return mainCoach;
    }

    /**
     * Returns team's assistant coaches
     * @return team's assistant coaches
     */

    public AssistantCoach[] getAssistantCoaches() {
        return assistantCoaches;
    }

    /**
     * Return's team's players
     * @return team's players
     */

    public Player[] getPlayers(){

        return players;


    }

    /**
     * Returns all of the team's existing formations
     * @return team's formations
     */

    public ArrayList<Formation> getFormations() {
        return formations;
    }
}
