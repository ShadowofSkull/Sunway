package com.prg1203.package2;

public class Product {
    private String title;    
    private double price;
    private int qty;

    public Product(String title, double price, int qty){
        this.title = title;
        this.price = price;
        this.qty = qty;
    }

    
    /** 
     * @return String
     */
    public String getTitle() {
        return title;
    }

    
    /** 
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    
    /** 
     * @return double
     */
    public double getPrice() {
        return price;
    }

    
    /** 
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    
    /** 
     * @return int
     */
    public int getQty() {
        return qty;
    }

    
    /** 
     * @param qty
     */
    public void setQty(int qty) {
        this.qty = qty;
    }


    
}