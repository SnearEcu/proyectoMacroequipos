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
	@Column(name="gui_id")
	private Integer guiId;

	private String descripcion;

	private Boolean est;

	private String estado;

	private String fechaentrega;

	private String fechasalida;

	@Column(name="gui_destino")
	private String guiDestino;

	//bi-directional many-to-one association to MacFactura
	@ManyToOne
	@JoinColumn(name="fac_id")
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