package com.libreria.main.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "items_factura_venta")
public class ItemFVenta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer cantidad;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "producto_id")
	private Producto producto;

	
	//CONSTRUCTORES ------------------------------------------------
//	public ItemFVenta() {
//	}
//
//	public ItemFVenta(Long id, int cantidad, Producto producto) {
//		this.id = id;
//		this.cantidad = cantidad;
//		this.producto = producto;
//	}

	
	//GETTERS Y SETTERS --------------------------------------
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public Double calcularImporte() {
		//Double importe = cantidad.doubleValue() * producto.getPrecio();
		Double importe = cantidad.doubleValue() * producto.getPrecio().getPrecioVenta();
		return (double)Math.round(importe * 100d) / 100d;
	}
	
}
