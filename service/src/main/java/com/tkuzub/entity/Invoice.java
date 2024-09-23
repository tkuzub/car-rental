package com.tkuzub.entity;

import com.tkuzub.entity.enums.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private Integer invoiceId;

    private Double amount;

    @Column(name = "issue_date")
    private LocalDate issueDate;

    private Boolean paid;

    @Enumerated(EnumType.STRING)
    @Column(name = "invoice_type")
    private Type type;

    @Column(name = "rental_id")
    private Integer rentalId;

}
