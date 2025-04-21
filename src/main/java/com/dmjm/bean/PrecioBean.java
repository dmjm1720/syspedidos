package com.dmjm.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.dmjm.dao.PrecioDao;
import com.dmjm.impl.PrecioDaoImpl;
import com.dmjm.model.Inve01;

@Named(value = "precioBean")
@ViewScoped
public class PrecioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Inve01> listaPrecio;
	private Inve01 precio;

	public PrecioBean() {
		precio = new Inve01();
	}

	public List<Inve01> getListaPrecio() {
		PrecioDao pDao = new PrecioDaoImpl();
		listaPrecio = pDao.listaPrecio();
		return listaPrecio;
	}

	public void setListaPrecio(List<Inve01> listaPrecio) {
		this.listaPrecio = listaPrecio;
	}

	public Inve01 getPrecio() {
		return precio;
	}

	public void setPrecio(Inve01 precio) {
		this.precio = precio;
	}

}
