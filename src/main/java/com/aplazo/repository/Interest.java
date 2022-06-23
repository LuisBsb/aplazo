package com.aplazo.repository;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "INTEREST")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="interest_id_seq")
    @SequenceGenerator(name="interest_id_seq", sequenceName="interest_id_seq", allocationSize=1)
    @Column(name = "IDINTEREST")
    private Integer idInterest;

    @NonNull
    @Column(name = "REQUEST")
    private String request;

    @Column(name = "RESPONSE")
    private String response;
}
