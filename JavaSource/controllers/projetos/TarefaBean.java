package controllers.projetos;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.projetos.Projeto;
import entidades.projetos.Tarefa;
import models.projetos.TarefaServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class TarefaBean {
	
	private Tarefa tarefa;
	
	private Tarefa tarefaCadastrar;
	
	@EJB
	private TarefaServico tarefaServico;

	public TarefaBean() {
		
		this.tarefa = new Tarefa();
		
		this.tarefaCadastrar = new Tarefa();
		
	}
	
	public void cadastrarTarefa(Projeto projeto) {		
		
		try {
			
			this.tarefaCadastrar.setProjeto(projeto);
			
			this.tarefaServico.cadastrarTarefa(this.tarefaCadastrar);
			
			this.tarefaCadastrar = new Tarefa();
			
			JSFUtil.addInfoMessage("Tarefa cadastrada com sucesso");			
			
		} catch (Exception e) {
			
			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<Tarefa> listarTarefaEspecifica(Projeto projeto) {
				
		return this.tarefaServico.listarTarefaEspecifica(projeto);
		
	}
	
	public void modificarTarefa() {
		
		try {
			
			this.tarefaServico.modificarTarefa(this.tarefa);
			
			this.tarefa = new Tarefa();
			
			JSFUtil.addInfoMessage("Tarefa modificada com sucesso");
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public Tarefa getTarefaCadastrar() {
		return tarefaCadastrar;
	}

	public void setTarefaCadastrar(Tarefa tarefaCadastrar) {
		this.tarefaCadastrar = tarefaCadastrar;
	}

}
