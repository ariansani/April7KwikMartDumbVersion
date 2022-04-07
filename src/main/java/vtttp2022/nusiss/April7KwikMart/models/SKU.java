package vtttp2022.nusiss.April7KwikMart.models;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class SKU {

    private Integer prodId;
    private String description;
    private Float unitPrice;



    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public static SKU create(SqlRowSet rs){
        SKU sku = new SKU();

        sku.prodId = rs.getInt("prod_id");
        sku.description = rs.getString("description");
        sku.unitPrice = rs.getFloat("unit_price");

        return sku;
    }

}
