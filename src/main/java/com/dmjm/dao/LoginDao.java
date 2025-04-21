package com.dmjm.dao;

import com.dmjm.model.Usuarios;

public interface LoginDao {

    public Usuarios obternerDatosUsuario(Usuarios usuarios);

    public Usuarios login(Usuarios usuarios);

}
