package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the mac_factura database table.
 * 
 */
@Entity
@Table(name="mac_factura")
@NamedQuery(name="MacFactura.findAll", query="SELECT m FROM MacFactura m")
public class MacFactura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="fac_id")
	private Integer facId;

	private double anticipo;

	private Boolean est;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private Integer total;

	//bi-directional many-to-one association to MacDetalleFactura
	@OneToMany(mappedBy="macFactura")
	private List<MacDetalleFactura> macDetalleFacturas;

	//bi-directional many-to-one association to MacCliente
	@ManyToOne
	@JoinColumn(name="cli_id")
	private MacCliente macCliente;

	//bi-directional many-to-one association to MacOpcPago
	@ManyToOne
	@JoinColumn(name="opc_pago_id")
	private MacOpcPago macOpcPago;

	//bi-directional many-to-one association to MacGuiaEnvio
	@OneToMany(mappedBy="macFactura")
	private List<MacGuiaEnvio> macGuiaEnvios;

	public MacFactura() {
	}

	public Integer getFacId() {
		return this.facId;
	}

	public void setFacId(Integer facId) {
		this.facId = facId;
	}

	public double getAnticipo() {
		return this.anticipo;
	}

	public void setAnticipo(double anticipo) {
		this.anticipo = anticipo;
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

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getTotal() {
		return this.total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<MacDetalleFactura> getMacDetalleFacturas() {
		return this.macDetalleFacturas;
	}

	public void setMacDetalleFacturas(List<MacDetalleFactura> macDetalleFacturas) {
		this.macDetalleFacturas = macDetalleFacturas;
	}

	public MacDetalleFactura addMacDetalleFactura(MacDetalleFactura macDetalleFactura) {
		getMacDetalleFacturas().add(macDetalleFactura);
		macDetalleFactura.setMacFactura(this);

		return macDetalleFactura;
	}

	public MacDetalleFactura removeMacDetalleFactura(MacDetalleFactura macDetalleFactura) {
		getMacDetalleFacturas().remove(macDetalleFactura);
		macDetalleFactura.setMacFactura(null);

		return macDetalleFactura;
	}

	public MacCliente getMacCliente() {
		return this.macCliente;
	}

	public void setMacCliente(MacCliente macCliente) {
		this.macCliente = macCliente;
	}

	public MacOpcPago getMacOpcPago() {
		return this.macOpcPago;
	}

	public void setMacOpcPago(MacOpcPago macOpcPago) {
		this.macOpcPago = macOpcPago;
	}

	public List<MacGuiaEnvio> getMacGuiaEnvios() {
		return this.macGuiaEnvios;
	}

	public void setMacGuiaEnvios(List<MacGuiaEnvio> macGuiaEnvios) {
		this.macGuiaEnvios = macGuiaEnvios;
	}

	public MacGuiaEnvio addMacGuiaEnvio(MacGuiaEnvio macGuiaEnvio) {
		getMacGuiaEnvios().add(macGuiaEnvio);
		macGuiaEnvio.setMacFactura(this);

		return macGuiaEnvio;
	}

	public MacGuiaEnvio removeMacGuiaEnvio(MacGuiaEnvio macGuiaEnvio) {
		getMacGuiaEnvios().remove(macGuiaEnvio);
		macGuiaEnvio.setMacFactura(null);

		return macGuiaEnvio;
	}

}