package com.suprab.modules.corpoFilosofico.mapper;


import com.suprab.config.mapstruct.BaseMapper;
import com.suprab.modules.corpoFilosofico.dto.CorpoFilosoficoDTO;
import com.suprab.modules.corpoFilosofico.entity.CorpoFilosofico;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CorpoFilosoficoMapper extends BaseMapper<CorpoFilosofico, CorpoFilosoficoDTO> {


}
