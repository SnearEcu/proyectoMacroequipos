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

	@Column(nullable=false)
	private double precioventa;

	@Column(nullable=false)
	private Integer stock;

	//bi-directional many-to-one association to MacAbastecimiento
	@OneToMany(mappedBy="macProducto")
	private List<MacAbastecimiento> macAbastecimientos;

	//bi-directional many-to-one association to MacDetalleFactura
	@OneToMany(mappedBy="macProducto")
	private List<MacDetalleFactura> macDetalleFacturas;

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

	public double getPrecioventa() {
		return this.precioventa;
	}

	public void setPrecioventa(double precioventa) {
		this.precioventa = precioventa;
	}

	public Integer getStock() {
		return this.stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public List<MacAbastecimiento> getMacAbastecimientos() {
		return this.macAbastecimientos;
	}

	public void setMacAbastecimientos(List<MacAbastecimiento> macAbastecimientos) {
		this.macAbastecimientos = macAbastecimientos;
	}

	public MacAbastecimiento addMacAbastecimiento(MacAbastecimiento macAbastecimiento) {
		getMacAbastecimientos().add(macAbastecimiento);
		macAbastecimiento.setMacProducto(this);

		return macAbastecimiento;
	}

	public MacAbastecimiento removeMacAbastecimiento(MacAbastecimiento macAbastecimiento) {
		getMacAbastecimientos().remove(macAbastecimiento);
		macAbastecimiento.setMacProducto(null);

		return macAbastecimiento;
	}

	public List<MacDetalleFactura> getMacDetalleFacturas() {
		return this.macDetalleFacturas;
	}

	public void setMacDetalleFacturas(List<MacDetalleFactura> macDetalleFacturas) {
		this.macDetalleFacturas = macDetalleFacturas;
	}

	public MacDetalleFactura addMacDetalleFactura(MacDetalleFactura macDetalleFactura) {
		getMacDetalleFacturas().add(macDetalleFactura);
		macDetalleFactura.setMacProducto(this);

		return macDetalleFactura;
	}

	public MacDetalleFactura removeMacDetalleFactura(MacDetalleFactura macDetalleFactura) {
		getMacDetalleFacturas().remove(macDetalleFactura);
		macDetalleFactura.setMacProducto(null);

		return macDetalleFactura;
	}

}