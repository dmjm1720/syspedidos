package com.dmjm.util;

import java.util.ArrayList;
import java.util.List;

public class Caja {
	private int id; // ID de la caja
	private List<ContenidoCaja> contenidos = new ArrayList<>();

	public Caja() {

	}

	public Caja(int id, List<ContenidoCaja> contenidos) {

		this.id = id;
		this.contenidos = contenidos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<ContenidoCaja> getContenidos() {
		return contenidos;
	}

	public void setContenidos(List<ContenidoCaja> contenidos) {
		this.contenidos = contenidos;
	}

}
