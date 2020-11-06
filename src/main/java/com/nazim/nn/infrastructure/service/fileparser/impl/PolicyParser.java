package com.nazim.nn.infrastructure.service.fileparser.impl;

import com.nazim.nn.infrastructure.adapter.model.PolicyModel;
import com.nazim.nn.infrastructure.service.fileparser.FileParserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PolicyParser implements FileParserService {

    @Override
    public String getType() {
        return "POLICY";
    }

    @Override
    public List<PolicyModel> parse(String text) {
        return getPolicyList(getCellsAsList(text));
    }

    private List<PolicyModel> getPolicyList(List<String[]> cellsArrayList){
        List<PolicyModel> policyList = new ArrayList<>();

        cellsArrayList.forEach(line -> policyList.add(createPolicyModel(line)));

        return policyList;
    }

    private List<String[]> getCellsAsList(String text){
        List<String[]> individualItems = new ArrayList<>();
        for (String line : getLines(text)){
            individualItems.add(line.split("\\|"));
        }
        return individualItems;
    }

    private PolicyModel createPolicyModel(String[] rawList){
        PolicyModel policy = new PolicyModel();

        try {
            policy.setChdrnum(rawList[0].trim());
            policy.setCownnum(rawList[1].trim());
            policy.setOwnerName(rawList[2].trim());
            policy.setLifcNum(rawList[3].trim());
            policy.setLifcName(rawList[4].trim());
            policy.setAracde(rawList[5].trim());
            policy.setAgntnum(rawList[6].trim());
            policy.setMailAddress(rawList[7].trim());

        } catch (StringIndexOutOfBoundsException e){
            log.warn("Missing data!");
        }

        return policy;
    }
}
