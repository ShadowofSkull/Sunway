package lab06;

public class Account {
    private double balance;
    private static double total = 0;

    Account(double initialBalance){
        this.balance = initialBalance;
        total += initialBalance;
    }

    public void credit(double amount){
        this.balance += amount;
        increaseTotal(amount);
    }

    public void debit(double amount){
        if(amount > this.balance){
            System.out.println("Debit amount exceeded account balance.");
        }else{
            this.balance -= amount;
            decreaseTotal(amount);
        }
    }

    public double getBalance() {
        return balance;
    }

    public static double getTotal(){
        return total;
    }
    
    private static void increaseTotal(double amount) {
        total += amount;
    }
    
    private static void decreaseTotal(double amount) {
        total -= amount;
    }

    

}
