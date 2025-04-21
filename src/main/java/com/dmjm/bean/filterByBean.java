package com.dmjm.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.dmjm.dao.ClienteDao;
import com.dmjm.impl.ClienteDaoImpl;
import com.dmjm.model.Clie01;

@Named(value = "filterByBean")
@ViewScoped
public class filterByBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String filterRFC;
	List<String> listarTodo = new ArrayList<>();
	private List<Clie01> listaClieRfc;
	private Clie01 clie01;

	public filterByBean() {
		listaClieRfc = new ArrayList<>();
		clie01 = new Clie01();
	}

	public String getFilterRFC() {
		return filterRFC;
	}

	public void setFilterRFC(String filterRFC) {
		this.filterRFC = filterRFC;
	}

	public Clie01 getClie01() {
		return clie01;
	}

	public void setClie01(Clie01 clie01) {
		this.clie01 = clie01;
	}

	public List<String> completeRFC(String rfc) {
		List<String> resultRFC = new ArrayList<>();
		ClienteDao cDao = new ClienteDaoImpl();
		resultRFC = cDao.listarRfc(rfc.toUpperCase());
		for (int i = 0; i < listarTodo.size(); i++) {
			resultRFC.add(listarTodo.get(i));
		}
		if (resultRFC.isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Sistema de pedidos", "No hay resultados para tu búsqueda"));
		}
		return resultRFC;
	}

	public List<Clie01> getListaClieRfc() {
		return listaClieRfc;
	}

	public void listar() {
		try {
			String rfc = new String(filterRFC);
			String array[] = rfc.split("___", 2);
			String newRfc = array[0];
			ClienteDao cDao = new ClienteDaoImpl();
			listaClieRfc = cDao.listaClieRfc(newRfc);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
