package vtttp2022.nusiss.April7KwikMart.controllers;

import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import vtttp2022.nusiss.April7KwikMart.models.SKU;
import vtttp2022.nusiss.April7KwikMart.services.MartService;

@Controller
@RequestMapping("/")
public class MartController {

    @Autowired
    private MartService martSvc;

    @GetMapping
    public String loadIndex(Model model){
        
        List<SKU> skus = martSvc.getAllSKU();

        model.addAttribute("allSkus", skus);
        return "index";
    }

    @PostMapping(path = "/purchase_order", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createOrder(@RequestBody MultiValueMap<String, String> form, Model model) {
        String name = form.getFirst("nameInput");
        String date = form.getFirst("dateInput");
    
        Integer sku = Integer.parseInt(form.getFirst("skuInput1"));
        Integer sku2 = Integer.parseInt(form.getFirst("skuInput2"));
        List<Integer> skus = new LinkedList<>();
        skus.add(sku);
        skus.add(sku2);
        Date convertedDate = new Date();
        martSvc.insertOrder(skus, name, convertedDate);

        List<SKU> skuList = martSvc.getAllSKU();

        model.addAttribute("allSkus", skuList);
        return "index";

    }

}
