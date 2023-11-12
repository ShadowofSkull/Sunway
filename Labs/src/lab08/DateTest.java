package lab08;

import java.util.Scanner;

public class DateTest {
    public static Date getMenuChoice(){
        Scanner input = new Scanner(System.in);
        System.out.println("Choose your choice of date format: 1/2/3 or 4 to exit");
        System.out.println("1: DD/MM/YYYY");
        System.out.println("2: MMM/DD/YYYY");
        System.out.println("3: DDD/YYYY");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                try {
                    System.out.println("Enter day");
                    int day = input.nextInt();
                    System.out.println("Enter month");
                    int month = input.nextInt();
                    System.out.println("Enter year");
                    int year = input.nextInt();    
                    Date date = new Date(day, month, year);
                    input.close();
                    return date;
                } catch (Exception e) {
                    System.out.println("Enter 1 to 3 only");
                }
                
                break;
            case 2:
                try {
                    System.out.println("Enter day");
                    int day = input.nextInt();
                    System.out.println("Enter month in string (Apr)");
                    String monthInStr = input.next();
                    
                    System.out.println("Enter year");
                    int year = input.nextInt();    
                    Date date = new Date(monthInStr, day, year);
                    input.close();
                    return date;
                } catch (Exception e) {
                    System.out.println("Enter 1 to 3 only");
                }
                
                break;
            case 3:
                try {
                    System.out.println("Enter days in year");
                    int daysInYear = input.nextInt();
                    
                    System.out.println("Enter year");
                    int year = input.nextInt();    
                    Date date = new Date(daysInYear, year);
                    input.close();
                    return date;
                } catch (Exception e) {
                    System.out.println("Enter 1 to 3 only");
                }
                
                break;
            case 4:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        input.close();
        return null;
    }
    public static void main(String[] args) {
        Date date = getMenuChoice();
        System.out.println(date.toString());
        System.out.println(date.toMonthNameDateString());
        System.out.println(date.toDayDateString());
    }
}
