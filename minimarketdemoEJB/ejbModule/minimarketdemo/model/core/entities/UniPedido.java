package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the uni_pedido database table.
 * 
 */
@Entity
@Table(name="uni_pedido")
@NamedQuery(name="UniPedido.findAll", query="SELECT u FROM UniPedido u")
public class UniPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="uni_id", unique=true, nullable=false)
	private Integer uniId;

	@Column(nullable=false)
	private Integer cantidad;

	@Column(nullable=false)
	private double total;

	//bi-directional many-to-one association to UniPrenda
	@ManyToOne
	@JoinColumn(name="pre_id")
	private UniPrenda uniPrenda;

	//bi-directional many-to-one association to UniProforma
	@ManyToOne
	@JoinColumn(name="pro_id")
	private UniProforma uniProforma;

	public UniPedido() {
	}

	public Integer getUniId() {
		return this.uniId;
	}

	public void setUniId(Integer uniId) {
		this.uniId = uniId;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public UniPrenda getUniPrenda() {
		return this.uniPrenda;
	}

	public void setUniPrenda(UniPrenda uniPrenda) {
		this.uniPrenda = uniPrenda;
	}

	public UniProforma getUniProforma() {
		return this.uniProforma;
	}

	public void setUniProforma(UniProforma uniProforma) {
		this.uniProforma = uniProforma;
	}

}