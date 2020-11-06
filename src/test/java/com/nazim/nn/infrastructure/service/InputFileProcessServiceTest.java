package com.nazim.nn.infrastructure.service;

import com.nazim.nn.infrastructure.service.filestorage.FileStorageUtil;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class InputFileProcessServiceTest {

    @Mock
    FileStorageUtil fileStorageUtil;

    @Mock
    FileParserFactory fileParserFactory;

    @InjectMocks
    InputFileProcessService contentConsumer;

    private ClassLoader classLoader;

    private static final String FILE_NAME = "POLICY.txt";

    @BeforeEach
    void init_mocks() {
        MockitoAnnotations.initMocks(this);
        classLoader = this.getClass().getClassLoader();
    }

    @SneakyThrows
    @Test
    @DisplayName("Should return with related string content")
    void asString() {
        // Given

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(FILE_NAME).getFile());
        Resource resource = new UrlResource(file.toURI());
        String result = "86000019|76000018|Szegedi István |76000018|Szegedi István |00X|11111|6436 Budapest Rév u. 27. |";

        // When
        String resultString = InputFileProcessService.asString(resource);

        // Then
        assertEquals(resultString, result);
    }

}