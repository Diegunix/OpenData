package com.opendata.dao.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "air")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Air {

    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_provincia", referencedColumnName = "id_provincia")
    @JoinColumn(name = "id_localidad", referencedColumnName = "id") 
    private Localidad localidad;
    @ManyToOne
    @JoinColumn(name = "estacion")
    private Estacion estacion;
    @ManyToOne
    @JoinColumn(name = "magnitud")
    private Magnitud magnitud;
    @Column(nullable = true)
    private int ano;
    @Column(nullable = true)
    private int mes;
    @Column(nullable = true)
    private int dia;

    @Column(nullable = true)
    private BigDecimal h01;

    @Column(nullable = true)
    private BigDecimal h02;

    @Column(nullable = true)
    private BigDecimal h03;

    @Column(nullable = true)
    private BigDecimal h04;

    @Column(nullable = true)
    private BigDecimal h05;

    @Column(nullable = true)
    private BigDecimal h06;

    @Column(nullable = true)
    private BigDecimal h07;

    @Column(nullable = true)
    private BigDecimal h08;

    @Column(nullable = true)
    private BigDecimal h09;

    @Column(nullable = true)
    private BigDecimal h10;

    @Column(nullable = true)
    private BigDecimal h11;

    @Column(nullable = true)
    private BigDecimal h12;

    @Column(nullable = true)
    private BigDecimal h13;

    @Column(nullable = true)
    private BigDecimal h14;

    @Column(nullable = true)
    private BigDecimal h15;

    @Column(nullable = true)
    private BigDecimal h16;

    @Column(nullable = true)
    private BigDecimal h17;

    @Column(nullable = true)
    private BigDecimal h18;

    @Column(nullable = true)
    private BigDecimal h19;

    @Column(nullable = true)
    private BigDecimal h20;

    @Column(nullable = true)
    private BigDecimal h21;

    @Column(nullable = true)
    private BigDecimal h22;

    @Column(nullable = true)
    private BigDecimal h23;
    
    @Column(nullable = true)
    private BigDecimal h24;
}
