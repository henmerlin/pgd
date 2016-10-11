package controllers.projetos;

import java.util.List;

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
	
	private List<Projeto> listaDeProjetos;
	
	private List<Projeto> listaDeProjetosFiltred;
		
	@EJB
	private ProjetoServico projetoServico;

	public ProjetoBean() {
		
		this.projeto = new Projeto();
		
	}
	
	public void cadasrtarProjeto() {
		
		try {
			
			this.projetoServico.cadastrarProjeto(this.projeto);
			JSFUtil.addInfoMessage("Projeto cadastrado com sucesso.");
			this.projeto = new Projeto();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public void modificarProjeto() {
		
		try {
			
			this.projetoServico.modificarProjeto(this.projeto);
			JSFUtil.addInfoMessage("Projeto modificado com sucesso.");
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<Projeto> listarProjetos() {
		
		return this.projetoServico.listarProjetos();
		
	}
	
	public void listarProjetosLista() {
		
		this.listaDeProjetos = this.projetoServico.listarProjetos();
		
	}
	
	public void listarProjetoEspecifico() {
		
		try {
			
			this.projeto = this.projetoServico.listarProjetoEspecifico(this.projeto);
			
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

	public List<Projeto> getListaDeProjetos() {
		return listaDeProjetos;
	}

	public void setListaDeProjetos(List<Projeto> listaDeProjetos) {
		this.listaDeProjetos = listaDeProjetos;
	}

	public List<Projeto> getListaDeProjetosFiltred() {
		return listaDeProjetosFiltred;
	}

	public void setListaDeProjetosFiltred(List<Projeto> listaDeProjetosFiltred) {
		this.listaDeProjetosFiltred = listaDeProjetosFiltred;
	}	

}
