package Chap7_02;
import java.util.Scanner;

class Chap7_Ex1 {
    // Ex1
    public static void display(int[] arr, int ctr){
        for (int i = 0; i < ctr; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static boolean hasEntered(int[] arr, int num, int ctr){
        for (int i = 0; i < ctr; i++) {
            if (num == arr[i]){
                return true;
            }
        }
        return false;
    }

    
    public static void main(String[] args) {
        // Ex1
        int[] arr; 
        Scanner sc = new Scanner(System.in);
        int ctr = 0;
        System.out.print("Enter size of array: ");
        int size = sc.nextInt();
        arr = new int[size];
        while (ctr < size){
            System.out.print("Enter a number(10-100): ");
            int num = sc.nextInt();
            if (num < 10 || num > 100){
                System.out.println("Number exits limit. Please try again.");
                continue;
            }
            if (hasEntered(arr, num, ctr)){
                System.out.println(num + " has already been entered");
            }
            else{
                arr[ctr] = num;
                ctr++;
            }
            display(arr, ctr);
        }
        sc.close();

    }
}