package com.h2.product.controller;

import com.h2.product.entity.Product;
import com.h2.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping(value = "/saveOrUpdate")
    public ResponseEntity<Void> saveOrUpdateProduct(@RequestBody Product product){
        productService.saveOrUpdateProduct(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable(value = "productId", required = true) String productId){
        productService.deleteProduct(Integer.parseInt(productId));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<Product>> getAllProduct(){
      //  productService.getAllProduct();
//return new ResponseEntity<>(HttpStatus.OK);
        List<Product> allProduct = productService.getAllProduct();
        return new ResponseEntity<>(allProduct, HttpStatus.OK);
    }

    @GetMapping(value = "/getOne")
    public ResponseEntity<Product> getOneProduct(@RequestParam("productId") String productId){
        Product product = productService.getProduct(Integer.parseInt(productId));
        productService.getProduct(Integer.parseInt(productId));
        return ResponseEntity.ok(product);
    }
}
