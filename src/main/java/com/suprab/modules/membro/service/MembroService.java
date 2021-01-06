package com.suprab.modules.membro.service;


import com.suprab.exception.ObjectNotFoundException;
import com.suprab.modules.corpoFilosofico.entity.CorpoFilosofico;
import com.suprab.modules.corpoFilosofico.mapper.CorpoFilosoficoMapper;
import com.suprab.modules.corpoFilosofico.service.CorpoFilosoficoService;
import com.suprab.modules.endereco.mapper.EnderecoCadastroMapper;
import com.suprab.modules.endereco.service.EnderecoService;
import com.suprab.modules.membro.dto.MembroCadastroDTO;
import com.suprab.modules.membro.dto.MembroDTO;
import com.suprab.modules.membro.entity.Membro;
import com.suprab.modules.membro.mapper.MembroCadastroMapper;
import com.suprab.modules.membro.mapper.MembroMapper;
import com.suprab.modules.membro.repository.MembroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.suprab.modules.utils.StringValidator.isEmptyOrNull;

@Service
@RequiredArgsConstructor
public class MembroService {

    private final MembroRepository repository;
    private final MembroMapper mapper;
    private final CorpoFilosoficoService corpoService;
    private final MembroCadastroMapper cadastroMapper;
    private final EnderecoService enderecoService;
    private final CorpoFilosoficoMapper corpoMapper;
    private final EnderecoCadastroMapper enderecoMapper;

    @Transactional(readOnly = true)
    public List<Membro> listarTudo() {
        return repository.findAll();
    }


    @Transactional
    public Membro salvar(final MembroCadastroDTO dto) {
        Membro membro = cadastroMapper.toEntity(dto);

        membro.setEndereco(enderecoService.salvar(enderecoMapper.toEntity(dto)));

        if (!dto.getCorposFilosoficos().isEmpty()) {
            List<CorpoFilosofico> corpos = corpoMapper.toEntity(dto.getCorposFilosoficos());
            membro.setCorposFilosoficos(corpoService.salvarTodos(corpos));
        }

        return repository.save(membro);
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

    public Membro adicionarCorpoFilosofico(Long idMembro, Long idCorpo) {
        Membro membro = buscarPeloId(idMembro);
        if (membro.getCorposFilosoficos() == null) {
            membro.setCorposFilosoficos(new ArrayList<>());
        }

        CorpoFilosofico corpo = corpoService.buscarPeloId(idCorpo);

        if (!membro.getCorposFilosoficos().contains(corpo)) {
            membro.getCorposFilosoficos().add(corpo);
            return repository.save(membro);
        }
        return membro;

    }

    public Membro removerCorpoFilosofico(Long idMembro, Long idCorpo) {
        Membro membro = buscarPeloId(idMembro);
        if (membro.getCorposFilosoficos() == null) {
            throw new ObjectNotFoundException("Esse membro não possui o corpo fisolófico informado");
        }

        CorpoFilosofico corpo = corpoService.buscarPeloId(idCorpo);
        membro.getCorposFilosoficos().removeIf(c -> c.getId().equals(corpo.getId()));
        return repository.save(membro);
    }
}
