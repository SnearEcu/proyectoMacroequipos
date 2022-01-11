package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mac_fab_mat database table.
 * 
 */
@Entity
@Table(name="mac_fab_mat")
@NamedQuery(name="MacFabMat.findAll", query="SELECT m FROM MacFabMat m")
public class MacFabMat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fab_mat_id", unique=true, nullable=false)
	private Integer fabMatId;

	@Column(name="fab_mat_cantidad", nullable=false)
	private Integer fabMatCantidad;

	@Column(name="fab_mat_est", nullable=false)
	private Boolean fabMatEst;

	//bi-directional many-to-one association to MacFabricacion
	@ManyToOne
	@JoinColumn(name="fab_id", nullable=false)
	private MacFabricacion macFabricacion;

	//bi-directional many-to-one association to MacMateriale
	@ManyToOne
	@JoinColumn(name="mat_id", nullable=false)
	private MacMateriale macMateriale;

	public MacFabMat() {
	}

	public Integer getFabMatId() {
		return this.fabMatId;
	}

	public void setFabMatId(Integer fabMatId) {
		this.fabMatId = fabMatId;
	}

	public Integer getFabMatCantidad() {
		return this.fabMatCantidad;
	}

	public void setFabMatCantidad(Integer fabMatCantidad) {
		this.fabMatCantidad = fabMatCantidad;
	}

	public Boolean getFabMatEst() {
		return this.fabMatEst;
	}

	public void setFabMatEst(Boolean fabMatEst) {
		this.fabMatEst = fabMatEst;
	}

	public MacFabricacion getMacFabricacion() {
		return this.macFabricacion;
	}

	public void setMacFabricacion(MacFabricacion macFabricacion) {
		this.macFabricacion = macFabricacion;
	}

	public MacMateriale getMacMateriale() {
		return this.macMateriale;
	}

	public void setMacMateriale(MacMateriale macMateriale) {
		this.macMateriale = macMateriale;
	}

}