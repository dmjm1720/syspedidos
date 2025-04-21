package com.dmjm.model;

public class Partida implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String cveDoc;
	private Integer numPart;
	private String cveArt;
	private Double cant;
	private Double precio;
	private Double impu4;
	private Double totimp4;
	private Double desc1;
	private Double desc2;
	private Double desc3;
	private Double tipCam;
	private Double totPart;
	private Integer tipMon;
	private String observacion;
	private String descrLarga;
	private String descr;

	public Partida() {
	}

	public Partida(int id) {
		this.id = id;
	}

	public Partida(String cveDoc, Integer numPart, String cveArt, Double cant, Double precio, Double impu4,
			Double totimp4, Double desc1, Double desc2, Double desc3, Double tipCam, Double totPart, Integer tipMon,
			String observacion, String descrLarga, String descr) {
		this.cveDoc = cveDoc;
		this.numPart = numPart;
		this.cveArt = cveArt;
		this.cant = cant;
		this.precio = precio;
		this.impu4 = impu4;
		this.totimp4 = totimp4;
		this.desc1 = desc1;
		this.desc2 = desc2;
		this.desc3 = desc3;
		this.tipCam = tipCam;
		this.totPart = totPart;
		this.tipMon = tipMon;
		this.observacion = observacion;
		this.descrLarga = descrLarga;
		this.descr = descr;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCveDoc() {
		return this.cveDoc;
	}

	public void setCveDoc(String cveDoc) {
		this.cveDoc = cveDoc;
	}

	public Integer getNumPart() {
		return this.numPart;
	}

	public void setNumPart(Integer numPart) {
		this.numPart = numPart;
	}

	public String getCveArt() {
		return this.cveArt;
	}

	public void setCveArt(String cveArt) {
		this.cveArt = cveArt;
	}

	public Double getCant() {
		return this.cant;
	}

	public void setCant(Double cant) {
		this.cant = cant;
	}

	public Double getPrecio() {
		return this.precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Double getImpu4() {
		return this.impu4;
	}

	public void setImpu4(Double impu4) {
		this.impu4 = impu4;
	}

	public Double getTotimp4() {
		return this.totimp4;
	}

	public void setTotimp4(Double totimp4) {
		this.totimp4 = totimp4;
	}

	public Double getDesc1() {
		return this.desc1;
	}

	public void setDesc1(Double desc1) {
		this.desc1 = desc1;
	}

	public Double getDesc2() {
		return this.desc2;
	}

	public void setDesc2(Double desc2) {
		this.desc2 = desc2;
	}

	public Double getDesc3() {
		return this.desc3;
	}

	public void setDesc3(Double desc3) {
		this.desc3 = desc3;
	}

	public Double getTipCam() {
		return this.tipCam;
	}

	public void setTipCam(Double tipCam) {
		this.tipCam = tipCam;
	}

	public Double getTotPart() {
		return this.totPart;
	}

	public void setTotPart(Double totPart) {
		this.totPart = totPart;
	}

	public Integer getTipMon() {
		return this.tipMon;
	}

	public void setTipMon(Integer tipMon) {
		this.tipMon = tipMon;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getDescrLarga() {
		return this.descrLarga;
	}

	public void setDescrLarga(String descrLarga) {
		this.descrLarga = descrLarga;
	}

	public String getDescr() {
		return this.descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

}
