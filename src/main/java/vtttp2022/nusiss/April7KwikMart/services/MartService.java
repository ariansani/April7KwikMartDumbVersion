package vtttp2022.nusiss.April7KwikMart.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vtttp2022.nusiss.April7KwikMart.models.LineItem;
import vtttp2022.nusiss.April7KwikMart.models.PurchaseOrder;
import vtttp2022.nusiss.April7KwikMart.models.SKU;
import vtttp2022.nusiss.April7KwikMart.repositories.MartRepository;

@Service
public class MartService {
    
    @Autowired
    private MartRepository martRepo;

    public List<SKU> getAllSKU(){
        return martRepo.getAllSKU();
    }

    public SKU getSKU(Integer prodId){
        return martRepo.getSKU(prodId);
    }

    public boolean insertOrder(List<Integer> skuIds,String name ,Date date){


        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setName(name);
        purchaseOrder.setOrderDate(date);
        martRepo.insertPurchaseOrder(purchaseOrder.getOrderId(),purchaseOrder.getName(),purchaseOrder.getOrderDate());

        for (Integer prodId : skuIds) {
        SKU sku = martRepo.getSKU(prodId);
        LineItem lineItem = new LineItem();
        lineItem.setOrderId(purchaseOrder.getOrderId());
        lineItem.setProdId(sku.getProdId());
        martRepo.insertOrder( purchaseOrder.getOrderId(), lineItem.getProdId());
        }

        
        return true;
        
    }

}
