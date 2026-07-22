package com.dmjm.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.dmjm.dao.EtiquetasDao;
import com.dmjm.model.Etiquetas;
import com.dmjm.model.Factc01;
import com.dmjm.util.HibernateUtil;
import com.dmjm.util.HibernateUtilSae;

public class EtiquetasDaoImpl implements EtiquetasDao {

	@Override
	public void guardarEtiquetas(Etiquetas et) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(et);
			session.getTransaction().commit();
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
//					"SISTEMA DE PEDIDOS", "Etiquetas listas para imprimir"));

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	@Override
	public String folio(String folio) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			String hql = "SELECT e.cveDoc FROM Etiquetas e WHERE e.cveDoc = :cveDoc";
			Query<String> query = session.createQuery(hql, String.class);
			query.setMaxResults(1);
			query.setParameter("cveDoc", folio);
			return query.uniqueResultOptional().orElse("0");
		}
	}
}
