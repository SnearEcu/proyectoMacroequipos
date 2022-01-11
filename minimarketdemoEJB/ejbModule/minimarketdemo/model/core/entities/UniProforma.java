package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the uni_proformas database table.
 * 
 */
@Entity
@Table(name="uni_proformas")
@NamedQuery(name="UniProforma.findAll", query="SELECT u FROM UniProforma u")
public class UniProforma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pro_id", unique=true, nullable=false)
	private Integer proId;

	@Column(name="pro_estado", nullable=false, length=2147483647)
	private String proEstado;

	@Temporal(TemporalType.DATE)
	@Column(name="pro_fechaentrega")
	private Date proFechaentrega;

	@Column(name="pro_total", nullable=false)
	private double proTotal;

	//bi-directional many-to-one association to UniFabricacion
	@OneToMany(mappedBy="uniProforma")
	private List<UniFabricacion> uniFabricacions;

	//bi-directional many-to-one association to UniPedido
	@OneToMany(mappedBy="uniProforma")
	private List<UniPedido> uniPedidos;

	//bi-directional many-to-one association to UniCliente
	@ManyToOne
	@JoinColumn(name="cli_id")
	private UniCliente uniCliente;

	public UniProforma() {
	}

	public Integer getProId() {
		return this.proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
	}

	public String getProEstado() {
		return this.proEstado;
	}

	public void setProEstado(String proEstado) {
		this.proEstado = proEstado;
	}

	public Date getProFechaentrega() {
		return this.proFechaentrega;
	}

	public void setProFechaentrega(Date proFechaentrega) {
		this.proFechaentrega = proFechaentrega;
	}

	public double getProTotal() {
		return this.proTotal;
	}

	public void setProTotal(double proTotal) {
		this.proTotal = proTotal;
	}

	public List<UniFabricacion> getUniFabricacions() {
		return this.uniFabricacions;
	}

	public void setUniFabricacions(List<UniFabricacion> uniFabricacions) {
		this.uniFabricacions = uniFabricacions;
	}

	public UniFabricacion addUniFabricacion(UniFabricacion uniFabricacion) {
		getUniFabricacions().add(uniFabricacion);
		uniFabricacion.setUniProforma(this);

		return uniFabricacion;
	}

	public UniFabricacion removeUniFabricacion(UniFabricacion uniFabricacion) {
		getUniFabricacions().remove(uniFabricacion);
		uniFabricacion.setUniProforma(null);

		return uniFabricacion;
	}

	public List<UniPedido> getUniPedidos() {
		return this.uniPedidos;
	}

	public void setUniPedidos(List<UniPedido> uniPedidos) {
		this.uniPedidos = uniPedidos;
	}

	public UniPedido addUniPedido(UniPedido uniPedido) {
		getUniPedidos().add(uniPedido);
		uniPedido.setUniProforma(this);

		return uniPedido;
	}

	public UniPedido removeUniPedido(UniPedido uniPedido) {
		getUniPedidos().remove(uniPedido);
		uniPedido.setUniProforma(null);

		return uniPedido;
	}

	public UniCliente getUniCliente() {
		return this.uniCliente;
	}

	public void setUniCliente(UniCliente uniCliente) {
		this.uniCliente = uniCliente;
	}

}