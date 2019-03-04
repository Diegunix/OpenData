package com.opendata.dao.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
    @JoinColumns({ @JoinColumn(name = "id_provincia", referencedColumnName = "id_provincia"),
            @JoinColumn(name = "id_localidad", referencedColumnName = "id") })
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
    private BigDecimal H01;

    @Column(nullable = true)
    private BigDecimal H02;

    @Column(nullable = true)
    private BigDecimal H03;

    @Column(nullable = true)
    private BigDecimal H04;

    @Column(nullable = true)
    private BigDecimal H05;

    @Column(nullable = true)
    private BigDecimal H06;

    @Column(nullable = true)
    private BigDecimal H07;

    @Column(nullable = true)
    private BigDecimal H08;

    @Column(nullable = true)
    private BigDecimal H09;

    @Column(nullable = true)
    private BigDecimal H10;

    @Column(nullable = true)
    private BigDecimal H11;

    @Column(nullable = true)
    private BigDecimal H12;

    @Column(nullable = true)
    private BigDecimal H13;

    @Column(nullable = true)
    private BigDecimal H14;

    @Column(nullable = true)
    private BigDecimal H15;

    @Column(nullable = true)
    private BigDecimal H16;

    @Column(nullable = true)
    private BigDecimal H17;

    @Column(nullable = true)
    private BigDecimal H18;

    @Column(nullable = true)
    private BigDecimal H19;

    @Column(nullable = true)
    private BigDecimal H20;

    @Column(nullable = true)
    private BigDecimal H21;

    @Column(nullable = true)
    private BigDecimal H22;

    @Column(nullable = true)
    private BigDecimal H23;
    
    @Column(nullable = true)
    private BigDecimal H24;
}
