package com.suprab.modules.notificacao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "TB_NOTIFICACAO")
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_NOTIFICACAO")
    private Long id;

    @Column(name = "TX_TITULO")
    private String titulo;

    @Column(name = "TX_MENSAGEM")
    private String mensagem;


}
