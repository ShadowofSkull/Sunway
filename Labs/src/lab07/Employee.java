package lab07;

public class Employee {
    private String name;
    private double salary;
    private static double totalSalary = 0.0;

    Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
        totalSalary += salary;
    }

    public static double getTotalSalary(){
        return totalSalary;
    }

    public String getName(){
        return name;
    }
    
    public double getSalary(){
        return salary;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSalary(double salary){
        if (salary >= 0.0){
            totalSalary -= this.salary;
            this.salary = salary;
            totalSalary += salary;
            return;
        }
        System.out.println("Salary must be greater or equal to zero.");
    }

    public void increaseSalary(double raisePercentage){
        if (raisePercentage > 0.0){
            totalSalary -= this.salary;
            salary += raisePercentage / 100 * salary;
            totalSalary += salary;
            return;
        }
        System.out.println("Percentage must be greater.");
    }
}
