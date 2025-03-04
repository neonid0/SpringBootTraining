package com.neonid0.springboottraining.repository;

import com.neonid0.springboottraining.model.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Good, Integer> {

    @Query("SELECT p from Good p WHERE " +
    "LOWER(p.productName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.productDescription) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.productBrand) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(p.productCategory) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Good> searchProducts(String keyword);
}
