package py.com.mspbs.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import py.com.mspbs.ejb.PersonaLogica;
import py.com.mspbs.jpa.Persona;

@Api("Servicios de personas")
@Path("personas/")
@Produces("application/json")
@Consumes("application/json")
public class PersonaResource {

	@Inject
	PersonaLogica logica;

	@GET
	@ApiOperation("Retorna la lista de personas")
	public List<Persona> getTodos(@QueryParam("cantidad") int cantidad, @QueryParam("primero") int primero) {
		return logica.getPersonas(cantidad, primero);
	}

	@POST
	@ApiOperation("Agrega o actualiza una persona")
	public Persona agregarPersona(Persona p) {
		return logica.agreagrOActualizarPersona(p);
	}

	@DELETE
	@Path("/{id}")
	@ApiOperation("Borra una persona")
	public Response borrarPersona(@PathParam("id") Long id) {

		try {
			logica.eliminarAlternativa1(id);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.status(404).build();
		}
	}

}
