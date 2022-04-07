package vtttp2022.nusiss.April7KwikMart.repositories;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vtttp2022.nusiss.April7KwikMart.models.SKU;

@Repository
public class MartRepository {
    

    @Autowired
    private JdbcTemplate template;

    public List<SKU> getAllSKU(){
        
        final List<SKU> skuList = new LinkedList<>();
        final SqlRowSet rs = template.queryForRowSet(Queries.SQL_SELECT_ALL_SKU);

        while (rs.next()){
            skuList.add(SKU.create(rs));
        }
        
        return Collections.unmodifiableList(skuList);
    }

    public SKU getSKU(Integer prodId){
        final SqlRowSet rs = template.queryForRowSet(
            // select * from game where gid = <gid>
            Queries.SQL_SELECT_SKU_BY_PRODID, prodId);
            SKU sku = new SKU();
            while (rs.next()){
              sku = SKU.create(rs);
            }
            
            return sku;

    }

    public boolean insertOrder( String orderId, Integer prodId){
        
        int added = template.update(Queries.SQL_INSERT_LINE_ITEM, orderId, prodId);

        return added > 0;

    }
    public boolean insertPurchaseOrder(String orderId,String name, Date date){

        int added = template.update(Queries.SQL_INSERT_PO, orderId,name,date);
        return added > 0;
    }

}
