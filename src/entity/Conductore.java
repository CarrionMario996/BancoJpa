package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the conductores database table.
 * 
 */
@Entity
@Table(name="conductores")
@NamedQuery(name="Conductore.findAll", query="SELECT c FROM Conductore c")
public class Conductore implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codigoConductor;
	private String apellido;
	private String dirrecion;
	private String dui;
	private String nombre;
	private String numeroLicencia;
	private String tipo_vehiculo;
	private List<Viaje> viajes;

	public Conductore() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_conductor")
	public int getCodigoConductor() {
		return this.codigoConductor;
	}

	public void setCodigoConductor(int codigoConductor) {
		this.codigoConductor = codigoConductor;
	}


	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getDirrecion() {
		return this.dirrecion;
	}

	public void setDirrecion(String dirrecion) {
		this.dirrecion = dirrecion;
	}


	public String getDui() {
		return this.dui;
	}

	public void setDui(String dui) {
		this.dui = dui;
	}


	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Column(name="numero_licencia")
	public String getNumeroLicencia() {
		return this.numeroLicencia;
	}

	public void setNumeroLicencia(String numeroLicencia) {
		this.numeroLicencia = numeroLicencia;
	}


	public String getTipo_vehiculo() {
		return this.tipo_vehiculo;
	}

	public void setTipo_vehiculo(String tipo_vehiculo) {
		this.tipo_vehiculo = tipo_vehiculo;
	}


	//bi-directional many-to-one association to Viaje
	@OneToMany(mappedBy="conductore")
	public List<Viaje> getViajes() {
		return this.viajes;
	}

	public void setViajes(List<Viaje> viajes) {
		this.viajes = viajes;
	}

	public Viaje addViaje(Viaje viaje) {
		getViajes().add(viaje);
		viaje.setConductore(this);

		return viaje;
	}

	public Viaje removeViaje(Viaje viaje) {
		getViajes().remove(viaje);
		viaje.setConductore(null);

		return viaje;
	}

}