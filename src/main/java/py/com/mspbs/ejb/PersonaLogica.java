package py.com.mspbs.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import py.com.mspbs.jpa.Persona;

@Stateless
public class PersonaLogica {

	@PersistenceContext
	EntityManager jpa;

	public List<Persona> getPersonas(int cantidad, int primero) {
		return jpa.createQuery("FROM Persona p")
				.setMaxResults(cantidad)
				.setFirstResult(primero)
				.getResultList();
	}

	public Persona agreagrOActualizarPersona(Persona p) {
		return jpa.merge(p);
	}

	public void eliminarPersona(Persona p) {
		jpa.remove(jpa.merge(p));
	}

	@Transactional
	public void eliminarAlternativa1(Long id) {
		
		Persona p = jpa
				.createQuery("SELECT p FROM Persona p WHERE p.id = :id", Persona.class)
				.setParameter("id", id)
				.setLockMode(LockModeType.OPTIMISTIC)
				.getSingleResult();
		
		jpa.remove(p);
	}
	
	public void eliminarAlternativa2(Long id) {
		
		Persona p = jpa.find(Persona.class, id);

		jpa.remove(p);
	}
}
