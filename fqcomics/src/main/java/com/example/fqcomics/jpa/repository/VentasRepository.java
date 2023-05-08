package com.example.fqcomics.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.fqcomics.jpa.entities.VentasEntity;

@Repository
public interface VentasRepository extends JpaRepository<VentasEntity, Long> {

	@Query(value = "SELECT SUM(m.TOTAL) FROM VENTAS_ENTITY m",nativeQuery = true)
	int totalVentas();
	
}
