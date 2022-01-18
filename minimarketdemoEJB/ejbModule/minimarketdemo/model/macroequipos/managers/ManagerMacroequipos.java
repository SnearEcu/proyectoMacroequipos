package minimarketdemo.model.macroequipos.managers;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import minimarketdemo.controller.JSFUtil;
import minimarketdemo.model.auditoria.managers.ManagerAuditoria;
import minimarketdemo.model.core.entities.MacCliente;
import minimarketdemo.model.core.entities.MacMaterial;
import minimarketdemo.model.core.entities.MacOrdenProduccion;
import minimarketdemo.model.core.entities.MacProducto;
import minimarketdemo.model.core.entities.PryProyecto;
import minimarketdemo.model.core.entities.SegModulo;
import minimarketdemo.model.core.entities.SegUsuario;
import minimarketdemo.model.core.managers.ManagerDAO;
import minimarketdemo.model.core.utils.ModelUtil;
import minimarketdemo.model.seguridades.dtos.LoginDTO;

@Stateless
@LocalBean
public class ManagerMacroequipos {
	@EJB
	private ManagerDAO mDAO;
	@EJB
	private ManagerAuditoria mAuditoria;

	// Funciones gerente - Materials
	public List<MacMaterial> findAllMacMaterials() {
		return mDAO.findAll(MacMaterial.class);
	}

	public List<MacProducto> findAllMacProductos() {
		return mDAO.findAll(MacProducto.class);
	}

	public MacMaterial inicializarMaterial() {
		MacMaterial material = new MacMaterial();
		material.setNombre(null);
		material.setStock(0);
		material.setDescripcion(null);
		material.setEst(true);
		return material;
	}

//	public MacProducto inicializarProducto(){
//		MacProducto producto = new MacProducto();
//		producto.setNombre(null);
//		producto.setPrecioventa(null);
//		producto.setStock(0);
//		producto.setDescripcion(null);
//		producto.setEst(true);
//		return producto;
//	}
//	
	public MacMaterial findByIdMacMaterials(int idMaterial) throws Exception {
		return (MacMaterial) mDAO.findById(MacMaterial.class, idMaterial);
	}

	public void actualizarStockAumentar(LoginDTO loginDTO, MacMaterial edicionMaterial) throws Exception {
		MacMaterial modulo = (MacMaterial) mDAO.findById(MacMaterial.class, edicionMaterial.getMatId());
		Double stock = modulo.getStock() + edicionMaterial.getStock();
		modulo.setStock(stock);
		mDAO.actualizar(modulo);
		mAuditoria.mostrarLog(loginDTO, getClass(), "sumar stock",
				"se aumentó el material " + edicionMaterial.getMatId());
		throw new Exception("Se aumento el stock ");

	}

	public void actualizarStockDisminuir(LoginDTO loginDTO, MacMaterial edicionMaterial) throws Exception {
		Double stock = 0.0;
		MacMaterial modulo = (MacMaterial) mDAO.findById(MacMaterial.class, edicionMaterial.getMatId());
		if (modulo.getStock() > 0) {
			if (modulo.getStock() > edicionMaterial.getStock()) {
				stock = modulo.getStock() - edicionMaterial.getStock();
				System.out.println(stock);
				modulo.setStock(stock);
				mDAO.actualizar(modulo);
				mAuditoria.mostrarLog(loginDTO, getClass(), "restar stock",
						"se disminuyo el material " + edicionMaterial.getMatId());
				throw new Exception("Se redujo el stock");
			} else {
				throw new Exception("La cantidad que desa reducir supera el stock ");
			}
		} else {
			throw new Exception("No existe stock para reducir ");
		}

	}

	public void actualizarUsuario(LoginDTO loginDTO, SegUsuario edicionUsuario) throws Exception {
		SegUsuario usuario = (SegUsuario) mDAO.findById(SegUsuario.class, edicionUsuario.getIdSegUsuario());
		usuario.setApellidos(edicionUsuario.getApellidos());
		usuario.setClave(edicionUsuario.getClave());
		usuario.setCorreo(edicionUsuario.getCorreo());
		usuario.setCodigo(edicionUsuario.getCodigo());
		usuario.setNombres(edicionUsuario.getNombres());
		mDAO.actualizar(usuario);
		mAuditoria.mostrarLog(loginDTO, getClass(), "actualizarUsuario",
				"se actualizó al usuario " + usuario.getApellidos());
	}

	/*
	 * public List<MacMaterial> findMaterialById(int idMaterial){ return
	 * mDAO.findWhere(MacMaterial.class, "o.macMaterial.Id="+idProforma, "o.uniId");
	 * }
	 */

	public void insertarMaterial(MacMaterial nuevoMaterial) throws Exception {

		mDAO.insertar(nuevoMaterial);
	}

	public void actualizarMaterial(MacMaterial material) throws Exception {
		mDAO.actualizar(material);
	}

	// funciones de vendedor
		
	public List<MacCliente> findAllMacClientes() {
		return mDAO.findAll(MacCliente.class);
	}
	public MacCliente inicializarCliente() {
		MacCliente cliente = new MacCliente();
		cliente.setApellido(null);
		cliente.setCedula(null);
		cliente.setCiudad(null);
		cliente.setDireccion(null);
		cliente.setEst(true);
		cliente.setNombre(null);
		cliente.setTelefono(null);
		return cliente;
	}
	
	
	// funciones de operario
	public List<MacOrdenProduccion> findAllMacOrdenProduccions() {
		return mDAO.findAll(MacOrdenProduccion.class);
	}

	public MacOrdenProduccion inicializarOrden() {
		MacOrdenProduccion orden = new MacOrdenProduccion();
		orden.setDescripcion(null);
		orden.setEst("Espera");
		orden.setFechafinal(null);
		orden.setFechainicio(null);
		return orden;
	}
}
