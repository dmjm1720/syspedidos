package com.dmjm.model;

import java.util.Date;

public class EncabezadoFact {

	private String clave;
	private String nombre;
	private String rfc;
	private String cve_doc;
	private String estatus;
	private String cve_pedi;
	private Date fecha_doc;
	private Date fecha_ent;
	private Date fecha_ven;
	private Double imp_tot1;
	private Double imp_tot2;
	private Double imp_tot3;
	private Double imp_tot4;
	private Integer can_tot;
	private Date fecha_cancela;
	private Double des_tot;
	private String condicion;
	private String num_pagos;
	private String formaenvio;
	private Double importe;
	private String metopago;
	private String tip_doc_ant;
	private String doc_ant;
	private String tip_doc_sig;
	private String doc_sig;

	public EncabezadoFact() {

	}

	public EncabezadoFact(String clave, String nombre, String rfc, String cve_doc, String estatus, String cve_pedi,
			Date fecha_doc, Date fecha_ent, Date fecha_ven, Double imp_tot1, Double imp_tot2, Double imp_tot3,
			Double imp_tot4, Integer can_tot, Date fecha_cancela, Double des_tot, String condicion, String num_pagos,
			String formaenvio, Double importe, String metopago, String tip_doc_ant, String doc_ant, String tip_doc_sig,
			String doc_sig) {

		this.clave = clave;
		this.nombre = nombre;
		this.rfc = rfc;
		this.cve_doc = cve_doc;
		this.estatus = estatus;
		this.cve_pedi = cve_pedi;
		this.fecha_doc = fecha_doc;
		this.fecha_ent = fecha_ent;
		this.fecha_ven = fecha_ven;
		this.imp_tot1 = imp_tot1;
		this.imp_tot2 = imp_tot2;
		this.imp_tot3 = imp_tot3;
		this.imp_tot4 = imp_tot4;
		this.can_tot = can_tot;
		this.fecha_cancela = fecha_cancela;
		this.des_tot = des_tot;
		this.condicion = condicion;
		this.num_pagos = num_pagos;
		this.formaenvio = formaenvio;
		this.importe = importe;
		this.metopago = metopago;
		this.tip_doc_ant = tip_doc_ant;
		this.doc_ant = doc_ant;
		this.tip_doc_sig = tip_doc_sig;
		this.doc_sig = doc_sig;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getCve_doc() {
		return cve_doc;
	}

	public void setCve_doc(String cve_doc) {
		this.cve_doc = cve_doc;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getCve_pedi() {
		return cve_pedi;
	}

	public void setCve_pedi(String cve_pedi) {
		this.cve_pedi = cve_pedi;
	}

	public Date getFecha_doc() {
		return fecha_doc;
	}

	public void setFecha_doc(Date fecha_doc) {
		this.fecha_doc = fecha_doc;
	}

	public Date getFecha_ent() {
		return fecha_ent;
	}

	public void setFecha_ent(Date fecha_ent) {
		this.fecha_ent = fecha_ent;
	}

	public Date getFecha_ven() {
		return fecha_ven;
	}

	public void setFecha_ven(Date fecha_ven) {
		this.fecha_ven = fecha_ven;
	}

	public Double getImp_tot1() {
		return imp_tot1;
	}

	public void setImp_tot1(Double imp_tot1) {
		this.imp_tot1 = imp_tot1;
	}

	public Double getImp_tot2() {
		return imp_tot2;
	}

	public void setImp_tot2(Double imp_tot2) {
		this.imp_tot2 = imp_tot2;
	}

	public Double getImp_tot3() {
		return imp_tot3;
	}

	public void setImp_tot3(Double imp_tot3) {
		this.imp_tot3 = imp_tot3;
	}

	public Double getImp_tot4() {
		return imp_tot4;
	}

	public void setImp_tot4(Double imp_tot4) {
		this.imp_tot4 = imp_tot4;
	}

	public Integer getCan_tot() {
		return can_tot;
	}

	public void setCan_tot(Integer can_tot) {
		this.can_tot = can_tot;
	}

	public Date getFecha_cancela() {
		return fecha_cancela;
	}

	public void setFecha_cancela(Date fecha_cancela) {
		this.fecha_cancela = fecha_cancela;
	}

	public Double getDes_tot() {
		return des_tot;
	}

	public void setDes_tot(Double des_tot) {
		this.des_tot = des_tot;
	}

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	public String getNum_pagos() {
		return num_pagos;
	}

	public void setNum_pagos(String num_pagos) {
		this.num_pagos = num_pagos;
	}

	public String getFormaenvio() {
		return formaenvio;
	}

	public void setFormaenvio(String formaenvio) {
		this.formaenvio = formaenvio;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public String getMetopago() {
		return metopago;
	}

	public void setMetopago(String metopago) {
		this.metopago = metopago;
	}

	public String getTip_doc_ant() {
		return tip_doc_ant;
	}

	public void setTip_doc_ant(String tip_doc_ant) {
		this.tip_doc_ant = tip_doc_ant;
	}

	public String getDoc_ant() {
		return doc_ant;
	}

	public void setDoc_ant(String doc_ant) {
		this.doc_ant = doc_ant;
	}

	public String getTip_doc_sig() {
		return tip_doc_sig;
	}

	public void setTip_doc_sig(String tip_doc_sig) {
		this.tip_doc_sig = tip_doc_sig;
	}

	public String getDoc_sig() {
		return doc_sig;
	}

	public void setDoc_sig(String doc_sig) {
		this.doc_sig = doc_sig;
	}

}
