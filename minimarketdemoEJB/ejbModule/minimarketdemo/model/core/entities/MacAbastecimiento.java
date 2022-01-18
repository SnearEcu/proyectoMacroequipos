package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mac_abastecimiento database table.
 * 
 */
@Entity
@Table(name="mac_abastecimiento")
@NamedQuery(name="MacAbastecimiento.findAll", query="SELECT m FROM MacAbastecimiento m")
public class MacAbastecimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="aba_id", unique=true, nullable=false)
	private Integer abaId;

	@Column(nullable=false)
	private Integer cantidad;

	@Column(nullable=false)
	private Boolean est;

	//bi-directional many-to-one association to MacOrdenProduccion
	@ManyToOne
	@JoinColumn(name="ord_id", nullable=false)
	private MacOrdenProduccion macOrdenProduccion;

	//bi-directional many-to-one association to MacProducto
	@ManyToOne
	@JoinColumn(name="pro_id", nullable=false)
	private MacProducto macProducto;

	public MacAbastecimiento() {
	}

	public Integer getAbaId() {
		return this.abaId;
	}

	public void setAbaId(Integer abaId) {
		this.abaId = abaId;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Boolean getEst() {
		return this.est;
	}

	public void setEst(Boolean est) {
		this.est = est;
	}

	public MacOrdenProduccion getMacOrdenProduccion() {
		return this.macOrdenProduccion;
	}

	public void setMacOrdenProduccion(MacOrdenProduccion macOrdenProduccion) {
		this.macOrdenProduccion = macOrdenProduccion;
	}

	public MacProducto getMacProducto() {
		return this.macProducto;
	}

	public void setMacProducto(MacProducto macProducto) {
		this.macProducto = macProducto;
	}

}