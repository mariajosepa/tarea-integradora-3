public class AssistantCoach extends Coach {

    private boolean wasPro;
    private Expertise expertise;

    public AssistantCoach(String name, String id, double salary, int wasPro, int expertise) {
        super(name, id, salary);

        switch(wasPro){

            case 1:

                this.wasPro = true;

                break;
            case 2:

                this.wasPro = false;


        }

        this.expertise = Expertise.values()[expertise];

    }

    public boolean isWasPro() {
        return wasPro;
    }
}
