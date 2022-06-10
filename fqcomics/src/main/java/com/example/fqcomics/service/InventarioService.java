package com.example.fqcomics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.fqcomics.jpa.entities.InventarioEntity;
import com.example.fqcomics.jpa.entities.PreVentaEntity;
import com.example.fqcomics.jpa.repository.InventarioRepository;

@Service
public class InventarioService {
	
	@Autowired InventarioRepository inventarioRepository;
	
	PreVentaEntity savePreVenta(PreVentaEntity newPreventa) {
		if(newPreventa.getPrecioVentaReal()==null || newPreventa.getPrecioVentaReal()<=0d) {
			List<InventarioEntity> ie = inventarioRepository.findByIsbn(newPreventa.getIsbn());
			newPreventa.setPrecioVentaReal(ie.get(0).getPrecioPiso());
		}
		return newPreventa;
	}
	
}
