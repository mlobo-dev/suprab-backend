package com.suprab.modules.corpoFilosofico.controller.v1;


import com.suprab.modules.corpoFilosofico.dto.CorpoFilosoficoDTO;
import com.suprab.modules.corpoFilosofico.mapper.CorpoFilosoficoMapper;
import com.suprab.modules.corpoFilosofico.service.CorpoFilosoficoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/corpos")
@Api(tags = "Corpo Filosófico")
@RequiredArgsConstructor
public class CorpoFilosoficoController {

    private final CorpoFilosoficoService service;
    private final CorpoFilosoficoMapper mapper;

    @PostMapping
    @ApiOperation("Salvar um Funcionário")
    public ResponseEntity<CorpoFilosoficoDTO> salvar(@Valid @RequestBody CorpoFilosoficoDTO dto) {
        return ResponseEntity.ok(mapper.toDto(service.salvar(dto)));
    }

    @PutMapping
    @ApiOperation("Edita um  Funcionário.")
    public ResponseEntity<CorpoFilosoficoDTO> editar(@Valid @RequestBody final CorpoFilosoficoDTO dto) {
        return ResponseEntity.ok(mapper.toDto(service.editar(dto)));
    }

    @GetMapping
    @ApiOperation("Lista todas os Funcionários ")
    public ResponseEntity<List<CorpoFilosoficoDTO>> listar() {
        return ResponseEntity.ok(mapper.toDto(service.listarTudo()));
    }

    @GetMapping("/{id}")
    @ApiOperation("Busca o Funcionário Pelo ID ")
    public ResponseEntity<CorpoFilosoficoDTO> buscarPeloId(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(mapper.toDto(service.buscarPeloId(id)));
    }


    @DeleteMapping("/{id}")
    @ApiOperation("Deleta pelo ID")
    public ResponseEntity<Void> deletarPeloId(@PathVariable(value = "id") Long id) {
        service.deletarPeloId(id);
        return ResponseEntity.ok().build();
    }


}
