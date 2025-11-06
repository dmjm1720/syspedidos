package com.dmjm.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Etiquetas {

	public void impresion(Map<String, Integer> inventario) {
	    final int CAPACIDAD_NORMAL = 6;
	    final int CAPACIDAD_CA = 12;
	    List<Caja> cajas = new ArrayList<>();
	    int cajaId = 1;

	    // Primero procesa todos los productos "CA..." (no se mezclan)
	    for (Map.Entry<String, Integer> entry : inventario.entrySet()) {
	        String nombreProducto = entry.getKey();
	        int cantidad = entry.getValue();

	        if (nombreProducto != null && nombreProducto.toUpperCase().startsWith("CA")) {
	            int capacidadCaja = CAPACIDAD_CA;

	            while (cantidad > 0) {
	                Caja cajaActual = new Caja();
	                cajaActual.setId(cajaId);

	                int aAgregar = Math.min(cantidad, capacidadCaja);

	                ContenidoCaja contenido = new ContenidoCaja();
	                contenido.setCajaId(cajaId);
	                contenido.setProductoId(nombreProducto);
	                contenido.setCantidad(aAgregar);
	                cajaActual.getContenidos().add(contenido);

	                System.out.println("Cantidad: " + contenido.getCantidad() + " | Producto: " + nombreProducto);
	                System.out.println("No. caja: " + cajaId);
	                System.out.println();

	                cajas.add(cajaActual);

	                cantidad -= aAgregar;
	                cajaId++;
	            }
	        }
	    }

	    // Luego procesa todos los que NO empiezan con CA, pueden ir juntos mientras quepan en la caja
	    Caja cajaActual = null;
	    int espacioDisponible = 0;

	    for (Map.Entry<String, Integer> entry : inventario.entrySet()) {
	        String nombreProducto = entry.getKey();
	        int cantidad = entry.getValue();

	        if (nombreProducto != null && nombreProducto.toUpperCase().startsWith("CA")) {
	            continue; // ya procesados arriba
	        }

	        int capacidadCaja = CAPACIDAD_NORMAL;

	        while (cantidad > 0) {
	            if (cajaActual == null || espacioDisponible == 0) {
	                cajaActual = new Caja();
	                cajaActual.setId(cajaId);
	                espacioDisponible = capacidadCaja;
	            }

	            int aAgregar = Math.min(cantidad, espacioDisponible);

	            ContenidoCaja contenido = new ContenidoCaja();
	            contenido.setCajaId(cajaActual.getId());
	            contenido.setProductoId(nombreProducto);
	            contenido.setCantidad(aAgregar);
	            cajaActual.getContenidos().add(contenido);

	            System.out.println("Cantidad: " + contenido.getCantidad() + " | Producto: " + nombreProducto);

	            cantidad -= aAgregar;
	            espacioDisponible -= aAgregar;

	            if (espacioDisponible == 0) {
	                cajas.add(cajaActual);
	                System.out.println("No. caja: " + cajaActual.getId());
	                System.out.println();
	                cajaId++;
	                cajaActual = null;
	            }
	        }
	    }
	    // Si hay productos en la última caja, mostrarlos
	    if (cajaActual != null && !cajaActual.getContenidos().isEmpty()) {
	        cajas.add(cajaActual);
	        System.out.println("No. caja: " + cajaActual.getId());
	    }
	}
	
}
