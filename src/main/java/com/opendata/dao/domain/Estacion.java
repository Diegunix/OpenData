package com.opendata.dao.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estacion")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Estacion implements Serializable {
    
    private static final long serialVersionUID = 6250491396396124297L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long id;
    @Column @NotNull
    private String descripcion;
    

}
