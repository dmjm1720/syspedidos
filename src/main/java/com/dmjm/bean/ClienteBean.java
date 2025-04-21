package com.dmjm.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.dmjm.dao.ClienteDao;
import com.dmjm.impl.ClienteDaoImpl;
import com.dmjm.model.Clie01;

@Named(value = "clienteBean")
@ViewScoped
public class ClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Clie01> listaCliente;
	private Clie01 clie01;

	public ClienteBean() {
		clie01 = new Clie01();
	}

	public List<Clie01> getListaCliente() {
		ClienteDao cDao = new ClienteDaoImpl();
		listaCliente = cDao.listaCliente();
		return listaCliente;
	}

	public void setListaCliente(List<Clie01> listaCliente) {
		this.listaCliente = listaCliente;
	}

	public Clie01 getClie01() {
		return clie01;
	}

	public void setClie01(Clie01 clie01) {
		this.clie01 = clie01;
	}

	public void prepararNuevoCliente() {
		clie01 = new Clie01();
	}

	public void nuevoCliente() {
		ClienteDao cDao = new ClienteDaoImpl();
		cDao.newClie01(clie01);
	}

	public void modificarCliente() {
		ClienteDao cDao = new ClienteDaoImpl();
		cDao.updateClie01(clie01);
		clie01 = new Clie01();
	}

	public void borrarCliente() {
		ClienteDao cDao = new ClienteDaoImpl();
		cDao.deleteClie01(clie01);
		clie01 = new Clie01();
	}
}
