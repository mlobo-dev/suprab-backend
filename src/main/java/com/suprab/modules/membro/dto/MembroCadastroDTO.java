package com.suprab.modules.membro.dto;

import com.suprab.modules.corpoFilosofico.dto.CorpoFilosoficoDTO;
import com.suprab.modules.membro.StatusEnum;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MembroCadastroDTO {

    private Long id;

    @NotNull(message = "Nome não pode ser nulo")
    private StatusEnum status;

    @NotEmpty(message = "Nome não pode ser vazio")
    private String cgp;

    @CPF(message = "Cpf inválido")
    private String cpf;

    @NotEmpty(message = "Nome não pode ser vazio")
    private String nome;

    @NotEmpty(message = "Nome não pode ser vazio")
    @Size(min=2, max=2)
    private String tipoSanguineo;

    @NotEmpty(message = "Cargo não pode ser vazio")
    private String cargo;

    @NotEmpty(message = "Título honorífico não pode ser vazio")
    private String tituloHonorifico;

    @NotEmpty(message = "Data de nascimento não pode ser vazio")
    private String dataNascimento;

    @NotEmpty(message = "Cep não pode ser vazio")
    private String cep;

    @NotEmpty(message = "Cidade não pode ser vazio")
    private String cidade;

    @NotEmpty(message = "UF não pode ser vazio")
    @Size(max=2)
    private String uf;

    private List<CorpoFilosoficoDTO> corposFilosoficos = new ArrayList<>();

}
