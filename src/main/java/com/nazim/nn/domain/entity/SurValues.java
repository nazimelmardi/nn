package com.nazim.nn.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "sur_values")
public class SurValues {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "chdrnum", nullable = false, unique = true, columnDefinition = "char", length = 8)
    private String chdrnum;

    @Column(name = "survalue", nullable = false)
    private BigDecimal survalue;

    @Column(name = "company", nullable = false, columnDefinition = "char", length = 1)
    private String company;

    @Column(name = "currency", columnDefinition = "char", length = 3)
    private String currency;

    @Column(name = "valid_date", columnDefinition = "char", length = 10)
    private String validDate;

}
