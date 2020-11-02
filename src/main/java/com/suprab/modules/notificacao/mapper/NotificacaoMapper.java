package com.suprab.modules.notificacao.mapper;


import com.suprab.config.mapstruct.BaseMapper;
import com.suprab.modules.notificacao.dto.NotificacaoDTO;
import com.suprab.modules.notificacao.entity.Notificacao;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface NotificacaoMapper extends BaseMapper<Notificacao, NotificacaoDTO> {


}
