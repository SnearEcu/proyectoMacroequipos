package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the aut_productos database table.
 * 
 */
@Entity
@Table(name="aut_productos")
@NamedQuery(name="AutProducto.findAll", query="SELECT a FROM AutProducto a")
public class AutProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pro_id", unique=true, nullable=false)
	private Integer proId;

	@Column(nullable=false, precision=131089)
	private Double costo;

	@Column(nullable=false, length=2147483647)
	private String descripcion;

	@Column(nullable=false, length=2147483647)
	private String nombre;

	//bi-directional many-to-one association to AutPedido
	@OneToMany(mappedBy="autProducto")
	private List<AutPedido> autPedidos;

	public AutProducto() {
	}

	public Integer getProId() {
		return this.proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
	}

	public Double getCosto() {
		return this.costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<AutPedido> getAutPedidos() {
		return this.autPedidos;
	}

	public void setAutPedidos(List<AutPedido> autPedidos) {
		this.autPedidos = autPedidos;
	}

	public AutPedido addAutPedido(AutPedido autPedido) {
		getAutPedidos().add(autPedido);
		autPedido.setAutProducto(this);

		return autPedido;
	}

	public AutPedido removeAutPedido(AutPedido autPedido) {
		getAutPedidos().remove(autPedido);
		autPedido.setAutProducto(null);

		return autPedido;
	}

}