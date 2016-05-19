package controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.Impacto;
import models.ImpactoServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class ImpactoBean {
	
	private Impacto impacto;
	
	@EJB
	private ImpactoServico impactoServico;

	public ImpactoBean() {
		
		this.impacto = new Impacto();
		
	}
	
	public void cadastrarImpacto() {
		
		try {
			
			this.impactoServico.cadastrarImpacto(this.impacto);
			
			this.impacto = new Impacto();
			
			JSFUtil.addInfoMessage("Impacto cadastrada com sucesso");
			
		} catch (Exception e) {
			
			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<Impacto> listarImpacto() {
		
		return this.impactoServico.listarImpacto();		
		
	}

	public Impacto getImpacto() {
		return impacto;
	}

	public void setImpacto(Impacto impacto) {
		this.impacto = impacto;
	}
	
}
