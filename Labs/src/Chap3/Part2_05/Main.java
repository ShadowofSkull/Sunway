package Chap3.Part2_05;

public class Main {
    public static void main(String[] args) {
        // Ex1
        Student student = new Student("Alex", 5, "BCS");
        Student student2 = new Student("Mindy", 2, "BIT");
        System.out.println(student);
        System.out.println(student2);
        
        student.setName("Johnson");
        // System.out.println(student.getName());
        // System.out.println(student2.getName());
        // System.out.println(student.getName());
        student.checkEligibility();
        student2.checkEligibility();

        //Ex2
        TV tv1 = new TV("S101", "Elba", 'R', 1400);
        System.out.println(tv1.getPrice());
        tv1.setPrice(1500);
        System.out.println(tv1.getPrice());
        System.out.println(tv1.calcTax(6));
    }
}
