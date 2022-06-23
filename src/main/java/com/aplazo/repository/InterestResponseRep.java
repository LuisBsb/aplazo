package com.aplazo.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "INTERESTRESPONSEREP")
public class InterestResponseRep {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "payment_number")
    private Integer payment_number;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "payment_date")
    private Date payment_date;

    @ManyToOne(fetch = FetchType.LAZY)
    private Interest interest;
}
