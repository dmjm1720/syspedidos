package com.dmjm.model;

import java.util.Date;

public class Usuarios implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int idusuario;
	private Perfiles perfiles;
	private String clave;
	private String nombre;
	private String rfc;
	private String clasific;
	private Integer listaPrec;
	private String cveVend;
	private String password;
	private String correo;
	private Date fecha;
	private boolean estatus;

	public Usuarios() {
	}

	public Usuarios(int idusuario, Perfiles perfiles, String clave, String password, String correo, Date fecha,
			boolean estatus) {
		this.idusuario = idusuario;
		this.perfiles = perfiles;
		this.clave = clave;
		this.password = password;
		this.correo = correo;
		this.fecha = fecha;
		this.estatus = estatus;
	}

	public Usuarios(int idusuario, Perfiles perfiles, String clave, String nombre, String rfc, String clasific,
			Integer listaPrec, String cveVend, String password, String correo, Date fecha, boolean estatus) {
		this.idusuario = idusuario;
		this.perfiles = perfiles;
		this.clave = clave;
		this.nombre = nombre;
		this.rfc = rfc;
		this.clasific = clasific;
		this.listaPrec = listaPrec;
		this.cveVend = cveVend;
		this.password = password;
		this.correo = correo;
		this.fecha = fecha;
		this.estatus = estatus;
	}

	public int getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public Perfiles getPerfiles() {
		return this.perfiles;
	}

	public void setPerfiles(Perfiles perfiles) {
		this.perfiles = perfiles;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRfc() {
		return this.rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getClasific() {
		return this.clasific;
	}

	public void setClasific(String clasific) {
		this.clasific = clasific;
	}

	public Integer getListaPrec() {
		return this.listaPrec;
	}

	public void setListaPrec(Integer listaPrec) {
		this.listaPrec = listaPrec;
	}

	public String getCveVend() {
		return this.cveVend;
	}

	public void setCveVend(String cveVend) {
		this.cveVend = cveVend;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isEstatus() {
		return this.estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

}
