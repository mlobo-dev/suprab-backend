package com.suprab.modules.usuario.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "TB_USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_USUARIO")
    private Long id;

    @Column(name = "TX_NOME")
    private String nome;

    @Column(name = "TX_CPF")
    private String cpf;

    @Column(name = "TX_SENHA")
    private String senha;

    @Column(name = "TX_LOGIN")
    private String login;


}
