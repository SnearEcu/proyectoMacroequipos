package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mac_fabricacion_material database table.
 * 
 */
@Entity
@Table(name="mac_fabricacion_material")
@NamedQuery(name="MacFabricacionMaterial.findAll", query="SELECT m FROM MacFabricacionMaterial m")
public class MacFabricacionMaterial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fab_mat_id", unique=true, nullable=false)
	private Integer fabMatId;

	@Column(nullable=false)
	private Integer cantidad;

	@Column(nullable=false)
	private Boolean est;

	//bi-directional many-to-one association to MacFabricacion
	@ManyToOne
	@JoinColumn(name="fab_id", nullable=false)
	private MacFabricacion macFabricacion;

	//bi-directional many-to-one association to MacMaterial
	@ManyToOne
	@JoinColumn(name="mat_id", nullable=false)
	private MacMaterial macMaterial;

	public MacFabricacionMaterial() {
	}

	public Integer getFabMatId() {
		return this.fabMatId;
	}

	public void setFabMatId(Integer fabMatId) {
		this.fabMatId = fabMatId;
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

	public MacFabricacion getMacFabricacion() {
		return this.macFabricacion;
	}

	public void setMacFabricacion(MacFabricacion macFabricacion) {
		this.macFabricacion = macFabricacion;
	}

	public MacMaterial getMacMaterial() {
		return this.macMaterial;
	}

	public void setMacMaterial(MacMaterial macMaterial) {
		this.macMaterial = macMaterial;
	}

}