package com.dmjm.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import com.dmjm.dao.ClienteDao;
import com.dmjm.dao.UsuarioDao;
import com.dmjm.impl.ClienteDaoImpl;
import com.dmjm.impl.UsuarioDaoImpl;
import com.dmjm.model.Clie01;
import com.dmjm.model.Usuarios;

@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Usuarios usuarios;
	private Clie01 cliente;

	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuario(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	public Clie01 getCliente() {
		return cliente;
	}

	public void setCliente(Clie01 cliente) {
		this.cliente = cliente;
	}

	public LoginBean() {

	}

	@PostConstruct
	public void init() {
		this.usuarios = new Usuarios();
	}

	public void login(ActionEvent event) throws InterruptedException {
		boolean loggedIn = false;
		String ruta = "";
		UsuarioDao usuarioDao = new UsuarioDaoImpl();
		this.usuarios = usuarioDao.login(this.usuarios);

		if (this.usuarios != null) {

			ClienteDao cDao = new ClienteDaoImpl();
			cliente = cDao.cliente(usuarios.getRfc());
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("nombre", usuarios);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("rol",
					usuarios.getPerfiles().getNombrePerfil());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "¡BIENVENIDO!", this.usuarios.getNombre()));
			loggedIn = true;
			if (this.usuarios.getPerfiles().getNombrePerfil().equals("Administrador")) {
				ruta = "/syspedidos/admin/PedidosClientes.html";
			} else if (this.usuarios.getPerfiles().getNombrePerfil().equals("Cliente")) {
				ruta = "/syspedidos/cliente/Pedidos.html";
			}

		} else {
			loggedIn = false;
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "¡ERROR DE ACCESO!", "¡VERIFIQUE SUS CREDENCIALES!"));
			String script = "setTimeout(function() { window.location.href='index.html'; }, 3000);";
			PrimeFaces.current().executeScript(script);
			this.usuarios = new Usuarios();
		}

		PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
		PrimeFaces.current().ajax().addCallbackParam("ruta", ruta);
	}

	public void cerrarSesion() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}

}
