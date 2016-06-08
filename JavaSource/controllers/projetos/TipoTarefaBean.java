package controllers.projetos;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.projetos.TipoTarefa;
import models.projetos.TipoTarefaServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class TipoTarefaBean {

	private TipoTarefa tipoTarefa;

	private TipoTarefa tipoTarefaCadastro;

	@EJB
	private TipoTarefaServico tipoTarefaServico;

	public TipoTarefaBean() {

		this.tipoTarefa = new TipoTarefa();

		this.tipoTarefaCadastro = new TipoTarefa();

	}

	public List<TipoTarefa> listarTipoTarefa() {

		return this.tipoTarefaServico.listarTipoTarefa();

	}

	public List<TipoTarefa> listarTipoTarefaAtivo() {

		return this.tipoTarefaServico.listarTipoTarefaAtivo();

	}

	public void modificarTipoTarefa() {

		try {

			this.tipoTarefaServico.modificarTipoTarefa(this.tipoTarefa);

			this.tipoTarefa = new TipoTarefa();

			JSFUtil.addInfoMessage("Tafera modificada com sucesso");

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}	

	public void cadastrarTipoTarefa() {

		try {

			this.tipoTarefaServico.cadastrarTipoTarefa(this.tipoTarefaCadastro);

			this.tipoTarefaCadastro = new TipoTarefa();

			JSFUtil.addInfoMessage("Tipo tarefa cadastrada com sucesso");

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public TipoTarefa getTipoTarefa() {
		return tipoTarefa;
	}

	public void setTipoTarefa(TipoTarefa tipoTarefa) {
		this.tipoTarefa = tipoTarefa;
	}

	public TipoTarefa getTipoTarefaCadastro() {
		return tipoTarefaCadastro;
	}

	public void setTipoTarefaCadastro(TipoTarefa tipoTarefaCadastro) {
		this.tipoTarefaCadastro = tipoTarefaCadastro;
	}	

}
