package com.libreria.main.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	//private String descripcion;
	
	//private Double precio; //SACAR DESPUES
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "precio_id")
	private Precio precio;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "stock_id")
	private Stock stock;
	
	
	//CONSTRUCTORES ------------------------------------------------
//	public Producto() {
//		
//	}
//
//	public Producto(Long id, String nombre, String descripcion, Precio precio, Stock stock) {
//		this.id = id;
//		this.nombre = nombre;
//		this.descripcion = descripcion;
//		this.precio = precio;
//		this.stock = stock;
//	}

	
	//GETTERS Y SETTERS --------------------------------------
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

//	public String getDescripcion() {
//		return descripcion;
//	}
//
//	public void setDescripcion(String descripcion) {
//		this.descripcion = descripcion;
//	}

//	public Double getPrecio() {	//DESPUÉS SACAR
//		return precio;
//	}
//
//	public void setPrecio(Double precio) { //DESPUÉS SACAR
//		this.precio = precio;
//	}

	public Precio getPrecio() {
		return precio;
	}

	public void setPrecio(Precio precio) {
		this.precio = precio;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}
		
	
}
