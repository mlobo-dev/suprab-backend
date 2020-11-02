package com.suprab.modules.usuario.service;


import com.suprab.exception.ObjectNotFoundException;
import com.suprab.modules.usuario.dto.UsuarioDTO;
import com.suprab.modules.usuario.entity.Usuario;
import com.suprab.modules.usuario.mapper.UsuarioMapper;
import com.suprab.modules.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.security.auth.message.AuthException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;


    @Transactional(readOnly = true)
    public List<Usuario> listarTudo() {
        return repository.findAll();
    }


    @Transactional
    public Usuario salvar(final UsuarioDTO dto) {
        return repository.save(mapper.toEntity(dto));
    }

    public Usuario buscarPeloId(Long id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
                "Usuáio não econtrado pelo ID:" + id
        ));
    }



    public void deletarPeloId(Long id) {
        buscarPeloId(id);
        repository.deleteById(id);
    }

    public Usuario autenticar(String login, String senha) throws AuthException {
        Optional<Usuario> usuario = repository.findByLogin(login);
        if (!usuario.isPresent()) {
            throw new AuthException("Usuário não encontrado: " );
        }

        if (!usuario.get().getSenha().equals(senha)) {
            throw new AuthException("Senha Inválida.");
        }
        return usuario.get();
    }
}
