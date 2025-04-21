package com.dmjm.impl;

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

}
