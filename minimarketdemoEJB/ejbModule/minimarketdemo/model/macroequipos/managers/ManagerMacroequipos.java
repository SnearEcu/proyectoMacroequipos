package minimarketdemo.model.macroequipos.managers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import minimarketdemo.model.auditoria.managers.ManagerAuditoria;
import minimarketdemo.model.core.entities.MacMaterial;
import minimarketdemo.model.core.entities.MacProducto;
import minimarketdemo.model.core.managers.ManagerDAO;
import minimarketdemo.model.seguridades.dtos.LoginDTO;

@Stateless
@LocalBean
public class ManagerMacroequipos {
	@EJB
	private ManagerDAO mDAO;
	@EJB
	private ManagerAuditoria mAuditoria;

	// Funciones gerente - Materials
	@SuppressWarnings("unchecked")
	public List<MacMaterial> findAllMacMaterials() {
		return mDAO.findAll(MacMaterial.class);
	}

	@SuppressWarnings("unchecked")
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
			if (modulo.getStock() >= edicionMaterial.getStock()) {
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


	/*
	 * public List<MacMaterial> findMaterialById(int idMaterial){ return
	 * mDAO.findWhere(MacMaterial.class, "o.macMaterial.Id="+idProforma, "o.uniId");
	 * }
	 */

	public void insertarMaterial(MacMaterial nuevoMaterial) throws Exception {
		System.out.print("123");
		mDAO.insertar(nuevoMaterial);
	}

	public void actualizarMaterial(MacMaterial material) throws Exception {
		mDAO.actualizar(material);
	}

	// funciones de vendedor

	/*
	 * //Funciones de vendedor
	 * 
	 * 
	 * public List<MacMaterial> findPedidosByProforma(int idProforma){ return
	 * mDAO.findWhere(UniPedido.class, "o.uniProforma.proId="+idProforma,
	 * "o.uniId"); } public UniProforma inicializarProforma() { UniProforma proforma
	 * = new UniProforma(); proforma.setProEstado("Negociación");
	 * proforma.setProTotal(0); proforma.setProFechaentrega(ModelUtil.addDays(new
	 * Date(), 30)); return proforma; } public UniPedido inicializarPedido() {
	 * UniPedido pedido = new UniPedido(); pedido.setCantidad(0);
	 * pedido.setTotal(0); return pedido; } public void insertarProforma
	 * (UniProforma nuevaProforma) throws Exception { mDAO.insertar(nuevaProforma);
	 * } public void insertarPedido(UniPedido nuevoPedido) throws Exception {
	 * mDAO.insertar(nuevoPedido); }
	 * 
	 * public void actualizarEstado(UniProforma proforma) throws Exception {
	 * mDAO.actualizar(proforma); }
	 * 
	 * public List<UniCliente> findAllClientes(){ return
	 * mDAO.findAll(UniCliente.class); } public List<UniPrenda> findAllPrendas(){
	 * return mDAO.findAll(UniPrenda.class); } public List<UniPedido>
	 * findAllUniformes(){ return mDAO.findAll(UniPedido.class); } public
	 * List<UniReclamo> findAllReclamos(){ return mDAO.findAll(UniReclamo.class); }
	 */
}
