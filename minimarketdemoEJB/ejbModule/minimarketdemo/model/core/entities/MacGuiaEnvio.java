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

	@Column(name="gui_descripcion", nullable=false, length=2147483647)
	private String guiDescripcion;

	@Column(name="gui_destino", nullable=false, length=2147483647)
	private String guiDestino;

	@Column(name="gui_est", nullable=false)
	private Boolean guiEst;

	@Column(name="gui_estado", nullable=false, length=2147483647)
	private String guiEstado;

	@Column(name="gui_fechaentrega", nullable=false, length=2147483647)
	private String guiFechaentrega;

	@Column(name="gui_fechasalida", nullable=false, length=2147483647)
	private String guiFechasalida;

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

	public String getGuiDescripcion() {
		return this.guiDescripcion;
	}

	public void setGuiDescripcion(String guiDescripcion) {
		this.guiDescripcion = guiDescripcion;
	}

	public String getGuiDestino() {
		return this.guiDestino;
	}

	public void setGuiDestino(String guiDestino) {
		this.guiDestino = guiDestino;
	}

	public Boolean getGuiEst() {
		return this.guiEst;
	}

	public void setGuiEst(Boolean guiEst) {
		this.guiEst = guiEst;
	}

	public String getGuiEstado() {
		return this.guiEstado;
	}

	public void setGuiEstado(String guiEstado) {
		this.guiEstado = guiEstado;
	}

	public String getGuiFechaentrega() {
		return this.guiFechaentrega;
	}

	public void setGuiFechaentrega(String guiFechaentrega) {
		this.guiFechaentrega = guiFechaentrega;
	}

	public String getGuiFechasalida() {
		return this.guiFechasalida;
	}

	public void setGuiFechasalida(String guiFechasalida) {
		this.guiFechasalida = guiFechasalida;
	}

	public MacFactura getMacFactura() {
		return this.macFactura;
	}

	public void setMacFactura(MacFactura macFactura) {
		this.macFactura = macFactura;
	}

}