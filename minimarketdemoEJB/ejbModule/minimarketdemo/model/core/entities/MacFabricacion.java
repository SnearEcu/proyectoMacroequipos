package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mac_fabricacion database table.
 * 
 */
@Entity
@Table(name="mac_fabricacion")
@NamedQuery(name="MacFabricacion.findAll", query="SELECT m FROM MacFabricacion m")
public class MacFabricacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fab_id", unique=true, nullable=false)
	private Integer fabId;

	@Column(name="fab_calidad", nullable=false)
	private Boolean fabCalidad;

	@Column(name="fab_cantidad", nullable=false)
	private Integer fabCantidad;

	@Column(name="fab_est", nullable=false)
	private Boolean fabEst;

	@Column(name="fab_estado", nullable=false, length=2147483647)
	private String fabEstado;

	//bi-directional many-to-one association to MacFabMat
	@OneToMany(mappedBy="macFabricacion")
	private List<MacFabMat> macFabMats;

	//bi-directional many-to-one association to MacProducto
	@ManyToOne
	@JoinColumn(name="pro_id", nullable=false)
	private MacProducto macProducto;

	public MacFabricacion() {
	}

	public Integer getFabId() {
		return this.fabId;
	}

	public void setFabId(Integer fabId) {
		this.fabId = fabId;
	}

	public Boolean getFabCalidad() {
		return this.fabCalidad;
	}

	public void setFabCalidad(Boolean fabCalidad) {
		this.fabCalidad = fabCalidad;
	}

	public Integer getFabCantidad() {
		return this.fabCantidad;
	}

	public void setFabCantidad(Integer fabCantidad) {
		this.fabCantidad = fabCantidad;
	}

	public Boolean getFabEst() {
		return this.fabEst;
	}

	public void setFabEst(Boolean fabEst) {
		this.fabEst = fabEst;
	}

	public String getFabEstado() {
		return this.fabEstado;
	}

	public void setFabEstado(String fabEstado) {
		this.fabEstado = fabEstado;
	}

	public List<MacFabMat> getMacFabMats() {
		return this.macFabMats;
	}

	public void setMacFabMats(List<MacFabMat> macFabMats) {
		this.macFabMats = macFabMats;
	}

	public MacFabMat addMacFabMat(MacFabMat macFabMat) {
		getMacFabMats().add(macFabMat);
		macFabMat.setMacFabricacion(this);

		return macFabMat;
	}

	public MacFabMat removeMacFabMat(MacFabMat macFabMat) {
		getMacFabMats().remove(macFabMat);
		macFabMat.setMacFabricacion(null);

		return macFabMat;
	}

	public MacProducto getMacProducto() {
		return this.macProducto;
	}

	public void setMacProducto(MacProducto macProducto) {
		this.macProducto = macProducto;
	}

}