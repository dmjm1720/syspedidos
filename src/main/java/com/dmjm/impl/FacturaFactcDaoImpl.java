package com.dmjm.impl;

import java.util.List;

import javax.faces.context.FacesContext;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.dmjm.dao.FacturaFactcDao;
import com.dmjm.model.Factc01;
import com.dmjm.model.Usuarios;
import com.dmjm.util.HibernateUtilSae;

public class FacturaFactcDaoImpl implements FacturaFactcDao {

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

}
