package Chap3.Part2_05;

public class TV {
    private String stockNumber;
    private String maker;
    private char screenType;
    private double price;
    
    TV(String stockNumber, String maker, char screenType, double price){
        this.stockNumber = stockNumber;
        this.maker = maker;
        this.screenType = screenType;
        this.price = price;
    }

    public String getStockNumber() {
        return stockNumber;
    }

    public String getMaker() {
        return maker;
    }

    public char getScreenType() {
        return screenType;
    }

    public double getPrice() {
        return price;
    }

    // public void setStockNumber(String stockNumber) {
    //     this.stockNumber = stockNumber;
    // }

    // public void setMaker(String maker) {
    //     this.maker = maker;
    // }

    // public void setScreenType(char screenType) {
    //     this.screenType = screenType;
    // }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString(){
        return String.format("TV with stock number %s has maker %s and screen type %s with price %.2f", stockNumber, maker, screenType, price);
    }

    public double calcTax(double taxRate){
        return this.price * taxRate / 100;
    }
}
