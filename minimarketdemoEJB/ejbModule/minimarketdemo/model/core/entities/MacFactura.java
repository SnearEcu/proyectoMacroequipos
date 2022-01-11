package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fac_id", unique=true, nullable=false)
	private Integer facId;

	@Column(name="fac_anticipo", nullable=false)
	private double facAnticipo;

	@Column(name="fac_est", nullable=false)
	private Boolean facEst;

	@Column(name="fac_estado", nullable=false, length=2147483647)
	private String facEstado;

	@Column(name="fac_total", nullable=false)
	private Integer facTotal;

	//bi-directional many-to-one association to MacDetFac
	@OneToMany(mappedBy="macFactura")
	private List<MacDetFac> macDetFacs;

	//bi-directional many-to-one association to MacCliente
	@ManyToOne
	@JoinColumn(name="cli_id", nullable=false)
	private MacCliente macCliente;

	//bi-directional many-to-one association to MacOpcPago
	@ManyToOne
	@JoinColumn(name="opc_pago_id", nullable=false)
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

	public double getFacAnticipo() {
		return this.facAnticipo;
	}

	public void setFacAnticipo(double facAnticipo) {
		this.facAnticipo = facAnticipo;
	}

	public Boolean getFacEst() {
		return this.facEst;
	}

	public void setFacEst(Boolean facEst) {
		this.facEst = facEst;
	}

	public String getFacEstado() {
		return this.facEstado;
	}

	public void setFacEstado(String facEstado) {
		this.facEstado = facEstado;
	}

	public Integer getFacTotal() {
		return this.facTotal;
	}

	public void setFacTotal(Integer facTotal) {
		this.facTotal = facTotal;
	}

	public List<MacDetFac> getMacDetFacs() {
		return this.macDetFacs;
	}

	public void setMacDetFacs(List<MacDetFac> macDetFacs) {
		this.macDetFacs = macDetFacs;
	}

	public MacDetFac addMacDetFac(MacDetFac macDetFac) {
		getMacDetFacs().add(macDetFac);
		macDetFac.setMacFactura(this);

		return macDetFac;
	}

	public MacDetFac removeMacDetFac(MacDetFac macDetFac) {
		getMacDetFacs().remove(macDetFac);
		macDetFac.setMacFactura(null);

		return macDetFac;
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