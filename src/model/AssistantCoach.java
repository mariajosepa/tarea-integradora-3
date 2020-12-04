package model;

public class AssistantCoach extends Coach {

    private boolean wasPro;
    private Expertise expertise;

    public AssistantCoach(double salary, char wasPro, int expertise, String name, String id, int experience) {
        super(name, id, salary,experience);

        switch(wasPro){

            case 's':

                this.wasPro = true;

                break;
            case 'n':

                this.wasPro = false;


        }

        this.expertise = Expertise.values()[expertise];

    }

    /**
     * Return's boolean to specify if coach was pro (true) or not (false)
     * @return boolean
     */
    public boolean wasPro() {
        return wasPro;
    }

    /**
     * Return's the coaches expertise
     * @return the coach's expertise
     */

    public String getExpertise() {
        return expertise.name();
    }

    @Override
    public String getInfo() {

        String wasPro = ((wasPro() == true) ? "Si" : "No");
       String msg = super.getInfo();
        msg += "Profesional: " + wasPro+ "\n";
        msg += "Experticia: " + getExpertise()+ "\n";
        msg += "Experiencia: " + getYearsExperience()+ " anios" + "\n";
        msg += "------------------------------------" + "\n";
        return msg;
    }


}
