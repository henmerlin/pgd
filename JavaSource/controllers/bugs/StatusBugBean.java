package controllers.bugs;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.bugs.StatusBug;
import models.bugs.SequenciaRelatorioBugServico;
import models.bugs.StatusBugServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class StatusBugBean {
	
	private StatusBug statusBug;
	
	private StatusBug statusBugModifica;

	@EJB
	private StatusBugServico statusBugServico;
	
	@EJB
	private SequenciaRelatorioBugServico sequenciaRelatorioBugServico;
	
	public StatusBugBean() {
		
		this.statusBug = new StatusBug();
		
		this.statusBugModifica = new StatusBug();
		
	}
	
	public void cadastrarStatus() {
		
		try {
			
			this.statusBugServico.cadastrarStatus(this.statusBug);
			
			this.sequenciaRelatorioBugServico.cadastrarSequencia(this.statusBug);
			
			JSFUtil.addInfoMessage("Status Cadastrado com sucesso.");
			this.statusBug = new StatusBug();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public void modificarStatus() {
		
		try {
			
			this.statusBugServico.modificarStatus(this.statusBugModifica);
			JSFUtil.addInfoMessage("Status modificado com sucesso.");
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<StatusBug> listarStatus() {
		
		return this.statusBugServico.listarStatus();
		
	}
	
	public List<StatusBug> listarStatusAtivo() {
		
		return this.statusBugServico.listarStatusAtivo();
		
	}

	public StatusBug getStatusBug() {
		return statusBug;
	}

	public void setStatusBug(StatusBug statusBug) {
		this.statusBug = statusBug;
	}

	public StatusBug getStatusBugModifica() {
		return statusBugModifica;
	}

	public void setStatusBugModifica(StatusBug statusBugModifica) {
		this.statusBugModifica = statusBugModifica;
	}

}
