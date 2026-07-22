package com.dmjm.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dmjm.dao.ClienteDao;
import com.dmjm.dao.EtiquetasDao;
import com.dmjm.dao.FacturaFactcDao;
import com.dmjm.dao.LoginDao;
import com.dmjm.dao.PartidaFactcDao;
import com.dmjm.impl.ClienteDaoImpl;
import com.dmjm.impl.EtiquetasDaoImpl;
import com.dmjm.impl.FacturaFactcDaoImpl;
import com.dmjm.impl.LoginUsuarioImpl;
import com.dmjm.impl.PartidaFactcDaoImpl;
import com.dmjm.model.Clie01;
import com.dmjm.model.EncabezadoFact;
import com.dmjm.model.Factc01;
import com.dmjm.model.ParFactc01;
import com.dmjm.model.PartidaCotizacion;
import com.dmjm.model.Perfiles;
import com.dmjm.model.Usuarios;
import com.dmjm.util.EtiquetasPre;
import com.dmjm.util.PreviewEtiquetas;

@Named("factSaeBean")
@ViewScoped
public class FacturaSaeBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LogManager.getLogger(FacturaSaeBean.class.getName());
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

	public void listarEtiquetas(String pedido, String docSig, String cveProv, String rfc) {
		listarPartidasCotizaciones = new ArrayList<>();
		PartidaFactcDao fDao = new PartidaFactcDaoImpl();
		listarPartidasCotizaciones = fDao.listarPartidasCotizacion(pedido);
		PreviewEtiquetas e = new PreviewEtiquetas();

		EtiquetasDao eDao = new EtiquetasDaoImpl();
		String validaFolio = eDao.folio(pedido.toString().trim());
		if (validaFolio.equals("0")) {
			Map<String, Integer> etiquetas = new LinkedHashMap<>();
			for (PartidaCotizacion etiFact : listarPartidasCotizaciones) {
				if (!etiFact.getDescr().contains("GRENETINA COMESTIBLE SACO")) {
					etiquetas.put(etiFact.getDescr(), etiFact.getCant());
				}
			}
			e.impresion(etiquetas, pedido, docSig, cveProv);
			
			System.out.println("VALIDAR RFC:" + rfc);
			revisarClienteExiste(rfc);

			try {
				visualizarReporte(Integer.parseInt(pedido.trim()));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else {
			try {
				visualizarReporte(Integer.parseInt(pedido.trim()));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	public void visualizarReporte(Integer pedido) throws SQLException {
		@SuppressWarnings("unused")

		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();

		EtiquetasPre reporte = new EtiquetasPre();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
		String ruta = servletContext.getRealPath("/REP/etiquetas_syspedidos.jasper");

		reporte.getReporte(ruta, pedido);

		FacesContext.getCurrentInstance().responseComplete();

	}

	public void revisarClienteExiste(String rfcCliente) {
		ClienteDao cDao = new ClienteDaoImpl();
		Clie01 c = new Clie01();
		c = cDao.cliente(rfcCliente);

		LoginDao lDao = new LoginUsuarioImpl();
		String usu = "";
		usu = lDao.validarUsuarioExiste(rfcCliente);
		LOGGER.info("VALIDACIÓN DE RFC:" + usu);
		System.out.println("VALIDACIÓN DE RFC:" + usu);
		if (usu.equals("0")) {
			Perfiles p = new Perfiles();
			p.setIdPerfil(2);
			LoginDao uDao = new LoginUsuarioImpl();
			uDao.guardarUsuario(new Usuarios(p, c.getClave(), c.getNombre(), c.getRfc(), "", "", new Date(), true));
		}

	}

}
