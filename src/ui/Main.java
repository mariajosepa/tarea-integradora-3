package ui;
import model.*;

public class Main {

    public static void main(String[] args) {

     SoccerClub soccerClub = new SoccerClub();

        soccerClub.hireEmployee(34.5,2,3,"Alberto","321");
        soccerClub.hireEmployee(34.5,2,3,"Carlos","321");

        soccerClub.hireEmployee("Juan","123",34.5,3,3);
        soccerClub.hireEmployee("Jose","123",34.5,3,3);


        soccerClub.assignAssistantCoach(1,"Alberto");
        soccerClub.assignAssistantCoach(1,"Carlos");

        soccerClub.assignMainCoach(1,"Jose");


        System.out.println(soccerClub.displayEmployees(1));

    }
}
