package com.dmjm.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.primefaces.PrimeFaces;

import com.dmjm.dao.UsuarioDao;
import com.dmjm.model.Usuarios;
import com.dmjm.util.HibernateUtil;
import com.dmjm.util.Password;

public class UsuarioDaoImpl implements UsuarioDao {

	@Override
	public Usuarios obtenerDatosUsuario(Usuarios usuario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "FROM Usuarios WHERE rfc=:rfc AND password=:password";
		Query q = session.createQuery(hql).setMaxResults(1);
		q.setParameter("rfc", usuario.getRfc());
		q.setParameter("password", Password.sha512(usuario.getPassword()));
		return (Usuarios) q.uniqueResult();
	}

	@Override
	public Usuarios login(Usuarios usuarios) {
		Usuarios user = this.obtenerDatosUsuario(usuarios);
		if (user != null) {
			if (!user.getPassword().equals(Password.sha512(usuarios.getPassword()))) {
				user = null;
			}
		}
		return user;
	}

	@Override
	public void guardarUsuario(Usuarios usuarios) {
		Session session = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();

			Transaction transaction = session.beginTransaction();
			session.save(usuarios);
			transaction.commit();
			String info = "Usuario agregado correctamente";

			PrimeFaces.current()
					.executeScript("Swal.fire({\n" + "  position: 'top-center',\n" + "  icon: 'success',\n"
							+ "  title: '¡Aviso!',\n" + "  text: '" + info + "',\n" + "  showConfirmButton: false,\n"
							+ "  timer: 8000\n" + "})");
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void actualizarUsuario(Usuarios usuarios) {
		Session session = null;
		try {

			session = HibernateUtil.getSessionFactory().openSession();

			Transaction transaction = session.beginTransaction();
			session.update(usuarios);
			transaction.commit();

			String info = "Usuario actualizado correctamente";

			PrimeFaces.current()
					.executeScript("Swal.fire({\n" + "  position: 'top-center',\n" + "  icon: 'success',\n"
							+ "  title: '¡Aviso!',\n" + "  text: '" + info + "',\n" + "  showConfirmButton: false,\n"
							+ "  timer: 8000\n" + "})");

		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void borrarUsuario(Usuarios usuarios) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public List<Usuarios> listarUsuarios() {
		List<Usuarios> usuarios = HibernateUtil.getSessionFactory().openSession()
				.createQuery("From Usuarios").list();
		return usuarios;
	}

}
