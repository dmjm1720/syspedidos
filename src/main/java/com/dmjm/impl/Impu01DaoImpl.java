package com.dmjm.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dmjm.dao.Impu01Dao;
import com.dmjm.model.Impu01;
import com.dmjm.util.HibernateUtilSae;

public class Impu01DaoImpl implements Impu01Dao {

	@Override
	public Impu01 obtenerImpu(String cveEsq) {
		Impu01 impu = new Impu01();
		Session session = HibernateUtilSae.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		String hql = "FROM Impu01 WHERE cveEsqimpu = "+ cveEsq +"";
		try {
			impu = (Impu01) session.createQuery(hql).uniqueResult();
			t.commit();
			session.close();
		} catch (HibernateException e) {
			t.rollback();
		}
		return impu;
	}

}
