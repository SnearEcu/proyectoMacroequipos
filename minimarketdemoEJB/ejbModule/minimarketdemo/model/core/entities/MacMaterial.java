package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mac_material database table.
 * 
 */
@Entity
@Table(name="mac_material")
@NamedQuery(name="MacMaterial.findAll", query="SELECT m FROM MacMaterial m")
public class MacMaterial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mat_id", unique=true, nullable=false)
	private Integer matId;

	@Column(length=2147483647)
	private String descripcion;

	@Column(nullable=false)
	private Boolean est;

	@Column(nullable=false, length=2147483647)
	private String nombre;

	@Column(nullable=false)
	private Integer stock;

	//bi-directional many-to-one association to MacFabricacionMaterial
	@OneToMany(mappedBy="macMaterial")
	private List<MacFabricacionMaterial> macFabricacionMaterials;

	public MacMaterial() {
	}

	public Integer getMatId() {
		return this.matId;
	}

	public void setMatId(Integer matId) {
		this.matId = matId;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getEst() {
		return this.est;
	}

	public void setEst(Boolean est) {
		this.est = est;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getStock() {
		return this.stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public List<MacFabricacionMaterial> getMacFabricacionMaterials() {
		return this.macFabricacionMaterials;
	}

	public void setMacFabricacionMaterials(List<MacFabricacionMaterial> macFabricacionMaterials) {
		this.macFabricacionMaterials = macFabricacionMaterials;
	}

	public MacFabricacionMaterial addMacFabricacionMaterial(MacFabricacionMaterial macFabricacionMaterial) {
		getMacFabricacionMaterials().add(macFabricacionMaterial);
		macFabricacionMaterial.setMacMaterial(this);

		return macFabricacionMaterial;
	}

	public MacFabricacionMaterial removeMacFabricacionMaterial(MacFabricacionMaterial macFabricacionMaterial) {
		getMacFabricacionMaterials().remove(macFabricacionMaterial);
		macFabricacionMaterial.setMacMaterial(null);

		return macFabricacionMaterial;
	}

}