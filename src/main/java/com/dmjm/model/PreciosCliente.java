package com.dmjm.model;

public class PreciosCliente {

    private String cveArt;
    private String descr;
    private String uniMed;
    private Integer numMon;
    private Double precio;

    public PreciosCliente() {
    }

    public PreciosCliente(String cveArt, String descr, String uniMed, Integer numMon, Double precio) {
        this.cveArt = cveArt;
        this.descr = descr;
        this.uniMed = uniMed;
        this.numMon = numMon;
        this.precio = precio;
    }

    public String getCveArt() {
        return cveArt;
    }

    public void setCveArt(String cveArt) {
        this.cveArt = cveArt;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getUniMed() {
        return uniMed;
    }

    public void setUniMed(String uniMed) {
        this.uniMed = uniMed;
    }

    public Integer getNumMon() {
        return numMon;
    }

    public void setNumMon(Integer numMon) {
        this.numMon = numMon;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
