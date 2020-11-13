package com.nazim.nn.infrastructure.service;

import com.nazim.nn.domain.FileDataService;
import com.nazim.nn.domain.value.Type;
import com.nazim.nn.infrastructure.service.fileparser.FileParserService;
import com.nazim.nn.infrastructure.service.filestorage.FileStorageUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
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

        FileParserService fileParserService = fileParserFactory.getParser(getFileType(file.getOriginalFilename()));

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

    private Type getFileType(String fileName) {
        if(fileName .contains(CUSTCOMP)){
            return Type.POLICY;
        } else if (fileName.contains(OUTPH)){
            return Type.OUTHEADER;
        } else if (fileName.contains(ZTPSPF)){
            return Type.SURVALUES;
        } else {
            log.error("Incorrect filename " + fileName );
            throw new RuntimeException("Incorrect file name");
        }
    }
}
