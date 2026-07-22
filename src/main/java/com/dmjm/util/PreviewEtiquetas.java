package com.dmjm.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dmjm.dao.EtiquetasDao;
import com.dmjm.impl.EtiquetasDaoImpl;
import com.dmjm.model.Etiquetas;


public class PreviewEtiquetas {
	
	private Etiquetas e;
	
	
	public Etiquetas getE() {
		return e;
	}

	public void setE(Etiquetas e) {
		this.e = e;
	}

	public void impresion(Map<String, Integer> inventario, String pedido, String docS, String cveProv) {
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
	                
	                e = new Etiquetas();
	                e.setCantidad(contenido.getCantidad());
	                e.setCveClpv(cveProv);
	                e.setCveDoc(pedido.trim());
	                e.setDocSig(docS);
	                e.setNoOrden(cajaId);
	                e.setDescr(nombreProducto);
	                guardarEtiquetas(e);
	                
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
	            
                e = new Etiquetas();
                e.setCantidad(contenido.getCantidad());
                e.setCveClpv(cveProv);
                e.setCveDoc(pedido.trim());
                e.setDocSig(docS);
                e.setNoOrden(cajaId);
                e.setDescr(nombreProducto);
                guardarEtiquetas(e);
                
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
	
	public void guardarEtiquetas(Etiquetas e) {
		EtiquetasDao eDao = new EtiquetasDaoImpl();
		eDao.guardarEtiquetas(e);
	}
	
}
