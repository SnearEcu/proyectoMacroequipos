package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the uni_cliente database table.
 * 
 */
@Entity
@Table(name="uni_cliente")
@NamedQuery(name="UniCliente.findAll", query="SELECT u FROM UniCliente u")
public class UniCliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cli_id", unique=true, nullable=false)
	private Integer cliId;

	@Column(name="cli_correo", nullable=false, length=2147483647)
	private String cliCorreo;

	@Column(name="cli_nombre", nullable=false, length=2147483647)
	private String cliNombre;

	//bi-directional many-to-one association to UniProforma
	@OneToMany(mappedBy="uniCliente")
	private List<UniProforma> uniProformas;

	//bi-directional many-to-one association to UniReclamo
	@OneToMany(mappedBy="uniCliente")
	private List<UniReclamo> uniReclamos;

	public UniCliente() {
	}

	public Integer getCliId() {
		return this.cliId;
	}

	public void setCliId(Integer cliId) {
		this.cliId = cliId;
	}

	public String getCliCorreo() {
		return this.cliCorreo;
	}

	public void setCliCorreo(String cliCorreo) {
		this.cliCorreo = cliCorreo;
	}

	public String getCliNombre() {
		return this.cliNombre;
	}

	public void setCliNombre(String cliNombre) {
		this.cliNombre = cliNombre;
	}

	public List<UniProforma> getUniProformas() {
		return this.uniProformas;
	}

	public void setUniProformas(List<UniProforma> uniProformas) {
		this.uniProformas = uniProformas;
	}

	public UniProforma addUniProforma(UniProforma uniProforma) {
		getUniProformas().add(uniProforma);
		uniProforma.setUniCliente(this);

		return uniProforma;
	}

	public UniProforma removeUniProforma(UniProforma uniProforma) {
		getUniProformas().remove(uniProforma);
		uniProforma.setUniCliente(null);

		return uniProforma;
	}

	public List<UniReclamo> getUniReclamos() {
		return this.uniReclamos;
	}

	public void setUniReclamos(List<UniReclamo> uniReclamos) {
		this.uniReclamos = uniReclamos;
	}

	public UniReclamo addUniReclamo(UniReclamo uniReclamo) {
		getUniReclamos().add(uniReclamo);
		uniReclamo.setUniCliente(this);

		return uniReclamo;
	}

	public UniReclamo removeUniReclamo(UniReclamo uniReclamo) {
		getUniReclamos().remove(uniReclamo);
		uniReclamo.setUniCliente(null);

		return uniReclamo;
	}

}