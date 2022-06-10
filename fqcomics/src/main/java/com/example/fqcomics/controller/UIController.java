package com.example.fqcomics.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.fqcomics.jpa.entities.InventarioEntity;
import com.example.fqcomics.jpa.entities.PreVentaEntity;
import com.example.fqcomics.jpa.entities.VentasEntity;
import com.example.fqcomics.jpa.repository.InventarioRepository;
import com.example.fqcomics.jpa.repository.PreVentaRepository;
import com.example.fqcomics.jpa.repository.VentasRepository;

@Controller
public class UIController {
	
	
	@Autowired InventarioRepository inventarioRepository;
	@Autowired PreVentaRepository preVentaRepository;
	@Autowired VentasRepository ventasRepository;
	
	@GetMapping("/")
	public String getIndexPage(Model model) {
		model.addAttribute("test", "mi test");
		
		InventarioEntity ie = new InventarioEntity("ecc","isbn","nombre","autor",10,1d,1d,1d,"bodega");
		
		InventarioEntity ie2 = inventarioRepository.save(ie);
		
		model.addAttribute("inventarioEntity", ie2);
		
		return "home-page";
	}
	
	@GetMapping("/ventas")
	public String getVentasPage(Model model) {
		
List<InventarioEntity> inventarioEntityList = new ArrayList<>();
		
		inventarioEntityList.add(new InventarioEntity("ECC","9788418225710","Watchmen (Edición cartoné) (Cuarta edición)","Alan Moore, Dave Gibbons",4,20588.75d,28824.25d));
		inventarioEntityList.add(new InventarioEntity("ECC","9788417509774","Watchmen (Edición Deluxe) (Tercera edición)","Alan Moore, Dave Gibbons",4,29412.5d,41177.5d));
		inventarioEntityList.add(new InventarioEntity("ECC","9788418225703","Watchmen (11ª edición) Rústica","Alan Moore, Dave Gibbons",4,17647.5d,24706.5d));
		inventarioEntityList.add(new InventarioEntity("ECC","9788416796809","V de Vendetta (Edición Deluxe) 2ª edición","Alan Moore, David Lloyd",4,26471.25d,37059.75d));
		inventarioEntityList.add(new InventarioEntity("ECC","9788418326936","V de Vendetta (Edición cartoné) (Cuarta edición)","Moore, Alan",4,18235.75d,25530.05d));
		inventarioEntityList.add(new InventarioEntity("ECC","9788418475849","Batman Vol. 1: El Tribunal de los Búhos (Batman Saga Nuevo Universo Parte 1)","James Tynion IV, Scott Snyde, Greg Capullo, Jason Fabok, Rafael Albuquerque",4,20588.75d,28824.25d));
		inventarioEntityList.add(new InventarioEntity("ECC","9788417665142","La Broma asesina Versión extendida (Edición Deluxe) (2a edición)","Alan Moore, Brian Bolland",4,20588.75d,28824.25d));
		inventarioEntityList.add(new InventarioEntity("ECC","9788418043192","Predicador vol. 1 (Edición Deluxe) (Segunda edición)","Garth Ennis, Steve Dillon",3,25294.75d,35412.65d));
		inventarioEntityList.add(new InventarioEntity("PANINI","9788411015158","Providence 1. El miedo que acecha","Alan Moore, Jacen Burrows",3,11877.944d,16629.1216d));
		inventarioEntityList.add(new InventarioEntity("PANINI","9788490947470","Providence 2. El abismo del tiempo","Alan Moore, Jacen Burrows",3,10718.50325d,15005.90455d));
		inventarioEntityList.add(new InventarioEntity("PANINI","9788491671510","Providence 3. Lo innombrable","Alan Moore, Jacen Burrows",3,10718.50325d,15005.90455d));
		inventarioEntityList.add(new InventarioEntity("PANINI","9788498857238","Neonomicon","Alan Moore",3,10181.431d,14254.0034d));
		inventarioEntityList.add(new InventarioEntity("PANINI","9788498855142","CIVIL WAR Marvel Deluxe Tapa Dura","Mark Millar",4,13546.80925d,18965.53295d));
		inventarioEntityList.add(new InventarioEntity("PANINI","9788411015035","Berserk Maximum 1","Kentaro Miura",4,9587.2985d,13422.2179d));
		inventarioEntityList.add(new InventarioEntity("PANINI","9788490948620","Blame! Master Edition 1","Tsutomu Nihei",4,11312.63575d,15837.69005d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467909708","ATAQUE A LOS TITANES 1 ","Hajime Isayama",4,4344d,6081.6d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467909715","ATAQUE A LOS TITANES 2","Hajime Isayama",4,4344d,6081.6d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467910995","ATAQUE A LOS TITANES 3","Hajime Isayama",4,4344d,6081.6d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467911503","ATAQUE A LOS TITANES 4","Hajime Isayama",4,4344d,6081.6d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467912616","ATAQUE A LOS TITANES 5","Hajime Isayama",4,4344d,6081.6d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467941920","JUJUTSU KAISEN (GUERRA DE HECHICEROS) 0. Escuela técnica de hechicería del área metropolitana de Tokio","Gege Akutami",4,4344d,6081.6d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467940657","JUJUTSU KAISEN (GUERRA DE HECHICEROS) 1. Ryômen-Sukuna","Gege Akutami",4,4344d,6081.6d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467941562","JUJUTSU KAISEN (GUERRA DE HECHICEROS) 2. El feto maldito bajo el cielo","Gege Akutami",4,4344d,6081.6d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467941913","JUJUTSU KAISEN (GUERRA DE HECHICEROS) 3. El pececillo y el castigo proporcionalmente inverso","Gege Akutami",4,4344d,6081.6d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467942699","JUJUTSU KAISEN (GUERRA DE HECHICEROS) 4. Te mataré","Gege Akutami",4,4344d,6081.6d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467943542","JUJUTSU KAISEN (GUERRA DE HECHICEROS) 5. Reunión de intercambio con el instituto hermano de Kioto","Gege Akutami",4,4344d,6081.6d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467941159","CHAINSAW MAN 1 ","Tatsuki Fujimoto",4,4887d,6841.8d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467942620","CHAINSAW MAN 2 ","Tatsuki Fujimoto",4,4887d,6841.8d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467943511","CHAINSAW MAN 3","Tatsuki Fujimoto",4,4887d,6841.8d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467944174","CHAINSAW MAN 4","Tatsuki Fujimoto",4,4887d,6841.8d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467945096","CHAINSAW MAN 5","Tatsuki Fujimoto",4,4887d,6841.8d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467935325","GUARDIANES DE LA NOCHE 1","Koyoharu Gotouge",4,4344d,6081.6d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467935127","GUARDIANES DE LA NOCHE 2","Koyoharu Gotouge",4,4344d,6081.6d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467935134","GUARDIANES DE LA NOCHE 3","Koyoharu Gotouge",4,4344d,6081.6d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467936681","GUARDIANES DE LA NOCHE 4","Koyoharu Gotouge",4,4344d,6081.6d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467936698","GUARDIANES DE LA NOCHE 5","Koyoharu Gotouge",4,4344d,6081.6d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467947076","TOKYO REVENGERS 1","Ken Wakui",4,8688d,12163.2d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467947083","TOKYO REVENGERS 2","Ken Wakui",4,8688d,12163.2d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467947090","TOKYO REVENGERS 3","Ken Wakui",4,8688d,12163.2d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467947106","TOKYO REVENGERS 4","Ken Wakui",4,8688d,12163.2d));
		inventarioEntityList.add(new InventarioEntity("RANDOM HOUSE","9788416709298","INCAL, EL (INTEGRAL)","JODOROWSKY, ALEJANDRO/MOEBIUS",3,24297.44d,34016.416d));
		
		for(InventarioEntity ie :inventarioEntityList){
			inventarioRepository.save(ie);
		}
		
		
		return "ventas";
	}
	
	@GetMapping("/inventario")
	public String getInventarioPage(Model model) {
		
		model.addAttribute("test", "mi test");
		
		List<InventarioEntity> inventarioEntityList = new ArrayList<>();
		
		inventarioEntityList.add(new InventarioEntity("ECC","9788418225710","Watchmen (Edición cartoné) (Cuarta edición)","Alan Moore, Dave Gibbons",4,20588.75d,28824.25d));
		inventarioEntityList.add(new InventarioEntity("ECC","9788417509774","Watchmen (Edición Deluxe) (Tercera edición)","Alan Moore, Dave Gibbons",4,29412.5d,41177.5d));
		inventarioEntityList.add(new InventarioEntity("ECC","9788418225703","Watchmen (11ª edición) Rústica","Alan Moore, Dave Gibbons",4,17647.5d,24706.5d));
		inventarioEntityList.add(new InventarioEntity("ECC","9788416796809","V de Vendetta (Edición Deluxe) 2ª edición","Alan Moore, David Lloyd",4,26471.25d,37059.75d));
		inventarioEntityList.add(new InventarioEntity("ECC","9788418326936","V de Vendetta (Edición cartoné) (Cuarta edición)","Moore, Alan",4,18235.75d,25530.05d));
		inventarioEntityList.add(new InventarioEntity("ECC","9788418475849","Batman Vol. 1: El Tribunal de los Búhos (Batman Saga Nuevo Universo Parte 1)","James Tynion IV, Scott Snyde, Greg Capullo, Jason Fabok, Rafael Albuquerque",4,20588.75d,28824.25d));
		inventarioEntityList.add(new InventarioEntity("ECC","9788417665142","La Broma asesina Versión extendida (Edición Deluxe) (2a edición)","Alan Moore, Brian Bolland",4,20588.75d,28824.25d));
		inventarioEntityList.add(new InventarioEntity("ECC","9788418043192","Predicador vol. 1 (Edición Deluxe) (Segunda edición)","Garth Ennis, Steve Dillon",3,25294.75d,35412.65d));
		inventarioEntityList.add(new InventarioEntity("PANINI","9788411015158","Providence 1. El miedo que acecha","Alan Moore, Jacen Burrows",3,11877.944d,16629.1216d));
		inventarioEntityList.add(new InventarioEntity("PANINI","9788490947470","Providence 2. El abismo del tiempo","Alan Moore, Jacen Burrows",3,10718.50325d,15005.90455d));
		inventarioEntityList.add(new InventarioEntity("PANINI","9788491671510","Providence 3. Lo innombrable","Alan Moore, Jacen Burrows",3,10718.50325d,15005.90455d));
		inventarioEntityList.add(new InventarioEntity("PANINI","9788498857238","Neonomicon","Alan Moore",3,10181.431d,14254.0034d));
		inventarioEntityList.add(new InventarioEntity("PANINI","9788498855142","CIVIL WAR Marvel Deluxe Tapa Dura","Mark Millar",4,13546.80925d,18965.53295d));
		inventarioEntityList.add(new InventarioEntity("PANINI","9788411015035","Berserk Maximum 1","Kentaro Miura",4,9587.2985d,13422.2179d));
		inventarioEntityList.add(new InventarioEntity("PANINI","9788490948620","Blame! Master Edition 1","Tsutomu Nihei",4,11312.63575d,15837.69005d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467909708","ATAQUE A LOS TITANES 1 ","Hajime Isayama",4,4344d,6081.6d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467909715","ATAQUE A LOS TITANES 2","Hajime Isayama",4,4344d,6081.6d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467910995","ATAQUE A LOS TITANES 3","Hajime Isayama",4,4344d,6081.6d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467911503","ATAQUE A LOS TITANES 4","Hajime Isayama",4,4344d,6081.6d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467912616","ATAQUE A LOS TITANES 5","Hajime Isayama",4,4344d,6081.6d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467941920","JUJUTSU KAISEN (GUERRA DE HECHICEROS) 0. Escuela técnica de hechicería del área metropolitana de Tokio","Gege Akutami",4,4344d,6081.6d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467940657","JUJUTSU KAISEN (GUERRA DE HECHICEROS) 1. Ryômen-Sukuna","Gege Akutami",4,4344d,6081.6d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467941562","JUJUTSU KAISEN (GUERRA DE HECHICEROS) 2. El feto maldito bajo el cielo","Gege Akutami",4,4344d,6081.6d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467941913","JUJUTSU KAISEN (GUERRA DE HECHICEROS) 3. El pececillo y el castigo proporcionalmente inverso","Gege Akutami",4,4344d,6081.6d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467942699","JUJUTSU KAISEN (GUERRA DE HECHICEROS) 4. Te mataré","Gege Akutami",4,4344d,6081.6d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467943542","JUJUTSU KAISEN (GUERRA DE HECHICEROS) 5. Reunión de intercambio con el instituto hermano de Kioto","Gege Akutami",4,4344d,6081.6d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467941159","CHAINSAW MAN 1 ","Tatsuki Fujimoto",4,4887d,6841.8d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467942620","CHAINSAW MAN 2 ","Tatsuki Fujimoto",4,4887d,6841.8d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467943511","CHAINSAW MAN 3","Tatsuki Fujimoto",4,4887d,6841.8d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467944174","CHAINSAW MAN 4","Tatsuki Fujimoto",4,4887d,6841.8d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467945096","CHAINSAW MAN 5","Tatsuki Fujimoto",4,4887d,6841.8d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467935325","GUARDIANES DE LA NOCHE 1","Koyoharu Gotouge",4,4344d,6081.6d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467935127","GUARDIANES DE LA NOCHE 2","Koyoharu Gotouge",4,4344d,6081.6d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467935134","GUARDIANES DE LA NOCHE 3","Koyoharu Gotouge",4,4344d,6081.6d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467936681","GUARDIANES DE LA NOCHE 4","Koyoharu Gotouge",4,4344d,6081.6d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467936698","GUARDIANES DE LA NOCHE 5","Koyoharu Gotouge",4,4344d,6081.6d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467947076","TOKYO REVENGERS 1","Ken Wakui",4,8688d,12163.2d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467947083","TOKYO REVENGERS 2","Ken Wakui",4,8688d,12163.2d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467947090","TOKYO REVENGERS 3","Ken Wakui",4,8688d,12163.2d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467947106","TOKYO REVENGERS 4","Ken Wakui",4,8688d,12163.2d));
		inventarioEntityList.add(new InventarioEntity("RANDOM HOUSE","9788416709298","INCAL, EL (INTEGRAL)","JODOROWSKY, ALEJANDRO/MOEBIUS",3,24297.44d,34016.416d));
		
		for(InventarioEntity ie :inventarioEntityList){
			inventarioRepository.save(ie);
		}
		
		model.addAttribute("inventarioEntity", inventarioEntityList);
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
	
}
