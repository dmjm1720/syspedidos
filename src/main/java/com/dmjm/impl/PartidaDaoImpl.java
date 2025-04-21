package com.dmjm.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dmjm.dao.PartidaDao;
import com.dmjm.model.Partida;
import com.dmjm.util.HibernateUtilSae;

public class PartidaDaoImpl implements PartidaDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Partida> listaPartida() {
		List<Partida> lista = null;
		Session session = HibernateUtilSae.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		String hql = "FROM Partida";
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
	@SuppressWarnings("null")
	public void newPartida(Partida partida) {
		Session session = null;
		try {
			session = HibernateUtilSae.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(partida);
			session.getTransaction().commit();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"SISTEMA DE PEDIDOS", "Registro agregado correctamente"));

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
	@SuppressWarnings("null")
	public void updatePartida(Partida partida) {
		Session session = null;
		try {
			session = HibernateUtilSae.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(partida);
			session.getTransaction().commit();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"SISTEMA DE PEDIDOS", "Registro actualizado correctamente"));
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
	@SuppressWarnings("null")
	public void deletePartida(Partida partida) {
		Session session = null;
		try {
			session = HibernateUtilSae.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(partida);
			session.getTransaction().commit();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"SISTEMA DE PEDIDOS", "Registro borrado correctamente"));
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
