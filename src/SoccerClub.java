public class SoccerClub {

    private final static int dressingRoomRows = 7;
    private final static int dressingRoomAcolumns = 6;
    private final static int dressingRoomBcolumns = 7;

    private String name;
    private String nit;
    private String foundingDate;
    private Team[] teams;
    private String[][] dressingRoomA;
    private String[][] dressingRoomB;
    private String [][] offices;

    public SoccerClub() {
        name = "Club del Rey";
        nit = "12345678";
        foundingDate = "4/1/1970";
        dressingRoomA = new String[dressingRoomRows][dressingRoomAcolumns];
        dressingRoomB = new String[dressingRoomRows][dressingRoomBcolumns];
        offices = new String[6][6];
        teams = new Team[2];
        Team teamA = new Team("FC JAVA");
        Team teamB = new Team( "FC APO");
        teams[0] = teamA;
        teams[1] = teamB;

    }
}
