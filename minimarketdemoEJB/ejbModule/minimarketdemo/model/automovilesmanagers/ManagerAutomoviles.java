package minimarketdemo.model.automovilesmanagers;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import minimarketdemo.model.core.entities.AutPedido;
import minimarketdemo.model.core.entities.AutProducto;
import minimarketdemo.model.core.entities.AutSolicitud;
import minimarketdemo.model.core.entities.UniCliente;
import minimarketdemo.model.core.entities.UniProforma;
import minimarketdemo.model.core.managers.ManagerDAO;

/**
 * Session Bean implementation class ManagerAutomoviles
 */
@Stateless
@LocalBean
public class ManagerAutomoviles {
	@EJB
	private ManagerDAO mDAO;

	
	private List<AutSolicitud> listaSolicitudes;
	private List<AutProducto> listaProductos;
	private List<AutPedido> listaPedidos;
    /**
     * Default constructor. 
     */
    public ManagerAutomoviles() {
        // TODO Auto-generated constructor stub
    }
    
    public AutSolicitud inicializarSolicitud() {
    	AutSolicitud solicitud = new AutSolicitud();
    	solicitud.setDescripcion("");
    	solicitud.setFechainicio(new Date());
    	return solicitud;
    }
    public AutPedido inicializarPedido() {
    	AutPedido pedido = new AutPedido();
    	pedido.setAutProducto(null);
    	pedido.setAutSolicitud(null);
    	return pedido;
    }
    public AutProducto inicializarProducto() {
    	AutProducto producto = new AutProducto();
    	producto.setCosto(1.5);
    	producto.setDescripcion(null);
    	producto.setNombre("");
    	return producto;
    }
    public void actualizarEstado(AutSolicitud solicitud) throws Exception {
    	mDAO.actualizar(solicitud);
    }
    
    
    
	public void insertarSolicitud (AutSolicitud nuevaSolicitud) throws Exception {
    	mDAO.insertar(nuevaSolicitud);
    }	public void insertarPedido (AutPedido nuevoPedido) throws Exception {
    	mDAO.insertar(nuevoPedido);
    }	public void insertarProducto (AutProducto nuevaProducto) throws Exception {
    	mDAO.insertar(nuevaProducto);
    }

    
	public List<AutSolicitud> findAllSolicitudes(){
    	return mDAO.findAll(AutSolicitud.class);
    }
	public List<AutProducto> findAllProductos(){
    	return mDAO.findAll(AutProducto.class);
    }
	public List<AutPedido> findAllPedidos(){
    	return mDAO.findAll(AutPedido.class);
    }
}
