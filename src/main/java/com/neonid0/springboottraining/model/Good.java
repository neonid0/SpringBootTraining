package com.neonid0.springboottraining.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Good {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    private String productName;
    private String productDescription;
    private String productBrand;
    private int productPrice;
    private String productCategory;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
    private Date productReleaseDate;
    private boolean productAvail;
    private int productQuantity;

    private String imageName;
    private String imageType;
    @Lob
    private byte[] imageData;
}
