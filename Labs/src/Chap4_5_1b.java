import java.util.Scanner;

class Chap4_5_1b{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int productNumber = -1;
        int quantitySold;
        double product1 = 0;
        double product2 = 0;
        double product3 = 0;
        while (true) {
            System.out.print("Enter product number (1-3) (0 to stop): ");
            productNumber = sc.nextInt();
            if (productNumber == 0) {
                System.out.printf("Product 1: $%.2f\n" , product1);
                System.out.printf("Product 2: $%.2f\n" , product2);
                System.out.printf("Product 3: $%.2f\n" , product3);
                break;
            }
            System.out.print("Enter quantity sold: ");
            quantitySold = sc.nextInt();
            switch (productNumber){
                case 1:
                    product1 += quantitySold * 2.98;
                    break;
                case 2:
                    product2 += quantitySold * 4.50;
                    break;
                case 3:
                    product3 += quantitySold * 9.98;
                    break;
                default:
                    System.out.println("Wrong number, try again");
            }

        }
        sc.close();
    }
}