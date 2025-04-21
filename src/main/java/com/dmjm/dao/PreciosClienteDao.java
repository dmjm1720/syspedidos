package com.dmjm.dao;

import java.util.List;

import com.dmjm.model.PreciosCliente;

public interface PreciosClienteDao {

	List<PreciosCliente> listaPrecios();

	double precio(String art);
}
