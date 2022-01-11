package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mac_det_fac database table.
 * 
 */
@Entity
@Table(name="mac_det_fac")
@NamedQuery(name="MacDetFac.findAll", query="SELECT m FROM MacDetFac m")
public class MacDetFac implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="det_fac_id", unique=true, nullable=false)
	private Integer detFacId;

	@Column(name="det_fac_cantidad", nullable=false, length=2147483647)
	private String detFacCantidad;

	@Column(name="det_fac_est", nullable=false)
	private Boolean detFacEst;

	//bi-directional many-to-one association to MacFactura
	@ManyToOne
	@JoinColumn(name="fac_id", nullable=false)
	private MacFactura macFactura;

	//bi-directional many-to-one association to MacOrdenPro
	@ManyToOne
	@JoinColumn(name="ord_id", nullable=false)
	private MacOrdenPro macOrdenPro;

	//bi-directional many-to-one association to MacProducto
	@ManyToOne
	@JoinColumn(name="pro_id", nullable=false)
	private MacProducto macProducto;

	public MacDetFac() {
	}

	public Integer getDetFacId() {
		return this.detFacId;
	}

	public void setDetFacId(Integer detFacId) {
		this.detFacId = detFacId;
	}

	public String getDetFacCantidad() {
		return this.detFacCantidad;
	}

	public void setDetFacCantidad(String detFacCantidad) {
		this.detFacCantidad = detFacCantidad;
	}

	public Boolean getDetFacEst() {
		return this.detFacEst;
	}

	public void setDetFacEst(Boolean detFacEst) {
		this.detFacEst = detFacEst;
	}

	public MacFactura getMacFactura() {
		return this.macFactura;
	}

	public void setMacFactura(MacFactura macFactura) {
		this.macFactura = macFactura;
	}

	public MacOrdenPro getMacOrdenPro() {
		return this.macOrdenPro;
	}

	public void setMacOrdenPro(MacOrdenPro macOrdenPro) {
		this.macOrdenPro = macOrdenPro;
	}

	public MacProducto getMacProducto() {
		return this.macProducto;
	}

	public void setMacProducto(MacProducto macProducto) {
		this.macProducto = macProducto;
	}

}