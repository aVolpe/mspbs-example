package py.com.mspbs.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import py.com.mspbs.jpa.Compra;
import py.com.mspbs.jpa.CompraDetalle;

@Stateless
public class CompraLogica {

	@PersistenceContext
	EntityManager jpa;

	public Compra agregarCompra(Compra compra) {

		jpa.persist(compra);
		for (CompraDetalle detalle : compra.getDetalles()) {
			jpa.persist(detalle);
		}

		return compra;
	}
}
