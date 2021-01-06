package com.suprab.modules.corpoFilosofico.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CorpoFilosoficoDTO {

    private Long id;

    @NotEmpty(message = "Grau não pode ser vazio")
    @Size(max=13)
    private String grau;

    @NotEmpty(message = "Corpo não pode ser vazio")
    private String corpo;

    @NotEmpty(message = "Data grau não pode ser vazio")
    private String dataGrau;
}
