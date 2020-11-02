package com.suprab.modules.Endereco.mapper;


import com.suprab.config.mapstruct.BaseMapper;
import com.suprab.modules.Endereco.dto.EnderecoDTO;
import com.suprab.modules.Endereco.entity.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EnderecoMapper extends BaseMapper<Endereco, EnderecoDTO> {


}
