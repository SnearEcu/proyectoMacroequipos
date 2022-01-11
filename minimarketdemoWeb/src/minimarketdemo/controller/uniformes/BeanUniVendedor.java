package minimarketdemo.controller.uniformes;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import minimarketdemo.controller.JSFUtil;
import minimarketdemo.model.core.entities.PryProyecto;
import minimarketdemo.model.core.entities.UniCliente;
import minimarketdemo.model.core.entities.UniPedido;
import minimarketdemo.model.core.entities.UniPrenda;
import minimarketdemo.model.core.entities.UniProforma;
import minimarketdemo.model.uniformes.managers.ManagerUniformes;

@Named
@SessionScoped
public class BeanUniVendedor implements Serializable {

	@EJB
	private ManagerUniformes mUniformes;
	private List<UniProforma> listaProformas;
	private UniProforma nuevaProforma;
	private List<UniCliente> listaClientes;
	private List<UniPedido> listaPedidos;
	private UniPedido nuevoPedido;
	private List<UniPrenda> listaPrendas;
	private int prendaSeleccionada;
	private int clienteSeleccionado;
	
	private String[] estado = {"abonado","pagado","entregado"};
	
	public BeanUniVendedor() {
	}
	@PostConstruct
	public void inicializar() {
		listaProformas = mUniformes.findAllProformas();
	}
	
	
	//Metodos para proforma
	public String actionCargarPedido() {
		listaClientes=mUniformes.findAllClientes();
		listaPrendas=mUniformes.findAllPrendas();
		nuevaProforma = mUniformes.inicializarProforma();
		nuevoPedido = mUniformes.inicializarPedido();
		return "pedido";
	}
	
	public void actionListenerInsertarPedido() {
		try {
			boolean existeProforma = false;
			nuevoPedido.setUniPrenda(listaPrendas.get(clienteSeleccionado-1));
			nuevaProforma.setUniCliente(listaClientes.get(clienteSeleccionado-1));
			double totalpedido= nuevoPedido.getCantidad()*nuevoPedido.getUniPrenda().getPrecio();
			double totalproforma = nuevaProforma.getProTotal();
			totalproforma=totalproforma+totalpedido;
			nuevoPedido.setUniProforma(nuevaProforma);

			nuevoPedido.setTotal(totalpedido);
			nuevaProforma.setProTotal(totalproforma);
			if (existeProforma) {
				mUniformes.actualizarEstado(nuevaProforma);
			} else {
				mUniformes.insertarProforma(nuevaProforma);
			}
			mUniformes.insertarPedido(nuevoPedido);
			JSFUtil.crearMensajeINFO("Proforma Creada");
			listaPedidos = mUniformes.findPedidosByProforma(nuevaProforma.getProId());
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	

	
	public void actionListenerActualizarEstado(UniProforma proforma) {
		try {
			mUniformes.actualizarEstado(proforma);
			JSFUtil.crearMensajeINFO("Estado actualizado");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}

	public List<UniProforma> getListaProformas() {
		return listaProformas;
	}

	public void setListaProformas(List<UniProforma> listaProformas) {
		this.listaProformas = listaProformas;
	}

	public UniProforma getNuevaProforma() {
		return nuevaProforma;
	}

	public void setNuevaProforma(UniProforma nuevaProforma) {
		this.nuevaProforma = nuevaProforma;
	}

	public List<UniCliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<UniCliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public String[] getEstado() {
		return estado;
	}

	public void setEstado(String[] estado) {
		this.estado = estado;
	}
	public List<UniPedido> getListaPedidos() {
		return listaPedidos;
	}
	public void setListaPedidos(List<UniPedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}
	public List<UniPrenda> getListaPrendas() {
		return listaPrendas;
	}
	public void setListaPrendas(List<UniPrenda> listaPrendas) {
		this.listaPrendas = listaPrendas;
	}
	public UniPedido getNuevoPedido() {
		return nuevoPedido;
	}
	public void setNuevoPedido(UniPedido nuevoPedido) {
		this.nuevoPedido = nuevoPedido;
	}
	public int getPrendaSeleccionada() {
		return prendaSeleccionada;
	}
	public void setPrendaSeleccionada(int prendaSeleccionada) {
		this.prendaSeleccionada = prendaSeleccionada;
	}
	public int getClienteSeleccionado() {
		return clienteSeleccionado;
	}
	public void setClienteSeleccionado(int clienteSeleccionado) {
		this.clienteSeleccionado = clienteSeleccionado;
	}

	
	
	//Metodos para cliente
	
	//Metodos para Uniforme

}
