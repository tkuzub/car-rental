package com.tkuzub.entity;

import com.tkuzub.entity.enums.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rentals")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id")
    private Integer rentalId;

    @Column(name = "rental_start_date")
    private LocalDateTime rentalStart;

    @Column(name = "rental_end_date")
    private LocalDateTime rentalEnd;

    @Column(name = "with_driver")
    private Boolean withDriver;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private Order order;

    @Column(name = "rejection_reason")
    private String rejectionReason;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "client_id")
    private Integer clientId;

    @Column(name = "car_id")
    private Integer carId;
}
