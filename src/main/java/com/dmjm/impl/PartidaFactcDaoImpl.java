package com.dmjm.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.context.FacesContext;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dmjm.bean.PartidaBean;
import com.dmjm.dao.PartidaFactcDao;
import com.dmjm.model.ParFactc01;
import com.dmjm.model.PartidaCotizacion;
import com.dmjm.model.Usuarios;
import com.dmjm.util.Conexion;
import com.dmjm.util.HibernateUtilSae;

public class PartidaFactcDaoImpl extends Conexion implements PartidaFactcDao {

	Usuarios us = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");

	@SuppressWarnings("unchecked")
	@Override
	public List<ParFactc01> listaPartidas(String cveDoc) {
		List<ParFactc01> lista = null;
		Session session = HibernateUtilSae.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		String hql = "FROM ParFactc01 where cveDoc='" + cveDoc + "'";
		try {
			lista = session.createQuery(hql).list();
			t.commit();
			session.close();
		} catch (HibernateException e) {
			t.rollback();
		}
		return lista;
	}

	@Override
	public List<PartidaCotizacion> listarPartidasCotizacion(String cveDoc) {
		List<PartidaCotizacion> lista = new ArrayList<>();
		try {
			this.ConectarSae();
			PreparedStatement ps = this.getCnSae()
					.prepareStatement("SELECT " + "	dbo.INVE01.UNI_MED, " + "	dbo.INVE01.DESCR, "
							+ "	dbo.INVE01.CVE_ART, " + "	dbo.PAR_FACTC01.CVE_DOC, " + "	dbo.PAR_FACTC01.NUM_PAR, "
							+ "	dbo.PAR_FACTC01.CANT, " + "	dbo.PAR_FACTC01.PREC, " + "	dbo.PAR_FACTC01.IMPU4, "
							+ "	dbo.PAR_FACTC01.TOTIMP4, " + "	dbo.PAR_FACTC01.DESC1, "
							+ "	dbo.PAR_FACTC01.TOT_PARTIDA " + "FROM " + "	dbo.INVE01 " + "INNER JOIN "
							+ "dbo.PAR_FACTC01 ON " + "	dbo.INVE01.CVE_ART = dbo.PAR_FACTC01.CVE_ART " + "WHERE "
							+ "	dbo.PAR_FACTC01.CVE_DOC = '" + cveDoc + "';");
			ResultSet rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("No hay folios");
			} else {
				while (rs.next()) {
					PartidaCotizacion p = new PartidaCotizacion();
					p.setUni_med(rs.getString("UNI_MED"));
					p.setDescr(rs.getString("DESCR"));
					p.setCve_art(rs.getString("CVE_ART"));
					p.setCve_doc(rs.getString("CVE_DOC"));
					p.setNum_par(rs.getInt("NUM_PAR"));
					p.setCant(rs.getInt("CANT"));
					p.setPrec(rs.getDouble("PREC"));
					p.setImpu4(rs.getDouble("IMPU4"));
					p.setTotimp4(rs.getDouble("TOTIMP4"));
					p.setDesc1(rs.getDouble("DESC1"));
					p.setTot_partida(rs.getDouble("TOT_PARTIDA"));

					lista.add(p);

				}
			}
			this.CerrarSae();
		} catch (SQLException ex) {
			Logger.getLogger(PartidaBean.class.getName()).log(Level.SEVERE, null, ex);
		}
		return lista;
	}

}
