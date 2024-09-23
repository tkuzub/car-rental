package com.tkuzub.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "returns")
public class Return {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "return_id")
    private Integer returnId;

    @Column(name = "return_date")
    private LocalDateTime returnDate;

    @Column(name = "damage_report")
    private String report;

    @Column(name = "damage_fee")
    private Double damage;

    @Column(name = "repair_invoice_id")
    private Integer repairInvoiceId;

    @Column(name = "rental_id")
    private Integer rentalId;
}
