package model;

import model.*;

import java.util.ArrayList;
import java.util.Arrays;

public class SoccerClub {

    private final static int dressingRoomRows = 7;
    private final static int dressingRoomAcolumns = 6;
    private final static int dressingRoomBcolumns = 7;

    private String name;
    private String nit;
    private String foundingDate;
    private ArrayList<Employee> employees;
    private Team[] teams;
    private int[][] dressingRoomA;
    private int[][] dressingRoomB;
    private String [][] offices;

    public SoccerClub() {
        name = "Club del Rey";
        nit = "12345678";
        foundingDate = "4/1/1970";
        employees = new ArrayList<Employee>();
        dressingRoomA = new int[][]{{0,0,0,0,0,0}, //0,2,4
                                    {0,0,0,0,0,0}, //1,3,5
                                    {0,0,0,0,0,0}, //0,2,4
                                    {0,0,0,0,0,0},
                                    {0,0,0,0,0,0},
                                    {0,0,0,0,0,0},
                                    {0,0,0,0,0,0}};

        dressingRoomB = new int[][]{{0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0},};
        offices = new String[6][6];
        teams = new Team[2];
        Team teamA = new Team("FC JAVA");
        Team teamB = new Team( "FC APO");
        teams[0] = teamA;
        teams[1] = teamB;

    }

    /**
     * Method that finds x employee (by name) and removes them from the active employee list
     * <b> Pre: </b> At least one employee has to be hired in order to be fired
     * @param name Employee to be fired
     * @return Message stating if employee could be successfully fired
     */

    public String fireEmployee(String name){

        String msg = "No se encontro un empleado con ese nombre";

        if(findEmployee(name) != null){


            if(findEmployee(name) instanceof MainCoach && teams[0].getMainCoach().getName().equalsIgnoreCase(name)){

                employees.remove(findEmployee(name));
                return  teams[0].removeMainCoach(name) +" de "+ teams[0].getName() + "\n";
            }

            else if(findEmployee(name) instanceof MainCoach && teams[1].getMainCoach().getName().equalsIgnoreCase(name)){

                employees.remove(findEmployee(name));
                return teams[1].removeMainCoach(name)  +" de "+ teams[1].getName()+ "\n";
            }

            else if(findEmployee(name) instanceof AssistantCoach){

                AssistantCoach [] assistantCoaches  = teams[0].getAssistantCoaches();

                for(int i = 0; i <assistantCoaches.length ; i++) {

                    if(assistantCoaches[i].getName().equalsIgnoreCase(name)){

                        employees.remove(findEmployee(name));
                        return teams[0].removeAssistantCoach(name)  +" de "+ teams[0].getName()+ "\n";
                    }
                }

                assistantCoaches  = teams[1].getAssistantCoaches();

                for(int i = 0; i <assistantCoaches.length ; i++) {

                    if(assistantCoaches[i].getName().equalsIgnoreCase(name)){

                        employees.remove(findEmployee(name));
                        return teams[1].removeAssistantCoach(name)  +" de "+ teams[1].getName()+ "\n";

                    }

                }

            }
        else if(findEmployee(name) instanceof Player){

                Player [] players  = teams[0].getPlayers();
                for(int i = 0; i <players.length ; i++) {

                    if(players[i].getName().equalsIgnoreCase(name)){

                        employees.remove(findEmployee(name));
                        return teams[0].removePlayer(name)  +" de "+ teams[0].getName()+ "\n";
                    }

                }

                players  = teams[1].getPlayers();

                for(int i = 0; i <players.length ; i++) {

                    if(players[i].getName().equalsIgnoreCase(name)){

                             employees.remove(findEmployee(name));
                            return teams[1].removePlayer(name) +" de "+ teams[1].getName()+ "\n";


                    }

                }

            }
        else{

            employees.remove(findEmployee(name));
            return "Empleado "+ findEmployee(name).getName() + "despedido" +"\n";

            }


        }

        return msg;
    }

    /**
     *Method that hires and employee that is also a main coach
     * <b>Pre: </b>
     * @param name name of the coach
     * @param id assigned employee id
     * @param salary earning salary
     * @param teamsInCharge number of teams coach has directed
     * @param wonChampionships number of won championships
     * @return Message stating if employee could be successfully hired
     */

