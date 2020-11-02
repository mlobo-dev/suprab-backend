package com.suprab.modules.endereco.controller.v1;


import com.suprab.modules.endereco.dto.EnderecoDTO;
import com.suprab.modules.endereco.mapper.EnderecoMapper;
import com.suprab.modules.endereco.service.EnderecoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/enderecos")
@Api(tags = "Endereços")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoService service;
    private final EnderecoMapper mapper;

    @PostMapping
    @ApiOperation("Salvar um Funcionário")
    public ResponseEntity<EnderecoDTO> salvar(@Validated @RequestBody EnderecoDTO dto) {
        return ResponseEntity.ok(mapper.toDto(service.salvar(dto)));
    }

    @PutMapping
    @ApiOperation("Edita um  Funcionário.")
    public ResponseEntity<EnderecoDTO> editar(@Validated @RequestBody final EnderecoDTO dto) {
        return ResponseEntity.ok(mapper.toDto(service.editar(dto)));
    }

    @GetMapping
    @ApiOperation("Lista todas os Funcionários ")
    public ResponseEntity<List<EnderecoDTO>> listar() {
        return ResponseEntity.ok(mapper.toDto(service.listarTudo()));
    }

    @GetMapping("/{id}")
    @ApiOperation("Busca o Funcionário Pelo ID ")
    public ResponseEntity<EnderecoDTO> buscarPeloId(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(mapper.toDto(service.buscarPeloId(id)));
    }


    @DeleteMapping("/{id}")
    @ApiOperation("Deleta pelo ID")
    public ResponseEntity<Void> deletarPeloId(@PathVariable(value = "id") Long id) {
        service.deletarPeloId(id);
        return ResponseEntity.ok().build();
    }


}
