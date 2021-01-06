package com.suprab.modules.membro.dto;

import com.suprab.modules.corpoFilosofico.dto.CorpoFilosoficoDTO;
import com.suprab.modules.membro.StatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MembroCadastroDTO {

    private Long id;

    private StatusEnum status;
    private String cgp;
    private String cpf;
    private String nome;
    private String tipoSanguineo;
    private String cargo;
    private String tituloHonorifico;
    private String dataNascimento;
    private String cep;
    private String cidade;
    private String uf;
    private List<CorpoFilosoficoDTO> corposFilosoficos = new ArrayList<>();


}
