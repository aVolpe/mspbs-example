package py.com.mspbs.jpa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "compra_detalle")
@SequenceGenerator(name = "CompraDetalleIdGenerator", sequenceName = "compra_detalle_id_sequence")
public class CompraDetalle implements Serializable {

	private static final long serialVersionUID = 3364920061196020320L;

	@Id
	@GeneratedValue(generator = "CompraDetalleIdGenerator")
	private long id;

	private String producto;

	private long cantidad;

	private long monto;

	@ManyToOne
	@JoinColumn(name = "compra_id")
	private Compra compra;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCantidad() {
		return cantidad;
	}

	public Compra getCompra() {
		return compra;
	}

	public long getMonto() {
		return monto;
	}

	public String getProducto() {
		return producto;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public void setMonto(long monto) {
		this.monto = monto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}
}
