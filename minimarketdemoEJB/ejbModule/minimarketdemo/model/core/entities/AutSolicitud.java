package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the aut_solicitud database table.
 * 
 */
@Entity
@Table(name="aut_solicitud")
@NamedQuery(name="AutSolicitud.findAll", query="SELECT a FROM AutSolicitud a")
public class AutSolicitud implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sol_id", unique=true, nullable=false)
	private Integer solId;

	@Column(nullable=false, length=2147483647)
	private String cliente;

	@Column(nullable=false, length=2147483647)
	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date fechainicio;

	//bi-directional many-to-one association to AutPedido
	@OneToMany(mappedBy="autSolicitud")
	private List<AutPedido> autPedidos;

	public AutSolicitud() {
	}

	public Integer getSolId() {
		return this.solId;
	}

	public void setSolId(Integer solId) {
		this.solId = solId;
	}

	public String getCliente() {
		return this.cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechainicio() {
		return this.fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public List<AutPedido> getAutPedidos() {
		return this.autPedidos;
	}

	public void setAutPedidos(List<AutPedido> autPedidos) {
		this.autPedidos = autPedidos;
	}

	public AutPedido addAutPedido(AutPedido autPedido) {
		getAutPedidos().add(autPedido);
		autPedido.setAutSolicitud(this);

		return autPedido;
	}

	public AutPedido removeAutPedido(AutPedido autPedido) {
		getAutPedidos().remove(autPedido);
		autPedido.setAutSolicitud(null);

		return autPedido;
	}

}