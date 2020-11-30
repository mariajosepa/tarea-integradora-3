package ui;

import model.SoccerClub;
import java.util.Scanner;

public class Menu {


    private final static int TEAMS = 1;
    private final static int EMPLOYEE_INFO = 2;
    private final static int FACILITIES = 3;

    private SoccerClub club;
    private Scanner input;

    public Menu(){

      club = new SoccerClub();
      input = new Scanner(System.in);

    }

    public void showMenu() {

        System.out.println("(1) EQUIPOS");
        System.out.println("(2) EMPLEADOS");
        System.out.println("(3) EDIFICIOS");
    }


    public void showTeams(){

        System.out.println("(1) FC JAVA");
        System.out.println("(2) FC APO");
    }

    public void showTeamOptions(){

        System.out.println("(1) ASIGNAR TECNICO");
        System.out.println("(2) ASIGNAR ASISTENTE TECNICO");
        System.out.println("(3) ASIGNAR JUGADOR");
        System.out.println("(4) AGREGAR ALINEACION");
        System.out.println("(5) MOSTRAR ALINEACIONES");
        System.out.println("(6) MOSTRAR EQUIPO");
    }


    public void showFacilityOptions(){

        System.out.println("(1) OFICINAS");
        System.out.println("(2) CAMERINO JAVA");
        System.out.println("(3) CAMERINO APO");
    }


}
