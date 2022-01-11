package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mac_cliente database table.
 * 
 */
@Entity
@Table(name="mac_cliente")
@NamedQuery(name="MacCliente.findAll", query="SELECT m FROM MacCliente m")
public class MacCliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cli_id", unique=true, nullable=false)
	private Integer cliId;

	@Column(name="cli_apellido", nullable=false, length=2147483647)
	private String cliApellido;

	@Column(name="cli_ciudad", nullable=false, length=2147483647)
	private String cliCiudad;

	@Column(name="cli_direccion", nullable=false, length=2147483647)
	private String cliDireccion;

	@Column(name="cli_est", nullable=false)
	private Boolean cliEst;

	@Column(name="cli_nombre", nullable=false, length=2147483647)
	private String cliNombre;

	@Column(name="cli_telefono", nullable=false, length=2147483647)
	private String cliTelefono;

	//bi-directional many-to-one association to MacFactura
	@OneToMany(mappedBy="macCliente")
	private List<MacFactura> macFacturas;

	public MacCliente() {
	}

	public Integer getCliId() {
		return this.cliId;
	}

	public void setCliId(Integer cliId) {
		this.cliId = cliId;
	}

	public String getCliApellido() {
		return this.cliApellido;
	}

	public void setCliApellido(String cliApellido) {
		this.cliApellido = cliApellido;
	}

	public String getCliCiudad() {
		return this.cliCiudad;
	}

	public void setCliCiudad(String cliCiudad) {
		this.cliCiudad = cliCiudad;
	}

	public String getCliDireccion() {
		return this.cliDireccion;
	}

	public void setCliDireccion(String cliDireccion) {
		this.cliDireccion = cliDireccion;
	}

	public Boolean getCliEst() {
		return this.cliEst;
	}

	public void setCliEst(Boolean cliEst) {
		this.cliEst = cliEst;
	}

	public String getCliNombre() {
		return this.cliNombre;
	}

	public void setCliNombre(String cliNombre) {
		this.cliNombre = cliNombre;
	}

	public String getCliTelefono() {
		return this.cliTelefono;
	}

	public void setCliTelefono(String cliTelefono) {
		this.cliTelefono = cliTelefono;
	}

	public List<MacFactura> getMacFacturas() {
		return this.macFacturas;
	}

	public void setMacFacturas(List<MacFactura> macFacturas) {
		this.macFacturas = macFacturas;
	}

	public MacFactura addMacFactura(MacFactura macFactura) {
		getMacFacturas().add(macFactura);
		macFactura.setMacCliente(this);

		return macFactura;
	}

	public MacFactura removeMacFactura(MacFactura macFactura) {
		getMacFacturas().remove(macFactura);
		macFactura.setMacCliente(null);

		return macFactura;
	}

}