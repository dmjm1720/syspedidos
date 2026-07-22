package com.dmjm.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.dmjm.dao.LoginDao;
import com.dmjm.model.Usuarios;
import com.dmjm.util.HibernateUtil;
import com.dmjm.util.Password;

public class LoginUsuarioImpl implements LoginDao {

    @Override
    public Usuarios obternerDatosUsuario(Usuarios usuarios) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Usuarios WHERE usuario=:usuario AND password=:password";
        @SuppressWarnings("rawtypes")
		Query q = session.createQuery(hql);
        q.setParameter("nombre", usuarios.getNombre());
        q.setParameter("password", Password.sha512(usuarios.getPassword()));
        return (Usuarios) q.uniqueResult();

    }

    @Override
    public Usuarios login(Usuarios usuarios) {
        Usuarios user = this.obternerDatosUsuario(usuarios);
        if (user != null) {
            if (!user.getPassword().equals(user.getPassword())) {
                user = null;
            }
        }
        return user;
    }

	@Override
	public String validarUsuarioExiste(String rfc) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			String hql = "SELECT e.rfc FROM Usuarios e WHERE e.rfc = :rfc";
			Query<String> query = session.createQuery(hql, String.class);
			query.setMaxResults(1);
			query.setParameter("rfc", rfc);
			return query.uniqueResultOptional().orElse("0");
		}
	}

	@Override
	public void guardarUsuario(Usuarios usuarios) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(usuarios);
			session.getTransaction().commit();

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
