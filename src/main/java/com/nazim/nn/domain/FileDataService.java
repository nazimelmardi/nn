package com.nazim.nn.domain;

import com.nazim.nn.domain.entity.OutpayHeader;
import com.nazim.nn.domain.entity.Policy;
import com.nazim.nn.domain.entity.SurValues;
import com.nazim.nn.domain.persistence.OutpayHeaderRepository;
import com.nazim.nn.domain.persistence.PolicyRepository;
import com.nazim.nn.domain.persistence.SurValuesRepository;
import com.nazim.nn.domain.value.Type;
import com.nazim.nn.infrastructure.adapter.mapper.FileParserMapper;
import com.nazim.nn.infrastructure.adapter.model.OutpayHeaderModel;
import com.nazim.nn.infrastructure.adapter.model.PolicyModel;
import com.nazim.nn.infrastructure.adapter.model.SurValuesModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FileDataService <T> {

    private final PolicyRepository policyRepository;
    private final OutpayHeaderRepository outpayHeaderRepository;
    private final SurValuesRepository surValuesRepository;
    private final FileParserMapper mapper;

    @Transactional
    public void save(List<T> models, Type type) {
        switch (type) {
            case POLICY:
                List<PolicyModel> policyModels = (List<PolicyModel>) models;
                savePolicy(policyModels);
                break;
            case OUTHEADER:
                List<OutpayHeaderModel> outpayHeaderModels = (List<OutpayHeaderModel>) models;
                saveOutpayHeader(outpayHeaderModels);
                break;
            case SURVALUES:
                List<SurValuesModel> surValuesModels = (List<SurValuesModel>) models;
                saveSurValues(surValuesModels);
                break;
        }
    }

    private void savePolicy(List<PolicyModel> models) {
        List<Policy> entities = mapper.toPolicyEntity(models);

        entities.stream().forEach(policyRepository::save);
    }

    private void saveSurValues(List<SurValuesModel> models) {
        List<SurValues> entities = mapper.toSurValuesEntity(models);

        entities.stream().forEach(surValuesRepository::save);
    }

    private void saveOutpayHeader(List<OutpayHeaderModel> models) {
        List<OutpayHeader> entities = mapper.toOutpayHeaderEntity(models);

        entities.stream().forEach(outpayHeaderRepository::save);
    }
}
