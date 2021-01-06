package com.suprab.modules.notificacao.service;


import com.suprab.exception.ObjectNotFoundException;
import com.suprab.modules.notificacao.dto.NotificacaoCadastroDTO;
import com.suprab.modules.notificacao.dto.NotificacaoDTO;
import com.suprab.modules.notificacao.entity.Notificacao;
import com.suprab.modules.notificacao.mapper.NotificacaoCadastroMapper;
import com.suprab.modules.notificacao.mapper.NotificacaoMapper;
import com.suprab.modules.notificacao.repository.NotificacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.suprab.modules.utils.StringValidator.isEmptyOrNull;

@Service
@RequiredArgsConstructor
public class NotificacaoService {

    private final NotificacaoRepository repository;
    private final NotificacaoMapper mapper;
    private final NotificacaoCadastroMapper cadastroMapper;;


    @Transactional(readOnly = true)
    public List<Notificacao> listarTudo() {
        return repository.findAll();
    }


    @Transactional
    public Notificacao salvar(final NotificacaoCadastroDTO dto) {
        Notificacao notificacao = cadastroMapper.toEntity(dto);
        notificacao.setDataNotificacao(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        return repository.save(notificacao);
    }

    public Notificacao buscarPeloId(Long id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
                "Usuáio não econtrado pelo ID:" + id
        ));
    }

    public Notificacao editar(NotificacaoCadastroDTO dto) {
        Notificacao notificacao = atualizarDados(buscarPeloId(dto.getId()), cadastroMapper.toEntity(dto));
        return repository.save(notificacao);
    }

    private Notificacao atualizarDados(Notificacao saved, Notificacao dto) {
        saved.setDataNotificacao(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        saved.setTitulo(!isEmptyOrNull(dto.getTitulo()) ? dto.getTitulo() : saved.getTitulo());
        saved.setMensagem(!isEmptyOrNull(dto.getMensagem()) ? dto.getMensagem() : saved.getMensagem());
        return saved;
    }

    public void deletarPeloId(Long id) {
        buscarPeloId(id);
        repository.deleteById(id);
    }
}
