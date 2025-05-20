package com.dmjm.bean;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.event.RowEditEvent;

import com.dmjm.dao.ClienteDao;
import com.dmjm.dao.Impu01Dao;
import com.dmjm.dao.Inve01Dao;
import com.dmjm.dao.PartidaDao;
import com.dmjm.dao.PrecioDao;
import com.dmjm.dao.PreciosClienteDao;
import com.dmjm.impl.ClienteDaoImpl;
import com.dmjm.impl.Impu01DaoImpl;
import com.dmjm.impl.Inve01DaoImpl;
import com.dmjm.impl.PartidaDaoImpl;
import com.dmjm.impl.PrecioDaoImpl;
import com.dmjm.impl.PreciosClienteDaoImpl;
import com.dmjm.model.Clie01;
import com.dmjm.model.Impu01;
import com.dmjm.model.Inve01;
import com.dmjm.model.Partida;
import com.dmjm.model.PreciosCliente;
import com.dmjm.model.Usuarios;
import com.dmjm.util.Conexion;
import com.dmjm.util.HibernateUtilSae;

@Named(value = "partidaBean")
@ViewScoped
public class PartidaBean extends Conexion implements Serializable {
	private static final Logger LOGGER = LogManager.getLogger(PartidaBean.class.getName());
	private static final long serialVersionUID = 1L;
	private List<Partida> listaPartidas;
	private Partida partida;
	private String clave;
	private Inve01 precio;
	private List<Partida> partidaCot;
	private String claveSeleccionado;
	private String descrSeleccionada;
	private Double cantidad;
	private Double descuento;
	private Double mxn = 0.0;
	private Double usd = 0.0;
	private String filterRFC;
	List<String> listarTodo = new ArrayList<>();
	private List<Clie01> listaClieRfc;
	private Clie01 clie01;

	private String TIP_DOC;
	private int ULT_DOC;
	private String SERIE;
	private String CLAVE_PROV;
	private String RFC_PROV;
	private EnviarCorreo enviarCorreo;
	Session session = null;
	Transaction transaction = null;
	private PreciosCliente preCliente;

	private String CVE_ESQIMPU;

	private Inve01 inve;
	private Impu01 impu;
	private String clasificacion;
	
	private double tot_imp4;
	Usuarios us = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");




	public PartidaBean() {
//		this.partidaCot = new ArrayList<>();
//		partida = new Partida();
//		listaClieRfc = new ArrayList<>();
//		clie01 = new Clie01();
//		this.enviarCorreo = new EnviarCorreo();
//		preCliente = new PreciosCliente();
//		buscarFolio();
	}

	@PostConstruct
	public void init() {
		this.partidaCot = new ArrayList<>();
		partida = new Partida();
		listaClieRfc = new ArrayList<>();
		clie01 = new Clie01();
		this.enviarCorreo = new EnviarCorreo();
		preCliente = new PreciosCliente();
		inve = new Inve01();
		impu = new Impu01();
		buscarFolio();
		listar();
	}

	public List<Partida> getListaPartidas() {
		PartidaDao pDao = new PartidaDaoImpl();
		listaPartidas = pDao.listaPartida();
		return listaPartidas;
	}

