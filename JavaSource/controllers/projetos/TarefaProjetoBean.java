package controllers.projetos;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.projetos.Projeto;
import entidades.projetos.TarefaProjeto;
import models.projetos.TarefaProjetoServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class TarefaProjetoBean {

	private TarefaProjeto tarefaProjeto;
	
	private TarefaProjeto tarefaProjetoModifica;
	
	@EJB
	private TarefaProjetoServico tarefaProjetoServico;
	
	public TarefaProjetoBean() {
		
		this.tarefaProjeto = new TarefaProjeto();
		
		this.tarefaProjetoModifica = new TarefaProjeto();
		
	}
	
	public void cadastrarTarefaProjeto(Projeto projeto) {
		
		try {			
			
			this.tarefaProjetoServico.cadastrarTarefaProjeto(this.tarefaProjeto, projeto);
			JSFUtil.addInfoMessage("Tarefa cadastrada com sucesso.");
			this.tarefaProjeto = new TarefaProjeto();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public void modificarTarefaProjeto() {
		
		try {
			
			this.tarefaProjetoServico.modificarTarefaProjeto(this.tarefaProjetoModifica);
			JSFUtil.addInfoMessage("Tarefa modificada com sucesso.");
			this.tarefaProjetoModifica = new TarefaProjeto();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<TarefaProjeto> listarTarefaProjetoEspecifico(Projeto projeto) {
		
		return this.tarefaProjetoServico.listarTarefaProjetoEspecifico(projeto);
		
	}

	public TarefaProjeto getTarefaProjeto() {
		return tarefaProjeto;
	}

	public void setTarefaProjeto(TarefaProjeto tarefaProjeto) {
		this.tarefaProjeto = tarefaProjeto;
	}

	public TarefaProjeto getTarefaProjetoModifica() {
		return tarefaProjetoModifica;
	}

	public void setTarefaProjetoModifica(TarefaProjeto tarefaProjetoModifica) {
		this.tarefaProjetoModifica = tarefaProjetoModifica;
	}	

}
