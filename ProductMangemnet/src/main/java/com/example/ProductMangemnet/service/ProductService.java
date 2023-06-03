package com.example.ProductMangemnet.service;


import com.example.ProductMangemnet.dto.GetCategoryItems;
import com.example.ProductMangemnet.dto.GetInvoiceResponce;
import com.example.ProductMangemnet.entity.Product;
import com.example.ProductMangemnet.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    //GET ALL GetAllProducts  according to product
    public List<Product> GetAllProducts() {
        return  productRepo.findAll();
    }
    public Product saveProductData( Product product){
           Product prodctinfo=productRepo.save(product);

        return product;
    }

    public boolean checkProductNameExists(String productName) {
        return productRepo.existsByTitle(productName);
    }


    public List<GetCategoryItems> getCategoryItems() {
        List<Object[]> queryResult = productRepo.countProductsByCategory();

       List<GetCategoryItems> customersWithAddresses = new ArrayList<>();

        for (Object[] row : queryResult) {
            GetCategoryItems dto = new GetCategoryItems();
            try {
                dto.setLabel((String) row[0]);
                dto.setId((String) row[0]);
                dto.setValue((Long) row[1]);

            }catch (Exception ex)
            {
                ex.getMessage();
            }

            customersWithAddresses.add(dto);
        }

        return customersWithAddresses;
    }
}
