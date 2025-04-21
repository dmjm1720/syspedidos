package com.dmjm.impl;

import java.util.List;

import javax.faces.context.FacesContext;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dmjm.dao.PartidaFactcDao;
import com.dmjm.model.ParFactc01;
import com.dmjm.model.Usuarios;
import com.dmjm.util.HibernateUtilSae;

public class PartidaFactcDaoImpl implements PartidaFactcDao {


	Usuarios us = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
	@SuppressWarnings("unchecked")
	@Override
	public List<ParFactc01> listaPartidas(String cveDoc) {
		List<ParFactc01> lista = null;
        Session session = HibernateUtilSae.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM ParFactc01 where cveDoc='"+ cveDoc+"'";
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
