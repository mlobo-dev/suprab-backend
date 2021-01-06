package com.suprab.modules.notificacao.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificacaoCadastroDTO {
    private Long id;
    private String titulo;
    private String mensagem;
}
