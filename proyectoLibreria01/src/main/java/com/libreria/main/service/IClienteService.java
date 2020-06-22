package com.libreria.main.service;

import java.util.List;

import com.libreria.main.entities.Cliente;
import com.libreria.main.entities.FacturaVenta;
import com.libreria.main.entities.Producto;

public interface IClienteService {

	public List<Cliente> findAll();
	
	public void save(Cliente cliente);
	
	public Cliente findById(Long id);
	
	public void deleteById(Long id);
	
	public List<Producto> findByNombre(String term);
	
	public void saveFacturaVenta(FacturaVenta facturaVenta);
	
	public Producto findProductoById(Long id);
	
	public FacturaVenta findFacturaVentaById(Long id);
	
	public void deleteFactura(Long id);
	
}
