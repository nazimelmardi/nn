package com.nazim.nn.infrastructure.service;

import com.nazim.nn.domain.FileDataService;
import com.nazim.nn.infrastructure.service.fileparser.FileParserService;
import com.nazim.nn.infrastructure.service.filestorage.FileStorageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

@Service
@RequiredArgsConstructor
public class InputFileProcessService <T> {

    private static final String CUSTCOMP = "CUSTCOMP";
    private static final String  OUTPH = "OUTPH";
    private static final String ZTPSPF = "ZTPSPF";

    private final FileParserFactory fileParserFactory;
    private final FileStorageUtil fileStorageUtil;
    private final FileDataService fileDataService;

    public int processFile(MultipartFile file) {
        Resource fileResource = fileStorageUtil.loadFileAsResource(file.getName());

        FileParserService fileParserService = fileParserFactory.getParser(getFileType(file.getName()));

        List<T> listOfModels = fileParserService.parse(asString(fileResource));

        fileDataService.save(listOfModels, fileParserService.getType());

        int size = listOfModels.size();

        return size;
    }

    protected static String asString(Resource resource) {
        try (Reader reader = new InputStreamReader(resource.getInputStream(), UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private String getFileType(String fileName) {
        if(fileName .contains(CUSTCOMP)){
            return "POLICY";
        } else if (fileName.contains(OUTPH)){
            return "OUTHEADER";
        } else if (fileName.contains(ZTPSPF)){
            return "SURVALUES";
        } else {
            throw new RuntimeException();
        }
    }
}
