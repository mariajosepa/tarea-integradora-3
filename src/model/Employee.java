package model;

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

    /**
     * Return's employee's name
     * @return employee's name
     */

    public String getName() {
        return name;
    }

    /**
     * Return's employee's id
     * @return employee's id
     */

    public String getId() {
        return id;
    }

    /**
     * Return's employee's salary
     * @return employee's salary
     */

    public double getSalary() {
        return salary;
    }

    /**
     * Return's employee's status
     * @return employee's status
     */

    public boolean getIsActive() {
        return isActive;
    }

    /**
     * Sets employee's status as inactive
     * @return employee's status updated
     */

    public void setIsActiveOFF() {
        this.isActive = false;
    }

    /**
     * Sets employee's status as active
     * @return employee's status updated
     */

    public void setIsActiveON(){

        this.isActive = true;

    }

    /**
     * Displays main information about an employee
     * @return
     */

    public String getInfo(){

        String isActive = ((getIsActive() == true) ? "Activo" : "Inactivo");

        String msg = "------------------------------------" + "\n";
        msg+=   "Nombre: " + getName() + "\n";
        msg +=   "ID: " + getId() + "\n";
        msg +=   "Salario: " + getSalary() + "\n";
        msg+=   "Estado: "+   isActive   +"\n";

        return msg;
    };

}
