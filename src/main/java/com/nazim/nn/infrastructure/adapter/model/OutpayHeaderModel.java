package com.nazim.nn.infrastructure.adapter.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@Data
public class OutpayHeaderModel {

    private String clntnum;

    private String chdrnum;

    private String letterType;

    private LocalDate printDate;

    private String dataId;

    private String clntName;

    private String clntAddress;

    private LocalDate regDate;

    private BigDecimal benPercent;

    private String role1;

    private String role2;

    private String cownNum;

    private String cownName;

    private String notice01;

    private String notice02;

    private String notice03;

    private String notice04;

    private String notice05;

    private String notice06;

    private String claimId;

    private OffsetDateTime tp2ProcessDate;
}
