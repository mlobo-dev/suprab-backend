package com.suprab.modules.membro.controller.v1;


import com.suprab.modules.membro.dto.MembroCadastroDTO;
import com.suprab.modules.membro.dto.MembroDTO;
import com.suprab.modules.membro.mapper.MembroCadastroMapper;
import com.suprab.modules.membro.mapper.MembroMapper;
import com.suprab.modules.membro.service.MembroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/membros")
@Api(tags = "Membros")
@RequiredArgsConstructor
public class MembroController {

    private final MembroService service;
    private final MembroMapper mapper;
    private final MembroCadastroMapper cadastroMapper;

    @PostMapping
    @ApiOperation("Salvar um Funcionário")
    public ResponseEntity<MembroDTO> salvar(@Validated @RequestBody MembroCadastroDTO dto) {
        return ResponseEntity.ok(mapper.toDto(service.salvar(dto)));
    }

    @PutMapping
    @ApiOperation("Edita um  Funcionário.")
    public ResponseEntity<MembroDTO> editar(@Validated @RequestBody final MembroCadastroDTO dto) {
        return ResponseEntity.ok(mapper.toDto(service.editar(dto)));
    }

    @GetMapping
    @ApiOperation("Lista todas os Funcionários ")
    public ResponseEntity<List<MembroDTO>> listar() {
        return ResponseEntity.ok(mapper.toDto(service.listarTudo()));
    }

    @GetMapping("/{id}")
    @ApiOperation("Busca o Funcionário Pelo ID ")
    public ResponseEntity<MembroDTO> buscarPeloId(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(mapper.toDto(service.buscarPeloId(id)));
    }

    @GetMapping("/{idMembro}/adicionar/{idCorpo}")
    @ApiOperation("Adiciona o corpo filosófico ao membro")
    public ResponseEntity<MembroDTO> adicionarCorpoFilosofico(@PathVariable(value = "idMembro") Long idMembro, @PathVariable(value = "idCorpo") Long idCorpo) {
        return ResponseEntity.ok(mapper.toDto(service.adicionarCorpoFilosofico(idMembro, idCorpo)));
    }

    @GetMapping("/{idMembro}/remover/{idCorpo}")
    @ApiOperation("remove o corpo filosófico ao membro")
    public ResponseEntity<MembroDTO> removerCorpoFilosofico(@PathVariable(value = "idMembro") Long idMembro, @PathVariable(value = "idCorpo") Long idCorpo) {
        return ResponseEntity.ok(mapper.toDto(service.adicionarCorpoFilosofico(idMembro, idCorpo)));
    }


    @DeleteMapping("/{id}")
    @ApiOperation("Deleta pelo ID")
    public ResponseEntity<Void> deletarPeloId(@PathVariable(value = "id") Long id) {
        service.deletarPeloId(id);
        return ResponseEntity.ok().build();
    }


}
