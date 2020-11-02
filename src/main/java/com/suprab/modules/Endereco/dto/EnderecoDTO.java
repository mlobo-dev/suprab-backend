package com.suprab.modules.Endereco.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO {

    private Long id;
    private String cpf;
    private String cep;
    private String cidade;
    private String uf;

}
