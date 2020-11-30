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

    public String fireEmployee(String name){

        if(findEmployee(name) != null){

            employees.remove(findEmployee(name));
            findEmployee(name).setIsActiveOFF();
            return "Empleado despedido";

        }

        return "Empleado no existe";
    }

    public String hireEmployee(String name, String id, double salary,int teamsInCharge, int wonChampionships){

        MainCoach mainCoach = new MainCoach(name, id, salary, teamsInCharge, wonChampionships);

        employees.add(mainCoach);
        mainCoach.setIsActiveOFF();

        return "Nuevo tecnico contratado" + "\n";


    }

    public String hireEmployee(double salary, int wasPro, int expertise, String name, String id){

        AssistantCoach assistantCoach = new AssistantCoach(salary,wasPro,expertise,name,id);

        employees.add(assistantCoach);
        assistantCoach.setIsActiveOFF();

        return "Nuevo asistente tecnico contratado" + "\n";



    }

    public String hireEmployee(String name, String id, double salary, int jerseyNumber, int scoredGoals, int averageRating, int position){

        Player player = new Player(name, id, salary, jerseyNumber, scoredGoals,averageRating,position);

        employees.add(player);
        player.setIsActiveOFF();

        return "Nuevo jugador contratado" + "\n";




    }

    public Employee findEmployee(String name){

        for(Employee employee : employees){

            if (employee.getName().equalsIgnoreCase(name)){

                return employee;

            }
        }

        return null;

    }

    public String addPlayerToTeam(String name, int team){

        team = team - 1;
        boolean added = false;

        if(findEmployee(name) != null && findEmployee(name) instanceof Player){

            added = teams[team].addPlayer((Player) findEmployee(name));

        }

        if(!added){

            return "No hay cupo para mas jugadores en el equipo " + teams[team].getName() + "\n";

        }

        else{

            findEmployee(name).setIsActiveON();
            return "Jugador agregado al equipo " + teams[team].getName() + "\n";


        }



    }

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


            return "No hay mas cupos para tecnicos asistentes, puestos ocupados por " + Arrays.toString(teams[0].getAssistantCoaches()) + "\n";

        }

    }

    public String assignMainCoach(int team, String name){

        boolean added = false;
        team = team - 1;
        if(findEmployee(name) != null && findEmployee(name) instanceof MainCoach && teams[team].getMainCoach() == null){

            teams[team].assignMainCoach((MainCoach) findEmployee(name));
            added = true;
        }

        if(added){
            findEmployee(name).setIsActiveON();
            return "Tecnico asistente agregado a "+ teams[team].getName() + "\n";

        }

        else{


            return "No hay mas cupos para tecnicos asistentes, puestos ocupados por " + Arrays.toString(teams[0].getAssistantCoaches()) + "\n";

        }




    }

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

    public String displayEmployees(int team){

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

    public String displayPlayersDressingRoomA(){

       boolean[][] positions = new boolean[][]
                {{true,false,true,false,true,false},
                {false,true,false,true,false,true},
                {true,false,true,false,true,false},
                {false,true,false,true,false,true},
                {true,false,true,false,true,false},
                {false,true,false,true,false,true},
                {true,false,true,false,true,false}};


        Player[] players = teams[0].getPlayers();
        int index  = 0;

            for(int i = 0; i < 7; i++) {

                for(int j = 0; j < 6; j++) {

                       if(players[index] != null && positions[i][j] == true){

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

            for(int j = 0; j < 6; j++) {

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
