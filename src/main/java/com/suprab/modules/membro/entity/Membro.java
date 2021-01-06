package com.suprab.modules.membro.entity;

import com.suprab.modules.corpoFilosofico.entity.CorpoFilosofico;
import com.suprab.modules.endereco.entity.Endereco;
import com.suprab.modules.membro.StatusEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "TB_MEMBRO_CORPO_FILOSOFICO",
            joinColumns = @JoinColumn(name = "COD_MEMBRO"),
            inverseJoinColumns = @JoinColumn(name = "COD_CORPO_FILOSOFICO")
    )
    private List<CorpoFilosofico> corposFilosoficos;

    @ManyToOne
    @JoinColumn(name = "COD_ENDERECO")
    private Endereco endereco;


}
