package com.solarlab.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "advertisments")
public class Advertisment {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @Column(name = "owner")
    private String owner;

    private String text;

    private int price;

    // add a category entity
    @Column(name = "category")
    private String category;

    // image
    @Column(name = "src")
    @Lob
    private byte[] src;


}
