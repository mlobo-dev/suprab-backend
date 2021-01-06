package com.suprab.modules.endereco.mapper;

import com.suprab.config.mapstruct.BaseMapper;
import com.suprab.modules.endereco.entity.Endereco;
import com.suprab.modules.membro.dto.MembroCadastroDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EnderecoCadastroMapper extends BaseMapper<Endereco, MembroCadastroDTO> {


}
