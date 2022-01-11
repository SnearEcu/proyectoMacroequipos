package minimarketdemo.controller.automoviles;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import minimarketdemo.controller.JSFUtil;
import minimarketdemo.model.automovilesmanagers.ManagerAutomoviles;
import minimarketdemo.model.core.entities.AutPedido;
import minimarketdemo.model.core.entities.AutProducto;
import minimarketdemo.model.core.entities.AutSolicitud;
import minimarketdemo.model.core.entities.UniProforma;

@Named
@SessionScoped
public class BeanAutVendedor implements Serializable {

	@EJB
	private ManagerAutomoviles mAutomoviles;
	private List<AutSolicitud> listaSolicitudes;
	private List<AutProducto> listaProductos;
	private List<AutPedido> listaPedidos;
	private AutSolicitud nuevaSolicitud;
	private AutPedido nuevoPedido;
	private int productoSeleccionado;
	private int solicitudSeleccionada;
	private String[] estado = {"Solicitado","Aprobado"};
	
	
	public BeanAutVendedor() {
		// TODO Auto-generated constructor stub
	}
	
	//Metodos para el vendedor
		//Solicitues
	@PostConstruct
	public void inicializar() {
		listaSolicitudes = mAutomoviles.findAllSolicitudes();
	}
	
	
	public String actionPedido() {
		nuevoPedido = mAutomoviles.inicializarPedido();
		listaProductos = mAutomoviles.findAllProductos();
		listaPedidos = mAutomoviles.findAllPedidos();
		nuevaSolicitud = mAutomoviles.inicializarSolicitud();
		return "pedido";
	}
	public void actionListenerInsertarPedido() {

			try {
				nuevoPedido.setAutProducto(listaProductos.get(productoSeleccionado-1));
				nuevoPedido.setAutSolicitud(nuevaSolicitud);
				mAutomoviles.insertarSolicitud(nuevaSolicitud);
				mAutomoviles.insertarPedido(nuevoPedido);
				listaPedidos = mAutomoviles.findAllPedidos();
				JSFUtil.crearMensajeINFO("Proforma Creada");
			} catch (Exception e) {
				e.printStackTrace();
			};
	}
	
	public void actionListenerActualizarSolicitud(AutSolicitud solicitud) {
		try {
			mAutomoviles.actualizarEstado(solicitud);
			JSFUtil.crearMensajeINFO("Estado actualizado");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}

	public List<AutSolicitud> getListaSolicitudes() {
		return listaSolicitudes;
	}

	public void setListaSolicitudes(List<AutSolicitud> listaSolicitudes) {
		this.listaSolicitudes = listaSolicitudes;
	}

	public AutSolicitud getNuevaSolicitud() {
		return nuevaSolicitud;
	}

	public void setNuevaSolicitud(AutSolicitud nuevaSolicitud) {
		this.nuevaSolicitud = nuevaSolicitud;
	}

	public AutPedido getNuevoPedido() {
		return nuevoPedido;
	}

	public void setNuevoPedido(AutPedido nuevoPedido) {
		this.nuevoPedido = nuevoPedido;
	}

	public String[] getEstado() {
		return estado;
	}

	public void setEstado(String[] estado) {
		this.estado = estado;
	}

	public List<AutProducto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<AutProducto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public List<AutPedido> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<AutPedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	public int getProductoSeleccionado() {
		return productoSeleccionado;
	}

	public void setProductoSeleccionado(int productoSeleccionado) {
		this.productoSeleccionado = productoSeleccionado;
	}

	public int getSolicitudSeleccionada() {
		return solicitudSeleccionada;
	}

	public void setSolicitudSeleccionada(int solicitudSeleccionada) {
		this.solicitudSeleccionada = solicitudSeleccionada;
	}

	
	
}
