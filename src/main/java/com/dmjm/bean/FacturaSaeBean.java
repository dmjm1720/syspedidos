package com.dmjm.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.dmjm.dao.FacturaFactcDao;
import com.dmjm.dao.PartidaFactcDao;
import com.dmjm.impl.FacturaFactcDaoImpl;
import com.dmjm.impl.PartidaFactcDaoImpl;
import com.dmjm.model.EncabezadoFact;
import com.dmjm.model.Factc01;
import com.dmjm.model.ParFactc01;
import com.dmjm.model.PartidaCotizacion;
import com.dmjm.util.Etiquetas;

@Named("factSaeBean")
@ViewScoped
public class FacturaSaeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Factc01> listarFacturasCotizaciones;
	private List<ParFactc01> listaPartidasCotizaciones;
	private Factc01 fc;
	private ParFactc01 pf;

	private List<Factc01> listarFacturasCotClientes;

	private List<PartidaCotizacion> listarPartidasCotizaciones;

	private List<EncabezadoFact> listaFacturasEncabezadosClientes;
	private List<EncabezadoFact> listaFacturasEncabezadosClientesVentas;
	private EncabezadoFact encabezadoFact;
	private EncabezadoFact etiquetasPedido;

	public FacturaSaeBean() {

	}

	@PostConstruct
	public void init() {
		listarFacturasCotizaciones = new ArrayList<>();
		listaPartidasCotizaciones = new ArrayList<>();
		fc = new Factc01();
		pf = new ParFactc01();
		listarFacturasCotClientes = new ArrayList<>();

		listaFacturasEncabezadosClientes = new ArrayList<>();
		encabezadoFact = new EncabezadoFact();
		etiquetasPedido = new EncabezadoFact();

		FacturaFactcDao fDao = new FacturaFactcDaoImpl();
		listaFacturasEncabezadosClientes = fDao.listaFXCli();

		listaFacturasEncabezadosClientesVentas = new ArrayList<>();

		FacturaFactcDao fClieDao = new FacturaFactcDaoImpl();
		listaFacturasEncabezadosClientesVentas = fClieDao.listaFCli();
		
		listarPartidasCotizaciones = new ArrayList<>();

	}

	public List<Factc01> getListarFacturasCotizaciones() {
		FacturaFactcDao fDao = new FacturaFactcDaoImpl();
		listarFacturasCotizaciones = fDao.listaFacturas();
		return listarFacturasCotizaciones;
	}

	public EncabezadoFact getEtiquetasPedido() {
		return etiquetasPedido;
	}

	public void setEtiquetasPedido(EncabezadoFact etiquetasPedido) {
		this.etiquetasPedido = etiquetasPedido;
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

	public EncabezadoFact getEncabezadoFact() {
		return encabezadoFact;
	}

	public void setEncabezadoFact(EncabezadoFact encabezadoFact) {
		this.encabezadoFact = encabezadoFact;
	}

	public List<EncabezadoFact> getListaFacturasEncabezadosClientes() {
		return listaFacturasEncabezadosClientes;
	}

	public List<EncabezadoFact> getListaFacturasEncabezadosClientesVentas() {
		return listaFacturasEncabezadosClientesVentas;
	}

	public List<ParFactc01> getListaPartidasCotizaciones() {
		PartidaFactcDao pDao = new PartidaFactcDaoImpl();
		listaPartidasCotizaciones = pDao.listaPartidas(fc.getCveDoc());
		return listaPartidasCotizaciones;
	}

	public List<Factc01> getListarFacturasCotClientes() {
		FacturaFactcDao fDao = new FacturaFactcDaoImpl();
		listarFacturasCotClientes = fDao.listaFacturasClientes();
		return listarFacturasCotClientes;
	}

	public List<PartidaCotizacion> getListarPartidasCotizaciones() {
		return listarPartidasCotizaciones;
	}
	
	public void listarPartidasPedidos(String pedido) {
		listarPartidasCotizaciones = new ArrayList<>();
		PartidaFactcDao fDao = new PartidaFactcDaoImpl();
		listarPartidasCotizaciones = fDao.listarPartidasCotizacion(pedido);
	}
	
	public void listarEtiquetas(String pedido) {
		listarPartidasCotizaciones = new ArrayList<>();
		PartidaFactcDao fDao = new PartidaFactcDaoImpl();
		listarPartidasCotizaciones = fDao.listarPartidasCotizacion(pedido);
		Etiquetas e = new Etiquetas();

		Map<String, Integer> etiquetas = new LinkedHashMap<>();
		for (PartidaCotizacion etiFact : listarPartidasCotizaciones) {
			etiquetas.put(etiFact.getDescr(), etiFact.getCant());
		}

		e.impresion(etiquetas);
	}

}
