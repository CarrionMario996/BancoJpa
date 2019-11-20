package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import dao.ClienteFacade;
import entity.Cliente;

@ManagedBean
@RequestScoped
public class ClienteController implements Serializable {

	private static final long serialVersionUID = 1L;

	private ClienteFacade cf;
	private Cliente c;
	public List<Cliente> listaCliente;

	public Cliente getC() {
		return c;
	}

	public void setC(Cliente c) {
		this.c = c;
	}

	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	@PostConstruct
	public void init() {
		cf = new ClienteFacade();
		c = new Cliente();
		mostrar();
	}

	public void mostrar() {
		this.listaCliente = new ArrayList<Cliente>();
		this.listaCliente = cf.mostrar();
	}

	public void agregar() {
		try {
			cf.create(c);
			limpiar();
			System.out.println("metodo agregado");
		} catch (Exception e) {

		}
	}

	public void limpiar() {
		c = new Cliente();
	}

	public void eliminar(int id) {
		try {
			c = cf.findId(id);
			cf.delete(c);

		} catch (Exception e) {
			
		}
	}

	public void modificar() {
		try {
			cf.update(c);
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	public void consultarId(int id) {
		this.c=cf.findId(id);
	}
	public void mensaje(String respuesta){
		FacesMessage mens = new FacesMessage(respuesta);
		FacesContext.getCurrentInstance().addMessage(null, mens);
	}
}

