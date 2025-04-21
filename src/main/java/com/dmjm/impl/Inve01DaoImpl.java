package com.dmjm.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dmjm.dao.Inve01Dao;
import com.dmjm.model.Inve01;
import com.dmjm.util.HibernateUtilSae;

public class Inve01DaoImpl implements Inve01Dao {

	@Override
	public Inve01 obtenerInve(String articulo) {
		Inve01 inve = new Inve01();
		Session session = HibernateUtilSae.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		String hql = "FROM Inve01 WHERE cveArt = '" + articulo + "'";
		try {
			inve = (Inve01) session.createQuery(hql).uniqueResult();
			t.commit();
			session.close();
		} catch (HibernateException e) {
			t.rollback();
		}
		return inve;
	}

}
