package com.dmjm.dao;

import com.dmjm.model.Usuarios;

public interface LoginDao {

	public Usuarios obternerDatosUsuario(Usuarios usuarios);

	public Usuarios login(Usuarios usuarios);

	public String validarUsuarioExiste(String rfc);

	public void guardarUsuario(Usuarios usuarios);

}
