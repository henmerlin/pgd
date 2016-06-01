package controllers.projetos;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.projetos.TipoTarefa;
import models.projetos.TipoTarefaServico;

@ManagedBean
@ViewScoped
public class TipoTarefaBean {
	
	private TipoTarefa tipoTarefa;
	
	@EJB
	private TipoTarefaServico tipoTarefaServico;

	public TipoTarefaBean() {
		
		this.tipoTarefa = new TipoTarefa();
		
	}
	
	public List<TipoTarefa> listarTipoTarefa() {
		
		return this.tipoTarefaServico.listarTipoTarefa();
		
	}

	public TipoTarefa getTipoTarefa() {
		return tipoTarefa;
	}

	public void setTipoTarefa(TipoTarefa tipoTarefa) {
		this.tipoTarefa = tipoTarefa;
	}

}
