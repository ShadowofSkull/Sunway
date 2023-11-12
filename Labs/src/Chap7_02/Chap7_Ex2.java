package Chap7_02;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Chap7_Ex2 {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        String name = "";

        while (true) {
            System.out.print("Enter name (-1 to break loop): ");
            name = sc.next();
            if(name.equals("-1")) break;
            
            if (!arr.contains(name)) 
                arr.add(name);
            else 
                System.out.println(name + " has been entered");
        }
        Collections.sort(arr);
        System.out.println("The names you entered are:");
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i));
            if (!(i == arr.size() - 1))
                System.out.print(", ");
        }
        System.out.println();

        while (true){
            System.out.print("Enter the name you want to delete (-1 to exit): ");
            String deleteName = sc.next();
            if (deleteName.equals("-1")) break;
            arr.remove(deleteName);
            System.out.println(deleteName + " is deleted");
            
        }

        for (int j = 0; j < arr.size(); j++) {
            System.out.print(arr.get(j));
            if (!(j == arr.size() - 1))
                System.out.print(", ");
        }
        System.out.println();

        while (true){
            System.out.print("Enter the name you wanna search(-1 to exit): ");
            
            String theName = sc.next();
            if (theName.equals("-1")) break;
            System.out.println("Index of the name is " + Collections.binarySearch(arr, theName));
        }

        sc.close();

    }
}

