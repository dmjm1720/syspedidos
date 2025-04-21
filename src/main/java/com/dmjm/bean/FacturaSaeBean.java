package com.dmjm.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.dmjm.dao.FacturaFactcDao;
import com.dmjm.dao.PartidaFactcDao;
import com.dmjm.impl.FacturaFactcDaoImpl;
import com.dmjm.impl.PartidaFactcDaoImpl;
import com.dmjm.model.Factc01;
import com.dmjm.model.ParFactc01;


@Named("factSaeBean")
@ViewScoped
public class FacturaSaeBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<Factc01> listarFacturasCotizaciones;
	private List<ParFactc01> listaPartidasCotizaciones;
	private Factc01 fc;
	private ParFactc01 pf;

	public FacturaSaeBean() {

	}

	@PostConstruct
	public void init() {
		listarFacturasCotizaciones = new ArrayList<>();
		listaPartidasCotizaciones = new ArrayList<>();
		fc = new Factc01();
		pf = new ParFactc01();
	}

	public List<Factc01> getListarFacturasCotizaciones() {
		FacturaFactcDao fDao = new FacturaFactcDaoImpl();
		listarFacturasCotizaciones = fDao.listaFacturas();
		return listarFacturasCotizaciones;
	}

	public Factc01 getFc() {
		return fc;
	}

	public void setFc(Factc01 fc) {
		this.fc = fc;
	}

	public ParFactc01 getPf() {
		return pf;
	}

	public void setPf(ParFactc01 pf) {
		this.pf = pf;
	}

	public List<ParFactc01> getListaPartidasCotizaciones() {
		PartidaFactcDao pDao = new  PartidaFactcDaoImpl();
		listaPartidasCotizaciones = pDao.listaPartidas(fc.getCveDoc());
		return listaPartidasCotizaciones;
	}



}
