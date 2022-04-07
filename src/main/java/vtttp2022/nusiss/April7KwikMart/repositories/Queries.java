package vtttp2022.nusiss.April7KwikMart.repositories;

public interface Queries {
    
    public static final String SQL_SELECT_ALL_SKU = "SELECT * FROM sku";

    public static final String SQL_SELECT_SKU_BY_PRODID = "SELECT * FROM sku where prod_id = ?";

    public static final String SQL_INSERT_LINE_ITEM = "insert into line_item(order_id, prod_id) values (?,?)";

    public static final String SQL_INSERT_PO = "insert into purchase_order(order_id,name,order_date) values(?,?,?)";
}
