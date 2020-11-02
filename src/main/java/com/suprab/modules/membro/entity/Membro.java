package com.suprab.modules.membro.entity;

import com.suprab.modules.membro.StatusEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "TB_MEMBRO")
public class Membro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_MEMBRO")
    private Long id;

    @Column(name = "TX_STATUS")
    private StatusEnum status;

    @Column(name = "TX_CGP")
    private String cgp;

    @Column(name = "TX_CPF")
    private String cpf;

    @Column(name = "TX_NOME")
    private String nome;

    @Column(name = "TX_TIPO_SANGUINEO")
    private String tipoSanguineo;

    @Column(name = "TX_CARGO")
    private String cargo;

    @Column(name = "TX_TITULO_HONORIFICO")
    private String tituloHonorifico;

    @Column(name = "DT_NASCIMENTO")
    private String dataNascimento;







}
