package com.nazim.nn.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "outpay_header")
public class OutpayHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "outpay_header_id", unique = true, nullable = false)
    private Integer outpayHeaderId;

    @Column(name = "clntnum", nullable = false, unique = true, columnDefinition = "char", length = 8)
    private String clntnum;

    @Column(name = "chdrnum", nullable = false, columnDefinition = "char", length = 8)
    private String chdrnum;

    @Column(name = "letter_type", nullable = false, columnDefinition = "char", length = 12)
    private String letterType;

    @Column(name = "print_date", nullable = false)
    private LocalDate printDate;

    @Column(name = "data_id", columnDefinition = "char", length = 6)
    private String dataId;

    @Column(name = "clnt_name", columnDefinition="clob", length = 80)
    private String clntName;

    @Column(name = "clnt_address", columnDefinition="clob", length = 80)
    private String clntAddress;

    @Column(name = "reg_date")
    private LocalDate regDate;

    @Column(name = "ben_percent")
    private BigDecimal benPercent;

    @Column(name = "role1", columnDefinition = "char", length = 2)
    private String role1;

    @Column(name = "role2", columnDefinition = "char", length = 2)
    private String role2;

    @Column(name = "cown_num", columnDefinition="char", length = 8)
    private String cownNum;

    @Column(name = "cown_name", columnDefinition="clob", length = 80)
    private String cownName;

    @Column(name = "notice01", columnDefinition="clob", length = 80)
    private String notice01;

    @Column(name = "notice02", columnDefinition="clob", length = 80)
    private String notice02;

    @Column(name = "notice03", columnDefinition="clob", length = 80)
    private String notice03;

    @Column(name = "notice04", columnDefinition="clob", length = 80)
    private String notice04;

    @Column(name = "notice05", columnDefinition="clob", length = 80)
    private String notice05;

    @Column(name = "notice06", columnDefinition="clob", length = 80)
    private String notice06;

    @Column(name = "claim_id", columnDefinition = "char", length = 9)
    private String claimId;

    @Column(name = "tp2_process_date")
    private OffsetDateTime tp2ProcessDate;

}
