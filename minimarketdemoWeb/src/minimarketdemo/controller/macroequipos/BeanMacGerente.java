package minimarketdemo.controller.macroequipos;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import minimarketdemo.controller.JSFUtil;
import minimarketdemo.controller.seguridades.BeanSegLogin;
import minimarketdemo.model.automovilesmanagers.ManagerAutomoviles;
import minimarketdemo.model.core.entities.AutPedido;
import minimarketdemo.model.core.entities.AutProducto;
import minimarketdemo.model.core.entities.AutSolicitud;
import minimarketdemo.model.core.entities.MacMaterial;
import minimarketdemo.model.core.entities.PryProyecto;
import minimarketdemo.model.core.entities.UniProforma;
import minimarketdemo.model.macroequipos.managers.ManagerMacroequipos;

@Named
@SessionScoped
public class BeanMacGerente implements Serializable {

	@EJB
	private ManagerMacroequipos mMacro;
	private List<MacMaterial> listaMateriales;
	private MacMaterial edicionMaterial;
	private MacMaterial nuevoMaterial;
	private int idseleccionado = 0;
	boolean redflag = false;

	public BeanMacGerente() {
		// TODO Auto-generated constructor stub
	}

	@Inject
	private BeanSegLogin beanSegLogin;

	// Metodos para el vendedor
	// Solicitues

	@PostConstruct
	public void inicializar() {
		listaMateriales = mMacro.findAllMacMaterials();
		nuevoMaterial = mMacro.inicializarMaterial();
	}

	public void actionListenerInsertarMaterial() {
		System.out.println("1 " + redflag);
		try {
			System.out.println("2 " + redflag);
			for (int i = 0; i < listaMateriales.size(); i++) {
				System.out.println("3 " + redflag);
				String nombre = listaMateriales.get(i).getNombre();
				System.out.println("4 " + redflag);
				if (nuevoMaterial.getNombre().equals(nombre)) {
					System.out.println("5 " + nuevoMaterial.getNombre() + " " + nombre +i);
					redflag = false;
				}else {
					redflag = true;
					System.out.println("6 " + redflag);
				}
				System.out.println("7 " + redflag);
			}
			System.out.println("8 " + redflag);
			if (redflag == true) {
				mMacro.insertarMaterial(nuevoMaterial);
				JSFUtil.crearMensajeINFO("Material creado");
				listaMateriales = mMacro.findAllMacMaterials();
				nuevoMaterial = mMacro.inicializarMaterial();
				} else {
					JSFUtil.crearMensajeWARN("Este material ya existe");
				}
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}

	public void actionListenerActualizarStockAumentar() {
		try {
			mMacro.actualizarStockAumentar(beanSegLogin.getLoginDTO(),edicionMaterial);
			listaMateriales = mMacro.findAllMacMaterials();
			nuevoMaterial = mMacro.inicializarMaterial();
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}
	public void actionListenerActualizarStockDisminuir() {
		try {
			mMacro.actualizarStockDisminuir(beanSegLogin.getLoginDTO(),edicionMaterial);
			listaMateriales = mMacro.findAllMacMaterials();
			nuevoMaterial = mMacro.inicializarMaterial();
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}

	public void actionListenerSeleccionarMaterial() throws Exception {
		edicionMaterial = mMacro.findByIdMacMaterials(idseleccionado);
	}

//	public String actionPedido() {
//		nuevoPedido = mAutomoviles.inicializarPedido();
//		listaProductos = mAutomoviles.findAllProductos();
//		listaPedidos = mAutomoviles.findAllPedidos();
//		nuevaSolicitud = mAutomoviles.inicializarSolicitud();
//		return "pedido";
//	}

//	
//	public void actionListenerActualizarSolicitud(AutSolicitud solicitud) {
//		try {
//			mAutomoviles.actualizarEstado(solicitud);
//			JSFUtil.crearMensajeINFO("Estado actualizado");
//		} catch (Exception e) {
//			JSFUtil.crearMensajeERROR(e.getMessage());
//			e.printStackTrace();
//		}
//	}

	public List<MacMaterial> getListaMateriales() {
		return listaMateriales;
	}

	public void setListaMateriales(List<MacMaterial> listaMateriales) {
		this.listaMateriales = listaMateriales;
	}

	public MacMaterial getEdicionMaterial() {
		return edicionMaterial;
	}

	public int getIdseleccionado() {
		return idseleccionado;
	}

	public void setIdseleccionado(int idseleccionado) {
		this.idseleccionado = idseleccionado;
	}

	public void setEdicionMaterial(MacMaterial edicionMaterial) {
		this.edicionMaterial = edicionMaterial;
	}

	public MacMaterial getNuevoMaterial() {
		return nuevoMaterial;
	}

	public void setNuevoMaterial(MacMaterial nuevoMaterial) {
		this.nuevoMaterial = nuevoMaterial;
	}

}
