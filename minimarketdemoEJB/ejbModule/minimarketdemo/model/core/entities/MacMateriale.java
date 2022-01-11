package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mac_materiales database table.
 * 
 */
@Entity
@Table(name="mac_materiales")
@NamedQuery(name="MacMateriale.findAll", query="SELECT m FROM MacMateriale m")
public class MacMateriale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mat_id", unique=true, nullable=false)
	private Integer matId;

	@Column(name="mat_descripcion", nullable=false, length=2147483647)
	private String matDescripcion;

	@Column(name="mat_est", nullable=false)
	private Boolean matEst;

	@Column(name="mat_nombre", nullable=false, length=2147483647)
	private String matNombre;

	@Column(name="mat_stock", nullable=false, length=2147483647)
	private String matStock;

	//bi-directional many-to-one association to MacFabMat
	@OneToMany(mappedBy="macMateriale")
	private List<MacFabMat> macFabMats;

	public MacMateriale() {
	}

	public Integer getMatId() {
		return this.matId;
	}

	public void setMatId(Integer matId) {
		this.matId = matId;
	}

	public String getMatDescripcion() {
		return this.matDescripcion;
	}

	public void setMatDescripcion(String matDescripcion) {
		this.matDescripcion = matDescripcion;
	}

	public Boolean getMatEst() {
		return this.matEst;
	}

	public void setMatEst(Boolean matEst) {
		this.matEst = matEst;
	}

	public String getMatNombre() {
		return this.matNombre;
	}

	public void setMatNombre(String matNombre) {
		this.matNombre = matNombre;
	}

	public String getMatStock() {
		return this.matStock;
	}

	public void setMatStock(String matStock) {
		this.matStock = matStock;
	}

	public List<MacFabMat> getMacFabMats() {
		return this.macFabMats;
	}

	public void setMacFabMats(List<MacFabMat> macFabMats) {
		this.macFabMats = macFabMats;
	}

	public MacFabMat addMacFabMat(MacFabMat macFabMat) {
		getMacFabMats().add(macFabMat);
		macFabMat.setMacMateriale(this);

		return macFabMat;
	}

	public MacFabMat removeMacFabMat(MacFabMat macFabMat) {
		getMacFabMats().remove(macFabMat);
		macFabMat.setMacMateriale(null);

		return macFabMat;
	}

}