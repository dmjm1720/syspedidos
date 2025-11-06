package com.dmjm.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.dmjm.dao.FacturaFactcDao;
import com.dmjm.model.EncabezadoFact;
import com.dmjm.model.Factc01;
import com.dmjm.model.Usuarios;
import com.dmjm.util.Conexion;
import com.dmjm.util.HibernateUtilSae;

public class FacturaFactcDaoImpl extends Conexion implements FacturaFactcDao {

	Usuarios us = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");

	@SuppressWarnings("unchecked")
	@Override
	public List<Factc01> listaFacturas() {
		List<Factc01> lista = null;
		Session session = HibernateUtilSae.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		String hql = "FROM Factc01 where cveClpv='" + us.getClave() + "' and rfc='" + us.getRfc() + "' AND serie='C'";
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
	public List<Factc01> listaFacturasClientes() {
		List<Factc01> lista = null;
		Session session = HibernateUtilSae.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();

		String hql = "FROM Factc01 f WHERE YEAR(f.fechaDoc) = :anio AND f.serie='C'";

		try {
			Query<Factc01> query = session.createQuery(hql, Factc01.class);
			query.setParameter("anio", 2025);

			lista = query.getResultList();
			t.commit();
		} catch (HibernateException e) {
			t.rollback();
			e.printStackTrace(); // Registrar error
			e.getCause().printStackTrace();

		} finally {
			session.close(); // Cerrar sesión correctamente
		}

		return lista;
	}

	@Override
	public List<EncabezadoFact> listaFCli() {
		List<EncabezadoFact> lista = new ArrayList<>();
		try {
			this.ConectarSae();
			PreparedStatement ps = this.getCnSae()
					.prepareStatement("SELECT dbo.CLIE01.CLAVE, dbo.CLIE01.NOMBRE, dbo.CLIE01.RFC, dbo.FACTC01.CVE_DOC,"
							+ "	dbo.FACTC01.STATUS,	dbo.FACTC01.CVE_PEDI, dbo.FACTC01.FECHA_DOC, dbo.FACTC01.FECHA_ENT,"
							+ "	dbo.FACTC01.FECHA_VEN, dbo.FACTC01.IMP_TOT1, dbo.FACTC01.IMP_TOT2, dbo.FACTC01.IMP_TOT3,"
							+ " dbo.FACTC01.IMP_TOT4, dbo.FACTC01.CAN_TOT, dbo.FACTC01.FECHA_CANCELA, dbo.FACTC01.DES_TOT,"
							+ " dbo.FACTC01.CONDICION, dbo.FACTC01.NUM_PAGOS, dbo.FACTC01.FORMAENVIO, dbo.FACTC01.IMPORTE,"
							+ " dbo.FACTC01.METODODEPAGO, dbo.FACTC01.TIP_DOC_ANT, dbo.FACTC01.DOC_ANT,	dbo.FACTC01.TIP_DOC_SIG,"
							+ " dbo.FACTC01.DOC_SIG" + " FROM dbo.CLIE01" + " INNER JOIN dbo.FACTC01 ON"
							+ "	dbo.CLIE01.CLAVE = dbo.FACTC01.CVE_CLPV" + " WHERE dbo.FACTC01.SERIE='C'");
			ResultSet rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("No hay folios");
			} else {
				while (rs.next()) {
					EncabezadoFact e = new EncabezadoFact();
					
					e.setClave(rs.getString("CLAVE"));
					e.setNombre(rs.getString("NOMBRE"));
					e.setRfc(rs.getString("RFC"));
					e.setCve_doc(rs.getString("CVE_DOC"));
					e.setEstatus(rs.getString("STATUS"));
					e.setCve_pedi(rs.getString("CVE_PEDI"));
					e.setFecha_doc(rs.getDate("FECHA_DOC"));
					e.setFecha_ent(rs.getDate("FECHA_ENT"));
					e.setFecha_ven(rs.getDate("FECHA_VEN"));
					e.setImp_tot1(rs.getDouble("IMP_TOT1"));
					e.setImp_tot2(rs.getDouble("IMP_TOT2"));
					e.setImp_tot3(rs.getDouble("IMP_TOT3"));
					e.setImp_tot4(rs.getDouble("IMP_TOT4"));
					e.setCan_tot(rs.getInt("CAN_TOT"));
					e.setFecha_cancela(rs.getDate("FECHA_CANCELA"));
					e.setDes_tot(rs.getDouble("DES_TOT"));
					e.setCondicion(rs.getString("CONDICION"));
					e.setNum_pagos(rs.getString("NUM_PAGOS"));
					e.setFormaenvio(rs.getString("FORMAENVIO"));
					e.setImporte(rs.getDouble("IMPORTE"));
					e.setMetopago(rs.getString("METODODEPAGO"));
					e.setTip_doc_ant(rs.getString("TIP_DOC_ANT"));
					e.setDoc_ant(rs.getString("DOC_ANT"));
					e.setTip_doc_sig(rs.getString("TIP_DOC_SIG"));
					e.setDoc_sig(rs.getString("DOC_SIG"));

					lista.add(e);

				}
			}
			this.CerrarSae();
		} catch (SQLException ex) {
			
		}
		return lista;
	}

