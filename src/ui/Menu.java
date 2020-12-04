package ui;

import model.SoccerClub;
import java.util.Scanner;

public class Menu {


    private final static int TEAMS = 1;
    private final static int EMPLOYEE_INFO = 2;
    private final static int FACILITIES = 3;
    private final static int EXIT = 4;

    private SoccerClub club;
    private Scanner input;

    public Menu(){

      club = new SoccerClub();
      input = new Scanner(System.in);

    }

    /**
     * Reads User's selection
     * @return user's selection
     */

    public int readOption() {
        int choice = input.nextInt();
        input.nextLine();
        return choice;

    }

    /**
     * Displays menu options
     */
    public void showMenu() {

        System.out.println("(1) EQUIPOS");
        System.out.println("(2) EMPLEADOS");
        System.out.println("(3) EDIFICIOS");
    }

    /**
     * Displays team selection options
     */
    public void showTeams(){

        System.out.println("(1) FC JAVA");
        System.out.println("(2) FC APO");
    }

    /**
     * Displays team options
     */

    public void showTeamOptions(){

        System.out.println("(1) ASIGNAR TECNICO");
        System.out.println("(2) ASIGNAR ASISTENTE TECNICO");
        System.out.println("(3) ASIGNAR JUGADOR");
        System.out.println("(4) AGREGAR ALINEACION");
        System.out.println("(5) MOSTRAR ALINEACIONES");
        System.out.println("(6) MOSTRAR EQUIPO");
    }

    /**
     * Displays facility options
     */

    public void showFacilityOptions(){

        System.out.println("(1) OFICINAS");
        System.out.println("(2) CAMERINO JAVA");
        System.out.println("(3) CAMERINO APO");
    }

    /**
     * Displays available tactics
     */

    public void showTactics(){

        System.out.println("(1) POSESION");
        System.out.println("(2) CONTRAATAQUE");
        System.out.println("(3) PRESION ALTA");
        System.out.println("(4) POR DEFECTO");
    }

    /**
     * Displays available expertises
     */

    public void showExpertises(){

        System.out.println("(1) OFENSIVO");
        System.out.println("(2) DEFENSIVO");
        System.out.println("(3) POSESION");
        System.out.println("(4) LABORATORIO");

    }

    /**
     * Display different player positions
     */

    public void showPositions(){

        System.out.println("(1) PORTERO");
        System.out.println("(2) DEFENSA");
        System.out.println("(3) VOLANTE");
        System.out.println("(4) DELANTERO");


    }

    /**
     * Displays employee options
     */

    public void showEmployeeOptions(){

        System.out.println("(1) CONTRATAR EMPLEADO");
        System.out.println("(2) DESPEDIR EMPLEADO");
        System.out.println("(3) MOSTRAR EMPLEADOS");

    }

    /**
     * Displays types of employees
     */

    public void showTypesEmployees(){

        System.out.println("(1) TECNICO");
        System.out.println("(2) ASISTENTE TECNICO");
        System.out.println("(3) JUGADOR");

    }

    /**
     * Runs and executes different team selection options, such as adding a player or assigning a Coach
     */

    public void teams(){

      int option;
      int team;
      showTeams();
      option = readOption();

      switch(option){


          case 1:

              team = 1;
              showTeamOptions();
              option = readOption();

              switch(option){

                  case 1:
                      assignMainCoach(team);
                      break;
                  case 2:
                      assignAssistantCoach(team);
                      break;
                  case 3:
                      addPlayerToTeam(team);
                      break;
                  case 4:
                      addFormation(team);
                      break;
                  case 5:
                      System.out.println(club.displayTeamFormations(team));
                      break;
                  case 6:
                      System.out.println(club.displayTeam(team));
                      break;

              }

              break;
          case 2:
              team = 2;
              showTeamOptions();
              option = readOption();

              switch(option){

                  case 1:
                      assignMainCoach(team);
                      break;
                  case 2:
                      assignAssistantCoach(team);
                      break;
                  case 3:
                      addPlayerToTeam(team);
                      break;
                  case 4:
                      addFormation(team);
                      break;
                  case 5:
                      System.out.println(club.displayTeamFormations(team));
                      break;
                  case 6:
                      System.out.println(club.displayTeam(team));
                      break;


              }


              break;


      }

    }

    /**
     * Assigns a main Coach
     * @param team team where coach is being assigned
     */

    public void assignMainCoach(int team){

        System.out.println("Ingrese nombre del tecnico");
        String name = input.next();

        System.out.println( club.assignMainCoach(team,name));
    }

