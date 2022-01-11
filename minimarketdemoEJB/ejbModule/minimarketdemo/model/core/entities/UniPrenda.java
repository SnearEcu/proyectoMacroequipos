package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the uni_prenda database table.
 * 
 */
@Entity
@Table(name="uni_prenda")
@NamedQuery(name="UniPrenda.findAll", query="SELECT u FROM UniPrenda u")
public class UniPrenda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pre_id", unique=true, nullable=false)
	private Integer preId;

	@Column(nullable=false, length=2147483647)
	private String modelo;

	@Column(nullable=false)
	private double precio;

	//bi-directional many-to-one association to UniPedido
	@OneToMany(mappedBy="uniPrenda")
	private List<UniPedido> uniPedidos;

	public UniPrenda() {
	}

	public Integer getPreId() {
		return this.preId;
	}

	public void setPreId(Integer preId) {
		this.preId = preId;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public List<UniPedido> getUniPedidos() {
		return this.uniPedidos;
	}

	public void setUniPedidos(List<UniPedido> uniPedidos) {
		this.uniPedidos = uniPedidos;
	}

	public UniPedido addUniPedido(UniPedido uniPedido) {
		getUniPedidos().add(uniPedido);
		uniPedido.setUniPrenda(this);

		return uniPedido;
	}

	public UniPedido removeUniPedido(UniPedido uniPedido) {
		getUniPedidos().remove(uniPedido);
		uniPedido.setUniPrenda(null);

		return uniPedido;
	}

}