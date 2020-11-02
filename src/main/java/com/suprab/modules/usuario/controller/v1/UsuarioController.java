package com.suprab.modules.usuario.controller.v1;


import com.suprab.modules.usuario.dto.UsuarioAuthDTO;
import com.suprab.modules.usuario.dto.UsuarioDTO;
import com.suprab.modules.usuario.entity.Usuario;
import com.suprab.modules.usuario.mapper.UsuarioMapper;
import com.suprab.modules.usuario.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.message.AuthException;
import java.util.List;

@RestController
@RequestMapping("/v1/usuarios")
@Api(tags = "Usuários")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;
    private final UsuarioMapper mapper;

    @PostMapping
    @ApiOperation("Salvar uma notificação")
    public ResponseEntity<UsuarioDTO> salvar(@Validated @RequestBody UsuarioDTO dto) {
        return ResponseEntity.ok(mapper.toDto(service.salvar(dto)));
    }

    @GetMapping
    @ApiOperation("Lista todas as notificações")
    public ResponseEntity<List<UsuarioDTO>> listar() {
        return ResponseEntity.ok(mapper.toDto(service.listarTudo()));
    }

    @GetMapping("/{id}")
    @ApiOperation("Busca a notificação Pelo ID ")
    public ResponseEntity<UsuarioDTO> buscarPeloId(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(mapper.toDto(service.buscarPeloId(id)));
    }


    @DeleteMapping("/{id}")
    @ApiOperation("Deleta pelo ID")
    public ResponseEntity<Void> deletarPeloId(@PathVariable(value = "id") Long id) {
        service.deletarPeloId(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/autenticar")
    @ApiOperation("Rota para autenticar o usuário através do login/email e senha.")
    public ResponseEntity autenticar(@RequestBody UsuarioAuthDTO dto) {
        try {
            Usuario usuarioAutenticado = service.autenticar(dto.getLogin(), dto.getSenha());
            return ResponseEntity.ok(mapper.toDto(usuarioAutenticado));
        } catch (AuthException e) {
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }

}
