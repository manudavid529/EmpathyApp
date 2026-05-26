package com.empathym3.empathy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empathym3.empathy.model.TestCompatibilidad;
@Repository
public interface TestCompatibilidadRepository extends JpaRepository<TestCompatibilidad, Long> {
}
