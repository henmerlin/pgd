package controllers.bugs;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.bugs.PrioridadeBug;
import models.bugs.PrioridadeBugServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class PrioridadeBugBean {
	
	private PrioridadeBug prioridadeBug;
	
	private PrioridadeBug prioridadeBugModifica;
	
	@EJB
	private PrioridadeBugServico prioridadeBugServico;

	public PrioridadeBugBean() {

		this.prioridadeBug = new PrioridadeBug();
		
		this.prioridadeBugModifica = new PrioridadeBug();
		
	}
	
	public void cadastrarPrioridade() {
		
		try {
			
			this.prioridadeBugServico.cadastrarPrioridade(this.prioridadeBug);
			JSFUtil.addInfoMessage("Prioridade cadastrada com sucesso.");
			this.prioridadeBug = new PrioridadeBug();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public void modificarPrioridade() {
		
		try {
			
			this.prioridadeBugServico.modificarPrioridade(this.prioridadeBugModifica);
			JSFUtil.addInfoMessage("Prioridade modificada com sucesso.");
			this.prioridadeBugModifica = new PrioridadeBug();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<PrioridadeBug> listarPrioridade() {
		
		return this.prioridadeBugServico.listarPrioridade();
		
	}

	public List<PrioridadeBug> listarPrioridadeAtivo() {
		
		return this.prioridadeBugServico.listarPrioridadeAtivo();
		
	}
	
	public PrioridadeBug getPrioridadeBug() {
		return prioridadeBug;
	}

	public void setPrioridadeBug(PrioridadeBug prioridadeBug) {
		this.prioridadeBug = prioridadeBug;
	}

	public PrioridadeBug getPrioridadeBugModifica() {
		return prioridadeBugModifica;
	}

	public void setPrioridadeBugModifica(PrioridadeBug prioridadeBugModifica) {
		this.prioridadeBugModifica = prioridadeBugModifica;
	}

}
