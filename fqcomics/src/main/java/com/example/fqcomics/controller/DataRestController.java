package com.example.fqcomics.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.fqcomics.jpa.entities.InventarioEntity;
import com.example.fqcomics.jpa.entities.PreVentaEntity;
import com.example.fqcomics.jpa.entities.VentasEntity;
import com.example.fqcomics.jpa.repository.InventarioRepository;
import com.example.fqcomics.jpa.repository.PreVentaRepository;
import com.example.fqcomics.jpa.repository.VentasRepository;
import com.example.fqcomics.service.PreVentaService;

@RestController
@Scope("session")
public class DataRestController {

	@Autowired InventarioRepository inventarioRepository;
	@Autowired PreVentaRepository preVentaRepository;
	@Autowired VentasRepository ventasRepository;
	@Autowired PreVentaService preVentaService;
	//@Autowired SecurityContextHolder sch;
	
	
	
	@GetMapping("/inventory/{isbn}") 
	List<InventarioEntity> returnInventarioList(@PathVariable String isbn,HttpServletRequest req, HttpServletResponse response) 
	{
		System.out.println(isbn);
		
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session= attr.getRequest().getSession(false);
		
	    List<InventarioEntity> ie = inventarioRepository.findByIsbn(isbn);
	 
	    if(ie.size() == 0)
	    		return null;

	    //req.getSession().setAttribute("ie", ie);
		
	    
		
		//session.setAttribute("ie", ie);
	    System.out.println("/inventory/{isbn} SESSION ID :"+req.getSession().getId());
		System.out.println("/inventory/{isbn} SESSION ID :"+session.getId());
		//System.out.println("session.getAttribute ie="+Arrays.asList(req.getSession().getAttribute("ie")));
		
		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		cookie.setMaxAge(7 * 24 * 60 * 60);
		cookie.setHttpOnly(true);
		cookie.setPath("/");
		response.addCookie(cookie);
		
		
		
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
	List<InventarioEntity> returnAllInventarioList(HttpServletRequest request, HttpServletResponse response) 
	{
		
		HttpSession session = request.getSession();
		System.out.println(" /inventory/all SESSION ID:"+session.getId());
		//ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		//HttpSession session= attr.getRequest().getSession(false);
		//System.out.println(" /inventory/all SESSION ID:"+session.getId());
		
//		HttpSession session = request.getSession();
//		if (request.getParameter("JSESSIONID") != null) {
//		    System.out.println("no nulo");
//			Cookie userCookie = new Cookie("JSESSIONID", request.getParameter("JSESSIONID"));
//		    response.addCookie(userCookie);
//		    System.out.println(" /inventory/all SESSION ID:"+session.getId());
//		} else {
//			System.out.println("nulo");
//		    String sessionId = session.getId();
//		    Cookie userCookie = new Cookie("JSESSIONID", sessionId);
//		    response.addCookie(userCookie);
//		}
		
		
		/*
		 * ServletRequestAttributes attr = (ServletRequestAttributes)
		 * RequestContextHolder.currentRequestAttributes(); HttpSession session=
		 * attr.getRequest().getSession(false);
		 * System.out.println(" /inventory/all SESSION ID:"+session.getId());
		 * 
		 * Cookie cookie = new Cookie("JSESSIONID", session.getId()); cookie.setMaxAge(7
		 * * 24 * 60 * 60); cookie.setHttpOnly(true); cookie.setPath("/");
		 * response.addCookie(cookie);
		 */
		
		/*
		 * HttpSession session = request.getSession(); if
		 * (request.getParameter("JSESSIONID") != null) {
		 * System.out.println("parameter distinto null"); Cookie userCookie = new
		 * Cookie("JSESSIONID", request.getParameter("JSESSIONID"));
		 * response.addCookie(userCookie); } else {
		 * System.out.println("parameter null"); String sessionId = session.getId();
		 * Cookie userCookie = new Cookie("JSESSIONID", sessionId);
		 * response.addCookie(userCookie); }
		 */
		
	    List<InventarioEntity> ie = inventarioRepository.findAll();
	    return ie;
	    
	}
	
	@PostMapping("/test") 
	Object test(@RequestBody Map body) 
	{
		
		List s = (List) body.get("list");
		System.out.println(s);
		return true;
	}
	
	@PostMapping("/presale/save") 
	PreVentaEntity saveInventario(@RequestBody PreVentaEntity newPreventa, HttpServletRequest req, HttpServletResponse response) 
	{
		
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session= attr.getRequest().getSession(false);
		System.out.println("SESSION ID:"+session.getId());
		
		//add value to session
		@SuppressWarnings("unchecked")
		List<PreVentaEntity> pvls = (List<PreVentaEntity>) req.getSession().getAttribute("preventaList");
		if(pvls == null) {
			pvls = new ArrayList<>(); 
		}
		
		//check newPreventa. is in the cart?
		boolean bandera = false;
		for(PreVentaEntity pe : pvls){
			if(pe.equals(newPreventa)) {
				pe.setCantidad(newPreventa.getCantidad()+pe.getCantidad());
				bandera = true;
				break;
			}
		}
		if(!bandera) {
			pvls.add(newPreventa);
		}
		req.getSession().setAttribute("preventaList", pvls);
		
		System.out.println("SESSION ID :"+req.getSession().getId());
		System.out.println("PREVENTA LIST :"+Arrays.asList(pvls));
		
		//ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		//HttpSession session2= attr.getRequest().getSession(true);
		//session2.setAttribute("preventaList", pvls);
		//System.out.println("SESSION ID :"+session2.getId());
		//System.out.println("session.getAttribute newPreventa="+((List<PreVentaEntity>) req.getSession().getAttribute("pvls")).get(0).getNombre());
		//System.out.println("SESSIONID REQuested"+request.getRequestedSessionId());
		//System.out.println("SESSIONID REQ"+request.getSession().getId());
		//System.out.println("SESSIONID"+session.getId());
		//System.out.println("PRINCIPAL:"+SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		
		PreVentaEntity preventa = preVentaService.validatePreVenta(newPreventa);
		if( preventa != null){
			return preventa;//preVentaRepository.save(preventa);
		}else {
			return null;
		}
	}
	
	@SuppressWarnings("unused")
	@PostMapping("/presale/payed") 
	Boolean payPreSale(@RequestBody Map payload, HttpServletRequest req) 
	{
		System.out.println("/presale/payed->newTotal:"+Arrays.asList(payload));
		
		//get carro
		@SuppressWarnings("unchecked")
		List<PreVentaEntity> pvls = (List<PreVentaEntity>) req.getSession().getAttribute("preventaList");
		
		if(pvls == null) {
			return false; 
		}

		//get orderId
		@SuppressWarnings("unchecked")
		String orderId =(String) req.getSession().getAttribute("orderId");
		
		if(orderId == null) {
			return false; 
		}
		System.out.println("/presale/payed->orderId:"+orderId);
		
		//get new total
		Double nt;
		if(payload.get("newtotal")==null || payload.get("newtotal")=="") {
			nt=(Double) req.getSession().getAttribute("totalVenta");
		}else {
			nt = Double.parseDouble((String) payload.get("newtotal"));
		}
		System.out.println("/presale/payed->nt:"+nt);
		
		//despacho
		if(payload.get("despacho")==null || payload.get("despacho")=="") {
			//nt=(Double) req.getSession().getAttribute("totalVenta");
		}else {
			nt = nt + Double.parseDouble((String) payload.get("despacho"));
		}
		System.out.println("/presale/payed->nt:"+nt);
		
		
		//loop through pvls
		for(PreVentaEntity pve : pvls) {
			//pve.setPagado(true);
			pve.setOrderId(orderId);
			preVentaRepository.save(pve);
		}
		
		
		//Create venta
		VentasEntity ve = new VentasEntity(orderId,nt, nt, pvls.get(0).getVendedor());
		ventasRepository.save(ve);
		
		//Update Stock
		for(PreVentaEntity pve : pvls) {
			//Get data from inventory
			List<InventarioEntity> ie = inventarioRepository.findByIsbn(pve.getIsbn());
			ie.get(0).setCantidad(ie.get(0).getCantidad() - pve.getCantidad());
			inventarioRepository.save(ie.get(0));
		}
		
				
		
		return true;
	}
	
}
