package lab07;

public class Invoice {
    private String partNumber;
    private String desc;
    private int quantity;
    private double pricePerItem;
    
    Invoice(String partNumber, String desc, int quantity, double pricePerItem){
        this.partNumber = partNumber;
        this.desc = desc;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public String getDesc() {
        return desc;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPricePerItem(double pricePerItem) {
        this.pricePerItem = pricePerItem;
    }

    public double getInvoiceAmount(){
        if (quantity < 0){
            quantity = 0;
        }
        if (pricePerItem < 0){
            pricePerItem = 0.0;
        }
        return quantity * pricePerItem;
    }
}
