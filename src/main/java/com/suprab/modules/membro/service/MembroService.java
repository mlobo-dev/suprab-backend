package com.suprab.modules.membro.service;


import com.suprab.exception.ObjectNotFoundException;
import com.suprab.modules.membro.dto.MembroDTO;
import com.suprab.modules.membro.entity.Membro;
import com.suprab.modules.membro.mapper.MembroMapper;
import com.suprab.modules.membro.repository.MembroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.suprab.modules.utils.StringValidator.isEmptyOrNull;

@Service
@RequiredArgsConstructor
public class MembroService {

    private final MembroRepository repository;
    private final MembroMapper mapper;


    @Transactional(readOnly = true)
    public List<Membro> listarTudo() {
        return repository.findAll();
    }


    @Transactional
    public Membro salvar(final MembroDTO dto) {
        return repository.save(mapper.toEntity(dto));
    }

    public Membro buscarPeloId(Long id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
                "Usuáio não econtrado pelo ID:" + id
        ));
    }

    public Membro editar(MembroDTO dto) {
        Membro membro = atualizarDados(buscarPeloId(dto.getId()), mapper.toEntity(dto));
        return repository.save(membro);
    }

    private Membro atualizarDados(Membro saved, Membro dto) {
        saved.setNome(isEmptyOrNull(dto.getNome()) ? dto.getNome() : saved.getNome());
        saved.setCargo(isEmptyOrNull(dto.getCargo()) ? dto.getCargo() : saved.getCargo());
        saved.setCgp(isEmptyOrNull(dto.getCgp()) ? dto.getCgp() : saved.getCgp());
        saved.setCpf(isEmptyOrNull(dto.getCpf()) ? dto.getCpf() : saved.getCpf());
        saved.setDataNascimento(isEmptyOrNull(dto.getDataNascimento()) ? dto.getDataNascimento() : saved.getDataNascimento());
        saved.setStatus(dto.getStatus() != null ? dto.getStatus() : saved.getStatus());
        saved.setTituloHonorifico(isEmptyOrNull(dto.getTituloHonorifico()) ? dto.getTituloHonorifico() : saved.getTituloHonorifico());
        return saved;
    }

    public void deletarPeloId(Long id) {
        buscarPeloId(id);
        repository.deleteById(id);
    }
}
