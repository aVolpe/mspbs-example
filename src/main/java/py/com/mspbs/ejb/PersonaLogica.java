package py.com.mspbs.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import py.com.mspbs.jpa.Persona;

@Stateless
public class PersonaLogica {

	@PersistenceContext
	EntityManager jpa;

	public List<Persona> getPersonas() {
		return jpa.createQuery("FROM Persona p").getResultList();
	}

	public Persona agreagrOActualizarPersona(Persona p) {
		return jpa.merge(p);
	}

	public void eliminarPersona(Persona p) {
		jpa.remove(jpa.merge(p));
	}

	public void eliminarAlternativa1(Long id) {
		
		Persona p = jpa
				.createQuery("SELECT p FROM Persona p WHERE p.id = :id", Persona.class)
				.setParameter("id", id)
				.getSingleResult();
		
		jpa.remove(p);
	}
	
	public void eliminarAlternativa2(Long id) {
		
		Persona p = jpa.find(Persona.class, id);

		jpa.remove(p);
	}
}
