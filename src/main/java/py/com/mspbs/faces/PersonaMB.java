package py.com.mspbs.faces;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import py.com.mspbs.ejb.PersonaLogica;
import py.com.mspbs.jpa.Persona;

@Named("personaController")
@ViewScoped
public class PersonaMB implements Serializable {

	List<Persona> personas;

	@Inject
	PersonaLogica logica;

	Persona personaNueva;

	@PostConstruct
	public void init() {

		this.personas = logica.getPersonas(0, 10);

		personaNueva = new Persona();
		personaNueva.setNombre("Cambiame el nombre");
	}

	public void agregarPersona() {
		personaNueva = logica.agreagrOActualizarPersona(personaNueva);

		this.personas = logica.getPersonas(0, 10);

		FacesMessage fm = new FacesMessage("Hola", "Mundo");
		FacesContext.getCurrentInstance().addMessage(null, fm);

		personaNueva = new Persona();
		personaNueva.setNombre("Soy otra persona!");
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public Persona getPersonaNueva() {
		return personaNueva;
	}
}
