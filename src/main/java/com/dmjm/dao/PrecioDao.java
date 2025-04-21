package com.dmjm.dao;

import java.util.List;

import org.hibernate.Session;

import com.dmjm.model.Inve01;

public interface PrecioDao {

    public List<Inve01> listaPrecio();

    public void newPrecio(Inve01 precio);

    public void updatePrecio(Inve01 precio);

    public void deletePrecio(Inve01 precio);

    public Inve01 obtenerClave(Session session, String clave) throws Exception;

}
