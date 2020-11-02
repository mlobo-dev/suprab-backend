package com.suprab.modules.membro.mapper;


import com.suprab.config.mapstruct.BaseMapper;
import com.suprab.modules.membro.dto.MembroCadastroDTO;
import com.suprab.modules.membro.dto.MembroDTO;
import com.suprab.modules.membro.entity.Membro;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MembroCadastroMapper extends BaseMapper<Membro, MembroCadastroDTO> {


}
