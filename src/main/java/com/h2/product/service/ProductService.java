package com.h2.product.service;

import com.h2.product.dao.ProductDao;
import com.h2.product.entity.Product;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ProductService {


    private final ProductDao productDao;

    public void saveOrUpdateProduct(Product product){
        log.info("Insert product object");
        productDao.save(product);
    }

    public List<Product> getAllProduct(){
        log.info("Finding all product object");
        return productDao.findAll();
    }

    public Product getProduct(int productId){
        log.info("Finding all object by id-{}", productId);
       return productDao.findById(productId).orElse(null);
    }

    public void deleteProduct(Product product){
        log.info("Deleting product object by product id");
        productDao.delete(product);
    }

    public void deleteProduct(int productId){
        log.info("Deleting product object by product id");
        productDao.deleteById(productId);
    }
}
