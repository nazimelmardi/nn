package com.nazim.nn.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "policy")
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "chdrnum", nullable = false, unique = true, columnDefinition = "char", length = 8)
    private String chdrnum;

    @Column(name = "cownnum", nullable = false, columnDefinition = "char", length = 8)
    private String cownnum;

    @Column(name = "owner_name", columnDefinition = "clob")
    private String ownerName;

    @Column(name = "lifc_num", columnDefinition = "char", length = 8)
    private String lifcNum;

    @Column(name = "lifc_name", columnDefinition = "clob")
    private String lifcName;

    @Column(name = "aracde", columnDefinition = "char", length = 3)
    private String aracde;

    @Column(name = "agntnum", columnDefinition = "char", length = 5)
    private String agntnum;

    @Column(name = "mail_address", columnDefinition = "clob")
    private String mailAddress;
}
