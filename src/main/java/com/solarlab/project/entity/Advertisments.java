package com.solarlab.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Advertisments")
public class Advertisments {

    @Column(name = "ID")
    @Id
    @SequenceGenerator(
            name = "ads_sequence",
            sequenceName = "ads_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ads_sequence")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @Column(name = "price")
    private int price;

    @Column(name = "category")
    private String category;

    @Column(name = "src")
    @Lob
    private Byte[] src;


}