	public void setListaPartidas(List<Partida> listaPartidas) {
		this.listaPartidas = listaPartidas;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public void prepapararNuevaPartida() {
		partida = new Partida();
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Inve01 getPrecio() {
		return precio;
	}

	public void setPrecio(Inve01 precio) {
		this.precio = precio;
	}

	public List<Partida> getPartidaCot() {
		return partidaCot;
	}

	public void setPartidaCot(List<Partida> partidaCot) {
		this.partidaCot = partidaCot;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	public String getClaveSeleccionado() {
		return claveSeleccionado;
	}

	public void setClaveSeleccionado(String claveSeleccionado) {
		this.claveSeleccionado = claveSeleccionado;
	}

	public String getDescrSeleccionada() {
		return descrSeleccionada;
	}

	public void setDescrSeleccionada(String descrSeleccionada) {
		this.descrSeleccionada = descrSeleccionada;
	}

	public Double getMxn() {
		return mxn;
	}

	public void setMxn(Double mxn) {
		this.mxn = mxn;
	}

	public Double getUsd() {
		return usd;
	}

	public void setUsd(Double usd) {
		this.usd = usd;
	}

	public EnviarCorreo getEnviarCorreo() {
		return enviarCorreo;
	}

	public void setEnviarCorreo(EnviarCorreo enviarCorreo) {
		this.enviarCorreo = enviarCorreo;
	}

	public PreciosCliente getPreCliente() {
		return preCliente;
	}

	public void setPreCliente(PreciosCliente preCliente) {
		this.preCliente = preCliente;
	}

	public String getCVE_ESQIMPU() {
		return CVE_ESQIMPU;
	}

	public void setCVE_ESQIMPU(String cVE_ESQIMPU) {
		CVE_ESQIMPU = cVE_ESQIMPU;
	}

	public void nuevaPartida() {
		PartidaDao pDao = new PartidaDaoImpl();
		pDao.newPartida(partida);
	}

	public void modificarPartida() {
		PartidaDao pDao = new PartidaDaoImpl();
		pDao.updatePartida(partida);
		partida = new Partida();
	}

	public void deletePartida() {
		PartidaDao pDao = new PartidaDaoImpl();
		pDao.deletePartida(partida);
		partida = new Partida();
	}

	public void solicitarCantDesc(String clave, String descr) {
		this.claveSeleccionado = clave;
		this.descrSeleccionada = descr;
	}

	public String getFilterRFC() {
		return filterRFC;
	}

	public void setFilterRFC(String filterRFC) {
		this.filterRFC = filterRFC;
	}

	public Clie01 getClie01() {
		return clie01;
	}

	public void setClie01(Clie01 clie01) {
		this.clie01 = clie01;
	}

	public String getTIP_DOC() {
		return TIP_DOC;
	}

	public void setTIP_DOC(String TIP_DOC) {
		this.TIP_DOC = TIP_DOC;
	}

	public int getULT_DOC() {
		return ULT_DOC;
	}

	public void setULT_DOC(int ULT_DOC) {
		this.ULT_DOC = ULT_DOC;
	}

	public String getSERIE() {
		return SERIE;
	}

	public void setSERIE(String SERIE) {
		this.SERIE = SERIE;
	}

	public String getCLAVE_PROV() {
		return CLAVE_PROV;
	}

	public void setCLAVE_PROV(String CLAVE_PROV) {
		this.CLAVE_PROV = CLAVE_PROV;
	}

	public String getRFC_PROV() {
		return RFC_PROV;
	}

	public void setRFC_PROV(String RFC_PROV) {
		this.RFC_PROV = RFC_PROV;
	}

	public Inve01 getInve() {
		return inve;
	}

	public void setInve(Inve01 inve) {
		this.inve = inve;
	}

	public Impu01 getImpu() {
		return impu;
	}

	public void setImpu(Impu01 impu) {
		this.impu = impu;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	// **//
	public void agregarPartida() {
		this.session = null;
		this.transaction = null;
		this.mxn = 0.0;
		this.usd = 0.0;
		try {
			if (this.descuento == null) {
				this.descuento = 0.0;
			}
			this.session = HibernateUtilSae.getSessionFactory().openSession();
			PrecioDao pDao = new PrecioDaoImpl();
			this.transaction = this.session.beginTransaction();
			this.precio = pDao.obtenerClave(session, this.claveSeleccionado);
			double precioListaCliente = 0.0;
			PreciosClienteDao preciosDao = new PreciosClienteDaoImpl();
			precioListaCliente = preciosDao.precio(this.precio.getCveArt());

			this.partidaCot.add(new Partida(null, null, this.precio.getCveArt(), this.cantidad, precioListaCliente,
					null, null, this.descuento, this.descuento, null, null,
					((precioListaCliente * this.cantidad)
							- ((precioListaCliente * this.cantidad) * this.descuento / 100)),
					this.precio.getNumMon(), null, null, this.precio.getDescr()));

			this.transaction.commit();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE PEDIDOS", "Artículo agregado al pedido"));
			this.descuento = null;
			this.cantidad = null;
		} catch (Exception e) {
			if (this.transaction != null) {
				System.out.println(e.getMessage());
				transaction.rollback();
			}
		} finally {
			if (this.session != null) {
				this.session.close();
			}
		}
		sumar();
	}

	public void sumar() {

		this.mxn = 0.0;
		for (Partida element : partidaCot) {
			element.setTotPart(element.getCant() * element.getPrecio());
			if (element.getTipMon().equals(1)) {
				this.mxn += (element.getPrecio() * element.getCant())
						- (element.getPrecio() * element.getCant() * element.getDesc1()
								/ 100);
			}

		}
		getPartidaCot();

	}

	public void quitar(String cve, Integer filaSeleccionada) {
		this.mxn = 0.0;
		this.usd = 0.0;
		try {
			int i = 0;
			for (Partida item : partidaCot) {
				if (item.getCveArt().equals(cve) && filaSeleccionada.equals(i)) {
					this.partidaCot.remove(i);
					break;
				}
				i++;
			}
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "SISTEMA DE PEDIDOS", "Artículo retirado del pedido"));
			sumar();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public List<String> completeRFC(String rfc) {
		List<String> resultRFC = new ArrayList<>();
		ClienteDao cDao = new ClienteDaoImpl();
		resultRFC = cDao.listarRfc(rfc.toUpperCase());
		for (int i = 0; i < listarTodo.size(); i++) {
			resultRFC.add(listarTodo.get(i));
		}
		if (resultRFC.isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Sistema de pedidos", "No hay resultados para tu búsqueda"));
		}
		return resultRFC;
	}

	public List<Clie01> getListaClieRfc() {
		return listaClieRfc;
	}

	public void listar() {
		try {
//            String rfc = filterRFC;
//            String array[] = rfc.split("___", 2);
//            String newRfc = array[0];
			ClienteDao cDao = new ClienteDaoImpl();
			listaClieRfc = cDao.listaClieRfc(us.getRfc());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public void guardarTodo() throws SQLException {
		buscarFolio();
		guardarPartidas();
		guardarEncabezado();
		actualizarFolio();
		// this.enviarCorreo.enviarCorreo(SERIE, TIP_DOC, clave);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE PEDIDOS", "Pedido agregado correctamente..."));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"SISTEMA DE PEDIDOS", "Se ha enviado correo de levantamiento de pedido..."));
		listaClieRfc.clear();
		partidaCot.clear();
		this.mxn = 0.0;
		this.usd = 0.0;
		buscarFolio();
	}

	public void guardarEncabezado() throws SQLException {
		this.ConectarSae();
		Statement st = this.getCnSae().createStatement();
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String fecha = dateFormat.format(cal.getTime());
		for (Clie01 element : listaClieRfc) {
			this.CLAVE_PROV = element.getClave();
			this.RFC_PROV = element.getRfc();
			clasificacion = element.getClasific();
			LOGGER.info("********************************************************************************");
			LOGGER.info("CLIENTE: " + element.getNombre()+ " CLASIFICACIÓN: " + clasificacion);
		}

		st.executeUpdate("INSERT INTO FACTC01"
				+ "(TIP_DOC, CVE_DOC, CVE_CLPV, STATUS, DAT_MOSTR, CVE_VEND, CVE_PEDI, FECHA_DOC, FECHA_ENT, FECHA_VEN, "
				+ "FECHA_CANCELA, CAN_TOT, IMP_TOT1, IMP_TOT2, IMP_TOT3, IMP_TOT4, DES_TOT, DES_FIN, COM_TOT, CONDICION, "
				+ "CVE_OBS, NUM_ALMA, ACT_CXC, ACT_COI, ENLAZADO, TIP_DOC_E, NUM_MONED, TIPCAMB, NUM_PAGOS, FECHAELAB, "
				+ "PRIMERPAGO, RFC, CTLPOL, ESCFD, AUTORIZA, SERIE, FOLIO, AUTOANIO, DAT_ENVIO, CONTADO, "
				+ "CVE_BITA, BLOQ, FORMAENVIO, DES_FIN_PORC, DES_TOT_PORC, IMPORTE, COM_TOT_PORC, METODODEPAGO, NUMCTAPAGO, TIP_DOC_ANT, "
				+ "DOC_ANT, TIP_DOC_SIG, DOC_SIG, UUID, VERSION_SINC, FORMADEPAGOSAT, USO_CFDI)"
				+ "VALUES('C', '                " + ULT_DOC + "', '" + CLAVE_PROV + "', 'E', 0, '', '', '" + fecha
				+ "', '" + fecha + "', '" + fecha + "'," + " NULL, '" + this.mxn + "', 0, 0, 0, '" + this.mxn * .16
				+ "', 0, 0, 0, 'CONDICION'," + " 0, 1, 'S', 'N', 'O', 'O', 1, 1, 1, '" + fecha + "', " + "0, '"
				+ this.RFC_PROV + "', 0, 'N', 0, '" + this.SERIE + "', '" + this.ULT_DOC + "', '', 528, 'N', "
				+ "2537, 'N', 'I', 0, 0, '" + this.mxn + "', 0, NULL, NULL, NULL, " + "NULL, NULL, NULL, 'UUID', '"
				+ fecha + "', NULL, NULL);");
		this.CerrarSae();
	}

	public void guardarPartidas() throws SQLException {
		this.ConectarSae();
		Statement st = this.getCnSae().createStatement();
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String fecha = dateFormat.format(cal.getTime());
		int part = 1;
		for (Partida p : this.partidaCot) {
			// SELECT * FROM INVE01 WHERE CVE_ART = ?
			Inve01 inve01 = new Inve01();
			inve01 = buscarCveEsquimpuInve(p.getCveArt());
			Impu01 impu01 = new Impu01();
			impu01 = buscarImpuArticulo(inve01.getCveEsqimpu().toString());

			LOGGER.info("DESCRICIÓN: " + p.getDescr() + " U/M:" + inve01.getUniMed());
			LOGGER.info("CLAVE ESQ IMPU: " + inve01.getCveEsqimpu());

			LOGGER.info(impu01.getImpuesto1() + " " + impu01.getImpuesto2() + " " + impu01.getImpuesto3() + " "
					+ impu01.getImpuesto4() + " " + impu01.getImpuesto5() + " " + impu01.getImpuesto6() + " "
					+ impu01.getImpuesto7() + " " + impu01.getImpuesto8());
			LOGGER.info(impu01.getImp1aplica() + " " + impu01.getImp2aplica() + " " + impu01.getImp3aplica()
					+ " " + impu01.getImp4aplica() + " " + impu01.getImp5aplica() + " " + impu01.getImp6aplica() + " "
					+ impu01.getImp7aplica() + " " + impu01.getImp8aplica());
			String descr [] =p.getDescr().split(" ");
			LOGGER.info("BUSCAR DESCUENTO PARA: " + descr[0]);
			double calcularDescuento = 0.0;
			double descuentoArticulo=0.0;
			descuentoArticulo = politicasDescuentoValor(descr[0], clasificacion);
			calcularDescuento = (impu01.getImpuesto4()/100) * (p.getCant()* p.getPrecio()) -((impu01.getImpuesto4()/100) * (p.getCant()* p.getPrecio())*descuentoArticulo);
			LOGGER.info("CANTIDAD: "+p.getCant());
			LOGGER.info("PRECIO: "+p.getPrecio());
			LOGGER.info("TOTAL PARTIDA: "+p.getPrecio()*p.getCant());
			LOGGER.info("DESCUENTO: "+ politicasDescuentoValor(descr[0], clasificacion));
			LOGGER.info("PARTE 1: "+(impu01.getImpuesto4()/100) * (p.getCant()* p.getPrecio()));
			LOGGER.info("PARTE 2: "+((impu01.getImpuesto4()/100) * (p.getCant()* p.getPrecio()) * descuentoArticulo));
			LOGGER.info("CALCULO DEL DESCUENTO: "+ calcularDescuento);
			LOGGER.info("********************************************************************************");

			st.executeUpdate("INSERT INTO PAR_FACTC01\n"
					+ "(CVE_DOC, NUM_PAR, CVE_ART, CANT, PXS, PREC, COST, "
					+ "IMPU1, IMPU2, IMPU3, IMPU4, IMP1APLA, IMP2APLA, IMP3APLA, IMP4APLA, "
					+ "TOTIMP1, TOTIMP2, TOTIMP3, TOTIMP4, DESC1, DESC2, DESC3, "
					+ "COMI, APAR, ACT_INV, NUM_ALM, POLIT_APLI, TIP_CAM, UNI_VENTA, TIPO_PROD, CVE_OBS, REG_SERIE, E_LTPD, TIPO_ELEM, NUM_MOV, "
					+ "TOT_PARTIDA, IMPRIMIR, MAN_IEPS, APL_MAN_IMP, CUOTA_IEPS, APL_MAN_IEPS, MTO_PORC, MTO_CUOTA, CVE_ESQ, DESCR_ART, UUID, VERSION_SINC, TOTIMP8, TOTIMP7, TOTIMP6, TOTIMP5, IMP8APLA, IMP7APLA, IMP6APLA, IMP5APLA, IMPU8, IMPU7, IMPU6, IMPU5)\n"
					+ "VALUES('                " + ULT_DOC + "', '" + part + "', '" + p.getCveArt() + "', '" + p.getCant() + "', '" + p.getCant() + "', '" + p.getPrecio() + "','" + p.getPrecio() + "'"
							+ ",'" + impu01.getImpuesto1() + "', '" + impu01.getImpuesto2() + "','" + impu01.getImpuesto3() + "','" + impu01.getImpuesto4() + "','" +impu01.getImp1aplica() +"','" +impu01.getImp2aplica() +"','" +impu01.getImp3aplica() +"','" +impu01.getImp4aplica() +"'"
									+ ", 0, 0, 0, '"+ calcularDescuento +"', '"+ politicasDescuentoValor(descr[0], clasificacion)*100 +"', 0, 0,"
									+ " 0, 0, 'N', 1, '', 1, '" + inve01.getUniMed() + "', 'P', 0, 0, 0, 'N', 0, '"
					+ (p.getCant() * p.getPrecio()) + "', NULL, 'N', NULL, NULL, NULL, NULL, NULL, '"+ inve01.getCveEsqimpu() +"', NULL, '', '"
					+ fecha + "', 0, 0, 0, 0, '" + impu01.getImp8aplica() + "', '" + impu01.getImp7aplica() + "', '" + impu01.getImp6aplica() + "', '" + impu01.getImp5aplica() +"', '" + impu01.getImpuesto8() + "', '" + impu01.getImpuesto7() + "', '" + impu01.getImpuesto6() + "', '" + impu01.getImpuesto5() + "');");
			part++;
		}

		this.CerrarSae();
	}

	public void buscarFolio() {
		try {
			this.ConectarSae();
			PreparedStatement ps = this.getCnSae()
					.prepareStatement("SELECT SERIE, ULT_DOC FROM FOLIOSF01 WHERE TIP_DOC='C' AND SERIE='C'");
			ResultSet rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("No hay folios");
			} else {
				while (rs.next()) {
					this.SERIE = rs.getString("SERIE");
					this.ULT_DOC = rs.getInt("ULT_DOC") + 1;
				}
			}
			this.CerrarSae();
		} catch (SQLException ex) {
			LOGGER.error("ERROR AL BUSCAR FOLIO: "+ex);
		}
	}

	// BUSCAR DESCUENTO
	public double politicasDescuentoValor(String articulo, String clasificacion) {
		double descuento = 0.0;
		try {
			this.ConectarSysPedidos();
			PreparedStatement ps = this.getCnSysPedidos()
					.prepareStatement("SELECT PORCENTAJE FROM POLITICAS_DESCUENTO WHERE CLAS_CLIE='"
							+ clasificacion + "' AND LIN_PROD LIKE '" + articulo + "%'");
			ResultSet rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) {
				LOGGER.warn("DESCUENTO NO ENCONTRADO PARA EL ARTICULO: " + articulo);
				descuento=0.0;
			} else {
				while (rs.next()) {
					descuento = rs.getDouble("PORCENTAJE");
					LOGGER.warn("DESCUENTO ENCONTRADO DE: "+ descuento +" PARA EL ARTICULO: " + articulo);
				}
			}
			this.CerrarSysPedidos();
		} catch (SQLException ex) {
			LOGGER.error("ERROR AL BUSCAR EL DESCUENTO: "+ex);
		}
		return descuento;
	}

	// BUSCAR CVE_ESQIMPU
	public Inve01 buscarCveEsquimpuInve(String articulo) {
		inve = new Inve01();
		Inve01Dao iDao = new Inve01DaoImpl();
		inve = iDao.obtenerInve(articulo);
		return inve;
	}

	// BUSCAR IMPU
	// IMPU1, IMPU2, IMPU3, IMPU4, IMPU5, IMPU6, IMPU7, IMPU8, IMP1APLA, IMP2APLA,
	// IMP3APLA, IMP4APLA, IMP5APLA, IMP6APLA, IMP7APLA, IMP8APLA
	public Impu01 buscarImpuArticulo(String cveEsq) {
		impu = new Impu01();
		Impu01Dao iDao = new Impu01DaoImpl();
		impu = iDao.obtenerImpu(cveEsq);
		return impu;
	}

	public void actualizarFolio() throws SQLException {
		this.ConectarSae();
		PreparedStatement ps = this.getCnSae().prepareStatement(
				"UPDATE FOLIOSF01 SET ULT_DOC='" + ULT_DOC + "' WHERE TIP_DOC='C' AND SERIE='C'");
		ps.executeUpdate();
		this.CerrarSae();
	}

	public void onRowEdit(RowEditEvent event) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE PEDIDOS", "Se ha modificado la cantidad..."));
		sumar();
	}

	public void onRowCancel(RowEditEvent event) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE PEDIDOS", "Se ha cancelado la edición..."));
	}

}
