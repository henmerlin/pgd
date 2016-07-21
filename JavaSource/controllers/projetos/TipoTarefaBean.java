package controllers.projetos;

import javax.faces.bean.ViewScoped;

import entidades.projetos.TipoTarefa;
import models.projetos.TipoTarefaServico;
import util.JSFUtil;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ViewScoped
public class TipoTarefaBean {

	private TipoTarefa tipoTarefa;
	
	private TipoTarefa tipoTarefaModifica;
	
	@EJB	
	private TipoTarefaServico tipoTarefaServico;
	
	public TipoTarefaBean() {
		
		this.tipoTarefa = new TipoTarefa();
		
		this.tipoTarefaModifica = new TipoTarefa();
		
	}
	
	public void cadastrarTipoTarefa() {
		
		try {
			
			this.tipoTarefaServico.cadastrarTipoTarefa(this.tipoTarefa);
			JSFUtil.addInfoMessage("Tipo Tarefa cadastrado com sucesso.");
			this.tipoTarefa = new TipoTarefa();
			
		} catch (Exception e) {
			
			JSFUtil.addErrorMessage(e.getMessage());

		}
		
	}
	
	public void modificarTipoTarefa() {
		
		try {
			
			this.tipoTarefaServico.modificarTarefa(this.tipoTarefaModifica);
			JSFUtil.addInfoMessage("Tipo Tarefa modificado com sucesso.");
			this.tipoTarefaModifica = new TipoTarefa();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<TipoTarefa> listarTipoTarefa() {
		
		return this.tipoTarefaServico.listarTipoTarefa();
		
	}
	
	public List<TipoTarefa> listarTipoTarefaAtivo() {
		
		return this.tipoTarefaServico.listarTipoTarefaAtivo();
		
	}

	public TipoTarefa getTipoTarefa() {
		return tipoTarefa;
	}

	public void setTipoTarefa(TipoTarefa tipoTarefa) {
		this.tipoTarefa = tipoTarefa;
	}

	public TipoTarefa getTipoTarefaModifica() {
		return tipoTarefaModifica;
	}

	public void setTipoTarefaModifica(TipoTarefa tipoTarefaModifica) {
		this.tipoTarefaModifica = tipoTarefaModifica;
	}	

}
