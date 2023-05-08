package com.example.fqcomics.jpa.repository;


import org.springframework.stereotype.Repository;

import com.example.fqcomics.jpa.entities.InventarioEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface InventarioRepository extends JpaRepository<InventarioEntity, Long> {
	
	List<InventarioEntity> findByNombreContaining(String title);
	List<InventarioEntity> findByIsbn(String isbn);

}
