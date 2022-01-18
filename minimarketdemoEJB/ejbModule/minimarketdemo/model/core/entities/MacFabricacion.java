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

	@Column(nullable=false)
	private Boolean calidad;

	@Column(nullable=false)
	private Boolean est;

	@Column(nullable=false, length=2147483647)
	private String estado;

	//bi-directional many-to-one association to MacOrdenProduccion
	@ManyToOne
	@JoinColumn(name="ord_id", nullable=false)
	private MacOrdenProduccion macOrdenProduccion;

	//bi-directional many-to-one association to MacFabricacionMaterial
	@OneToMany(mappedBy="macFabricacion", fetch=FetchType.EAGER)
	private List<MacFabricacionMaterial> macFabricacionMaterials;

	public MacFabricacion() {
	}

	public Integer getFabId() {
		return this.fabId;
	}

	public void setFabId(Integer fabId) {
		this.fabId = fabId;
	}

	public Boolean getCalidad() {
		return this.calidad;
	}

	public void setCalidad(Boolean calidad) {
		this.calidad = calidad;
	}

	public Boolean getEst() {
		return this.est;
	}

	public void setEst(Boolean est) {
		this.est = est;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public MacOrdenProduccion getMacOrdenProduccion() {
		return this.macOrdenProduccion;
	}

	public void setMacOrdenProduccion(MacOrdenProduccion macOrdenProduccion) {
		this.macOrdenProduccion = macOrdenProduccion;
	}

	public List<MacFabricacionMaterial> getMacFabricacionMaterials() {
		return this.macFabricacionMaterials;
	}

	public void setMacFabricacionMaterials(List<MacFabricacionMaterial> macFabricacionMaterials) {
		this.macFabricacionMaterials = macFabricacionMaterials;
	}

	public MacFabricacionMaterial addMacFabricacionMaterial(MacFabricacionMaterial macFabricacionMaterial) {
		getMacFabricacionMaterials().add(macFabricacionMaterial);
		macFabricacionMaterial.setMacFabricacion(this);

		return macFabricacionMaterial;
	}

	public MacFabricacionMaterial removeMacFabricacionMaterial(MacFabricacionMaterial macFabricacionMaterial) {
		getMacFabricacionMaterials().remove(macFabricacionMaterial);
		macFabricacionMaterial.setMacFabricacion(null);

		return macFabricacionMaterial;
	}

}