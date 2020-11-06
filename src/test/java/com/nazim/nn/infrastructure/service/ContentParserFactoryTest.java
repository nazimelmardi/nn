package com.nazim.nn.infrastructure.service;

import com.nazim.nn.infrastructure.service.fileparser.FileParserService;
import com.nazim.nn.infrastructure.service.fileparser.impl.OutpayHeaderParser;
import com.nazim.nn.infrastructure.service.fileparser.impl.PolicyParser;
import com.nazim.nn.infrastructure.service.fileparser.impl.SurValuesParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertTrue;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class ContentParserFactoryTest {

    @InjectMocks
    FileParserFactory contentParserFactory;

    @BeforeEach
    void init_mocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Should return with proper class type")
    void shouldReturnWithProperClassType() {
        // Given
        String fileTypePolicy = "POLICY";
        String fileTypeOutHeader = "OUTHEADER";
        String fileTypeSurValues = "SURVALUES";

        // When
        FileParserService contentParserPolicy = contentParserFactory.getParser(fileTypePolicy);
        FileParserService contentParserOutHeader = contentParserFactory.getParser(fileTypeOutHeader);
        FileParserService contentParserSurValues = contentParserFactory.getParser(fileTypeSurValues);

        // Then
        assertTrue(contentParserPolicy instanceof PolicyParser);
        assertTrue(contentParserOutHeader instanceof OutpayHeaderParser);
        assertTrue(contentParserSurValues instanceof SurValuesParser);
    }
}