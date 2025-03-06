package com.neonid0.springboottraining.Controller;

import com.neonid0.springboottraining.model.Good;
import com.neonid0.springboottraining.service.StoreService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StoreController {

    @Autowired
    StoreService service;

    @GetMapping("/store")
    public ResponseEntity<List<Good>> getProducts() {

        return new ResponseEntity<>(service.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/store/{productId}")
    public ResponseEntity<Good> getProductsById(@PathVariable int productId) {

        Good good = service.getProductById(productId);

        if (good != null )
            return new ResponseEntity<>(good, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/store/{productId}/image")
    public ResponseEntity<byte[]> getImageById(@PathVariable int productId) {

        Good good = service.getProductById(productId);
        byte[] imageFile = good.getImageData();

        if (imageFile != null)
            return ResponseEntity.ok()
                    .contentType(MediaType.valueOf(good.getImageType()))
                    .body(imageFile);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrftoken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/store")
    public ResponseEntity<?> addProduct(@RequestPart Good product,
                                        @RequestPart MultipartFile imageFile) {
        try {
            Good good1 = service.addProduct(product, imageFile);
            return new ResponseEntity<>(good1, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/store/{productId}")
    public ResponseEntity<String> updateProduct(@PathVariable int productId,
                                                @RequestPart Good product,
                                                @RequestPart MultipartFile imageFile) throws IOException {

        Good good = service.updateProduct(productId, product, imageFile);

        if (good != null) {
            return new ResponseEntity<>("Product is successfully updated.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Update failed.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/store/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable int productId) {

        Good good = service.getProductById(productId);

       if (good != null) {
           service.deleteProduct(productId);
           return new ResponseEntity<>("Product deleted.", HttpStatus.OK);
       } else {
           return new ResponseEntity<>("Product not found.", HttpStatus.NOT_FOUND);
       }

    }

    @GetMapping("/store/search")
    public ResponseEntity<List<Good>> searchProduct(@RequestParam String keyword) {
        List<Good> products = service.searchProducts(keyword);

        return new ResponseEntity<>(products, HttpStatus.OK);

    }

}
