package controllers.projetos;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.projetos.Status;
import models.projetos.StatusServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class StatusBean {
	
	private Status status;
	
	@EJB
	private StatusServico statusServico;

	public StatusBean() {
		
		this.status = new Status();
		
	}
	
	public void cadastrarStatus() {
		
		try {
			
			this.statusServico.cadastrarStatus(this.status);
			
			this.status = new Status();
			
			JSFUtil.addInfoMessage("Status cadastrada com sucesso");
			
		} catch (Exception e) {
			
			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<Status> listarStatus() {
		
		return this.statusServico.listarStatus();		
		
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
