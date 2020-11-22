public abstract class Employee {

    private  String name;
    private  String id;
    private  double salary;
    private double isActive;

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

    public double getIsActive() {
        return isActive;
    }
}
