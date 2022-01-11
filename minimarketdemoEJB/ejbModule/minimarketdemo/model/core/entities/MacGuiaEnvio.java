package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mac_guia_envio database table.
 * 
 */
@Entity
@Table(name="mac_guia_envio")
@NamedQuery(name="MacGuiaEnvio.findAll", query="SELECT m FROM MacGuiaEnvio m")
public class MacGuiaEnvio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="gui_id", unique=true, nullable=false)
	private Integer guiId;

	@Column(nullable=false, length=2147483647)
	private String descripcion;

	@Column(nullable=false)
	private Boolean est;

	@Column(nullable=false, length=2147483647)
	private String estado;

	@Column(nullable=false, length=2147483647)
	private String fechaentrega;

	@Column(nullable=false, length=2147483647)
	private String fechasalida;

	@Column(name="gui_destino", nullable=false, length=2147483647)
	private String guiDestino;

	//bi-directional many-to-one association to MacFactura
	@ManyToOne
	@JoinColumn(name="fac_id", nullable=false)
	private MacFactura macFactura;

	public MacGuiaEnvio() {
	}

	public Integer getGuiId() {
		return this.guiId;
	}

	public void setGuiId(Integer guiId) {
		this.guiId = guiId;
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

	public String getFechaentrega() {
		return this.fechaentrega;
	}

	public void setFechaentrega(String fechaentrega) {
		this.fechaentrega = fechaentrega;
	}

	public String getFechasalida() {
		return this.fechasalida;
	}

	public void setFechasalida(String fechasalida) {
		this.fechasalida = fechasalida;
	}

	public String getGuiDestino() {
		return this.guiDestino;
	}

	public void setGuiDestino(String guiDestino) {
		this.guiDestino = guiDestino;
	}

	public MacFactura getMacFactura() {
		return this.macFactura;
	}

	public void setMacFactura(MacFactura macFactura) {
		this.macFactura = macFactura;
	}

}