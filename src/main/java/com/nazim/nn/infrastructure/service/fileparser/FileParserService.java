package com.nazim.nn.infrastructure.service.fileparser;

import com.nazim.nn.domain.value.Type;

import java.util.List;

public interface FileParserService <T> {

    Type getType();

    List<T> parse(String text);

    default String[] getLines(String text){
        return text.split("\\r?\\n");
    }

}
