package minimarketdemo.controller.proyectos;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import minimarketdemo.controller.JSFUtil;
import minimarketdemo.model.core.entities.PryProyecto;
import minimarketdemo.model.proyectos.managers.ManagerProyectos;

@Named
@SessionScoped
public class BeanPryGerente implements Serializable {
	@EJB
	private ManagerProyectos mProyectos;
	private List<PryProyecto> listaProyectos;
	private String[] estado = {"Cancelado","Finalizado"};
	private String estadoSeleccionado;

	public BeanPryGerente() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void inicializar() {
		listaProyectos = mProyectos.findAllProyectos();
	}
	public void actionListenerActualizarEstado(PryProyecto proyecto) {
		try {
			mProyectos.actualizarEstado(proyecto);
			JSFUtil.crearMensajeINFO("Estado actualizado");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}

	public List<PryProyecto> getListaProyectos() {
		return listaProyectos;
	}

	public void setListaProyectos(List<PryProyecto> listaProyectos) {
		this.listaProyectos = listaProyectos;
	}

	public String[] getEstado() {
		return estado;
	}

	public void setEstado(String[] estado) {
		this.estado = estado;
	}

	public String getEstadoSeleccionado() {
		return estadoSeleccionado;
	}

	public void setEstadoSeleccionado(String estadoSeleccionado) {
		this.estadoSeleccionado = estadoSeleccionado;
	}
	

}
