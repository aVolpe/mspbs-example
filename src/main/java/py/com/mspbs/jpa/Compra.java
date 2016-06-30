package py.com.mspbs.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "compra")
@SequenceGenerator(name = "CompraIdGenerator", sequenceName = "compra_id_sequence")
public class Compra implements Serializable {

	private static final long serialVersionUID = 3364920061196020320L;

	@Id
	@GeneratedValue(generator = "CompraIdGenerator")
	private long id;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Persona cliente;

	@OneToMany(mappedBy = "compra")
	private List<CompraDetalle> detalles;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Persona getCliente() {
		return cliente;
	}

	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}

	public List<CompraDetalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<CompraDetalle> detalles) {
		this.detalles = detalles;
	}
}
