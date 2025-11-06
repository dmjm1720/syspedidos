package com.dmjm.util;

public class ContenidoCaja {
	private int cajaId; // ID de la caja (relación)
	private String productoId; // ID del producto
	private int cantidad;

	public ContenidoCaja() {

	}

	public ContenidoCaja(int cajaId, String productoId, int cantidad) {

		this.cajaId = cajaId;
		this.productoId = productoId;
		this.cantidad = cantidad;
	}

	public int getCajaId() {
		return cajaId;
	}

	public void setCajaId(int cajaId) {
		this.cajaId = cajaId;
	}

	public String getProductoId() {
		return productoId;
	}

	public void setProductoId(String productoId) {
		this.productoId = productoId;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
