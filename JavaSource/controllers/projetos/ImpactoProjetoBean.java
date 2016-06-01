package controllers.projetos;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.projetos.ImpactoProjeto;
import entidades.projetos.Projeto;
import models.projetos.ImpactoProjetoServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class ImpactoProjetoBean {

	private ImpactoProjeto impactoProjeto;
	
	@EJB
	private ImpactoProjetoServico impactoProjetoServico;
	
	public ImpactoProjetoBean() {
		
		this.impactoProjeto = new ImpactoProjeto();
		
	}
	
	public void cadastrarImpactoProjeto(Projeto projeto) {
		
		try {
			
			this.impactoProjeto.setProjeto(projeto);
			
			this.impactoProjetoServico.cadastrarImpactoProjeto(this.impactoProjeto);
			
			this.impactoProjeto = new ImpactoProjeto();
			
			JSFUtil.addInfoMessage("Impacto cadastrado com sucesso");
			
		} catch (Exception e) {

			JSFUtil.addInfoMessage(e.getMessage());
			
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

}
