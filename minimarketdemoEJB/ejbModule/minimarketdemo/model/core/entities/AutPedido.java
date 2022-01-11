package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the aut_pedido database table.
 * 
 */
@Entity
@Table(name="aut_pedido")
@NamedQuery(name="AutPedido.findAll", query="SELECT a FROM AutPedido a")
public class AutPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ped_id", unique=true, nullable=false)
	private Integer pedId;

	//bi-directional many-to-one association to AutProducto
	@ManyToOne
	@JoinColumn(name="pro_id")
	private AutProducto autProducto;

	//bi-directional many-to-one association to AutSolicitud
	@ManyToOne
	@JoinColumn(name="sol_id")
	private AutSolicitud autSolicitud;

	public AutPedido() {
	}

	public Integer getPedId() {
		return this.pedId;
	}

	public void setPedId(Integer pedId) {
		this.pedId = pedId;
	}

	public AutProducto getAutProducto() {
		return this.autProducto;
	}

	public void setAutProducto(AutProducto autProducto) {
		this.autProducto = autProducto;
	}

	public AutSolicitud getAutSolicitud() {
		return this.autSolicitud;
	}

	public void setAutSolicitud(AutSolicitud autSolicitud) {
		this.autSolicitud = autSolicitud;
	}

}