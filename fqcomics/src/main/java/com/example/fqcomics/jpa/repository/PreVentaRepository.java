package com.example.fqcomics.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fqcomics.jpa.entities.PreVentaEntity;

@Repository
public interface PreVentaRepository extends JpaRepository<PreVentaEntity, Long> {

	public List<PreVentaEntity> findByPagadoFalse();
	public List<PreVentaEntity> findByOrderId(String orderId);
}
