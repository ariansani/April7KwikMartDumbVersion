package vtttp2022.nusiss.April7KwikMart.models;

import java.util.Random;

public class LineItem {
    private Integer itemId;
    private Integer quantity;
    private String orderId;
    private Integer prodId;


    public Integer getItemId() {
        return itemId;
    }
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public Integer getProdId() {
        return prodId;
    }
    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    

}
