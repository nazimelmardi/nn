package com.nazim.nn.infrastructure.service.fileparser.impl;

import com.nazim.nn.domain.FileDataService;
import com.nazim.nn.infrastructure.adapter.model.OutpayHeaderModel;
import com.nazim.nn.infrastructure.service.fileparser.FileParserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class OutpayHeaderParser implements FileParserService {

    @Override
    public String getType() {
        return "OUTHEADER";
    }

    @Override
    public List<OutpayHeaderModel> parse(String text) {
        return getOutHeaderList(getCellsAsList(text));
    }

    private List<OutpayHeaderModel> getOutHeaderList(List<String[]> cellsArrayList){
        List<OutpayHeaderModel> outHeaderList = new ArrayList<>();

        cellsArrayList.forEach(line -> outHeaderList.add(createOutHeader(line)));

        return outHeaderList;
    }

    private List<String[]> getCellsAsList(String text){
        List<String[]> individualItems = new ArrayList<>();
        for (String line : getLines(text)){
            individualItems.add(line.split("\\;"));
        }
        return individualItems;
    }

    private OutpayHeaderModel createOutHeader(String[] rawList){
        OutpayHeaderModel outpayHeader = new OutpayHeaderModel();

        try {
            outpayHeader.setClntnum(rawList[0].trim());
            outpayHeader.setChdrnum(rawList[1].trim());
            outpayHeader.setLetterType(rawList[2].trim());
            outpayHeader.setPrintDate(asLocalDate(rawList[3].trim()));
            outpayHeader.setDataId(rawList[4].trim());
            outpayHeader.setClntName(rawList[5].trim());
            outpayHeader.setClntAddress(rawList[6].trim());
            outpayHeader.setClaimId(rawList[7].trim());
            outpayHeader.setBenPercent(asBigDecimal(rawList[8].trim()));
            outpayHeader.setRole1(rawList[9].trim());
            outpayHeader.setRole2(rawList[10].trim());
            outpayHeader.setCownNum(rawList[11].trim());
            outpayHeader.setCownName(rawList[12].trim());
            outpayHeader.setRegDate(null);

        } catch (ArrayIndexOutOfBoundsException e){
            log.warn("Missing data!");
        }

        return outpayHeader;
    }

    private LocalDate asLocalDate(String date){
        try {
            return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd"));
        } catch (DateTimeParseException e){
            log.warn("Could not parse dateTime properly. Adding empty value instead!");
            return null;
        }
    }

    private BigDecimal asBigDecimal(String bigDecimalString){
        try {
            return (bigDecimalString == null || bigDecimalString.equals("")) ? null : new BigDecimal(bigDecimalString);
        } catch (NumberFormatException e){
            log.warn("Wrong format for decimal value! Skipping to add value...");
            return null;
        }
    }
}
