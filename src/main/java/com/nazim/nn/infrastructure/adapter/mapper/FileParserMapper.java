package com.nazim.nn.infrastructure.adapter.mapper;

import com.nazim.nn.domain.entity.OutpayHeader;
import com.nazim.nn.domain.entity.Policy;
import com.nazim.nn.domain.entity.SurValues;
import com.nazim.nn.infrastructure.adapter.model.OutpayHeaderModel;
import com.nazim.nn.infrastructure.adapter.model.PolicyModel;
import com.nazim.nn.infrastructure.adapter.model.SurValuesModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface FileParserMapper {

    List<Policy> toPolicyEntity(List<PolicyModel> models);

    List<SurValues> toSurValuesEntity(List<SurValuesModel> models);

    List<OutpayHeader> toOutpayHeaderEntity(List<OutpayHeaderModel> models);

}
