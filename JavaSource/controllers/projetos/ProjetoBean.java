package controllers.projetos;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.projetos.Projeto;
import models.projetos.ProjetoServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class ProjetoBean {
	
	private Projeto projeto;

	@EJB
	private ProjetoServico projetoServico;
	
	public ProjetoBean() {
		
		this.projeto = new Projeto();
		
	}
	
	public void cadastrarProjeto() {
		
		try {
			
			this.projetoServico.cadastrarProjeto(this.projeto);
			
			this.projeto = new Projeto();
			
			JSFUtil.addInfoMessage("Projeto cadastrado com sucesso.");			
			
		} catch (Exception e) {
			
			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

}
