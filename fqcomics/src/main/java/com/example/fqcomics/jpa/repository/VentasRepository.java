package com.example.fqcomics.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.fqcomics.jpa.entities.VentasEntity;

@Repository
public interface VentasRepository extends JpaRepository<VentasEntity, Long> {

	
}
