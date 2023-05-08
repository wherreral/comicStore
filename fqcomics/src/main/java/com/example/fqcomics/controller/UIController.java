package com.example.fqcomics.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.fqcomics.jpa.entities.InventarioEntity;
import com.example.fqcomics.jpa.entities.PreVentaEntity;
import com.example.fqcomics.jpa.entities.VentasEntity;
import com.example.fqcomics.jpa.repository.InventarioRepository;
import com.example.fqcomics.jpa.repository.PreVentaRepository;
import com.example.fqcomics.jpa.repository.VentasRepository;
import com.example.fqcomics.utils.ComicUtils;

@Controller
@Scope("session")
public class UIController {
	
	
	@Autowired InventarioRepository inventarioRepository;
	@Autowired PreVentaRepository preVentaRepository;
	@Autowired VentasRepository ventasRepository;
	@Autowired ComicUtils ComicUtils; 
	@Autowired private Environment env;
	
	/*
	 * @GetMapping("/") public String getIndexPage(Model model) {
	 * model.addAttribute("test", "mi test");
	 * 
	 * InventarioEntity ie = new
	 * InventarioEntity("ecc","isbn","nombre","autor",10,1d,1d,1d,"bodega");
	 * 
	 * InventarioEntity ie2 = inventarioRepository.save(ie);
	 * 
	 * model.addAttribute("inventarioEntity", ie2);
	 * 
	 * return "home-page"; }
	 */
	
	
	@GetMapping("/productos")
	public String getProductosPage(Model model,HttpServletRequest req, HttpServletResponse response) {
		//ComicUtils.insertData();
		
		
		
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session= attr.getRequest().getSession(false);
		System.out.println(" /productos SESSION ID:"+session.getId());
		
//		Cookie cookie = new Cookie("JSESSIONID", session.getId());
//		cookie.setMaxAge(7 * 24 * 60 * 60);
//		cookie.setHttpOnly(true);
//		cookie.setPath("/");
//		response.addCookie(cookie);
	    
		List<PreVentaEntity> pvls = (List<PreVentaEntity>) req.getSession().getAttribute("preventaList");
		if(pvls == null) {
			pvls = new ArrayList<>(); 
		}
		req.getSession().setAttribute("preventaList", null);
		
		String host = env.getProperty("api.host");
		model.addAttribute("api_host", host);
		return "productos";
	}
	
	@GetMapping("/ventas")
	public String getVentasPage(Model model) {
		
		List<VentasEntity> lv = ventasRepository.findAll();
		Integer ventasTotales = ventasRepository.totalVentas();
		model.addAttribute("lv", lv);
		model.addAttribute("ventasTotales", ventasTotales);
		return "ventas";
	}
	
	@GetMapping("/inventario")
	public String getInventarioPage(Model model) {
		
		model.addAttribute("test", "mi test");
		
		return "inventario";
	}
	
	
	@GetMapping("/preventas")
	public String getPreVentasPage(Model model) {
		
		List<PreVentaEntity> pvl = preVentaRepository.findByPagadoFalse();
		List<VentasEntity> vl = ventasRepository.findAll();
		
		model.addAttribute("test", "mi test");
		model.addAttribute("pvl", pvl);
		model.addAttribute("vl", vl);
		return "preventas";
	}
	
	@GetMapping("/carro")
	public String getCarroPage(Model model, HttpServletRequest req) {
		
		//add value to session
		@SuppressWarnings("unchecked")
		List<PreVentaEntity> pvls = (List<PreVentaEntity>) req.getSession().getAttribute("preventaList");
		if(pvls == null) {
			pvls = new ArrayList<>(); 
		}
		System.out.println("getCarroPage->pvls:"+Arrays.asList(pvls));
		
		//calculate total
		Double totalVenta = 0d;
		for(PreVentaEntity pve : pvls) {
			pve.setTotal(pve.getCantidad() * pve.getPrecioVentaReal());
			totalVenta+=pve.getTotal();
		}
		req.getSession().setAttribute("totalVenta",totalVenta);
		//get order id 
		Random rand = new Random();
	    int random = rand.nextInt(99999);
		String orderId = "ORD"+random;
		req.getSession().setAttribute("orderId",orderId);
	    
		//logs
		System.out.println("CARRO SESSION ID :"+req.getSession().getId());
		System.out.println("CARRO PREVENTA LIST :"+Arrays.asList(pvls));
		//System.out.println(pvls.get(0).toString());
		
		//model
		model.addAttribute("pve", pvls);
		model.addAttribute("tv", totalVenta);
		model.addAttribute("oi", orderId);
		
		//api host
		String host = env.getProperty("api.host");
		model.addAttribute("api_host", host);
		
		return "carro";
	}
	
}
