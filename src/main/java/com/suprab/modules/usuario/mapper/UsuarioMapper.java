package com.suprab.modules.usuario.mapper;


import com.suprab.config.mapstruct.BaseMapper;
import com.suprab.modules.usuario.dto.UsuarioDTO;
import com.suprab.modules.usuario.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsuarioMapper extends BaseMapper<Usuario, UsuarioDTO> {


}
