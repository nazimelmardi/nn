package com.nazim.nn.infrastructure.service.fileparser.impl;

import com.nazim.nn.domain.value.Type;
import com.nazim.nn.infrastructure.adapter.model.SurValuesModel;
import com.nazim.nn.infrastructure.service.fileparser.FileParserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class SurValuesParser implements FileParserService {

    @Override
    public Type getType() {
        return Type.SURVALUES;
    }

    @Override
    public List<SurValuesModel> parse(String textFileContent) {

        return getSurValueList(getCellsAsList(textFileContent));
    }

    private List<SurValuesModel> getSurValueList(List<String> cellsArrayList){
        List<SurValuesModel> surValueList = new ArrayList<>();

        cellsArrayList.forEach(line -> surValueList.add(createSurValuesModel(line)));

        return surValueList;
    }

    private List<String> getCellsAsList(String text){
        return Arrays.asList(getLines(text));
    }

    private SurValuesModel createSurValuesModel(String rawList){
        SurValuesModel surValues = new SurValuesModel();

        try {
            surValues.setCompany(rawList.substring(0, 1).trim());
            surValues.setChdrnum(rawList.substring(1, 9).trim());
            surValues.setSurvalue(asBigDecimal(rawList.substring(9, 24).trim()));
            surValues.setCurrency(null);
            surValues.setValidDate(null);

        } catch (StringIndexOutOfBoundsException e){
            log.warn("Missing data!");
        }

        return surValues;
    }

    private BigDecimal asBigDecimal(String bigDecimalString){
        try {
            return (bigDecimalString == null || bigDecimalString.equals("")) ? null : new BigDecimal(bigDecimalString);
        } catch (NumberFormatException e){
            return null;
        }
    }
}
