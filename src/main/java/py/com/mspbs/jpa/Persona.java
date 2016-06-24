package py.com.mspbs.jpa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "persona")
@SequenceGenerator(name = "PersonaIdGenerator", sequenceName = "persona_id_sequence")
public class Persona implements Serializable {

	private static final long serialVersionUID = 3364920061196020320L;

	@Id
	@GeneratedValue(generator = "PersonaIdGenerator")
	private long id;

	@NotNull
	@Size(max = 200, min = 0)
	private String nombre;

	@NotNull
	@Size(max = 200, min = 0)
	private String apellido;

	@NotNull
	@Size(max = 200, min = 0)
	private String cedula;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
}
