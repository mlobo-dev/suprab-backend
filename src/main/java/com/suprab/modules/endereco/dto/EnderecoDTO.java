package com.suprab.modules.endereco.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO {

    private Long id;
    private String cpf;
    private String cidade;
    private String uf;

}
