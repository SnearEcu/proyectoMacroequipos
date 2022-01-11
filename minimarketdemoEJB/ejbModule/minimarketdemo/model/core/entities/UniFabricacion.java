package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the uni_fabricacion database table.
 * 
 */
@Entity
@Table(name="uni_fabricacion")
@NamedQuery(name="UniFabricacion.findAll", query="SELECT u FROM UniFabricacion u")
public class UniFabricacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fab_id", unique=true, nullable=false)
	private Integer fabId;

	@Column(name="fab_bono", nullable=false)
	private Boolean fabBono;

	@Column(name="fab_calidad", nullable=false)
	private Boolean fabCalidad;

	@Temporal(TemporalType.DATE)
	@Column(name="fab_fechafin", nullable=false)
	private Date fabFechafin;

	@Temporal(TemporalType.DATE)
	@Column(name="fab_fechainicio", nullable=false)
	private Date fabFechainicio;

	//bi-directional many-to-one association to UniProforma
	@ManyToOne
	@JoinColumn(name="pro_id")
	private UniProforma uniProforma;

	public UniFabricacion() {
	}

	public Integer getFabId() {
		return this.fabId;
	}

	public void setFabId(Integer fabId) {
		this.fabId = fabId;
	}

	public Boolean getFabBono() {
		return this.fabBono;
	}

	public void setFabBono(Boolean fabBono) {
		this.fabBono = fabBono;
	}

	public Boolean getFabCalidad() {
		return this.fabCalidad;
	}

	public void setFabCalidad(Boolean fabCalidad) {
		this.fabCalidad = fabCalidad;
	}

	public Date getFabFechafin() {
		return this.fabFechafin;
	}

	public void setFabFechafin(Date fabFechafin) {
		this.fabFechafin = fabFechafin;
	}

	public Date getFabFechainicio() {
		return this.fabFechainicio;
	}

	public void setFabFechainicio(Date fabFechainicio) {
		this.fabFechainicio = fabFechainicio;
	}

	public UniProforma getUniProforma() {
		return this.uniProforma;
	}

	public void setUniProforma(UniProforma uniProforma) {
		this.uniProforma = uniProforma;
	}

}