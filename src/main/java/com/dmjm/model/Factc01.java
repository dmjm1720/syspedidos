package com.dmjm.model;


import java.util.Date;


public class Factc01  implements java.io.Serializable {


     private static final long serialVersionUID = 1L;
	private String cveDoc;
     private String tipDoc;
     private String cveClpv;
     private String status;
     private String cvePedi;
     private Date fechaDoc;
     private Date fechaEnt;
     private Date fechaVen;
     private Double impTot1;
     private Double impTot2;
     private Double impTot3;
     private Double impTot4;
     private Double desFin;
     private Double comTot;
     private Integer numMoned;
     private Double tipcamb;
     private Double primerpago;
     private String rfc;
     private Integer autoriza;
     private Integer folio;
     private String serie;
     private String autoanio;
     private String escfd;
     private Integer numAlma;
     private String actCxc;
     private String actCoi;
     private Double canTot;
     private String cveVend;
     private Date fechaCancela;
     private Double desTot;
     private String condicion;
     private Integer numPagos;
     private Integer datEnvio;
     private String contado;
     private Integer datMostr;
     private Integer cveBita;
     private String bloq;
     private Date fechaelab;
     private Integer ctlpol;
     private Integer cveObs;
     private String enlazado;
     private String tipDocE;
     private String formaenvio;
     private Double desFinPorc;
     private Double desTotPorc;
     private Double importe;
     private Double comTotPorc;
     private String metododepago;
     private String numctapago;
     private String tipDocAnt;
     private String docAnt;
     private String tipDocSig;
     private String docSig;
     private String uuid;
     private Date versionSinc;
     private String formadepagosat;
     private String usoCfdi;
     private String tipTraslado;
     private Integer numAlmDes;
     private Double impTot5;
     private Double impTot6;
     private Double impTot7;
     private String regFisc;
     private String tipFac;
     private Double impTot8;

    public Factc01() {
    }


    public Factc01(String cveDoc, String cveClpv, String status, Date fechaDoc) {
        this.cveDoc = cveDoc;
        this.cveClpv = cveClpv;
        this.status = status;
        this.fechaDoc = fechaDoc;
    }
    public Factc01(String cveDoc, String tipDoc, String cveClpv, String status, String cvePedi, Date fechaDoc, Date fechaEnt, Date fechaVen, Double impTot1, Double impTot2, Double impTot3, Double impTot4, Double desFin, Double comTot, Integer numMoned, Double tipcamb, Double primerpago, String rfc, Integer autoriza, Integer folio, String serie, String autoanio, String escfd, Integer numAlma, String actCxc, String actCoi, Double canTot, String cveVend, Date fechaCancela, Double desTot, String condicion, Integer numPagos, Integer datEnvio, String contado, Integer datMostr, Integer cveBita, String bloq, Date fechaelab, Integer ctlpol, Integer cveObs, String enlazado, String tipDocE, String formaenvio, Double desFinPorc, Double desTotPorc, Double importe, Double comTotPorc, String metododepago, String numctapago, String tipDocAnt, String docAnt, String tipDocSig, String docSig, String uuid, Date versionSinc, String formadepagosat, String usoCfdi, String tipTraslado, Integer numAlmDes, Double impTot5, Double impTot6, Double impTot7, String regFisc, String tipFac, Double impTot8) {
       this.cveDoc = cveDoc;
       this.tipDoc = tipDoc;
       this.cveClpv = cveClpv;
       this.status = status;
       this.cvePedi = cvePedi;
       this.fechaDoc = fechaDoc;
       this.fechaEnt = fechaEnt;
       this.fechaVen = fechaVen;
       this.impTot1 = impTot1;
       this.impTot2 = impTot2;
       this.impTot3 = impTot3;
       this.impTot4 = impTot4;
       this.desFin = desFin;
       this.comTot = comTot;
       this.numMoned = numMoned;
       this.tipcamb = tipcamb;
       this.primerpago = primerpago;
       this.rfc = rfc;
       this.autoriza = autoriza;
       this.folio = folio;
       this.serie = serie;
       this.autoanio = autoanio;
       this.escfd = escfd;
       this.numAlma = numAlma;
       this.actCxc = actCxc;
       this.actCoi = actCoi;
       this.canTot = canTot;
       this.cveVend = cveVend;
       this.fechaCancela = fechaCancela;
       this.desTot = desTot;
       this.condicion = condicion;
       this.numPagos = numPagos;
       this.datEnvio = datEnvio;
       this.contado = contado;
       this.datMostr = datMostr;
       this.cveBita = cveBita;
       this.bloq = bloq;
       this.fechaelab = fechaelab;
       this.ctlpol = ctlpol;
       this.cveObs = cveObs;
       this.enlazado = enlazado;
       this.tipDocE = tipDocE;
       this.formaenvio = formaenvio;
       this.desFinPorc = desFinPorc;
       this.desTotPorc = desTotPorc;
       this.importe = importe;
       this.comTotPorc = comTotPorc;
       this.metododepago = metododepago;
       this.numctapago = numctapago;
       this.tipDocAnt = tipDocAnt;
       this.docAnt = docAnt;
       this.tipDocSig = tipDocSig;
       this.docSig = docSig;
       this.uuid = uuid;
       this.versionSinc = versionSinc;
       this.formadepagosat = formadepagosat;
       this.usoCfdi = usoCfdi;
       this.tipTraslado = tipTraslado;
       this.numAlmDes = numAlmDes;
       this.impTot5 = impTot5;
       this.impTot6 = impTot6;
       this.impTot7 = impTot7;
       this.regFisc = regFisc;
       this.tipFac = tipFac;
       this.impTot8 = impTot8;
    }

