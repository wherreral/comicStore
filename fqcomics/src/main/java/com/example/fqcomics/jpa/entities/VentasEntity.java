package com.example.fqcomics.jpa.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

@Entity
public class VentasEntity {

	//cantidad|precioVentaReal|vendedor|CLIENTE|DESPACHO
	
	public VentasEntity() {};
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private Date created;
	
	public VentasEntity(PreVentaEntity pve) {
		this.orderId = pve.getOrderId();
		this.isbn = pve.getIsbn();
		this.cantidad = pve.getCantidad();
		this.total = pve.getTotal();
		this.cliente = pve.getCliente();
		this.vendedor = pve.getVendedor();
	}
	

	public VentasEntity(String orderId, Double precioVentaReal,Double total, String vendedor) {
		super();
		this.orderId = orderId;
		this.precioVentaReal = precioVentaReal;
		this.total = total;
		this.vendedor = vendedor;
	}


	@PrePersist
	protected void onCreate() {
		created = new Date();
	}
	
	private String orderId;
	private String isbn;
	private Integer cantidad;
	private Double precioVentaReal;
	private Double total;
	private String vendedor;
	private String cliente;
	private String numTransferencia;
	private Boolean pagado;	
	
	
	public Boolean getPagado() {
		return pagado;
	}
	public void setPagado(Boolean pagado) {
		this.pagado = pagado;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
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
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public String getVendedor() {
		return vendedor;
	}
	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getNumTransferencia() {
		return numTransferencia;
	}
	public void setNumTransferencia(String numTransferencia) {
		this.numTransferencia = numTransferencia;
	}


	public Date getCreated() {
		return created;
	}


	public void setCreated(Date created) {
		this.created = created;
	}
	
	
	
}
