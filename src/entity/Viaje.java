package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the viaje database table.
 * 
 */
@Entity
@NamedQuery(name="Viaje.findAll", query="SELECT v FROM Viaje v")
public class Viaje implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idViaje;
	private String destino;
	private Date fechaViaje;
	private String horaViaje;
	private String origen;
	private double precioViaje;
	private Cliente cliente = new Cliente();
	private Conductore conductore = new Conductore();

	public Viaje() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_viaje")
	public int getIdViaje() {
		return this.idViaje;
	}

	public void setIdViaje(int idViaje) {
		this.idViaje = idViaje;
	}


	public String getDestino() {
		return this.destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="fecha_viaje")
	public Date getFechaViaje() {
		return this.fechaViaje;
	}

	public void setFechaViaje(Date fechaViaje) {
		this.fechaViaje = fechaViaje;
	}


	@Column(name="hora_viaje")
	public String getHoraViaje() {
		return this.horaViaje;
	}

	public void setHoraViaje(String horaViaje) {
		this.horaViaje = horaViaje;
	}


	public String getOrigen() {
		return this.origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}


	@Column(name="precio_viaje")
	public double getPrecioViaje() {
		return this.precioViaje;
	}

	public void setPrecioViaje(double precioViaje) {
		this.precioViaje = precioViaje;
	}


	//bi-directional many-to-one association to Cliente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codigo_cliente")
	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	//bi-directional many-to-one association to Conductore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codigo_conductor")
	public Conductore getConductore() {
		return this.conductore;
	}

	public void setConductore(Conductore conductore) {
		this.conductore = conductore;
	}

}