    public String hireEmployee(String name, String id, double salary,int teamsInCharge, int wonChampionships){

        MainCoach mainCoach = new MainCoach(name, id, salary, teamsInCharge, wonChampionships);

        employees.add(mainCoach);
        mainCoach.setIsActiveOFF();

        return "Nuevo tecnico contratado" + "\n";


    }

    /**
     * Method that hires and employee that is also an assistant coach
     * <b>Pre: </b>
     * @param salary earning salary
     * @param wasPro number stating if person was a professional yes(1) no(2)
     * @param expertise number that represents 1 of 4 expertises
     * @param name name of the coach
     * @param id assigned employee id
     * @return Message stating if employee could be successfully hired
     */

    public String hireEmployee(double salary, char wasPro, int expertise, String name, String id){

        expertise--;

        AssistantCoach assistantCoach = new AssistantCoach(salary,wasPro,expertise,name,id);

        employees.add(assistantCoach);
        assistantCoach.setIsActiveOFF();

        return "Nuevo asistente tecnico contratado" + "\n";



    }

    /**
     * Method that hires and employee that is also a player
     * <b>Pre: </b>
     * @param name name of the coach
     * @param id assigned employee id
     * @param salary earning salary
     * @param jerseyNumber jersey number
     * @param scoredGoals number of scored goals
     * @param averageRating average player rating
     * @param position number that represents 1 of 4 positions
     * @return Message stating if employee could be successfully hired
     */

    public String hireEmployee(String name, String id, double salary, int jerseyNumber, int scoredGoals, double averageRating, int position){

        position--;

        Player player = new Player(name, id, salary, jerseyNumber, scoredGoals,averageRating,position);

        employees.add(player);
        player.setIsActiveOFF();

        return "Nuevo jugador contratado" + "\n";




    }

    /**
     * Method that finds a specific employee using their name
     * <b>Pre: </b>
     * @param name employee to be found's name
     * @return the employee, if it was found
     */

    public Employee findEmployee(String name){

        for(Employee employee : employees){

            if (employee.getName().equalsIgnoreCase(name)){

                return employee;

            }
        }

        return null;

    }

    /**
     * Method that adds an employee of type player to a team
     * <b>Pre: </b> At least one employee of type player has to be hired
     * @param name name of the player
     * @param team team where player is being assigned (1 or 2)
     * @return Message stating if player was added to the team
     */

    public String addPlayerToTeam(String name, int team){

        team = team - 1;
        boolean added = false;

        if(findEmployee(name) != null && findEmployee(name) instanceof Player){

            added = teams[team].addPlayer((Player) findEmployee(name));

        }

        if(added){

            findEmployee(name).setIsActiveON();
            return "Jugador agregado al equipo " + teams[team].getName() + "\n";

        }

        else{

            Player [] players = teams[0].getPlayers();
            int counter = 0;

            for (int i = 0; i < players.length; i++) {

                if(players[i] == null){

                    counter++;

                }

            }

            String msg = ((counter == 25) ? "Ese empleado no ha sido contratado" : "No hay cupo para mas jugadores en el equipo " + teams[team].getName() + "\n" );
            return msg;

        }



    }

    /**
     * Method that adds an employee of type assistant coach to a team
     * <b>Pre: </b>  At least one employee of type assistant coach has to be hired
     * @param team team where coach is being assigned (1 or 2)
     * @param name name of the assistant coach
     * @return Message stating if coach was added to the team
     */

    public String assignAssistantCoach(int team, String name){

        boolean added = false;
        team = team - 1;
        if(findEmployee(name) != null && findEmployee(name) instanceof AssistantCoach){

           added = teams[team].addAssistantCoach((AssistantCoach) findEmployee(name));

        }

        if(added){
            findEmployee(name).setIsActiveON();
            return "Tecnico asistente agregado a "+ teams[team].getName() + "\n";

        }

        else{

            AssistantCoach [] assistantCoaches = teams[0].getAssistantCoaches();
            int counter = 0;

            for (int i = 0; i < assistantCoaches.length; i++) {

                if(assistantCoaches[i] == null){

                    counter++;

                }

            }

            String msg = ((counter==3) ?  "Ese empleado no ha sido contratado" : "No hay mas cupos para tecnicos asistentes, puestos ocupados por " + Arrays.toString(teams[0].getAssistantCoaches()) + "\n" );
            return msg ;


        }

    }

