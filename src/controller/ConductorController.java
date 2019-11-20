package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import dao.ConductorFacade;

import entity.Conductore;

@ManagedBean
@RequestScoped
public class ConductorController implements Serializable {

	private static final long serialVersionUID = 1L;
	private ConductorFacade cf;
	private Conductore c;
	private List<Conductore> listaConductor;

	@PostConstruct
	public void init() {
		cf = new ConductorFacade();
		c = new Conductore();
		mostrar();

	}



	public Conductore getC() {
		return c;
	}

	public void setC(Conductore c) {
		this.c = c;
	}


	public List<Conductore> getListaConductor() {
		return listaConductor;
	}

	public void setListaConductor(List<Conductore> listaConductor) {
		this.listaConductor = listaConductor;
	}

	public void mostrar() {
		this.listaConductor = new ArrayList<Conductore>();
		this.listaConductor = cf.mostrar();

	}

	public void limpiar() {
		c = new Conductore();
	}

	public void eliminar(int id) {
		try {
			c=cf.findId(id);
			cf.delete(c);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void update(int id) {
		try {
			
			cf.update(c);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void agregar() {
		try {
			cf.create(c);
			limpiar();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void consultarId(int id) {
		this.c=cf.findId(id);
	}
	
	public void modificar() {
		try {
			cf.update(c);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void mensaje(String respuesta){
		FacesMessage mens = new FacesMessage(respuesta);
		FacesContext.getCurrentInstance().addMessage(null, mens);
	}
}
