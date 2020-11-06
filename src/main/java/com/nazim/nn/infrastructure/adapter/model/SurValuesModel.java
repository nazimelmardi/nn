package com.nazim.nn.infrastructure.adapter.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SurValuesModel {

    private String chdrnum;

    private BigDecimal survalue;

    private String company;

    private String currency;

    private String validDate;
}
