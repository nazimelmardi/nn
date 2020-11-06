package com.nazim.nn.infrastructure.adapter;

import com.nazim.nn.infrastructure.service.InputFileProcessService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.nazim.nn.infrastructure.api.model.*;

@Service
@RequiredArgsConstructor
public class FileProcessAdapter {

    private final InputFileProcessService inputFileProcessService;

    public void inputFileProcess(MultipartFile file) {
        int size = inputFileProcessService.processFile(file);

//        OkResponse response = new OkResponse();
//        response.setSize(size);
//        okResponse.setMessage(file.getName() + " successfully uploaded");
//        return response;
    }
}
