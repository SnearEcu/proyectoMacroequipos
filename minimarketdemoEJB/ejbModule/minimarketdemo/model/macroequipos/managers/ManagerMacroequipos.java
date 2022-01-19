package minimarketdemo.model.macroequipos.managers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import minimarketdemo.model.core.entities.MacMaterial;
import minimarketdemo.model.core.entities.MacOrdenProduccion;
import minimarketdemo.model.core.entities.PryProyecto;
import minimarketdemo.model.core.entities.PryTarea;
import minimarketdemo.model.core.managers.ManagerDAO;
import minimarketdemo.model.core.utils.ModelUtil;

@Stateless
@LocalBean
public class ManagerMacroequipos {
	@EJB
	private ManagerDAO mDAO;
	
	//Funciones gerente - Materials
	public List<MacMaterial> findAllMacMaterials(){
    	return mDAO.findAll(MacMaterial.class);
    }
	
	public MacMaterial inicializarMaterial(){
		MacMaterial material = new MacMaterial();
		material.setNombre(null);
		material.setStock(0);
		material.setDescripcion(null);
		material.setEst(true);
		return material;
	}
	
	/*public List<MacMaterial> findMaterialById(int idMaterial){
    	return mDAO.findWhere(MacMaterial.class, "o.macMaterial.Id="+idProforma, "o.uniId");
    }*/
	
	public void insertarMaterial (MacMaterial nuevoMaterial) throws Exception {
    	mDAO.insertar(nuevoMaterial);
    }
	/*
	//Funciones de vendedor
	

	public List<MacMaterial> findPedidosByProforma(int idProforma){
    	return mDAO.findWhere(UniPedido.class, "o.uniProforma.proId="+idProforma, "o.uniId");
    }
	public UniProforma inicializarProforma() {
		UniProforma proforma = new UniProforma();
		proforma.setProEstado("Negociación");
		proforma.setProTotal(0);
		proforma.setProFechaentrega(ModelUtil.addDays(new Date(), 30));
		return proforma;
	}
	public UniPedido inicializarPedido() {
		UniPedido pedido = new UniPedido();
		pedido.setCantidad(0);
		pedido.setTotal(0);
		return pedido;
	}
	public void insertarProforma (UniProforma nuevaProforma) throws Exception {
    	mDAO.insertar(nuevaProforma);
    }
	public void insertarPedido(UniPedido nuevoPedido) throws Exception {
    	mDAO.insertar(nuevoPedido);
    }
	
    public void actualizarEstado(UniProforma proforma) throws Exception {
    	mDAO.actualizar(proforma);
    }
	
	
	public List<UniCliente> findAllClientes(){
    	return mDAO.findAll(UniCliente.class);
    }
	public List<UniPrenda> findAllPrendas(){
    	return mDAO.findAll(UniPrenda.class);
    }
	public List<UniPedido> findAllUniformes(){
    	return mDAO.findAll(UniPedido.class);
    }
	public List<UniReclamo> findAllReclamos(){
    	return mDAO.findAll(UniReclamo.class);
    }*/
	
	//----------------Produccion--------------
	public List<MacOrdenProduccion> findAllMacOrdenProduccions(){
    	return mDAO.findAll(MacOrdenProduccion.class);
    }
	
	public MacOrdenProduccion inicializarMacOrdenProduccion(){
		MacOrdenProduccion orden = new MacOrdenProduccion();
		orden.setEst("Solicitada");
		return orden;
	}
	public void insertarOrden(MacOrdenProduccion nuevaOrden) throws Exception {
    	mDAO.insertar(nuevaOrden);
    }
    public void iniciarOrden(MacOrdenProduccion orden) throws Exception {
    	orden.setEst("Estado");
    	orden.setFechainicio(new Date());
    	mDAO.actualizar(orden);
    }
    public void terminarOrden(MacOrdenProduccion orden) throws Exception {
    	orden.setEst("Terminada");
    	orden.setFechafinal(new Date());
    	mDAO.actualizar(orden);
    }
	
}
