package vtttp2022.nusiss.April7KwikMart.models;

import java.util.Date;
import java.util.Random;

public class PurchaseOrder {

    private String orderId;
    private String name;
    private Date orderDate;

    public PurchaseOrder() {
        this.orderId = generateId(8);
    }
    public PurchaseOrder(String orderId, String name, Date orderDate) {
        this.orderId = generateId(8);
        this.name = name;
        this.orderDate = orderDate;
    }
    public PurchaseOrder( String name, Date orderDate) {
        this.orderId = generateId(8);
        this.name = name;
        this.orderDate = orderDate;
    }
        

    private synchronized String generateId(int numChars){
        Random r = new Random();
        StringBuilder strBuilder = new StringBuilder();
        while(strBuilder.length()< numChars){
            strBuilder.append(Integer.toHexString(r.nextInt()));
        }
        return strBuilder.toString().substring(0,numChars);
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

}
