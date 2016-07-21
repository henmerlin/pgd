package controllers.projetos;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.projetos.StatusProjeto;
import models.projetos.SequenciaRelatorioProjetoServico;
import models.projetos.StatusProjetoServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class StatusProjetoBean {

	private StatusProjeto statusProjeto;
	
	private StatusProjeto statusProjetoModifica;
	
	@EJB
	private StatusProjetoServico statusProjetoServico;
	
	@EJB
	private SequenciaRelatorioProjetoServico sequenciaRelatorioProjetoServico;
	
	public StatusProjetoBean() {
		
		this.statusProjeto = new StatusProjeto();
		
		this.statusProjetoModifica = new StatusProjeto();
		
	}
	
	public void cadastraStatusProjeto() {
		
		try {
			
			this.statusProjetoServico.cadastrarStatusProjeto(this.statusProjeto);
			
			this.sequenciaRelatorioProjetoServico.cadastrarSequenciaRelatorioProjeto(this.statusProjeto);
			
			JSFUtil.addInfoMessage("Status Projeto cadastrado com sucesso.");
			this.statusProjeto = new StatusProjeto();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public void modificaStatusProjeto() {
		
		try {
			
			this.statusProjetoServico.modificarStatusProjeto(this.statusProjetoModifica);
			JSFUtil.addInfoMessage("Status Projeto modificado com sucesso.");
			this.statusProjetoModifica = new StatusProjeto();			
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}
		
	}
	
	public List<StatusProjeto> listarStatusProjeto() {
		
		return this.statusProjetoServico.listarStatusProjeto();
		
	}
	
	public List<StatusProjeto> listarStatusProjetoAtivo() {
		
		return this.statusProjetoServico.listarStatusAtivo();
		
	}

	public StatusProjeto getStatusProjeto() {
		return statusProjeto;
	}

	public void setStatusProjeto(StatusProjeto statusProjeto) {
		this.statusProjeto = statusProjeto;
	}

	public StatusProjeto getStatusProjetoModifica() {
		return statusProjetoModifica;
	}

	public void setStatusProjetoModifica(StatusProjeto statusProjetoModifica) {
		this.statusProjetoModifica = statusProjetoModifica;
	}

}
