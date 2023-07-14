package com.example.ProductMangemnet.service;


import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.example.ProductMangemnet.dto.GetCategoryItems;
import com.example.ProductMangemnet.dto.GetInvoiceResponce;
import com.example.ProductMangemnet.entity.Product;
import com.example.ProductMangemnet.repository.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Service
@Slf4j
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    @Value("${application.bucket.name}")
    private String bucketName;

    @Autowired
    private AmazonS3 s3Client;

    //GET ALL GetAllProducts  according to product
    public List<Product> GetAllProducts() {
        return  productRepo.findAll();
    }
    public Product saveProductData( Product product ,MultipartFile file){
           product.setImgpath(uploadFile(file));
           Product prodctinfo=productRepo.save(product);

        return product;
    }

    public String uploadFile(MultipartFile file) {
        File fileObj = convertMultiPartFileToFile(file);
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        s3Client.putObject(new PutObjectRequest(bucketName, fileName, fileObj));
        fileObj.delete();
        // Generate the object URL
        String objectUrl = s3Client.getUrl(bucketName, fileName).toString();
        return objectUrl;

    }

    public String deleteFile(String fileName) {
        s3Client.deleteObject(bucketName, fileName);
        return fileName + " removed ...";
    }


    private File convertMultiPartFileToFile(MultipartFile file) {
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        } catch (IOException e) {
            log.error("Error converting multipartFile to file", e);
        }
        return convertedFile;
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