    /**
     * Assigns an assistant coach
     * @param team team where assistant is being assigned
     */

    public void assignAssistantCoach(int team){

        System.out.println("Ingrese nombre del asistente tecnico");
        String name = input.next();

        System.out.println(club.assignAssistantCoach(team,name));

    }

    /**
     * Adds player to team x
     * @param team team where player is being added
     */

    public void addPlayerToTeam(int team){
        System.out.println("Ingrese nombre del jugador");
        String name = input.next();

        System.out.println(club.addPlayerToTeam(name,team));

    }

    /**
     * Adds new team formation
     * @param team team where formation is being added
     */

    public void addFormation(int team){

        System.out.println("Ingrese la fecha");
        String date = input.next();

        System.out.println("Seleccione la tactica");
        showTactics();
        int tactic = input.nextInt();

        System.out.println("Ingrese formacion (ej. 4-4-2)");
        String fieldFormation = input.next();

        System.out.println(club.addTeamFormation(team, date, tactic, fieldFormation));

    }

    /**
     * Displays and runs all operations related to employees, such as hiring and firing
     */

    public void employees(){
        showEmployeeOptions();
        int option = readOption();



        switch(option){
            case 1:
                System.out.println("Ingrese nombre del empleado");
                String name = input.next();

                System.out.println("Ingrese idetificacion del empleado");
                String id = input.next();

                System.out.println("Ingrese salario del empleado");
                double salary = input.nextDouble();

                showTypesEmployees();
                option = readOption();

                switch(option){

                    case 1:

                        System.out.println("Ingrese numero de equipos a cargo: ");
                        int teamsInCharge = input.nextInt();

                        System.out.println("Ingrese Campeonatos ganados: ");
                        int wonChampionships = input.nextInt();

                        System.out.println("Anios de experiencia: ");
                        int experience1 = input.nextInt();

                        System.out.println(club.hireEmployee(name,id,salary,experience1,teamsInCharge,wonChampionships));

                        break;
                    case 2:

                        System.out.println("Seleccione experticia: ");
                        showExpertises();
                        int expertise = input.nextInt();

                        System.out.println("Fue profesional en el pasado? [s] [n]: ");
                        String wasPro = input.next();

                        char wasPro1 = wasPro.charAt(0);

                        System.out.println("Anios de experiencia: ");
                        int experience = input.nextInt();

                        System.out.println(club.hireEmployee(salary,wasPro1,expertise,name,id,experience));

                        break;
                    case 3:
                        System.out.println("Seleccione posicion: ");
                        showPositions();
                        int position = input.nextInt();

                        System.out.println("Ingrese numero de camiseta: ");
                        int jerseyNumber = input.nextInt();

                        System.out.println("Ingrese numero de goles anotados: ");
                        int scoredGoals = input.nextInt();

                        System.out.println("Ingrese calificacion promedio: ");
                        double averageRating = input.nextDouble();


                        System.out.println(club.hireEmployee(name,id,salary,jerseyNumber,scoredGoals,averageRating,position));

                        break;

                    default:
                        System.out.println("Ingrese una opcion valida");
                        break;

                }

                break;
            case 2:

                System.out.println("Ingrese nombre del empleado a despedir: ");
                String employeeName = input.next();
                System.out.println(club.fireEmployee(employeeName));

                break;
            case 3:

                System.out.println(club.displayEmployees());
                break;
            default:
                System.out.println("Ingrese una opcion valida");
                break;


        }



    }

    /**
     * Displays and runs all operations related to facilities, such as displaying dressing room accommodations
     */

    public void facilities(){

        int option;
        showFacilityOptions();
        option = readOption();

        switch (option){

            case 1:
                System.out.println(club.displayOffices());
                break;
            case 2:
                System.out.println(club.displayPlayersDressingRoomA());
                break;
            case 3:
                System.out.println(club.displayPlayersDressingRoomB());
                break;
            default:
                System.out.println("Ingrese una opcion valida");
                break;


        }



    }

    /**
     * Executes an action depending on the inputted option
     * @param option desired option
     */

    public void doOperation(int option) {

        switch (option) {

            case TEAMS:
                teams();
                break;
            case EMPLOYEE_INFO:
               employees();
                break;
            case FACILITIES:
                facilities();
                break;
            case EXIT:
                break;
            default:
                System.out.println("Ingrese una opcion valida");
                break;

        }

    }

    /**
     * Starts the program
     */

    public void startProgram(){

        int choice;

        do{
            showMenu();
            choice = readOption();
            doOperation(choice);


        }while(choice != 4);



    }




}
