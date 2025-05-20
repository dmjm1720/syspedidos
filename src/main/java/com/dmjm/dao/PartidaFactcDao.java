package com.dmjm.dao;

import java.util.List;

import com.dmjm.model.ParFactc01;
import com.dmjm.model.PartidaCotizacion;

public interface PartidaFactcDao {

	List<ParFactc01> listaPartidas(String cveDoc);
	
	List<PartidaCotizacion> listarPartidasCotizacion(String cveDoc);
	

}
