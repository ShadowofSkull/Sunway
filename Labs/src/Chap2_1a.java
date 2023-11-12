import java.util.Scanner;

public class Chap2_1a {
    // Ex1
    public static int largest(int n1, int n2, int n3) {
        int largest = n1;
        if (n2 > largest) {
            largest = n2;
        }
        if (n3 > largest) {
            largest = n3;
        }
        return largest;
    }
    // Ex1
    public static int smallest(int n1, int n2, int n3) {
        int smallest = n1;
        if (n2 < smallest) {
            smallest = n2;
        }
        if (n3 < smallest) {
            smallest = n3;
        }
        return smallest;
    }
    
    // public static int getMinMax(int n1, int n2, int n3, String mode) {
    //     switch (mode) {
    //         case "min":
    //             int smallest = n1;
    //             if (n2 < smallest)  {
    //                 smallest = n2;
    //             }
    //             if (n3 < smallest){
    //                 smallest = n3;
    //             }
    //             return smallest;
    //         case "max":
    //             int max = n1;
    //             if (n2 > max) max = n2;
    //             if (n3 > max) max = n3;
    //             return max;
    //         default:
    //             System.out.println("Enter mode 'min' or 'max'");
    //             return 0;
    //     }
    // }
    //Ex 2
    public static void splitString(String str){
        if (str.length() == 5){
            for(int i = 0; i < 5; i++){

                System.out.print(str.charAt(i)+"   ");
            }
        }
    }
    public static void main(String[] args) throws Exception {
        // Ex 1
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter first integer: ");
        // int n1 = sc.nextInt();
        // System.out.println("Enter second integer: ");
        // int n2 = sc.nextInt();
        // System.out.println("Enter third integer: ");
        // int n3 = sc.nextInt();
        // sc.close();
        // int largest = largest(n1, n2, n3);
        // int smallest = smallest(n1, n2, n3);
        // System.out.println("For numbers " + n1 + ", " + n2 + ", " + n3 + ":");
        // System.out.println("Largest is: " + largest);
        // System.out.println("Smallest is: " + smallest);
        // System.out.println("Sum of three integers: " + (n1 + n2 + n3));
        // System.out.println("Product fo three integers: " + (n1 * n2 * n3));
        // System.out.println("Average of three integers: " + (n1 + n2 + n3) / 3);
        // System.out.println(getMinMax(n1, n2, n3,"max"));
        // System.out.println(getMinMax(n1, n2, n3,"min"));

        // Ex2
        // Scanner sc =  new Scanner(System.in);
        // String str = sc.next();
        // sc.close();
        // splitString(str);

        // Ex3
        System.out.println("Enter an integer: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        String type;
        if (num % 2 == 0){
            type = "even";
        }
        else type = "odd";
        System.out.println("Number is " + type);
        
    }

}
