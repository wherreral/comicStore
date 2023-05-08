package com.example.fqcomics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.fqcomics.jpa.entities.InventarioEntity;
import com.example.fqcomics.jpa.entities.PreVentaEntity;
import com.example.fqcomics.jpa.repository.InventarioRepository;
import com.example.fqcomics.jpa.repository.PreVentaRepository;

@Service
public class PreVentaService {
	
	@Autowired InventarioRepository inventarioRepository;
	@Autowired PreVentaRepository preVentaRepository;
	
	public PreVentaEntity validatePreVenta(PreVentaEntity newPreventa) {
		
		//Get data from inventory
		List<InventarioEntity> ie = inventarioRepository.findByIsbn(newPreventa.getIsbn());
		
		//Get Stock
		Integer stock = ie.get(0).getCantidad();
		
		//Validate Stock
		if(stock<=0 || newPreventa.getCantidad() > stock)
		{
			System.out.println("Error: Stock Validation");
			return null;
		}
		
		//Update Stock
		//ie.get(0).setCantidad(stock - newPreventa.getCantidad());
		//inventarioRepository.save(ie.get(0));
		
		//Validate Precio
		if(newPreventa.getPrecioVentaReal()==null || newPreventa.getPrecioVentaReal()<=0d 
				|| newPreventa.getPrecioVentaReal().isNaN()) {
			//List<InventarioEntity> ie = inventarioRepository.findByIsbn(newPreventa.getIsbn());
			newPreventa.setPrecioVentaReal(ie.get(0).getPrecioPiso());
		}
		
		//Save 
		//PreVentaEntity saved = preVentaRepository.save(newPreventa);
		
		//System.out.println("Order id:"+saved.getOrderId());
		
		return newPreventa;
	}
	
}
