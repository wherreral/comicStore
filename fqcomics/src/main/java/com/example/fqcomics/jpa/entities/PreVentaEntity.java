package com.example.fqcomics.jpa.entities;



import java.text.DecimalFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.Transient;

@Entity
public class PreVentaEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	

	
	private Date created;
	@PrePersist
	protected void onCreate() {
		created = new Date();
	}
 
	@PostPersist
	protected void onPost() {
		DecimalFormat myFormatter = new DecimalFormat("ORD000000");
	    orderId = myFormatter.format(id);
	    total = cantidad * precioVentaReal;
	}

	private String isbn;
	private String nombre;
	private String orderId;
	private Integer cantidad;
	private Double precioVentaReal;
	private Double total;
	private String cliente;
	private String vendedor;
	private Double despacho;
	private Boolean pagado = false;	
	
	public PreVentaEntity() {}
	
	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Double getDespacho() {
		return despacho;
	}
	public void setDespacho(Double despacho) {
		this.despacho = despacho;
	}
	public Boolean getPagado() {
		return pagado;
	}
	public void setPagado(Boolean pagado) {
		this.pagado = pagado;
	}
	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
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
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Double getPrecioVentaReal() {
		return precioVentaReal;
	}
	public void setPrecioVentaReal(Double precioVentaReal) {
		this.precioVentaReal = precioVentaReal;
	}
	public String getVendedor() {
		return vendedor;
	}
	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}
	
	
}
