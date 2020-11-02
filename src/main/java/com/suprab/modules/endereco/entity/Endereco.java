package com.suprab.modules.endereco.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "TB_ENDERECO")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_ENDERECO")
    private Long id;

    @Column(name = "TX_CPF")
    private String cpf;

    @Column(name = "TX_CIDADE")
    private String cidade;

    @Column(name = "TX_UF")
    private String uf;

    @Column(name = "TX_CEP")
    private String cep;


}
