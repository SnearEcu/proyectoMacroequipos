package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mac_producto database table.
 * 
 */
@Entity
@Table(name="mac_producto")
@NamedQuery(name="MacProducto.findAll", query="SELECT m FROM MacProducto m")
public class MacProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pro_id", unique=true, nullable=false)
	private Integer proId;

	@Column(name="pro_descripcion", nullable=false, length=2147483647)
	private String proDescripcion;

	@Column(name="pro_est", nullable=false)
	private Boolean proEst;

	@Column(name="pro_nombre", nullable=false, length=2147483647)
	private String proNombre;

	@Column(name="pro_precioventa", nullable=false, length=2147483647)
	private String proPrecioventa;

	@Column(name="pro_stock", nullable=false)
	private Integer proStock;

	//bi-directional many-to-one association to MacDetFac
	@OneToMany(mappedBy="macProducto")
	private List<MacDetFac> macDetFacs;

	//bi-directional many-to-one association to MacFabricacion
	@OneToMany(mappedBy="macProducto")
	private List<MacFabricacion> macFabricacions;

	public MacProducto() {
	}

	public Integer getProId() {
		return this.proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
	}

	public String getProDescripcion() {
		return this.proDescripcion;
	}

	public void setProDescripcion(String proDescripcion) {
		this.proDescripcion = proDescripcion;
	}

	public Boolean getProEst() {
		return this.proEst;
	}

	public void setProEst(Boolean proEst) {
		this.proEst = proEst;
	}

	public String getProNombre() {
		return this.proNombre;
	}

	public void setProNombre(String proNombre) {
		this.proNombre = proNombre;
	}

	public String getProPrecioventa() {
		return this.proPrecioventa;
	}

	public void setProPrecioventa(String proPrecioventa) {
		this.proPrecioventa = proPrecioventa;
	}

	public Integer getProStock() {
		return this.proStock;
	}

	public void setProStock(Integer proStock) {
		this.proStock = proStock;
	}

	public List<MacDetFac> getMacDetFacs() {
		return this.macDetFacs;
	}

	public void setMacDetFacs(List<MacDetFac> macDetFacs) {
		this.macDetFacs = macDetFacs;
	}

	public MacDetFac addMacDetFac(MacDetFac macDetFac) {
		getMacDetFacs().add(macDetFac);
		macDetFac.setMacProducto(this);

		return macDetFac;
	}

	public MacDetFac removeMacDetFac(MacDetFac macDetFac) {
		getMacDetFacs().remove(macDetFac);
		macDetFac.setMacProducto(null);

		return macDetFac;
	}

	public List<MacFabricacion> getMacFabricacions() {
		return this.macFabricacions;
	}

	public void setMacFabricacions(List<MacFabricacion> macFabricacions) {
		this.macFabricacions = macFabricacions;
	}

	public MacFabricacion addMacFabricacion(MacFabricacion macFabricacion) {
		getMacFabricacions().add(macFabricacion);
		macFabricacion.setMacProducto(this);

		return macFabricacion;
	}

	public MacFabricacion removeMacFabricacion(MacFabricacion macFabricacion) {
		getMacFabricacions().remove(macFabricacion);
		macFabricacion.setMacProducto(null);

		return macFabricacion;
	}

}