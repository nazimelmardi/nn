package com.nazim.nn.infrastructure.service;

import com.nazim.nn.domain.value.Type;
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

    public FileParserService getParser(Type type){
        if (type == null){
            return null;
        }
        if (type.equals(Type.POLICY)){
            return new PolicyParser();
        }
        if (type.equals(Type.OUTHEADER)){
            return new OutpayHeaderParser();
        }
        if (type.equals(Type.SURVALUES)){
            return new SurValuesParser();
        }
        return null;
    }
}
