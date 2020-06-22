package com.libreria.main.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "facturas_venta")
public class FacturaVenta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull  //FUNCIONA??
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@PastOrPresent
	private Date fecha;
	
	@ManyToOne(fetch = FetchType.LAZY) //muchas facturas, un cliente
	private Cliente cliente;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "factura_venta_id") //es necesario cuando la relación es unidireccional
	private List<ItemFVenta> items;
	
	
//	@PrePersist //se asigna la fecha justo antes de persistir la factura
//	public void generarFecha() {
//		fecha = new Date();
//	}							//LA QUITAMOS PORQUE LA AGREGAMOS MEDIANTE FORMULARIO
	
	
	//CONSTRUCTORES ------------------------------------------------
	public FacturaVenta() {
		items = new ArrayList<ItemFVenta>();
	}

//	public FacturaVenta(Long id, Date fecha, Double total, int cantidad, /*Producto producto, */Cliente cliente,
//			List<ItemFVenta> items) {
//		items = new ArrayList<ItemFVenta>();
//		this.id = id;
//		this.fecha = fecha;
//		this.total = total;
//		this.cantidad = cantidad;
//		//this.producto = producto;
//		this.cliente = cliente;
//		this.items = items;
//	}


	//SETTERS Y GETTERS --------------------------------------------
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemFVenta> getItems() {
		return items;
	}

	public void setItems(List<ItemFVenta> items) {
		this.items = items;
	}
	
	public void agregarItemFVenta(ItemFVenta item) {
		this.items.add(item);
	}
	
	public Double getTotal() {
		Double total = 0.00;
		
		for(int i=0; i<items.size(); i++) {
			total += items.get(i).calcularImporte();
		}
		return total;
	}
}
