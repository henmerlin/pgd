package controllers.projetos;

import javax.faces.bean.ViewScoped;

import entidades.projetos.ImpactoProjeto;
import entidades.projetos.Projeto;
import models.projetos.ImpactoProjetoServico;
import util.JSFUtil;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ViewScoped
public class ImpactoProjetoBean {

	private ImpactoProjeto impactoProjeto;
	
	private ImpactoProjeto impactoProjetoModifica;
	
	@EJB
	private ImpactoProjetoServico impactoProjetoServico;
	
	public ImpactoProjetoBean() {
		
		this.impactoProjeto = new ImpactoProjeto();
		
		this.impactoProjetoModifica = new ImpactoProjeto();
		
	}
	
	public void cadastrarImpactoProjeto(Projeto projeto) {
		
		try {
			
			this.impactoProjetoServico.cadastrarImpactoProjeto(this.impactoProjeto, projeto);
			JSFUtil.addInfoMessage("Impacto cadastrado com sucesso.");
			this.impactoProjeto = new ImpactoProjeto();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public void modificaImpactoProjeto() {
		
		try {
			
			this.impactoProjetoServico.modificarImpactoProjeto(this.impactoProjetoModifica);
			JSFUtil.addInfoMessage("Impacto modificado com sucesso.");
			this.impactoProjetoModifica = new ImpactoProjeto();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<ImpactoProjeto> listarImpactoProjetoEspecifico(Projeto projeto) {
		
		return this.impactoProjetoServico.listarImpactoProjetoEspecifico(projeto);
		
	}

	public ImpactoProjeto getImpactoProjeto() {
		return impactoProjeto;
	}

	public void setImpactoProjeto(ImpactoProjeto impactoProjeto) {
		this.impactoProjeto = impactoProjeto;
	}

	public ImpactoProjeto getImpactoProjetoModifica() {
		return impactoProjetoModifica;
	}

	public void setImpactoProjetoModifica(ImpactoProjeto impactoProjetoModifica) {
		this.impactoProjetoModifica = impactoProjetoModifica;
	}

}
