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

	@Column(nullable=false, length=2147483647)
	private String apellido;

	@Column(nullable=false, length=2147483647)
	private String cedula;

	@Column(nullable=false, length=2147483647)
	private String ciudad;

	@Column(nullable=false, length=2147483647)
	private String direccion;

	@Column(nullable=false)
	private Boolean est;

	@Column(nullable=false, length=2147483647)
	private String nombre;

	@Column(nullable=false, length=2147483647)
	private String telefono;

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

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Boolean getEst() {
		return this.est;
	}

	public void setEst(Boolean est) {
		this.est = est;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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