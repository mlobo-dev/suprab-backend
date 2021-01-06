package com.suprab.modules.notificacao.controller.v1;


import com.suprab.modules.notificacao.dto.NotificacaoCadastroDTO;
import com.suprab.modules.notificacao.dto.NotificacaoDTO;
import com.suprab.modules.notificacao.mapper.NotificacaoCadastroMapper;
import com.suprab.modules.notificacao.mapper.NotificacaoMapper;
import com.suprab.modules.notificacao.service.NotificacaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/notificacoes")
@Api(tags = "Notificações")
@RequiredArgsConstructor
public class NotificacaoController {

    private final NotificacaoService service;
    private final NotificacaoMapper mapper;

    @PostMapping
    @ApiOperation("Salvar uma notificação")
    public ResponseEntity<NotificacaoDTO> salvar(@Validated @RequestBody NotificacaoCadastroDTO dto) {
        return ResponseEntity.ok(mapper.toDto(service.salvar(dto)));
    }

    @PutMapping
    @ApiOperation("Edita uma notificação")
    public ResponseEntity<NotificacaoDTO> editar(@Validated @RequestBody final NotificacaoCadastroDTO dto) {
        return ResponseEntity.ok(mapper.toDto(service.editar(dto)));
    }

    @GetMapping
    @ApiOperation("Lista todas as notificações")
    public ResponseEntity<List<NotificacaoDTO>> listar() {
        return ResponseEntity.ok(mapper.toDto(service.listarTudo()));
    }

    @GetMapping("/{id}")
    @ApiOperation("Busca a notificação Pelo ID ")
    public ResponseEntity<NotificacaoDTO> buscarPeloId(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(mapper.toDto(service.buscarPeloId(id)));
    }


    @DeleteMapping("/{id}")
    @ApiOperation("Deleta pelo ID")
    public ResponseEntity<Void> deletarPeloId(@PathVariable(value = "id") Long id) {
        service.deletarPeloId(id);
        return ResponseEntity.ok().build();
    }


}
