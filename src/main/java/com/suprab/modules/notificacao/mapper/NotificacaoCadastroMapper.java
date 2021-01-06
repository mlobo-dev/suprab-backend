package com.suprab.modules.notificacao.mapper;

import com.suprab.config.mapstruct.BaseMapper;
import com.suprab.modules.notificacao.dto.NotificacaoCadastroDTO;
import com.suprab.modules.notificacao.entity.Notificacao;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface NotificacaoCadastroMapper extends BaseMapper<Notificacao, NotificacaoCadastroDTO> {

}
