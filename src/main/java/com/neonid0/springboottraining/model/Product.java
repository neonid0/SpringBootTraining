package com.neonid0.springboottraining.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Product {


    @Id
    private int itemId;

    private String itemName;
    private float itemPrice;

}