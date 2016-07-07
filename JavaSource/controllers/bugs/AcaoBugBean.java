package controllers.bugs;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.bugs.AcaoBug;
import entidades.bugs.Bug;
import models.bugs.AcaoBugServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class AcaoBugBean {
	
	private AcaoBug acaoBug;

	private AcaoBug acaoBugModifica;
	
	@EJB
	private AcaoBugServico acaoBugServico;
	
	public AcaoBugBean() {
		
		this.acaoBug = new AcaoBug();
		
		this.acaoBugModifica = new AcaoBug();
		
	}
	
	public void cadastrarAcao() {
		
		try {
			
			this.acaoBugServico.cadastrarAcao(this.acaoBug);
			JSFUtil.addInfoMessage("Acão cadastrada com sucesso.");
			this.acaoBug = new AcaoBug();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public void modificarAcao() {
		
		try {
			
			this.acaoBugServico.modificarAcao(this.acaoBugModifica);
			JSFUtil.addInfoMessage("Acão modifica com sucesso.");
			this.acaoBugModifica = new AcaoBug();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<AcaoBug> listarAcaoBugsEspecifico(Bug bug) {
		
		return this.acaoBugServico.listarAcaoBugsEspecifico(bug);
		
	}

	public AcaoBug getAcaoBug() {
		return acaoBug;
	}

	public void setAcaoBug(AcaoBug acaoBug) {
		this.acaoBug = acaoBug;
	}

	public AcaoBug getAcaoBugModifica() {
		return acaoBugModifica;
	}

	public void setAcaoBugModifica(AcaoBug acaoBugModifica) {
		this.acaoBugModifica = acaoBugModifica;
	}	

}
