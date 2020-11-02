package com.suprab.modules.usuario.dto;

import lombok.*;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioAuthDTO {

    private String login;
    private String senha;
}
