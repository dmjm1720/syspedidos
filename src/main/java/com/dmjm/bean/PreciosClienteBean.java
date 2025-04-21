
package com.dmjm.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.dmjm.dao.PreciosClienteDao;
import com.dmjm.impl.PreciosClienteDaoImpl;
import com.dmjm.model.PreciosCliente;

@Named(value = "PreciosClienteBean")
@ViewScoped
public class PreciosClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<PreciosCliente> listaPrecios;
	private PreciosCliente pre;

	public PreciosClienteBean() {

	}

	@PostConstruct
	public void init() {
		listaPrecios = new ArrayList<>();
		pre = new PreciosCliente();
	}

	public List<PreciosCliente> getListaPrecios() {
		PreciosClienteDao preDao = new PreciosClienteDaoImpl();
		listaPrecios = preDao.listaPrecios();
		return listaPrecios;
	}

	public PreciosCliente getPre() {
		return pre;
	}

	public void setPre(PreciosCliente pre) {
		this.pre = pre;
	}

}
