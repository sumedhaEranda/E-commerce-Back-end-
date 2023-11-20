package com.example.ProductMangemnet.controller;

import com.example.ProductMangemnet.dto.GetCategoryItems;
import com.example.ProductMangemnet.entity.Product;
import com.example.ProductMangemnet.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/product")
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    // Get All products
    @GetMapping("/all")
    public List<Product> getAllNotes()
    {
        return productService.GetAllProducts();
    }

    @PostMapping("/AddProduct")
    public ResponseEntity<Product> postBody( @RequestParam("title") String title, @RequestParam("price") float price, @RequestParam("category") String category, @RequestParam("description") String description, @RequestPart("image") MultipartFile image) {
        Product product=new Product();
        product.setTitle(title);
        product.setPrice(price);
        product.setCategory(category);
        product.setDescription(description);
        Product prodt=  productService.saveProductData(product,image);
        return ResponseEntity.ok(prodt);
    }

    @GetMapping("/check/{title}")
    public ResponseEntity<?> checkProductNameAvailability(@PathVariable("title") String productName) {
        boolean exists = productService.checkProductNameExists(productName);
        return ResponseEntity.ok().body(exists);
    }

    @GetMapping(value = "/getCategoryItems")
    public List<GetCategoryItems> getOrdersWithCustomerDetails() {
        return productService.getCategoryItems();
    }

}
