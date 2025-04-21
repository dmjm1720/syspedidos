package com.dmjm.dao;

import java.util.List;

import com.dmjm.model.Usuarios;

public interface UsuarioDao {

    public Usuarios obtenerDatosUsuario(Usuarios usuarios);

    public Usuarios login(Usuarios usuarios);

    public void guardarUsuario(Usuarios usuarios);

    public void actualizarUsuario(Usuarios usuarios);

    public void borrarUsuario(Usuarios usuarios);

     List<Usuarios> listarUsuarios();
}
