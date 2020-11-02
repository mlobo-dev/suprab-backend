package com.suprab.modules.corpoFilosofico.service;


import com.suprab.exception.ObjectNotFoundException;
import com.suprab.modules.corpoFilosofico.dto.CorpoFilosoficoDTO;
import com.suprab.modules.corpoFilosofico.entity.CorpoFilosofico;
import com.suprab.modules.corpoFilosofico.mapper.CorpoFilosoficoMapper;
import com.suprab.modules.corpoFilosofico.repository.CorpoFilosoficoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.suprab.modules.utils.StringValidator.isEmptyOrNull;

@Service
@RequiredArgsConstructor
public class CorpoFilosoficoService {

    private final CorpoFilosoficoRepository repository;
    private final CorpoFilosoficoMapper mapper;

    @Transactional(readOnly = true)
    public List<CorpoFilosofico> listarTudo() {
        return repository.findAll();
    }


    @Transactional
    public CorpoFilosofico salvar(final CorpoFilosoficoDTO dto) {
        return repository.save(mapper.toEntity(dto));
    }

    public CorpoFilosofico buscarPeloId(Long id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
                "Usuáio não econtrado pelo ID:" + id
        ));
    }

    public CorpoFilosofico editar(CorpoFilosoficoDTO dto) {
        CorpoFilosofico CorpoFilosofico = atualizarDados(buscarPeloId(dto.getId()), mapper.toEntity(dto));
        return repository.save(CorpoFilosofico);
    }

    private CorpoFilosofico atualizarDados(CorpoFilosofico saved, CorpoFilosofico dto) {

        saved.setGrau(isEmptyOrNull(dto.getGrau()) ? dto.getGrau() : saved.getGrau());
        saved.setDataGrau(isEmptyOrNull(dto.getDataGrau()) ? dto.getDataGrau() : saved.getDataGrau());
        return saved;
    }

    public void deletarPeloId(Long id) {
        buscarPeloId(id);
        repository.deleteById(id);
    }
}
