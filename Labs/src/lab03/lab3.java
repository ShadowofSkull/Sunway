package lab03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class lab3 {

    //Ex 1
    public static int sum(int n){
        if (n == 1)
            return 1;
        return n + sum(n - 1);
    }
    

    public static void main(String[] args) {
        //ex1
        // System.out.println(sum(5));
        // ex2
    //     Scanner sc = new Scanner(System.in);
    //     int[] arr = new int[5];
    //     for (int i = 0; i < arr.length; i++) {
    //         try {
    //             int num = sc.nextInt();
    //             arr[i] = num;
            
    //         } catch (Exception e) {
    //             System.out.println("Enter integer only");
    //             //to consume the newline character, 
    //             // so the next input operation does not unintentionally read the leftover newline character
    //             sc.nextLine();
    //             i--;
    //         }
    //     }
    //     for (int i = 0; i < arr.length; i++) {
    //         System.out.print(arr[i] + " ");
    //     }
    //     sc.close();

    //     try {
    //         int result = arr[0] / 0;
    //     } catch (Exception e) {
    //         System.out.println("Error: Division by zero.");
    //     }

    //    try{
    //         arr[5] = 10;
    //    }
    //    catch (Exception e){
    //         System.out.println("Error: Array index out of bound.");
    //    }


        //ex3
        try {
            File file = new File("Sunway/src/lab03/studentMark.txt");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
            Scanner input = new Scanner(System.in);
            FileWriter writer = new FileWriter("Sunway/src/lab03/studentMark.txt");
            String name;
            int mark;

            while (true) {
                System.out.print("Enter student name (or 'quit' to exit): ");
                name = input.nextLine();
                if (name.equals("quit")) {
                    break;
                }
                System.out.print("Enter student mark: ");
                mark = input.nextInt();
                input.nextLine(); // consume the newline character

                writer.write(name + "," + mark + "\n");
            }

            writer.close();
            input.close();
        } 
        catch (InputMismatchException e){
            System.out.println("Student mark must be number");
        }
        catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        }

        // ex4
        // try {
        //     File file = new File("Sunway/src/lab03/studentMark.txt");
        //     Scanner myReader = new Scanner(file);
        //     while (myReader.hasNextLine()) {
        //         String data = myReader.nextLine();
        //         System.out.println(data);
        //     }
        //     myReader.close();
        // } 
        // catch (FileNotFoundException e) {
        //     System.out.println("An error occurred.");
        //     e.printStackTrace();
        // }
    }
    
}
   
    