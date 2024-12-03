package com.yashraj.Megamerch.Model;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "P_id")
    private Long id;


    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "category_id")
    private Category category;

    private Double price;

    private Double weight;

    private String description;

    private String imageName;
}
