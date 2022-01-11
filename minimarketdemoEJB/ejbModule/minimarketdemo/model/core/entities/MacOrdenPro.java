package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the mac_orden_pro database table.
 * 
 */
@Entity
@Table(name="mac_orden_pro")
@NamedQuery(name="MacOrdenPro.findAll", query="SELECT m FROM MacOrdenPro m")
public class MacOrdenPro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ord_id", unique=true, nullable=false, length=2147483647)
	private String ordId;

	@Column(name="ord_descripcion", length=2147483647)
	private String ordDescripcion;

	@Column(name="ord_est", nullable=false, length=2147483647)
	private String ordEst;

	@Temporal(TemporalType.DATE)
	@Column(name="ord_fechafin", nullable=false)
	private Date ordFechafin;

	@Temporal(TemporalType.DATE)
	@Column(name="ord_fechaincio", nullable=false)
	private Date ordFechaincio;

	//bi-directional many-to-one association to MacDetFac
	@OneToMany(mappedBy="macOrdenPro")
	private List<MacDetFac> macDetFacs;

	public MacOrdenPro() {
	}

	public String getOrdId() {
		return this.ordId;
	}

	public void setOrdId(String ordId) {
		this.ordId = ordId;
	}

	public String getOrdDescripcion() {
		return this.ordDescripcion;
	}

	public void setOrdDescripcion(String ordDescripcion) {
		this.ordDescripcion = ordDescripcion;
	}

	public String getOrdEst() {
		return this.ordEst;
	}

	public void setOrdEst(String ordEst) {
		this.ordEst = ordEst;
	}

	public Date getOrdFechafin() {
		return this.ordFechafin;
	}

	public void setOrdFechafin(Date ordFechafin) {
		this.ordFechafin = ordFechafin;
	}

	public Date getOrdFechaincio() {
		return this.ordFechaincio;
	}

	public void setOrdFechaincio(Date ordFechaincio) {
		this.ordFechaincio = ordFechaincio;
	}

	public List<MacDetFac> getMacDetFacs() {
		return this.macDetFacs;
	}

	public void setMacDetFacs(List<MacDetFac> macDetFacs) {
		this.macDetFacs = macDetFacs;
	}

	public MacDetFac addMacDetFac(MacDetFac macDetFac) {
		getMacDetFacs().add(macDetFac);
		macDetFac.setMacOrdenPro(this);

		return macDetFac;
	}

	public MacDetFac removeMacDetFac(MacDetFac macDetFac) {
		getMacDetFacs().remove(macDetFac);
		macDetFac.setMacOrdenPro(null);

		return macDetFac;
	}

}