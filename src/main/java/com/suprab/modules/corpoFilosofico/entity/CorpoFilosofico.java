package com.suprab.modules.corpoFilosofico.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "TB_CORPO_FILOSOFICO")
public class CorpoFilosofico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_CORPO_FILOSOFICO")
    private Long id;

    @Column(name = "TX_GRAU")
    private String grau;

    @Column(name = "TX_CORPO")
    private String corpo;

    @Column(name = "DT_GRAU")
    private String dataGrau;

}
