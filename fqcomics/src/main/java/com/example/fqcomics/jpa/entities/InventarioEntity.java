package com.example.fqcomics.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InventarioEntity {

	//isbn|nombre|autor|cantidad|precioCosto|precioPiso|precioVenta|bodega
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String editorial;
	private String isbn;
	private String nombre;
	private String nombreCorto;
	private String autor;
	private Integer cantidad;
	private Double precioCosto;
	private Double precioPiso;
	private Double precioVenta;
	private String bodega;
	
	public InventarioEntity(){};
	
	public InventarioEntity( String editorial, String isbn, String nombre, String nombreCorto, String autor, Integer cantidad, Double precioCosto,
			Double precioPiso) {
		super();
		this.editorial=editorial;
		this.isbn = isbn;
		this.nombre = nombre;
		this.nombreCorto = nombreCorto;
		this.autor = autor;
		this.cantidad = cantidad;
		this.precioCosto = precioCosto;
		this.precioPiso = precioPiso;
	}
	
	public InventarioEntity( String editorial, String isbn, String nombre, String autor, Integer cantidad, Double precioCosto,
			Double precioPiso, Double precioVenta, String bodega) {
		super();
		this.editorial=editorial;
		this.isbn = isbn;
		this.nombre = nombre;
		this.autor = autor;
		this.cantidad = cantidad;
		this.precioCosto = precioCosto;
		this.precioPiso = precioPiso;
		this.precioVenta = precioVenta;
		this.bodega = bodega;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Double getPrecioCosto() {
		return precioCosto;
	}
	public void setPrecioCosto(Double precioCosto) {
		this.precioCosto = precioCosto;
	}
	public Double getPrecioPiso() {
		return precioPiso;
	}
	public void setPrecioPiso(Double precioPiso) {
		this.precioPiso = precioPiso;
	}
	public Double getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
	}
	public String getBodega() {
		return bodega;
	}
	public void setBodega(String bodega) {
		this.bodega = bodega;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getNombreCorto() {
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}
	
}
