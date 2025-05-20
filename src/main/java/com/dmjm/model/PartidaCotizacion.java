package com.dmjm.model;

public class PartidaCotizacion {
	private String uni_med;
	private String descr;
	private String cve_art;
	private String cve_doc;
	private Integer num_par;
	private Integer cant;
	private Double prec;
	private Double impu4;
	private Double totimp4;
	private Double desc1;
	private Double tot_partida;

	public PartidaCotizacion() {

	}

	public PartidaCotizacion(String uni_med, String descr, String cve_art, String cve_doc, Integer num_par,
			Integer cant, Double prec, Double impu4, Double totimp4, Double desc1, Double tot_partida) {
		this.uni_med = uni_med;
		this.descr = descr;
		this.cve_art = cve_art;
		this.cve_doc = cve_doc;
		this.num_par = num_par;
		this.cant = cant;
		this.prec = prec;
		this.impu4 = impu4;
		this.totimp4 = totimp4;
		this.desc1 = desc1;
		this.tot_partida = tot_partida;
	}

	public String getUni_med() {
		return uni_med;
	}

	public void setUni_med(String uni_med) {
		this.uni_med = uni_med;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getCve_art() {
		return cve_art;
	}

	public void setCve_art(String cve_art) {
		this.cve_art = cve_art;
	}

	public String getCve_doc() {
		return cve_doc;
	}

	public void setCve_doc(String cve_doc) {
		this.cve_doc = cve_doc;
	}

	public Integer getNum_par() {
		return num_par;
	}

	public void setNum_par(Integer num_par) {
		this.num_par = num_par;
	}

	public Integer getCant() {
		return cant;
	}

	public void setCant(Integer cant) {
		this.cant = cant;
	}

	public Double getPrec() {
		return prec;
	}

	public void setPrec(Double prec) {
		this.prec = prec;
	}

	public Double getImpu4() {
		return impu4;
	}

	public void setImpu4(Double impu4) {
		this.impu4 = impu4;
	}

	public Double getTotimp4() {
		return totimp4;
	}

	public void setTotimp4(Double totimp4) {
		this.totimp4 = totimp4;
	}

	public Double getDesc1() {
		return desc1;
	}

	public void setDesc1(Double desc1) {
		this.desc1 = desc1;
	}

	public Double getTot_partida() {
		return tot_partida;
	}

	public void setTot_partida(Double tot_partida) {
		this.tot_partida = tot_partida;
	}

}
