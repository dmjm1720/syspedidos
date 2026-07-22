package com.dmjm.model;

public class Etiquetas implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int idEtiqueta;
	private String cveArt;
	private String descr;
	private String cveDoc;
	private Integer noOrden;
	private Integer cantidad;
	private String cveClpv;
	private String docSig;

	public Etiquetas() {
	}

	public Etiquetas(int idEtiqueta) {
		this.idEtiqueta = idEtiqueta;
	}

	public Etiquetas(int idEtiqueta, String cveArt, String descr, String cveDoc, Integer noOrden, Integer cantidad,
			String cveClpv, String docSig) {
		this.idEtiqueta = idEtiqueta;
		this.cveArt = cveArt;
		this.descr = descr;
		this.cveDoc = cveDoc;
		this.noOrden = noOrden;
		this.cantidad = cantidad;
		this.cveClpv = cveClpv;
		this.docSig = docSig;
	}

	public int getIdEtiqueta() {
		return this.idEtiqueta;
	}

	public void setIdEtiqueta(int idEtiqueta) {
		this.idEtiqueta = idEtiqueta;
	}

	public String getCveArt() {
		return this.cveArt;
	}

	public void setCveArt(String cveArt) {
		this.cveArt = cveArt;
	}

	public String getDescr() {
		return this.descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getCveDoc() {
		return this.cveDoc;
	}

	public void setCveDoc(String cveDoc) {
		this.cveDoc = cveDoc;
	}

	public Integer getNoOrden() {
		return this.noOrden;
	}

	public void setNoOrden(Integer noOrden) {
		this.noOrden = noOrden;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getCveClpv() {
		return this.cveClpv;
	}

	public void setCveClpv(String cveClpv) {
		this.cveClpv = cveClpv;
	}

	public String getDocSig() {
		return docSig;
	}

	public void setDocSig(String docSig) {
		this.docSig = docSig;
	}

}
