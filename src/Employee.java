public abstract class Employee {

    private  String name;
    private  String id;
    private  double salary;
    private boolean isActive;

    public Employee(String name, String id, double salary){

        this.name = name;
        this.id = id;
        this.salary = salary;

    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActiveOFF() {
        this.isActive = false;
    }

    public void setIsActiveON(){

        this.isActive = true;

    }

}
