package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mac_opc_pago database table.
 * 
 */
@Entity
@Table(name="mac_opc_pago")
@NamedQuery(name="MacOpcPago.findAll", query="SELECT m FROM MacOpcPago m")
public class MacOpcPago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="opc_pago_id", unique=true, nullable=false)
	private Integer opcPagoId;

	@Column(name="opc_tipo", nullable=false, length=2147483647)
	private String opcTipo;

	//bi-directional many-to-one association to MacFactura
	@OneToMany(mappedBy="macOpcPago")
	private List<MacFactura> macFacturas;

	public MacOpcPago() {
	}

	public Integer getOpcPagoId() {
		return this.opcPagoId;
	}

	public void setOpcPagoId(Integer opcPagoId) {
		this.opcPagoId = opcPagoId;
	}

	public String getOpcTipo() {
		return this.opcTipo;
	}

	public void setOpcTipo(String opcTipo) {
		this.opcTipo = opcTipo;
	}

	public List<MacFactura> getMacFacturas() {
		return this.macFacturas;
	}

	public void setMacFacturas(List<MacFactura> macFacturas) {
		this.macFacturas = macFacturas;
	}

	public MacFactura addMacFactura(MacFactura macFactura) {
		getMacFacturas().add(macFactura);
		macFactura.setMacOpcPago(this);

		return macFactura;
	}

	public MacFactura removeMacFactura(MacFactura macFactura) {
		getMacFacturas().remove(macFactura);
		macFactura.setMacOpcPago(null);

		return macFactura;
	}

}