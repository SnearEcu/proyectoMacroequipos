package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the uni_reclamo database table.
 * 
 */
@Entity
@Table(name="uni_reclamo")
@NamedQuery(name="UniReclamo.findAll", query="SELECT u FROM UniReclamo u")
public class UniReclamo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rec_id", unique=true, nullable=false)
	private Integer recId;

	@Column(name="rec_descripcion", nullable=false, length=2147483647)
	private String recDescripcion;

	//bi-directional many-to-one association to UniCliente
	@ManyToOne
	@JoinColumn(name="cli_id")
	private UniCliente uniCliente;

	public UniReclamo() {
	}

	public Integer getRecId() {
		return this.recId;
	}

	public void setRecId(Integer recId) {
		this.recId = recId;
	}

	public String getRecDescripcion() {
		return this.recDescripcion;
	}

	public void setRecDescripcion(String recDescripcion) {
		this.recDescripcion = recDescripcion;
	}

	public UniCliente getUniCliente() {
		return this.uniCliente;
	}

	public void setUniCliente(UniCliente uniCliente) {
		this.uniCliente = uniCliente;
	}

}