    public String getCveDoc() {
        return this.cveDoc;
    }

    public void setCveDoc(String cveDoc) {
        this.cveDoc = cveDoc;
    }
    public String getTipDoc() {
        return this.tipDoc;
    }

    public void setTipDoc(String tipDoc) {
        this.tipDoc = tipDoc;
    }
    public String getCveClpv() {
        return this.cveClpv;
    }

    public void setCveClpv(String cveClpv) {
        this.cveClpv = cveClpv;
    }
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getCvePedi() {
        return this.cvePedi;
    }

    public void setCvePedi(String cvePedi) {
        this.cvePedi = cvePedi;
    }
    public Date getFechaDoc() {
        return this.fechaDoc;
    }

    public void setFechaDoc(Date fechaDoc) {
        this.fechaDoc = fechaDoc;
    }
    public Date getFechaEnt() {
        return this.fechaEnt;
    }

    public void setFechaEnt(Date fechaEnt) {
        this.fechaEnt = fechaEnt;
    }
    public Date getFechaVen() {
        return this.fechaVen;
    }

    public void setFechaVen(Date fechaVen) {
        this.fechaVen = fechaVen;
    }
    public Double getImpTot1() {
        return this.impTot1;
    }

    public void setImpTot1(Double impTot1) {
        this.impTot1 = impTot1;
    }
    public Double getImpTot2() {
        return this.impTot2;
    }

    public void setImpTot2(Double impTot2) {
        this.impTot2 = impTot2;
    }
    public Double getImpTot3() {
        return this.impTot3;
    }

    public void setImpTot3(Double impTot3) {
        this.impTot3 = impTot3;
    }
    public Double getImpTot4() {
        return this.impTot4;
    }

    public void setImpTot4(Double impTot4) {
        this.impTot4 = impTot4;
    }
    public Double getDesFin() {
        return this.desFin;
    }

    public void setDesFin(Double desFin) {
        this.desFin = desFin;
    }
    public Double getComTot() {
        return this.comTot;
    }

    public void setComTot(Double comTot) {
        this.comTot = comTot;
    }
    public Integer getNumMoned() {
        return this.numMoned;
    }

    public void setNumMoned(Integer numMoned) {
        this.numMoned = numMoned;
    }
    public Double getTipcamb() {
        return this.tipcamb;
    }

    public void setTipcamb(Double tipcamb) {
        this.tipcamb = tipcamb;
    }
    public Double getPrimerpago() {
        return this.primerpago;
    }

