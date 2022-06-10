package com.example.fqcomics.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.fqcomics.jpa.entities.InventarioEntity;
import com.example.fqcomics.jpa.entities.PreVentaEntity;
import com.example.fqcomics.jpa.entities.VentasEntity;
import com.example.fqcomics.jpa.repository.InventarioRepository;
import com.example.fqcomics.jpa.repository.PreVentaRepository;
import com.example.fqcomics.jpa.repository.VentasRepository;
import com.example.fqcomics.service.PreVentaService;

@RestController
public class DataRestController {

	@Autowired InventarioRepository inventarioRepository;
	@Autowired PreVentaRepository preVentaRepository;
	@Autowired VentasRepository ventasRepository;
	@Autowired PreVentaService preVentaService;
	
	@GetMapping("/inventory/{isbn}") 
	List<InventarioEntity> returnInventarioList(@PathVariable String isbn) 
	{
		System.out.println(isbn);
	    List<InventarioEntity> ie = inventarioRepository.findByIsbn(isbn);
	 
	    if(ie.size() == 0)
	    		return null;
	    
	    return ie;
	}
	
	
	/*
	 * @GetMapping("/inventory/{title}") Integer returnInventarioList(@PathVariable
	 * String title) { System.out.println(title); List<InventarioEntity> ie =
	 * inventarioRepository.findByNombreContaining(title); if(ie != null &&
	 * ie.size() > 0) { System.out.println(ie.get(0)); return ie.size(); } else {
	 * return 0; } }
	 */
	
	@GetMapping("/inventory/all") 
	List<InventarioEntity> returnAllInventarioList() 
	{
	    List<InventarioEntity> ie = inventarioRepository.findAll();
	    return ie;
	    
	}
	
	
	@PostMapping("/presale/save") 
	PreVentaEntity saveInventario(@RequestBody PreVentaEntity newPreventa) 
	{
		PreVentaEntity preventa = preVentaService.validatePreVenta(newPreventa);
		if( preventa != null){
			return preventa;//preVentaRepository.save(preventa);
		}else {
			return null;
		}
		
	}
	
	@PostMapping("/presale/payed") 
	Boolean payPreSale(@RequestBody Map preventa) 
	{
		System.out.println("datos recibido:"+preventa.get("id"));
		Long id = Long.parseLong((String) preventa.get("id"));
		Optional<PreVentaEntity> opve = preVentaRepository.findById((Long) id);
		PreVentaEntity pve = opve.get();
		
		//Update flag pagado
		pve.setPagado(true);
		preVentaRepository.save(pve);
		
		//Create venta
		VentasEntity ve = new VentasEntity(pve);
		ventasRepository.save(ve);
		
		return true;
	}
	
}