	@Override
	public List<EncabezadoFact> listaFXCli() {
		List<EncabezadoFact> lista = new ArrayList<>();
		try {
			this.ConectarSae();
			PreparedStatement ps = this.getCnSae()
					.prepareStatement("SELECT dbo.CLIE01.CLAVE, dbo.CLIE01.NOMBRE, dbo.CLIE01.RFC, dbo.FACTC01.CVE_DOC,"
							+ "	dbo.FACTC01.STATUS,	dbo.FACTC01.CVE_PEDI, dbo.FACTC01.FECHA_DOC, dbo.FACTC01.FECHA_ENT,"
							+ "	dbo.FACTC01.FECHA_VEN, dbo.FACTC01.IMP_TOT1, dbo.FACTC01.IMP_TOT2, dbo.FACTC01.IMP_TOT3,"
							+ " dbo.FACTC01.IMP_TOT4, dbo.FACTC01.CAN_TOT, dbo.FACTC01.FECHA_CANCELA, dbo.FACTC01.DES_TOT,"
							+ " dbo.FACTC01.CONDICION, dbo.FACTC01.NUM_PAGOS, dbo.FACTC01.FORMAENVIO, dbo.FACTC01.IMPORTE,"
							+ " dbo.FACTC01.METODODEPAGO, dbo.FACTC01.TIP_DOC_ANT, dbo.FACTC01.DOC_ANT,	dbo.FACTC01.TIP_DOC_SIG,"
							+ " dbo.FACTC01.DOC_SIG" + " FROM dbo.CLIE01" + " INNER JOIN dbo.FACTC01 ON"
							+ "	dbo.CLIE01.CLAVE = dbo.FACTC01.CVE_CLPV" + " WHERE dbo.FACTC01.SERIE='C' AND dbo.CLIE01.CLAVE='"+ us.getClave() +"'");
			ResultSet rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("No hay folios");
			} else {
				while (rs.next()) {
					EncabezadoFact e = new EncabezadoFact();
					
					e.setClave(rs.getString("CLAVE"));
					e.setNombre(rs.getString("NOMBRE"));
					e.setRfc(rs.getString("RFC"));
					e.setCve_doc(rs.getString("CVE_DOC"));
					e.setEstatus(rs.getString("STATUS"));
					e.setCve_pedi(rs.getString("CVE_PEDI"));
					e.setFecha_doc(rs.getDate("FECHA_DOC"));
					e.setFecha_ent(rs.getDate("FECHA_ENT"));
					e.setFecha_ven(rs.getDate("FECHA_VEN"));
					e.setImp_tot1(rs.getDouble("IMP_TOT1"));
					e.setImp_tot2(rs.getDouble("IMP_TOT2"));
					e.setImp_tot3(rs.getDouble("IMP_TOT3"));
					e.setImp_tot4(rs.getDouble("IMP_TOT4"));
					e.setCan_tot(rs.getInt("CAN_TOT"));
					e.setFecha_cancela(rs.getDate("FECHA_CANCELA"));
					e.setDes_tot(rs.getDouble("DES_TOT"));
					e.setCondicion(rs.getString("CONDICION"));
					e.setNum_pagos(rs.getString("NUM_PAGOS"));
					e.setFormaenvio(rs.getString("FORMAENVIO"));
					e.setImporte(rs.getDouble("IMPORTE"));
					e.setMetopago(rs.getString("METODODEPAGO"));
					e.setTip_doc_ant(rs.getString("TIP_DOC_ANT"));
					e.setDoc_ant(rs.getString("DOC_ANT"));
					e.setTip_doc_sig(rs.getString("TIP_DOC_SIG"));
					e.setDoc_sig(rs.getString("DOC_SIG"));

					lista.add(e);

				}
			}
			this.CerrarSae();
		} catch (SQLException ex) {
			
		}
		return lista;
	}
	
}
