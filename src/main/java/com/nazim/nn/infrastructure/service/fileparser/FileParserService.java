package com.nazim.nn.infrastructure.service.fileparser;

import java.util.List;

public interface FileParserService <T> {

    String getType();

    List<T> parse(String text);

    default String[] getLines(String text){
        return text.split("\\r?\\n");
    }

}
