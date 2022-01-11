package minimarketdemo.model.uniformes.managers;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import minimarketdemo.model.core.entities.PryProyecto;
import minimarketdemo.model.core.entities.UniCliente;
import minimarketdemo.model.core.entities.UniPedido;
import minimarketdemo.model.core.entities.UniPrenda;
import minimarketdemo.model.core.entities.UniProforma;
import minimarketdemo.model.core.entities.UniReclamo;
import minimarketdemo.model.core.managers.ManagerDAO;
import minimarketdemo.model.core.utils.ModelUtil;

@Stateless
@LocalBean
public class ManagerUniformes {
	@EJB
	private ManagerDAO mDAO;
	
	
	//Funciones de vendedor
	
	public List<UniProforma> findAllProformas(){
    	return mDAO.findAll(UniProforma.class);
    }

	public List<UniPedido> findPedidosByProforma(int idProforma){
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
    }
}
