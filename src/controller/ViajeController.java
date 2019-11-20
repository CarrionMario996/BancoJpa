package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;



import dao.ViajeFacade;
import entity.Viaje;
@ManagedBean
@RequestScoped
public class ViajeController implements Serializable {

	private static final long serialVersionUID = 1L;
	private ViajeFacade vf;
	private Viaje v;
	private List<Viaje> listaViaje;

	public Viaje getV() {
		return v;
	}

	public void setV(Viaje v) {
		this.v = v;
	}

	public List<Viaje> getListaViaje() {
		return listaViaje;
	}

	public void setListaViaje(List<Viaje> listaViaje) {
		this.listaViaje = listaViaje;
	}

	@PostConstruct
	public void init() {
		vf = new ViajeFacade();
		v = new Viaje();
		mostrar();
	}

	public void mostrar() {
		this.listaViaje = new ArrayList<Viaje>();
		this.listaViaje = vf.mostrar();
	}

	public void eliminar(int id) {
		try {
			v = vf.findId(id);
			vf.delete(v);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	public void agregar() {
		try {
			vf.create(v);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void consultarId(int id) {
		v = vf.findId(id);
	}
}
