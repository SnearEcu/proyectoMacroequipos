package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the mac_orden_produccion database table.
 * 
 */
@Entity
@Table(name="mac_orden_produccion")
@NamedQuery(name="MacOrdenProduccion.findAll", query="SELECT m FROM MacOrdenProduccion m")
public class MacOrdenProduccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ord_id", unique=true, nullable=false, length=2147483647)
	private String ordId;

	@Column(length=2147483647)
	private String descripcion;

	@Column(nullable=false, length=2147483647)
	private String est;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date fechafin;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date fechaincio;

	public MacOrdenProduccion() {
	}

	public String getOrdId() {
		return this.ordId;
	}

	public void setOrdId(String ordId) {
		this.ordId = ordId;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEst() {
		return this.est;
	}

	public void setEst(String est) {
		this.est = est;
	}

	public Date getFechafin() {
		return this.fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public Date getFechaincio() {
		return this.fechaincio;
	}

	public void setFechaincio(Date fechaincio) {
		this.fechaincio = fechaincio;
	}

}