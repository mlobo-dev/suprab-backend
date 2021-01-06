package com.suprab.modules.endereco.service;


import com.suprab.exception.ObjectNotFoundException;
import com.suprab.modules.endereco.dto.EnderecoDTO;
import com.suprab.modules.endereco.entity.Endereco;
import com.suprab.modules.endereco.mapper.EnderecoMapper;
import com.suprab.modules.endereco.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.suprab.modules.utils.StringValidator.isEmptyOrNull;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository repository;
    private final EnderecoMapper mapper;


    @Transactional(readOnly = true)
    public List<Endereco> listarTudo() {
        return repository.findAll();
    }


    @Transactional
    public Endereco salvar(final EnderecoDTO dto) {
        return repository.save(mapper.toEntity(dto));
    }

    public Endereco salvar(final Endereco endereco) {
        return repository.save(endereco);
    }

    public Endereco buscarPeloId(Long id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
                "Endereco não econtrado pelo ID:" + id
        ));
    }

    public Endereco editar(EnderecoDTO dto) {
        Endereco Endereco = atualizarDados(buscarPeloId(dto.getId()), mapper.toEntity(dto));
        return repository.save(Endereco);
    }

    private Endereco atualizarDados(Endereco saved, Endereco dto) {
        saved.setCidade(isEmptyOrNull(dto.getCidade()) ? dto.getCidade() : saved.getCidade());
        saved.setCpf(isEmptyOrNull(dto.getCpf()) ? dto.getCpf() : saved.getCpf());
        return saved;
    }

    public void deletarPeloId(Long id) {
        buscarPeloId(id);
        repository.deleteById(id);
    }
}
