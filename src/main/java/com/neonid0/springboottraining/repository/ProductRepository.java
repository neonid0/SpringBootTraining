package com.neonid0.springboottraining.repository;

import com.neonid0.springboottraining.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {



}
