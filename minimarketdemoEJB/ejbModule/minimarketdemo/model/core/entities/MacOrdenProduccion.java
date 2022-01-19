package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the mac_orden_produccion database table.
 * 
 */
@Entity
@Table(name="mac_orden_produccion")
@NamedQuery(name="MacOrdenProduccion.findAll", query="SELECT m FROM MacOrdenProduccion m")
public class MacOrdenProduccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ord_id")
	private String ordId;

	private String descripcion;

	private String est;

	@Temporal(TemporalType.DATE)
	private Date fechafinal;

	@Temporal(TemporalType.DATE)
	private Date fechainicio;

	//bi-directional many-to-one association to MacAbastecimiento
	@OneToMany(mappedBy="macOrdenProduccion")
	private List<MacAbastecimiento> macAbastecimientos;

	//bi-directional many-to-one association to MacFabricacion
	@OneToMany(mappedBy="macOrdenProduccion")
	private List<MacFabricacion> macFabricacions;

	//bi-directional many-to-one association to MacPeticione
	@OneToMany(mappedBy="macOrdenProduccion")
	private List<MacPeticione> macPeticiones;

	public MacOrdenProduccion() {
	}

	public String getOrdId() {
		return this.ordId;
	}

	public void setOrdId(String ordId) {
		this.ordId = ordId;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEst() {
		return this.est;
	}

	public void setEst(String est) {
		this.est = est;
	}

	public Date getFechafinal() {
		return this.fechafinal;
	}

	public void setFechafinal(Date fechafinal) {
		this.fechafinal = fechafinal;
	}

	public Date getFechainicio() {
		return this.fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public List<MacAbastecimiento> getMacAbastecimientos() {
		return this.macAbastecimientos;
	}

	public void setMacAbastecimientos(List<MacAbastecimiento> macAbastecimientos) {
		this.macAbastecimientos = macAbastecimientos;
	}

	public MacAbastecimiento addMacAbastecimiento(MacAbastecimiento macAbastecimiento) {
		getMacAbastecimientos().add(macAbastecimiento);
		macAbastecimiento.setMacOrdenProduccion(this);

		return macAbastecimiento;
	}

	public MacAbastecimiento removeMacAbastecimiento(MacAbastecimiento macAbastecimiento) {
		getMacAbastecimientos().remove(macAbastecimiento);
		macAbastecimiento.setMacOrdenProduccion(null);

		return macAbastecimiento;
	}

	public List<MacFabricacion> getMacFabricacions() {
		return this.macFabricacions;
	}

	public void setMacFabricacions(List<MacFabricacion> macFabricacions) {
		this.macFabricacions = macFabricacions;
	}

	public MacFabricacion addMacFabricacion(MacFabricacion macFabricacion) {
		getMacFabricacions().add(macFabricacion);
		macFabricacion.setMacOrdenProduccion(this);

		return macFabricacion;
	}

	public MacFabricacion removeMacFabricacion(MacFabricacion macFabricacion) {
		getMacFabricacions().remove(macFabricacion);
		macFabricacion.setMacOrdenProduccion(null);

		return macFabricacion;
	}

	public List<MacPeticione> getMacPeticiones() {
		return this.macPeticiones;
	}

	public void setMacPeticiones(List<MacPeticione> macPeticiones) {
		this.macPeticiones = macPeticiones;
	}

	public MacPeticione addMacPeticione(MacPeticione macPeticione) {
		getMacPeticiones().add(macPeticione);
		macPeticione.setMacOrdenProduccion(this);

		return macPeticione;
	}

	public MacPeticione removeMacPeticione(MacPeticione macPeticione) {
		getMacPeticiones().remove(macPeticione);
		macPeticione.setMacOrdenProduccion(null);

		return macPeticione;
	}

}