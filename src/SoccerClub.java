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

        return "Nuevo tecnico contratado" + "\n";


    }

    public String hireEmployee( String id, int wasPro, int expertise, double salary, String name){

        AssistantCoach assistantCoach = new AssistantCoach(name, id, salary, wasPro, expertise);

        employees.add(assistantCoach);

        return "Nuevo asistente tecnico contratado" + "\n";



    }

    public String hireEmployee(String name, String id, double salary, int jerseyNumber, int scoredGoals, int averageRating, int position){

        Player player = new Player(name, id, salary, jerseyNumber, scoredGoals,averageRating,position);

        employees.add(player);

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

    public String addTeamFormation(int team, String date, int tactic, String fieldFormation){

        Formation newFormation = new Formation(date,tactic,fieldFormation);
        String msg = "";

        switch(team){

            //Team A
            case 1:
                teams[0].addFormation(newFormation);
                msg = "Formacion agregada al equipo: " + teams[0].getName() + "\n";
                break;


            //Team B
            case 2:

                teams[1].addFormation(newFormation);
                msg = "Formacion agregada al equipo: " + teams[1].getName() + "\n";
                break;



            default:

                msg = "Por favor ingrese una opcion valida";


                break;

        }

        return msg;


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

            return "Jugador agregado al equipo " + teams[team].getName() + "\n";

        }



    }


}
