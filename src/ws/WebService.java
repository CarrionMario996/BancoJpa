package ws;


import java.util.Date;

import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import dao.ConductorFacade;
import dao.ConductorPosicionFacade;
import dao.VehiculoFacade;
import entity.Conductor;
import entity.ConductorPosicion;
import entity.Vehiculo;

@Path("/WSCliente")
public class WebService {
	private Vehiculo v;
	private VehiculoFacade vf;
	private Conductor c;
	private ConductorFacade cf;
	private ConductorPosicionFacade cpf;
	private ConductorPosicion cp;

	public WebService() {
		vf = new VehiculoFacade();
		v = new Vehiculo();
		c = new Conductor();
		cf = new ConductorFacade();
		cpf = new ConductorPosicionFacade();
		cp = new ConductorPosicion();

	}

	@POST
	@Path("/guardarDatos")
	@Produces({ MediaType.APPLICATION_JSON })
	public String guardarDatos(@QueryParam("id_vehiculo") int id_vehiculo, @QueryParam("placa") String placa,
			@QueryParam("marca") String marca, @QueryParam("modelo") String modelo, @QueryParam("color") String color,
			@QueryParam("fecha") String fecha, @QueryParam("id_tipo_vehiculo") int id_tipo_vehiculo,
			@QueryParam("idConductor") int id_conductor, @QueryParam("nombre") String nombre,
			@QueryParam("apellido") String apellido, @QueryParam("dui") String dui,
			@QueryParam("numLicencia") String num_licencia, @QueryParam("direccion") String direccion,
			@QueryParam("id_municipio") int id_municipio, @QueryParam("email") String email,
			@QueryParam("telefono") String telefono, @QueryParam("estado") int estado) {

		if (id_vehiculo != 0) {

			v.setIdVehiculo(id_vehiculo);
			v.setPlaca(placa);
			v.setMarca(marca);
			v.setModelo(modelo);
			v.setColor(color);
			v.setFecha(fecha);
			v.setIdTipoVehiculo(id_tipo_vehiculo);

			vf.create(v);

			/***************************/

			c.setIdConductor(id_conductor);
			c.setNombre(nombre);
			c.setApellido(apellido);
			c.setDui(dui);
			c.setNumLicencia(num_licencia);
			c.setDireccion(direccion);
			c.setIdMunicipio(id_municipio);
			c.setVehiculo(v);
			c.setEmail(email);
			c.setTelefono(telefono);
			c.setEstado(estado);
			cf.create(c);

			return "datos ingresados exitosamente";

		} else {
			return "error al ingresar datos";
		}

	}

	@POST
	@Path("/conductorPosicion")
	@Produces(MediaType.APPLICATION_JSON)
	public String conductorPosicion(
			@QueryParam("ultima_posicion") String ultima_posicion, @QueryParam("estado") int estado) {
			
			cp.setUltimaPosicion(ultima_posicion);
			cp.setEstado(estado);
			cp.setHora(new Date());
			cpf.create(cp);
			return "datos ingresados";
		

	}

}
