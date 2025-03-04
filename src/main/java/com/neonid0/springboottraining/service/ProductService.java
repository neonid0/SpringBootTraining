package com.neonid0.springboottraining.service;

import com.neonid0.springboottraining.model.Product;
import com.neonid0.springboottraining.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

//    private List<Product> products = new ArrayList<>(Arrays.asList(
//                    new Product(100, "Samsung", 5000),
//                    new Product(101, "Iphone", 6000),
//                    new Product(102, "Nokia", 4000)));

    public List<Product> getProducts() {

//        return products;
        return repository.findAll();

    }

    public Product getProductById(int itemId) {
//        return products.stream()
//                .filter(p -> p.getItemId() == itemId)
//                .findFirst().orElse(new Product(99, "No Item", 0));
        return repository.findById(itemId).orElse(new Product());
    }

    public void addProduct(Product product){
//       products.add(product);
        repository.save(product);

    }

    public void updateProduct(Product product) {

//        int index = 0;
//        for (int i = 0; i < products.size(); i++) {
//            if (products.get(i).getItemId() == product.getItemId()) {
//                index = i;
//            }
//        }
//
//        products.set(index, product);

        repository.save(product);
    }


    public void deleteProduct(int itemId) {
//        int index = 0;
//
//        for (int i = 0; i < products.size(); i++) {
//            if (products.get(i).getItemId() == itemId) {
//                index = i;
//            }
//        }
//
//        products.remove(index);

        repository.deleteById(itemId);
    }
}
