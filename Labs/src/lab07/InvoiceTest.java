package lab07;

public class InvoiceTest {

    public static void display(Invoice invoice1, Invoice invoice2){
        System.out.printf("%-15s%-25s%-15s%-15s%s%n", "Part Number", "Description", "Quantity", "Price", "Invoice Amount");
        System.out.printf("%-15s%-25s%-15d$%-14.2f$%.2f%n", invoice1.getPartNumber(), invoice1.getDesc(),
            invoice1.getQuantity(), invoice1.getPricePerItem(), invoice1.getInvoiceAmount());
        System.out.printf("%-15s%-25s%-15d$%-14.2f$%.2f%n", invoice2.getPartNumber(), invoice2.getDesc(),
            invoice2.getQuantity(), invoice2.getPricePerItem(), invoice2.getInvoiceAmount());
    }
    
    public static void main(String[] args) {
        // Ex1
        Invoice invoice1 = new Invoice("1234", "Hammer", 2, 14.95);
        Invoice invoice2 = new Invoice("5678", "Paint Brush", -5, -9.95);

        display(invoice1, invoice2);

        invoice1.setPartNumber("001234");
        invoice1.setDesc("Yellow Hammer");
        invoice1.setQuantity(3);
        invoice1.setPricePerItem(19.49); 
        
        invoice2.setQuantity(3);
        invoice2.setPricePerItem(9.49);
        display(invoice1, invoice2);
    }
}
