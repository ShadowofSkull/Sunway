package lab10;

public class TestEmployee {
    public static void main(String[] args) {
        //ex1
        Employee employee = new Employee("George", "Tan", new Date(17, 8, 1990), new Date(25, 6, 2014));
        System.out.println(employee.toString());
        employee.setLastName("Chan");
        System.out.println(employee.toString());
        employee.setHireDate(new Date(25,6,2015));
        System.out.println(employee.toString());

        //ex2
        
    }   
}
