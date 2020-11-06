package com.nazim.nn.domain.persistence;

import com.nazim.nn.domain.entity.SurValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurValuesRepository extends JpaRepository<SurValues, Integer> {
}
