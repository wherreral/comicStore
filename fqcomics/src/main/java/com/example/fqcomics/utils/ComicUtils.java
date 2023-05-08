package com.example.fqcomics.utils;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.example.fqcomics.jpa.entities.InventarioEntity;
import com.example.fqcomics.jpa.repository.InventarioRepository;
import com.example.fqcomics.jpa.repository.PreVentaRepository;
import com.example.fqcomics.jpa.repository.VentasRepository;

@Service
@Scope("singleton")
public class ComicUtils {

	
	@Autowired InventarioRepository inventarioRepository;
	@Autowired PreVentaRepository preVentaRepository;
	@Autowired VentasRepository ventasRepository;
	
	public void insertData() {
		
		List<InventarioEntity> inventarioEntityList = new ArrayList<>();
		inventarioEntityList.add(new InventarioEntity("ECC","9788417509774","Watchmen (Edición Deluxe) (Tercera edición)","Watchmen Del","Alan Moore, Dave Gibbons",4,38844.5697307122d,60990d));
		inventarioEntityList.add(new InventarioEntity("ECC","9788416796809","V de Vendetta (Edición Deluxe) 2ª edición","Vendetta Del","Alan Moore, David Lloyd",4,34966.3278887979d,55990d));
		inventarioEntityList.add(new InventarioEntity("ECC","9788418326936","V de Vendetta (Edición cartoné) (Cuarta edición)","Vendetta Car","Moore, Alan",4,24089.8483641985d,40990d));
		inventarioEntityList.add(new InventarioEntity("ECC","9788418475849","Batman Vol. 1: El Tribunal de los Búhos (Batman Saga Nuevo Universo Parte 1)","Batman 1","James Tynion IV, Scott Snyde, Greg Capullo, Jason Fabok, Rafael Albuquerque",4,27197.4139426554d,43990d));
		inventarioEntityList.add(new InventarioEntity("ECC","9788417665142","La Broma asesina Versión extendida (Edición Deluxe) (2a edición)","Broma","Alan Moore, Brian Bolland",4,27197.4139426554d,43990d));
		inventarioEntityList.add(new InventarioEntity("ECC","9788418043192","Predicador vol. 1 (Edición Deluxe) (Segunda edición)","Predicador","Garth Ennis, Steve Dillon",3,33412.5450995694d,53990d));
		inventarioEntityList.add(new InventarioEntity("PANINI","9788411015158","Providence 1. El miedo que acecha","Providence 1","Alan Moore, Jacen Burrows",3,16308.5041557422d,26990d));
		inventarioEntityList.add(new InventarioEntity("PANINI","9788490947470","Providence 2. El abismo del tiempo","Providence 2","Alan Moore, Jacen Burrows",3,14717.4305795722d,23990d));
		inventarioEntityList.add(new InventarioEntity("PANINI","9788491671510","Providence 3. Lo innombrable","Providence 3","Alan Moore, Jacen Burrows",3,14717.4305795722d,23990d));
		inventarioEntityList.add(new InventarioEntity("PANINI","9788498857238","Neonomicon","Neonomicon","Alan Moore",3,13984.0451030564d,22990d));
		inventarioEntityList.add(new InventarioEntity("PANINI","9788498855142","CIVIL WAR Marvel Deluxe Tapa Dura","Civil War","Mark Millar",4,18608.1026838004d,29990d));
		inventarioEntityList.add(new InventarioEntity("PANINI","9788411015035","Berserk Maximum 1","Berserk 1","Kentaro Miura",4,13163.6477903437d,22990d));
		inventarioEntityList.add(new InventarioEntity("PANINI","9788490948620","Blame! Master Edition 1","Blame 1","Tsutomu Nihei",4,15537.8278922849d,29990d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467909708","ATAQUE A LOS TITANES 1 ","Ataque 1","Hajime Isayama",4,5730.35092667466d,12990d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467909715","ATAQUE A LOS TITANES 2","Ataque 2","Hajime Isayama",4,5730.35092667466d,12690d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467910995","ATAQUE A LOS TITANES 3","Ataque 3","Hajime Isayama",4,5730.35092667466d,12690d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467911503","ATAQUE A LOS TITANES 4","Ataque 4","Hajime Isayama",4,5730.35092667466d,12690d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467912616","ATAQUE A LOS TITANES 5","Ataque 5","Hajime Isayama",4,5730.35092667466d,12690d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467941920","JUJUTSU KAISEN (GUERRA DE HECHICEROS) 0. Escuela técnica de hechicería del área metropolitana de Tokio","Jjutsu 0","Gege Akutami",4,5730.35092667466d,13990d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467940657","JUJUTSU KAISEN (GUERRA DE HECHICEROS) 1. Ryômen-Sukuna","Jujutsu 1","Gege Akutami",4,5730.35092667466d,13990d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467941562","JUJUTSU KAISEN (GUERRA DE HECHICEROS) 2. El feto maldito bajo el cielo","Jujutsu 2","Gege Akutami",4,5730.35092667466d,13990d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467941913","JUJUTSU KAISEN (GUERRA DE HECHICEROS) 3. El pececillo y el castigo proporcionalmente inverso","Jujutsu 3","Gege Akutami",4,5730.35092667466d,13990d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467942699","JUJUTSU KAISEN (GUERRA DE HECHICEROS) 4. Te mataré","Jujutsu 4","Gege Akutami",4,5730.35092667466d,13990d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467943542","JUJUTSU KAISEN (GUERRA DE HECHICEROS) 5. Reunión de intercambio con el instituto hermano de Kioto","Jujutsu 5","Gege Akutami",4,5730.35092667466d,13990d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467941159","CHAINSAW MAN 1 ","Chainsaw 1","Tatsuki Fujimoto",4,6451.30614087668d,13990d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467942620","CHAINSAW MAN 2 ","Chainsaw 2","Tatsuki Fujimoto",4,6451.30614087668d,13990d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467943511","CHAINSAW MAN 3","Chainsaw 3","Tatsuki Fujimoto",4,6451.30614087668d,13990d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467944174","CHAINSAW MAN 4","Chainsaw 4","Tatsuki Fujimoto",4,6451.30614087668d,13990d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467945096","CHAINSAW MAN 5","Chainsaw 5","Tatsuki Fujimoto",4,6451.30614087668d,13990d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467935127","GUARDIANES DE LA NOCHE 2","Kimetsu 2","Koyoharu Gotouge",4,5730.35092667466d,13990d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467935134","GUARDIANES DE LA NOCHE 3","Kimetsu 3","Koyoharu Gotouge",4,5730.35092667466d,13990d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467936681","GUARDIANES DE LA NOCHE 4","Kimetsu 4","Koyoharu Gotouge",4,5730.35092667466d,13990d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467936698","GUARDIANES DE LA NOCHE 5","Kimetsu 5","Koyoharu Gotouge",4,5730.35092667466d,13990d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467947083","TOKYO REVENGERS 2","TOKYO 2","Ken Wakui",4,11473.1321156632d,19990d));
		inventarioEntityList.add(new InventarioEntity("NORMA","9788467947106","TOKYO REVENGERS 4","TOKYO 4","Ken Wakui",4,11473.1321156632d,19990d));
		inventarioEntityList.add(new InventarioEntity("RANDOM HOUSE","9788416709298","INCAL, EL (INTEGRAL)","Incal Int","JODOROWSKY, ALEJANDRO/MOEBIUS",3,35463.538381351d,49990d));
		inventarioEntityList.add(new InventarioEntity("","9788467906769","EL INCAL","Incal","JODOROWSKY, ALEJANDRO/MOEBIUS",3,10043.6519495729d,19990d));

		for(InventarioEntity ie :inventarioEntityList){
			inventarioRepository.save(ie);
		}
	}
}
