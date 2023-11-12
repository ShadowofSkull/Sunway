package lab07;

public class EmployeeTest {

    public static void display(Employee employee1, Employee employee2){
        System.out.printf("%-15s%-15s%n", "Name", "Salary");
        System.out.printf("%-15s$%-14.2f%n", employee1.getName(), employee1.getSalary());
        System.out.printf("%-15s$%-14.2f%n", employee2.getName(), employee2.getSalary());
    }
    public static void main(String[] args) {
        Employee employee1 = new Employee("John", 1000.0);
        Employee employee2 = new Employee("Jane", 1200.0);
        employee1.setSalary(100);
        display(employee1, employee2);
        System.out.println("Total salary of all employees: " + Employee.getTotalSalary());
        employee1.increaseSalary(0);
        employee2.increaseSalary(10.0);
        display(employee1, employee2);
        System.out.println("Total salary of all employees: " + Employee.getTotalSalary());
    }
}
