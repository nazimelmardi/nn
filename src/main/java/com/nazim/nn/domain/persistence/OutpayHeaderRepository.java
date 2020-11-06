package com.nazim.nn.domain.persistence;

import com.nazim.nn.domain.entity.OutpayHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutpayHeaderRepository extends JpaRepository<OutpayHeader, Integer> {
}
