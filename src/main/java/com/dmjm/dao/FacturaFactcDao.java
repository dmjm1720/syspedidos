package com.dmjm.dao;

import java.util.List;

import com.dmjm.model.Factc01;

public interface FacturaFactcDao {

	List<Factc01> listaFacturas();
	
	List<Factc01> listaFacturasClientes();
}
