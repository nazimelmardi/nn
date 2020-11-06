package com.nazim.nn.infrastructure.service.fileparser;

import com.nazim.nn.data.Data;
import com.nazim.nn.infrastructure.adapter.model.OutpayHeaderModel;
import com.nazim.nn.infrastructure.service.fileparser.impl.OutpayHeaderParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class OutHeaderContentParserTest {

    @InjectMocks
    OutpayHeaderParser outpayHeaderParser;

    @BeforeEach
    void init_mocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Should parse line to valid object")
    void parseStringContent() {
        // Given
        String singleTextLine = "20930093;70027344;CUP;20200210;OUTPAY;Kovács Lajos;2643 Budapest, Berényi út 37.;;100.00;OW;  ;20930093;Kovács Lajos;  ";

        List<OutpayHeaderModel> models = Data.createOutpayHeaderModelList();
        // When
        List<OutpayHeaderModel> result = outpayHeaderParser.parse(singleTextLine);

        // Then
        then(result).hasSize(1);
    }
}