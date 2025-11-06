package com.dmjm.dao;

import java.util.List;

import org.hibernate.Session;

import com.dmjm.model.Clie01;

public interface ClienteDao {

    public List<Clie01> listaCliente();

    public void newClie01(Clie01 clie01);

    public void updateClie01(Clie01 clie01);

    public void deleteClie01(Clie01 clie01);

    public Clie01 obtenerCliente(Session session, String clave) throws Exception;

    public List<String> listarRfc(String rfc);

    public List<Clie01> listaClieRfc(String rfc);
    
    public Clie01 cliente(String rfc);
}
