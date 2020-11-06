package com.nazim.nn.infrastructure.service;

import com.nazim.nn.infrastructure.service.fileparser.FileParserService;
import com.nazim.nn.infrastructure.service.fileparser.impl.OutpayHeaderParser;
import com.nazim.nn.infrastructure.service.fileparser.impl.PolicyParser;
import com.nazim.nn.infrastructure.service.fileparser.impl.SurValuesParser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class FileParserFactory {

    public FileParserService getParser(String type){
        if (type == null){
            return null;
        }
        if (type.equals("POLICY")){
            return new PolicyParser();
        }
        if (type.equals("OUTHEADER")){
            return new OutpayHeaderParser();
        }
        if (type.equals("SURVALUES")){
            return new SurValuesParser();
        }
        return null;
    }
}