    /**
     *  Method that adds an employee of type main coach to a team
     *  <b>Pre: </b>  At least one employee of type  coach has to be hired
     * @param team team where coach is being assigned (1 or 2)
     * @param name name of the  coach
     * @return Message stating if coach was added to the team
     */

    public String assignMainCoach(int team, String name){

        boolean added = false;
        team = team - 1;
        if(findEmployee(name) != null && findEmployee(name) instanceof MainCoach && teams[team].getMainCoach() == null){

            teams[team].assignMainCoach((MainCoach) findEmployee(name));
            added = true;
        }

        if(added){
            findEmployee(name).setIsActiveON();
            return "Tecnico agregado a "+ teams[team].getName() + "\n";

        }

        else{

            String msg = ((teams[0].getMainCoach() != null) ? "Puesto ocupado por "+ teams[0].getMainCoach().getName()  : "Ese empleado no ha sido contratado");
            return msg;



        }




    }

    /**
     * Adds a formation to a desired team
     *  <b>Pre: </b>  Input must be a String of number with format A-B-C, where A+B+C= 10
     * @param team team where formation is going to be added (1 or 2)
     * @param date date of creation
     * @param tactic 1 of 4 tactics that describe the formation
     * @param fieldFormation String containig the field formation
     * @return Message stating if formation was added to the team
     */

    public String addTeamFormation(int team, String date, int tactic, String fieldFormation) {

        Formation newFormation = new Formation(date, tactic, fieldFormation);
        String msg = "Formacion invalida (no se admiten mas de 7 jugadores en una fila y los valores deben sumar a 10)";

        String[] splitFormation = fieldFormation.split("-");
        int sum = 0;

        for (int i = 0; i < splitFormation.length; i++) {

            sum = sum + Integer.parseInt(splitFormation[i]);

        }

        if(sum == 10){
        switch (team) {

            //model.Team A
            case 1:
                teams[0].addFormation(newFormation);
                msg = "Formacion agregada al equipo: " + teams[0].getName() + "\n";
                break;


            //model.Team B
            case 2:

                teams[1].addFormation(newFormation);
                msg = "Formacion agregada al equipo: " + teams[1].getName() + "\n";
                break;


            default:

                msg = "Por favor ingrese una opcion valida";


                break;

        }
    }
        return msg;


    }

    /**
     * Method that displays information about a team
     *  <b>Pre: </b>
     * @param team team to be displayed (1 or 2)
     * @return All members in a team and information about each one
     */

    public String displayTeam(int team){

        team = team - 1;

        String msg = "Tecnicos: " + "\n";

        for(Employee employee : employees){

            if (employee instanceof MainCoach && teams[team].getMainCoach() != null && teams[team].getMainCoach().getName().equals(employee.getName())){

                msg += employee.getInfo();

            }

        }

      msg += "Asistentes Tecnicos: " + "\n";
        for(Employee employee : employees){

            if (employee instanceof AssistantCoach){

                AssistantCoach [] assistantCoaches = teams[team].getAssistantCoaches();

                for (int i = 0; i < assistantCoaches.length; i++) {

                    if(assistantCoaches[i] != null && employee.getName().equals(assistantCoaches[i].getName())){

                        msg += employee.getInfo();

                    }
                }



            }

        }

        msg += "Jugadores: " + "\n";

        for(Employee employee : employees){

            if (employee instanceof Player && Arrays.asList(teams[team].getPlayers()).contains(employee.getName())){

                msg += employee.getInfo();

            }

        }

        return msg;
    }

    /**
     * Method that displays all employees of the club
     *  <b>Pre: </b>
     * @return Employees of the club and information about each one
     */

    public String displayEmployees(){

        String msg = "TECNICOS"+"\n";

        for(Employee employee : employees){

            if(employee instanceof MainCoach){

                msg += employee.getInfo();

            }
        }

        msg += "ASISTENTES TECNICOS"+"\n";

        for(Employee employee : employees){

            if(employee instanceof AssistantCoach){

                msg += employee.getInfo();

            }
        }

        msg += "JUGADORES"+"\n";

        for(Employee employee : employees){

            if(employee instanceof AssistantCoach){

                msg += employee.getInfo();

            }
        }

        return msg;
    }

