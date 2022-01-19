package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mac_detalle_factura database table.
 * 
 */
@Entity
@Table(name="mac_detalle_factura")
@NamedQuery(name="MacDetalleFactura.findAll", query="SELECT m FROM MacDetalleFactura m")
public class MacDetalleFactura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="det_fac_id")
	private Integer detFacId;

	private Integer cantidad;

	private Boolean est;

	//bi-directional many-to-one association to MacFactura
	@ManyToOne
	@JoinColumn(name="fac_id")
	private MacFactura macFactura;

	//bi-directional many-to-one association to MacProducto
	@ManyToOne
	@JoinColumn(name="pro_id")
	private MacProducto macProducto;

	//bi-directional many-to-one association to MacPeticione
	@OneToMany(mappedBy="macDetalleFactura")
	private List<MacPeticione> macPeticiones;

	public MacDetalleFactura() {
	}

	public Integer getDetFacId() {
		return this.detFacId;
	}

	public void setDetFacId(Integer detFacId) {
		this.detFacId = detFacId;
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

	public MacFactura getMacFactura() {
		return this.macFactura;
	}

	public void setMacFactura(MacFactura macFactura) {
		this.macFactura = macFactura;
	}

	public MacProducto getMacProducto() {
		return this.macProducto;
	}

	public void setMacProducto(MacProducto macProducto) {
		this.macProducto = macProducto;
	}

	public List<MacPeticione> getMacPeticiones() {
		return this.macPeticiones;
	}

	public void setMacPeticiones(List<MacPeticione> macPeticiones) {
		this.macPeticiones = macPeticiones;
	}

	public MacPeticione addMacPeticione(MacPeticione macPeticione) {
		getMacPeticiones().add(macPeticione);
		macPeticione.setMacDetalleFactura(this);

		return macPeticione;
	}

	public MacPeticione removeMacPeticione(MacPeticione macPeticione) {
		getMacPeticiones().remove(macPeticione);
		macPeticione.setMacDetalleFactura(null);

		return macPeticione;
	}

}