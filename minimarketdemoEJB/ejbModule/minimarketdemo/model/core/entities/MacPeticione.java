package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mac_peticiones database table.
 * 
 */
@Entity
@Table(name="mac_peticiones")
@NamedQuery(name="MacPeticione.findAll", query="SELECT m FROM MacPeticione m")
public class MacPeticione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pet_id", unique=true, nullable=false)
	private Integer petId;

	//bi-directional many-to-one association to MacDetalleFactura
	@ManyToOne
	@JoinColumn(name="det_fac_id", nullable=false)
	private MacDetalleFactura macDetalleFactura;

	//bi-directional many-to-one association to MacOrdenProduccion
	@ManyToOne
	@JoinColumn(name="ord_id", nullable=false)
	private MacOrdenProduccion macOrdenProduccion;

	public MacPeticione() {
	}

	public Integer getPetId() {
		return this.petId;
	}

	public void setPetId(Integer petId) {
		this.petId = petId;
	}

	public MacDetalleFactura getMacDetalleFactura() {
		return this.macDetalleFactura;
	}

	public void setMacDetalleFactura(MacDetalleFactura macDetalleFactura) {
		this.macDetalleFactura = macDetalleFactura;
	}

	public MacOrdenProduccion getMacOrdenProduccion() {
		return this.macOrdenProduccion;
	}

	public void setMacOrdenProduccion(MacOrdenProduccion macOrdenProduccion) {
		this.macOrdenProduccion = macOrdenProduccion;
	}

}