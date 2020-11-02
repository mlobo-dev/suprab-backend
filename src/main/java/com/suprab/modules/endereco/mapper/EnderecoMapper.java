package com.suprab.modules.endereco.mapper;


import com.suprab.config.mapstruct.BaseMapper;
import com.suprab.modules.endereco.dto.EnderecoDTO;
import com.suprab.modules.endereco.entity.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EnderecoMapper extends BaseMapper<Endereco, EnderecoDTO> {


}
