package com.tkuzub.entity;

import com.tkuzub.entity.enums.Brand;
import com.tkuzub.entity.enums.Quality;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cars")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id" )
    private Integer carId;

    @Column(name = "name")
    private String carName;

    @Enumerated(EnumType.STRING)
    private Brand brand;

    @Enumerated(EnumType.STRING)
    @Column(name = "quality_class")
    private Quality quality;

    @Column(name = "rental_cost")
    private Double rentalCost;

    private String description;

}
