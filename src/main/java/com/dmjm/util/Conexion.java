package com.dmjm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion  extends Configuracion{


	private Connection cnSysPedidos;
	private Connection cnSae;


	public Connection getCnSysPedidos() {
		return cnSysPedidos;
	}

	public void setCnSysPedidos(Connection cnSysPedidos) {
		this.cnSysPedidos = cnSysPedidos;
	}

	public Connection getCnSae() {
		return cnSae;
	}

	public void setCnSae(Connection cnSae) {
		this.cnSae = cnSae;
	}

	public void ConectarSysPedidos() {
		leerConfig();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			this.cnSysPedidos = DriverManager.getConnection(getConexDBSysPedidos(),
					getConexUser(), getConexPwd());
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void CerrarSysPedidos() throws SQLException {
		try {
			if ((this.cnSysPedidos != null) && (!this.cnSysPedidos.isClosed())) {
				this.cnSysPedidos.close();
			}
		} catch (SQLException e) {
			throw e;
		}
	}

	public void ConectarSae() {
		leerConfig();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			this.cnSae = DriverManager.getConnection(getConexDBSae(),
					getConexUser(), getConexPwd2());
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void CerrarSae() throws SQLException {
		try {
			if ((this.cnSae != null) && (!this.cnSae.isClosed())) {
				this.cnSae.close();
			}
		} catch (SQLException e) {
			throw e;
		}
	}

}
