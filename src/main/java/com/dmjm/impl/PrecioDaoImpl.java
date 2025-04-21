package com.dmjm.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.dmjm.dao.PrecioDao;
import com.dmjm.model.Inve01;
import com.dmjm.util.HibernateUtilSae;

public class PrecioDaoImpl implements PrecioDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<Inve01> listaPrecio() {
        List<Inve01> lista = null;
        Session session = HibernateUtilSae.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Inve01 WHERE ultCosto<>0.0";
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
    public void newPrecio(Inve01 precio) {
        Session session = null;
        try {
            session = HibernateUtilSae.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(precio);
            session.getTransaction().commit();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE PEDIDOS", "Registro agregado correctamente"));

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
    public void updatePrecio(Inve01 precio) {
        Session session = null;
        try {
            session = HibernateUtilSae.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(precio);
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
    public void deletePrecio(Inve01 precio) {
        Session session = null;
        try {
            session = HibernateUtilSae.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(precio);
            session.getTransaction().commit();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA DE PEDIDOS", "Registro borrado correctamente"));
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
    public Inve01 obtenerClave(Session session, String clave) throws Exception {
        String hql = "FROM Inve01 WHERE cveArt=:clave  order by cveArt desc";
        Query q = session.createQuery(hql).setMaxResults(1);
        q.setParameter("clave", clave);
        return (Inve01) q.uniqueResult();
    }

}