    /**
     * Method that displays all of a team's added formations
     * <b>Pre: </b>
     * @param team team to be displayed (1 or 2)
     * @return all added formation of team x
     */

    public String displayTeamFormations(int team){

        int chosenTeam = team - 1;
       ArrayList<Formation> formations = teams[chosenTeam].getFormations();

       String msg = teams[chosenTeam].getName() + "\n";


       if(formations != null) {
           for(Formation formation : formations) {

               msg += formation.getFieldFormation() +  "\n";

           }

           return msg;
       }

        return "No hay alineaciones disponibles";
    }

    /**
     * Method that displays distribution of players in dressing room A
     * <b>Pre: </b>
     * @return Dressing room A arrangements
     */

    public String displayPlayersDressingRoomA(){

            boolean[][] positions = new boolean[][]
                            {{true, false, true, false, true, false},
                            {false, true, false, true, false, true},
                            {true, false, true, false, true, false},
                            {false, true, false, true, false, true},
                            {true, false, true, false, true, false},
                            {false, true, false, true, false, true},
                            {true, false, true, false, true, false}};


        Player[] players = teams[0].getPlayers();
        int index  = 0;

        for(int i = 0; i < 7; i++) {

            for(int j = 0; j < 6; j++) {

                if(players[index] != null && positions[i][j]){

                    dressingRoomA[i][j] = players[index].getJerseyNumber();
                    index++;

                }

            }

        }

        String playersInDressingRoomA = Arrays.toString(dressingRoomA[0]) + "\n";

        for (int i = 1; i < 6 ; i++) {

            playersInDressingRoomA += Arrays.toString(dressingRoomA[i]) + "\n";

        }
        return playersInDressingRoomA;







    }

    /**
     * Method that displays distribution of players in dressing room B
     * <b>Pre: </b>
     * @return Dressing room B arrangements
     */

    public String displayPlayersDressingRoomB(){

        boolean[][] positions = new boolean[][]
                        {{true,false,true,false,true,false,true},
                        {false,true,false,true,false,true,false},
                        {true,false,true,false,true,false,true},
                        {false,true,false,true,false,true,false},
                        {true,false,true,false,true,false,true},
                        {false,true,false,true,false,true,false},
                        {true,false,true,false,true,false,true}};


        Player[] players = teams[1].getPlayers();
        int index  = 0;

        for(int i = 0; i < 7; i++) {

            for(int j = 0; j < 7; j++) {

                if(players[index] != null && positions[i][j]){

                    dressingRoomB[i][j] = players[index].getJerseyNumber();
                    index++;

                }

            }

        }

        String playersInDressingRoomB = Arrays.toString(dressingRoomB[0]) + "\n";

        for (int i = 1; i < 6 ; i++) {

            playersInDressingRoomB += Arrays.toString(dressingRoomB[i]) + "\n";

        }
        return playersInDressingRoomB;



    }

    /**Method that displays distribution of coaches in offices
     * <b>Pre: </b>
     * @return Office arrangements
     */

    public String displayOffices(){

       Coach[] coaches = new Coach[40];

        boolean[][] positions = new boolean[][]
                        {{true,false,true,false,true,false},
                        {false,true,false,true,false,true},
                        {true,false,true,false,true,false},
                        {false,true,false,true,false,true},
                        {true,false,true,false,true,false},
                        {false,true,false,true,false,true}};

        int index = 0;

        for(Employee employee : employees){

            if(employee instanceof Coach && coaches[index] == null){

                 coaches[index] = (Coach)employee;
                 index++;

            }

        }

        index = 0;

        for (int i = 0; i < 6 && index <= coaches.length ; i++) {

            for (int j = 0; j < 6 && index <= coaches.length ; j++) {

                if(positions[i][j] && coaches[index] != null){

                    offices[i][j] = coaches[index].getName();
                    index++;
                }


            }

        }

        String coachesInOffices = Arrays.toString(offices[0]) + "\n";

        for (int i = 1; i < 6 ; i++) {

            coachesInOffices += Arrays.toString(offices[i]) + "\n";

        }
        return coachesInOffices;




    }






}
