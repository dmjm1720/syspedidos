package com.dmjm.model;

import java.util.Date;

public class Clie01 implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String clave;
	private String status;
	private String nombre;
	private String rfc;
	private String calle;
	private String numint;
	private String numext;
	private String cruzamientos;
	private String cruzamientos2;
	private String colonia;
	private String codigo;
	private String localidad;
	private String municipio;
	private String estado;
	private String pais;
	private String nacionalidad;
	private String referdir;
	private String telefono;
	private String clasific;
	private String fax;
	private String pagWeb;
	private String curp;
	private String cveZona;
	private String imprir;
	private String mail;
	private Integer nivelsec;
	private String enviosilen;
	private String emailpred;
	private String diarev;
	private String diapago;
	private String conCredito;
	private Integer diascred;
	private Double limcred;
	private Double saldo;
	private Integer listaPrec;
	private Integer cveBita;
	private String ultPagod;
	private Double ultPagom;
	private Date ultPagof;
	private Double descuento;
	private String ultVentad;
	private Double ultCompm;
	private Date fchUltcom;
	private Double ventas;
	private String cveVend;
	private Integer cveObs;
	private String tipoEmpresa;
	private String matriz;
	private String prospecto;
	private String calleEnvio;
	private String numintEnvio;
	private String numextEnvio;
	private String cruzamientosEnvio;
	private String cruzamientosEnvio2;
	private String coloniaEnvio;
	private String localidadEnvio;
	private String municipioEnvio;
	private String estadoEnvio;
	private String paisEnvio;
	private String codigoEnvio;
	private String cveZonaEnvio;
	private String referenciaEnvio;
	private String cuentaContable;
	private String addendaf;
	private String addendad;
	private String namespace;
	private String metododepago;
	private String numctapago;
	private String modelo;
	private String desImpu1;
	private String desImpu2;
	private String desImpu3;
	private String desImpu4;
	private String desPer;
	private Double latGeneral;
	private Double lonGeneral;
	private Double latEnvio;
	private Double lonEnvio;
	private String uuid;
	private Date versionSinc;
	private String usoCfdi;
	private String cvePaisSat;
	private String numidregfiscal;
	private String formadepagosat;

	public Clie01() {
	}

	public Clie01(String clave, String status) {
		this.clave = clave;
		this.status = status;
	}

	public Clie01(String clave, String status, String nombre, String rfc, String calle, String numint, String numext,
			String cruzamientos, String cruzamientos2, String colonia, String codigo, String localidad,
			String municipio, String estado, String pais, String nacionalidad, String referdir, String telefono,
			String clasific, String fax, String pagWeb, String curp, String cveZona, String imprir, String mail,
			Integer nivelsec, String enviosilen, String emailpred, String diarev, String diapago, String conCredito,
			Integer diascred, Double limcred, Double saldo, Integer listaPrec, Integer cveBita, String ultPagod,
			Double ultPagom, Date ultPagof, Double descuento, String ultVentad, Double ultCompm, Date fchUltcom,
			Double ventas, String cveVend, Integer cveObs, String tipoEmpresa, String matriz, String prospecto,
			String calleEnvio, String numintEnvio, String numextEnvio, String cruzamientosEnvio,
			String cruzamientosEnvio2, String coloniaEnvio, String localidadEnvio, String municipioEnvio,
			String estadoEnvio, String paisEnvio, String codigoEnvio, String cveZonaEnvio, String referenciaEnvio,
			String cuentaContable, String addendaf, String addendad, String namespace, String metododepago,
			String numctapago, String modelo, String desImpu1, String desImpu2, String desImpu3, String desImpu4,
			String desPer, Double latGeneral, Double lonGeneral, Double latEnvio, Double lonEnvio, String uuid,
			Date versionSinc, String usoCfdi, String cvePaisSat, String numidregfiscal, String formadepagosat) {
		this.clave = clave;
		this.status = status;
		this.nombre = nombre;
		this.rfc = rfc;
		this.calle = calle;
		this.numint = numint;
		this.numext = numext;
		this.cruzamientos = cruzamientos;
		this.cruzamientos2 = cruzamientos2;
		this.colonia = colonia;
		this.codigo = codigo;
		this.localidad = localidad;
		this.municipio = municipio;
		this.estado = estado;
		this.pais = pais;
		this.nacionalidad = nacionalidad;
		this.referdir = referdir;
		this.telefono = telefono;
		this.clasific = clasific;
		this.fax = fax;
		this.pagWeb = pagWeb;
		this.curp = curp;
		this.cveZona = cveZona;
		this.imprir = imprir;
		this.mail = mail;
		this.nivelsec = nivelsec;
		this.enviosilen = enviosilen;
		this.emailpred = emailpred;
		this.diarev = diarev;
		this.diapago = diapago;
		this.conCredito = conCredito;
		this.diascred = diascred;
		this.limcred = limcred;
		this.saldo = saldo;
		this.listaPrec = listaPrec;
		this.cveBita = cveBita;
		this.ultPagod = ultPagod;
		this.ultPagom = ultPagom;
		this.ultPagof = ultPagof;
		this.descuento = descuento;
		this.ultVentad = ultVentad;
		this.ultCompm = ultCompm;
		this.fchUltcom = fchUltcom;
		this.ventas = ventas;
		this.cveVend = cveVend;
		this.cveObs = cveObs;
		this.tipoEmpresa = tipoEmpresa;
		this.matriz = matriz;
		this.prospecto = prospecto;
		this.calleEnvio = calleEnvio;
		this.numintEnvio = numintEnvio;
		this.numextEnvio = numextEnvio;
		this.cruzamientosEnvio = cruzamientosEnvio;
		this.cruzamientosEnvio2 = cruzamientosEnvio2;
		this.coloniaEnvio = coloniaEnvio;
		this.localidadEnvio = localidadEnvio;
		this.municipioEnvio = municipioEnvio;
		this.estadoEnvio = estadoEnvio;
		this.paisEnvio = paisEnvio;
		this.codigoEnvio = codigoEnvio;
		this.cveZonaEnvio = cveZonaEnvio;
		this.referenciaEnvio = referenciaEnvio;
		this.cuentaContable = cuentaContable;
		this.addendaf = addendaf;
		this.addendad = addendad;
		this.namespace = namespace;
		this.metododepago = metododepago;
		this.numctapago = numctapago;
		this.modelo = modelo;
		this.desImpu1 = desImpu1;
		this.desImpu2 = desImpu2;
		this.desImpu3 = desImpu3;
		this.desImpu4 = desImpu4;
		this.desPer = desPer;
		this.latGeneral = latGeneral;
		this.lonGeneral = lonGeneral;
		this.latEnvio = latEnvio;
		this.lonEnvio = lonEnvio;
		this.uuid = uuid;
		this.versionSinc = versionSinc;
		this.usoCfdi = usoCfdi;
		this.cvePaisSat = cvePaisSat;
		this.numidregfiscal = numidregfiscal;
		this.formadepagosat = formadepagosat;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumint() {
		return this.numint;
	}

	public void setNumint(String numint) {
		this.numint = numint;
	}

	public String getNumext() {
		return this.numext;
	}

	public void setNumext(String numext) {
		this.numext = numext;
	}

	public String getCruzamientos() {
		return this.cruzamientos;
	}

	public void setCruzamientos(String cruzamientos) {
		this.cruzamientos = cruzamientos;
	}

	public String getCruzamientos2() {
		return this.cruzamientos2;
	}

	public void setCruzamientos2(String cruzamientos2) {
		this.cruzamientos2 = cruzamientos2;
	}

	public String getColonia() {
		return this.colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getMunicipio() {
		return this.municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getNacionalidad() {
		return this.nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getReferdir() {
		return this.referdir;
	}

	public void setReferdir(String referdir) {
		this.referdir = referdir;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getClasific() {
		return this.clasific;
	}

	public void setClasific(String clasific) {
		this.clasific = clasific;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getPagWeb() {
		return this.pagWeb;
	}

	public void setPagWeb(String pagWeb) {
		this.pagWeb = pagWeb;
	}

	public String getCurp() {
		return this.curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getCveZona() {
		return this.cveZona;
	}

	public void setCveZona(String cveZona) {
		this.cveZona = cveZona;
	}

	public String getImprir() {
		return this.imprir;
	}

	public void setImprir(String imprir) {
		this.imprir = imprir;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Integer getNivelsec() {
		return this.nivelsec;
	}

	public void setNivelsec(Integer nivelsec) {
		this.nivelsec = nivelsec;
	}

	public String getEnviosilen() {
		return this.enviosilen;
	}

	public void setEnviosilen(String enviosilen) {
		this.enviosilen = enviosilen;
	}

	public String getEmailpred() {
		return this.emailpred;
	}

	public void setEmailpred(String emailpred) {
		this.emailpred = emailpred;
	}

	public String getDiarev() {
		return this.diarev;
	}

	public void setDiarev(String diarev) {
		this.diarev = diarev;
	}

	public String getDiapago() {
		return this.diapago;
	}

	public void setDiapago(String diapago) {
		this.diapago = diapago;
	}

	public String getConCredito() {
		return this.conCredito;
	}

	public void setConCredito(String conCredito) {
		this.conCredito = conCredito;
	}

	public Integer getDiascred() {
		return this.diascred;
	}

	public void setDiascred(Integer diascred) {
		this.diascred = diascred;
	}

	public Double getLimcred() {
		return this.limcred;
	}

	public void setLimcred(Double limcred) {
		this.limcred = limcred;
	}

	public Double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Integer getListaPrec() {
		return this.listaPrec;
	}

	public void setListaPrec(Integer listaPrec) {
		this.listaPrec = listaPrec;
	}

	public Integer getCveBita() {
		return this.cveBita;
	}

	public void setCveBita(Integer cveBita) {
		this.cveBita = cveBita;
	}

	public String getUltPagod() {
		return this.ultPagod;
	}

	public void setUltPagod(String ultPagod) {
		this.ultPagod = ultPagod;
	}

	public Double getUltPagom() {
		return this.ultPagom;
	}

	public void setUltPagom(Double ultPagom) {
		this.ultPagom = ultPagom;
	}

	public Date getUltPagof() {
		return this.ultPagof;
	}

	public void setUltPagof(Date ultPagof) {
		this.ultPagof = ultPagof;
	}

	public Double getDescuento() {
		return this.descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	public String getUltVentad() {
		return this.ultVentad;
	}

	public void setUltVentad(String ultVentad) {
		this.ultVentad = ultVentad;
	}

	public Double getUltCompm() {
		return this.ultCompm;
	}

	public void setUltCompm(Double ultCompm) {
		this.ultCompm = ultCompm;
	}

	public Date getFchUltcom() {
		return this.fchUltcom;
	}

	public void setFchUltcom(Date fchUltcom) {
		this.fchUltcom = fchUltcom;
	}

	public Double getVentas() {
		return this.ventas;
	}

	public void setVentas(Double ventas) {
		this.ventas = ventas;
	}

	public String getCveVend() {
		return this.cveVend;
	}

	public void setCveVend(String cveVend) {
		this.cveVend = cveVend;
	}

	public Integer getCveObs() {
		return this.cveObs;
	}

	public void setCveObs(Integer cveObs) {
		this.cveObs = cveObs;
	}

	public String getTipoEmpresa() {
		return this.tipoEmpresa;
	}

	public void setTipoEmpresa(String tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

	public String getMatriz() {
		return this.matriz;
	}

	public void setMatriz(String matriz) {
		this.matriz = matriz;
	}

	public String getProspecto() {
		return this.prospecto;
	}

	public void setProspecto(String prospecto) {
		this.prospecto = prospecto;
	}

	public String getCalleEnvio() {
		return this.calleEnvio;
	}

	public void setCalleEnvio(String calleEnvio) {
		this.calleEnvio = calleEnvio;
	}

	public String getNumintEnvio() {
		return this.numintEnvio;
	}

	public void setNumintEnvio(String numintEnvio) {
		this.numintEnvio = numintEnvio;
	}

	public String getNumextEnvio() {
		return this.numextEnvio;
	}

	public void setNumextEnvio(String numextEnvio) {
		this.numextEnvio = numextEnvio;
	}

	public String getCruzamientosEnvio() {
		return this.cruzamientosEnvio;
	}

	public void setCruzamientosEnvio(String cruzamientosEnvio) {
		this.cruzamientosEnvio = cruzamientosEnvio;
	}

	public String getCruzamientosEnvio2() {
		return this.cruzamientosEnvio2;
	}

	public void setCruzamientosEnvio2(String cruzamientosEnvio2) {
		this.cruzamientosEnvio2 = cruzamientosEnvio2;
	}

	public String getColoniaEnvio() {
		return this.coloniaEnvio;
	}

	public void setColoniaEnvio(String coloniaEnvio) {
		this.coloniaEnvio = coloniaEnvio;
	}

	public String getLocalidadEnvio() {
		return this.localidadEnvio;
	}

	public void setLocalidadEnvio(String localidadEnvio) {
		this.localidadEnvio = localidadEnvio;
	}

	public String getMunicipioEnvio() {
		return this.municipioEnvio;
	}

	public void setMunicipioEnvio(String municipioEnvio) {
		this.municipioEnvio = municipioEnvio;
	}

	public String getEstadoEnvio() {
		return this.estadoEnvio;
	}

	public void setEstadoEnvio(String estadoEnvio) {
		this.estadoEnvio = estadoEnvio;
	}

	public String getPaisEnvio() {
		return this.paisEnvio;
	}

	public void setPaisEnvio(String paisEnvio) {
		this.paisEnvio = paisEnvio;
	}

	public String getCodigoEnvio() {
		return this.codigoEnvio;
	}

	public void setCodigoEnvio(String codigoEnvio) {
		this.codigoEnvio = codigoEnvio;
	}

	public String getCveZonaEnvio() {
		return this.cveZonaEnvio;
	}

	public void setCveZonaEnvio(String cveZonaEnvio) {
		this.cveZonaEnvio = cveZonaEnvio;
	}

	public String getReferenciaEnvio() {
		return this.referenciaEnvio;
	}

	public void setReferenciaEnvio(String referenciaEnvio) {
		this.referenciaEnvio = referenciaEnvio;
	}

	public String getCuentaContable() {
		return this.cuentaContable;
	}

	public void setCuentaContable(String cuentaContable) {
		this.cuentaContable = cuentaContable;
	}

	public String getAddendaf() {
		return this.addendaf;
	}

	public void setAddendaf(String addendaf) {
		this.addendaf = addendaf;
	}

	public String getAddendad() {
		return this.addendad;
	}

	public void setAddendad(String addendad) {
		this.addendad = addendad;
	}

	public String getNamespace() {
		return this.namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public String getMetododepago() {
		return this.metododepago;
	}

	public void setMetododepago(String metododepago) {
		this.metododepago = metododepago;
	}

	public String getNumctapago() {
		return this.numctapago;
	}

	public void setNumctapago(String numctapago) {
		this.numctapago = numctapago;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getDesImpu1() {
		return this.desImpu1;
	}

	public void setDesImpu1(String desImpu1) {
		this.desImpu1 = desImpu1;
	}

	public String getDesImpu2() {
		return this.desImpu2;
	}

	public void setDesImpu2(String desImpu2) {
		this.desImpu2 = desImpu2;
	}

	public String getDesImpu3() {
		return this.desImpu3;
	}

	public void setDesImpu3(String desImpu3) {
		this.desImpu3 = desImpu3;
	}

	public String getDesImpu4() {
		return this.desImpu4;
	}

	public void setDesImpu4(String desImpu4) {
		this.desImpu4 = desImpu4;
	}

	public String getDesPer() {
		return this.desPer;
	}

	public void setDesPer(String desPer) {
		this.desPer = desPer;
	}

	public Double getLatGeneral() {
		return this.latGeneral;
	}

	public void setLatGeneral(Double latGeneral) {
		this.latGeneral = latGeneral;
	}

	public Double getLonGeneral() {
		return this.lonGeneral;
	}

	public void setLonGeneral(Double lonGeneral) {
		this.lonGeneral = lonGeneral;
	}

	public Double getLatEnvio() {
		return this.latEnvio;
	}

	public void setLatEnvio(Double latEnvio) {
		this.latEnvio = latEnvio;
	}

	public Double getLonEnvio() {
		return this.lonEnvio;
	}

	public void setLonEnvio(Double lonEnvio) {
		this.lonEnvio = lonEnvio;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Date getVersionSinc() {
		return this.versionSinc;
	}

	public void setVersionSinc(Date versionSinc) {
		this.versionSinc = versionSinc;
	}

	public String getUsoCfdi() {
		return this.usoCfdi;
	}

	public void setUsoCfdi(String usoCfdi) {
		this.usoCfdi = usoCfdi;
	}

	public String getCvePaisSat() {
		return this.cvePaisSat;
	}

	public void setCvePaisSat(String cvePaisSat) {
		this.cvePaisSat = cvePaisSat;
	}

	public String getNumidregfiscal() {
		return this.numidregfiscal;
	}

	public void setNumidregfiscal(String numidregfiscal) {
		this.numidregfiscal = numidregfiscal;
	}

	public String getFormadepagosat() {
		return this.formadepagosat;
	}

	public void setFormadepagosat(String formadepagosat) {
		this.formadepagosat = formadepagosat;
	}

}
