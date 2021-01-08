package com.suprab.modules.membro.dto;

import com.suprab.modules.corpoFilosofico.dto.CorpoFilosoficoDTO;
import com.suprab.modules.endereco.dto.EnderecoDTO;
import com.suprab.modules.membro.StatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MembroDTO {

    private Long id;

    private StatusEnum status;
    private String cgp;
    private String cpf;
    private String nome;
    private String cargo;
    private String tituloHonorifico;
    private String dataNascimento;
    private EnderecoDTO endereco;
    private List<CorpoFilosoficoDTO> corposFilosoficos;


}
