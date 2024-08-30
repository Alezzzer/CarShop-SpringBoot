package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.AzTema;

@Repository
public interface AzTemaRepository extends JpaRepository<AzTema, Integer> {
}