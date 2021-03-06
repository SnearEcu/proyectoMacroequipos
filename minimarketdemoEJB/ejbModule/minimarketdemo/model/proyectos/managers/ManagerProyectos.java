package minimarketdemo.model.proyectos.managers;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import java.util.List;

import minimarketdemo.model.core.entities.PryProyecto;
import minimarketdemo.model.core.entities.PryTarea;
import minimarketdemo.model.core.entities.SegUsuario;
import minimarketdemo.model.core.managers.ManagerDAO;
import minimarketdemo.model.core.utils.ModelUtil;

/**
 * Session Bean implementation class ManagerProyectos
 */
@Stateless
@LocalBean
public class ManagerProyectos {
	@EJB
	private ManagerDAO mDAO;
	    /**
     * Default constructor. 
     */
    public ManagerProyectos() {
        
    }
    
    //funciones del Lider de proyectos
    public List<PryProyecto> findAllProyectos(){
    	return mDAO.findAll(PryProyecto.class);
    }
    
    public PryProyecto inicializarProyecto() {
    	PryProyecto proyecto =new PryProyecto();
    	proyecto.setAvance(0);
    	proyecto.setEstado("Iniciado");
    	proyecto.setFechaInicio(new Date());
    	proyecto.setFechaFin(ModelUtil.addDays(new Date(), 30));
    	return proyecto;
    }
    
    public void insertarProyecto(PryProyecto nuevoProyecto) throws Exception {
    	mDAO.insertar(nuevoProyecto);
    }
    
    public List<PryTarea>  findTareasByProyecto(int idPryProyecto){
    	return mDAO.findWhere(PryTarea.class, "o.pryProyecto.idPryProyecto="+idPryProyecto, "o.fechaInicio");
    }
    public PryTarea inicializarTarea(PryProyecto proyecto) {
    	PryTarea tarea =new PryTarea();
    	tarea.setAvance(0);
    	tarea.setFechaInicio(proyecto.getFechaInicio());
    	tarea.setFechaFin(proyecto.getFechaFin());
    	tarea.setPryProyecto(proyecto);
    	return tarea;
    }
    public void insertarTarea(PryTarea nuevaTarea,int idSegUsuario) throws Exception {
    	SegUsuario usuario = (SegUsuario) mDAO.findById(SegUsuario.class, idSegUsuario);
    	nuevaTarea.setSegUsuario(usuario);
    	mDAO.insertar(nuevaTarea);
    }
    
    //funciones Analista
    public List<PryTarea> findTareasByUsuario(int idSegUsuario){
    	return mDAO.findWhere(PryTarea.class, "o.segUsuario.idSegUsuario=" + idSegUsuario, "o.pryProyecto.nombre");
    }
    
    public void actualizarAvance(PryTarea tarea) throws Exception {
    	mDAO.actualizar(tarea);
    	List<PryTarea> listaTareas = findTareasByProyecto(tarea.getPryProyecto().getIdPryProyecto());    	
    	int suma = 0;
    	for(PryTarea t:listaTareas){
    		suma+= t.getAvance();
    		
    	}
    	int promedio = suma/listaTareas.size();
    	PryProyecto proyecto = tarea.getPryProyecto();
    	proyecto.setAvance(promedio);
    	mDAO.actualizar(proyecto);
    }
    
    //funciones Gerente
    public void actualizarEstado(PryProyecto proyecto) throws Exception {
    	mDAO.actualizar(proyecto);
    }
    
    
    
    
    
    
    
}
