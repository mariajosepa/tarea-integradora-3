package model;

public class AssistantCoach extends Coach {

    private boolean wasPro;
    private Expertise expertise;

    public AssistantCoach(double salary, int wasPro, int expertise, String name, String id) {
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

    public boolean wasPro() {
        return wasPro;
    }


    public String getExpertise() {
        return expertise.name();
    }

    @Override
    public String getInfo() {

        String wasPro = ((wasPro() == true) ? "Si" : "No");
       String msg = super.getInfo();
       msg += "Profesional: " + wasPro+ "\n";
        msg += "Experticia: " + getExpertise()+ "\n";
        msg += "------------------------------------" + "\n";
        return msg;
    }


}