    public void setPrimerpago(Double primerpago) {
        this.primerpago = primerpago;
    }
    public String getRfc() {
        return this.rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
    public Integer getAutoriza() {
        return this.autoriza;
    }

    public void setAutoriza(Integer autoriza) {
        this.autoriza = autoriza;
    }
    public Integer getFolio() {
        return this.folio;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }
    public String getSerie() {
        return this.serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }
    public String getAutoanio() {
        return this.autoanio;
    }

    public void setAutoanio(String autoanio) {
        this.autoanio = autoanio;
    }
    public String getEscfd() {
        return this.escfd;
    }

    public void setEscfd(String escfd) {
        this.escfd = escfd;
    }
    public Integer getNumAlma() {
        return this.numAlma;
    }

    public void setNumAlma(Integer numAlma) {
        this.numAlma = numAlma;
    }
    public String getActCxc() {
        return this.actCxc;
    }

    public void setActCxc(String actCxc) {
        this.actCxc = actCxc;
    }
    public String getActCoi() {
        return this.actCoi;
    }

    public void setActCoi(String actCoi) {
        this.actCoi = actCoi;
    }
    public Double getCanTot() {
        return this.canTot;
    }

    public void setCanTot(Double canTot) {
        this.canTot = canTot;
    }
    public String getCveVend() {
        return this.cveVend;
    }

    public void setCveVend(String cveVend) {
        this.cveVend = cveVend;
    }
    public Date getFechaCancela() {
        return this.fechaCancela;
    }

    public void setFechaCancela(Date fechaCancela) {
        this.fechaCancela = fechaCancela;
    }
    public Double getDesTot() {
        return this.desTot;
    }

    public void setDesTot(Double desTot) {
        this.desTot = desTot;
    }
    public String getCondicion() {
        return this.condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }
    public Integer getNumPagos() {
        return this.numPagos;
    }

    public void setNumPagos(Integer numPagos) {
        this.numPagos = numPagos;
    }
    public Integer getDatEnvio() {
        return this.datEnvio;
    }

    public void setDatEnvio(Integer datEnvio) {
        this.datEnvio = datEnvio;
    }
    public String getContado() {
        return this.contado;
    }

    public void setContado(String contado) {
        this.contado = contado;
    }
    public Integer getDatMostr() {
        return this.datMostr;
    }

    public void setDatMostr(Integer datMostr) {
        this.datMostr = datMostr;
    }
    public Integer getCveBita() {
        return this.cveBita;
    }

    public void setCveBita(Integer cveBita) {
        this.cveBita = cveBita;
    }
    public String getBloq() {
        return this.bloq;
    }

    public void setBloq(String bloq) {
        this.bloq = bloq;
    }
    public Date getFechaelab() {
        return this.fechaelab;
    }

    public void setFechaelab(Date fechaelab) {
        this.fechaelab = fechaelab;
    }
    public Integer getCtlpol() {
        return this.ctlpol;
    }

    public void setCtlpol(Integer ctlpol) {
        this.ctlpol = ctlpol;
    }
    public Integer getCveObs() {
        return this.cveObs;
    }

    public void setCveObs(Integer cveObs) {
        this.cveObs = cveObs;
    }
    public String getEnlazado() {
        return this.enlazado;
    }

    public void setEnlazado(String enlazado) {
        this.enlazado = enlazado;
    }
    public String getTipDocE() {
        return this.tipDocE;
    }

    public void setTipDocE(String tipDocE) {
        this.tipDocE = tipDocE;
    }
    public String getFormaenvio() {
        return this.formaenvio;
    }

    public void setFormaenvio(String formaenvio) {
        this.formaenvio = formaenvio;
    }
    public Double getDesFinPorc() {
        return this.desFinPorc;
    }

    public void setDesFinPorc(Double desFinPorc) {
        this.desFinPorc = desFinPorc;
    }
    public Double getDesTotPorc() {
        return this.desTotPorc;
    }

    public void setDesTotPorc(Double desTotPorc) {
        this.desTotPorc = desTotPorc;
    }
    public Double getImporte() {
        return this.importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }
    public Double getComTotPorc() {
        return this.comTotPorc;
    }

    public void setComTotPorc(Double comTotPorc) {
        this.comTotPorc = comTotPorc;
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
    public String getTipDocAnt() {
        return this.tipDocAnt;
    }

    public void setTipDocAnt(String tipDocAnt) {
        this.tipDocAnt = tipDocAnt;
    }
    public String getDocAnt() {
        return this.docAnt;
    }

    public void setDocAnt(String docAnt) {
        this.docAnt = docAnt;
    }
    public String getTipDocSig() {
        return this.tipDocSig;
    }

    public void setTipDocSig(String tipDocSig) {
        this.tipDocSig = tipDocSig;
    }
    public String getDocSig() {
        return this.docSig;
    }

    public void setDocSig(String docSig) {
        this.docSig = docSig;
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
    public String getFormadepagosat() {
        return this.formadepagosat;
    }

    public void setFormadepagosat(String formadepagosat) {
        this.formadepagosat = formadepagosat;
    }
    public String getUsoCfdi() {
        return this.usoCfdi;
    }

    public void setUsoCfdi(String usoCfdi) {
        this.usoCfdi = usoCfdi;
    }
    public String getTipTraslado() {
        return this.tipTraslado;
    }

    public void setTipTraslado(String tipTraslado) {
        this.tipTraslado = tipTraslado;
    }
    public Integer getNumAlmDes() {
        return this.numAlmDes;
    }

    public void setNumAlmDes(Integer numAlmDes) {
        this.numAlmDes = numAlmDes;
    }
    public Double getImpTot5() {
        return this.impTot5;
    }

    public void setImpTot5(Double impTot5) {
        this.impTot5 = impTot5;
    }
    public Double getImpTot6() {
        return this.impTot6;
    }

    public void setImpTot6(Double impTot6) {
        this.impTot6 = impTot6;
    }
    public Double getImpTot7() {
        return this.impTot7;
    }

    public void setImpTot7(Double impTot7) {
        this.impTot7 = impTot7;
    }
    public String getRegFisc() {
        return this.regFisc;
    }

    public void setRegFisc(String regFisc) {
        this.regFisc = regFisc;
    }
    public String getTipFac() {
        return this.tipFac;
    }

    public void setTipFac(String tipFac) {
        this.tipFac = tipFac;
    }
    public Double getImpTot8() {
        return this.impTot8;
    }

    public void setImpTot8(Double impTot8) {
        this.impTot8 = impTot8;
    }




}


