public class Main {

    public static void main(String[] args) {

     Formation formation = new Formation("4",2,"7-2-1");

     formation.assignFormationLines();

      System.out.println(formation.getFieldFormation());

    }
}
