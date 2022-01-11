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

	@Column(nullable=false, length=2147483647)
	private String descripcion;

	@Column(nullable=false)
	private Boolean est;

	@Column(nullable=false, length=2147483647)
	private String estado;

	@Column(nullable=false, length=2147483647)
	private String nombre;

	@Column(nullable=false, length=2147483647)
	private String precioventa;

	@Column(nullable=false)
	private Integer stock;

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

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecioventa() {
		return this.precioventa;
	}

	public void setPrecioventa(String precioventa) {
		this.precioventa = precioventa;
	}

	public Integer getStock() {
		return this.stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
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