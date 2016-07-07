package controllers.bugs;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.bugs.ImpactoBug;
import models.bugs.ImpactoBugServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class ImpactoBugBean {
	
	private ImpactoBug impactoBug;
	
	private ImpactoBug impactoBugModifica;
	
	@EJB
	private ImpactoBugServico impactoBugServico;

	public ImpactoBugBean() {
		
		this.impactoBug = new ImpactoBug();
		
		this.impactoBugModifica = new ImpactoBug();
		
	}
	
	public void cadastrarImpacto() {
		
		try {
			
			this.impactoBugServico.cadastrarImpacto(this.impactoBug);
			JSFUtil.addInfoMessage("Impacto cadastrado com sucesso.");
			this.impactoBug = new ImpactoBug();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public void modificarImpacto() {
		
		try {
			
			this.impactoBugServico.modificarImpacto(this.impactoBugModifica);
			JSFUtil.addInfoMessage("Impacto modificado com sucesso.");
			this.impactoBugModifica = new ImpactoBug();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<ImpactoBug> listarImpacto() {
		
		return this.impactoBugServico.listarImpacto();
		
	}
	
	public List<ImpactoBug> listarImpactoAtivo() {
		
		return this.impactoBugServico.listarImpactoAtivo();
		
	}

	public ImpactoBug getImpactoBug() {
		return impactoBug;
	}

	public void setImpactoBug(ImpactoBug impactoBug) {
		this.impactoBug = impactoBug;
	}

	public ImpactoBug getImpactoBugModifica() {
		return impactoBugModifica;
	}

	public void setImpactoBugModifica(ImpactoBug impactoBugModifica) {
		this.impactoBugModifica = impactoBugModifica;
	}

}
