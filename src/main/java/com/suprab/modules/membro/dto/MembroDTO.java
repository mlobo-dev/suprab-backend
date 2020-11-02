package com.suprab.modules.membro.dto;

import com.suprab.modules.membro.StatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MembroDTO {

    private Long id;
    private StatusEnum status;
    private String cgp;
    private String cpf;
    private String nome;
    private String dataNascimento;
    private String cidade;
    private String uf;
    private String cargo;
    private String tituloHonorifico;
    private String grau;
    private String dataGrau;
    private String corpoFilosofico;
}
