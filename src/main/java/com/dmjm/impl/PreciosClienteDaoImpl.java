package com.dmjm.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.context.FacesContext;

import com.dmjm.bean.PartidaBean;
import com.dmjm.dao.PreciosClienteDao;
import com.dmjm.model.PreciosCliente;
import com.dmjm.model.Usuarios;
import com.dmjm.util.Conexion;

public class PreciosClienteDaoImpl extends Conexion implements PreciosClienteDao {
	Usuarios us = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");

	@Override
	public List<PreciosCliente> listaPrecios() {
		List<PreciosCliente> lista = new ArrayList<>();
		try {
			this.ConectarSae();
			PreparedStatement ps = this.getCnSae()
					.prepareStatement("SELECT INV.UNI_MED, INV.NUM_MON, PRE.PRECIO, INV.CVE_ART, INV.DESCR "
							+ "FROM INVE01 AS INV " + "INNER JOIN PRECIO_X_PROD01 AS PRE "
							+ "ON INV.CVE_ART = PRE.CVE_ART WHERE PRE.CVE_PRECIO='" + us.getListaPrec()
							+ "' AND PRE.PRECIO<>0");
			ResultSet rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("No hay folios");
			} else {
				while (rs.next()) {
					PreciosCliente p = new PreciosCliente();
					p.setUniMed(rs.getString("UNI_MED"));
					p.setNumMon(rs.getInt("NUM_MON"));
					p.setPrecio(rs.getDouble("PRECIO"));
					p.setCveArt(rs.getString("CVE_ART"));
					p.setDescr(rs.getString("DESCR"));

					lista.add(p);

				}
			}
			this.CerrarSae();
		} catch (SQLException ex) {
			Logger.getLogger(PartidaBean.class.getName()).log(Level.SEVERE, null, ex);
		}
		return lista;
	}

	@Override
	public double precio(String art) {
		double precio = 0.0;
		try {
			this.ConectarSae();
			PreparedStatement ps = this.getCnSae().prepareStatement(
					"SELECT PRECIO FROM PRECIO_X_PROD01 WHERE CVE_PRECIO=232 AND CVE_ART='" + art + "'");
			ResultSet rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) {
				System.out.println("No hay folios");
			} else {
				while (rs.next()) {
					precio = rs.getDouble("PRECIO");
				}
			}
			this.CerrarSae();
		} catch (SQLException ex) {
			Logger.getLogger(PartidaBean.class.getName()).log(Level.SEVERE, null, ex);
		}
		return precio;
	}

}
