package com.libreria.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.libreria.main.dao.IClienteDao;
import com.libreria.main.dao.IFacturaVentaDao;
import com.libreria.main.dao.IProductoDao;
import com.libreria.main.entities.Cliente;
import com.libreria.main.entities.FacturaVenta;
import com.libreria.main.entities.Producto;

@Service
public class ClienteService implements IClienteService {

	@Autowired
	private IClienteDao clienteDao;
	
	@Autowired
	private IProductoDao productoDao;
	
	@Autowired
	public IFacturaVentaDao facturaVentaDao;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		clienteDao.save(cliente);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		clienteDao.deleteById(id);		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findByNombre(String term) {
		return productoDao.findByNombreLikeIgnoreCase("%" + term + "%"); //buscar por nombre ignorando si es con mayúscula o minúscula
	}

	@Override
	@Transactional
	public void saveFacturaVenta(FacturaVenta facturaVenta) {
		facturaVentaDao.save(facturaVenta);
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findProductoById(Long id) {
		return productoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public FacturaVenta findFacturaVentaById(Long id) {
		return facturaVentaDao.findById(id).orElse(null);
	}

	@Override
	public void deleteFactura(Long id) {
		facturaVentaDao.deleteById(id);
	}

	
}
