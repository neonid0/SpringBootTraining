package com.neonid0.springboottraining.service;

import com.neonid0.springboottraining.model.Good;
import com.neonid0.springboottraining.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class StoreService {

    @Autowired
    StoreRepository repository;

    public List<Good> getProducts() {
        return repository.findAll();
    }

    public Good getProductById(int productId) {
        return repository.findById(productId).orElse(null);
    }

    public Good addProduct(Good product,
                           MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return repository.save(product);
    }

    public Good updateProduct(int productId, Good product, MultipartFile imageFile) throws IOException {

        product.setProductId(productId);

        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());

        return repository.save(product);
    }

    public void deleteProduct(int productId) {
        repository.deleteById(productId);
    }


    public List<Good> searchProducts(String keyword) {
        return repository.searchProducts(keyword);
    }
}
