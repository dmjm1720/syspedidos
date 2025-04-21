package com.dmjm.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.dmjm.dao.ClienteDao;
import com.dmjm.model.Clie01;
import com.dmjm.model.Usuarios;
import com.dmjm.util.HibernateUtilSae;

public class ClienteDaoImpl implements ClienteDao {

	Usuarios us = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
    @SuppressWarnings("unchecked")
    @Override
    public List<Clie01> listaCliente() {
        List<Clie01> lista = null;
        Session session = HibernateUtilSae.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Clie01 where status='A' and rfc='"+ us.getRfc()+"'";
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
    public void newClie01(Clie01 clie01) {
        Session session = null;
        try {
            session = HibernateUtilSae.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(clie01);
            session.getTransaction().commit();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "COTIZADOR WEB", "Registro agregado correctamente"));

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
    public void updateClie01(Clie01 clie01) {
        Session session = null;
        try {
            session = HibernateUtilSae.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(clie01);
            session.getTransaction().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "COTIZADOR WEB", "Registro actualizado correctamente"));
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
    public void deleteClie01(Clie01 clie01) {
        Session session = null;
        try {
            session = HibernateUtilSae.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(clie01);
            session.getTransaction().commit();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "COTIZADOR WEB", "Registro borrado correctamente"));
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
    public Clie01 obtenerCliente(Session session, String clave) throws Exception {
        String hql = "FROM Clie01 WHERE clave=:clave AND status='A' AND rfc='"+ us.getRfc() +"' order by clave desc";
        Query q = session.createQuery(hql).setMaxResults(1);
        q.setParameter("clave", clave);
        return (Clie01) q.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<String> listarRfc(String rfc) {
        List<String> lista = null;
        Session session = HibernateUtilSae.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "SELECT DISTINCT rfc || '___' || nombre FROM Clie01 WHERE rfc LIKE'"+ us.getRfc() +"%' AND status='A'";
        try {
            lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Clie01> listaClieRfc(String rfc) {
        List<Clie01> lista = null;
        Session session = HibernateUtilSae.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Clie01 WHERE rfc ='" + rfc.toUpperCase() + "' AND status='A'";
        try {
            lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (HibernateException e) {
            t.rollback();
        }
        return lista;
    }

}
