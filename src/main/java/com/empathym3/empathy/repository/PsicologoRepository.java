package com.empathym3.empathy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empathym3.empathy.model.Psicologo;

@Repository
public interface PsicologoRepository extends JpaRepository<Psicologo, Long> {
    Optional<Psicologo> findByDocumento(String documento);
}
