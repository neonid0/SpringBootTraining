package com.neonid0.springboottraining.Controller;

import com.neonid0.springboottraining.model.Product;
import com.neonid0.springboottraining.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController{

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @GetMapping("/products/{itemId}")
    public Product getProductById(@PathVariable int itemId) {
        return service.getProductById(itemId);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product) {
       service.addProduct(product);
    }

    @PutMapping("/products")
    public void updateProduct(@RequestBody Product product) {
        service.updateProduct(product);
    }

    @DeleteMapping("/products/{itemId}")
    public void deleteProduct(@PathVariable int itemId) {
        service.deleteProduct(itemId);
    }
}
