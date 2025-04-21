package com.dmjm.dao;

import java.util.List;

import com.dmjm.model.Partida;

public interface PartidaDao {

	public List<Partida> listaPartida();

	public void newPartida(Partida partida);

	public void updatePartida(Partida partida);

	public void deletePartida(Partida partida);
}
