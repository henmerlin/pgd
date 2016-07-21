package controllers.projetos;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.projetos.ProjetoFase;
import models.projetos.ProjetoFaseServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class ProjetoFaseBean {
	
	private ProjetoFase projetoFase;
	
	private ProjetoFase projetoFaseModifica;
	
	@EJB
	private ProjetoFaseServico projetoFaseServico;

	public ProjetoFaseBean() {
		
		this.projetoFase = new ProjetoFase();
		
		this.projetoFaseModifica = new ProjetoFase();
		
	}
	
	public void cadastrarProjetoFase() {
		
		try {
			
			this.projetoFaseServico.cadastrarFase(this.projetoFase);
			JSFUtil.addInfoMessage("Fase cadastrado com sucesso.");
			this.projetoFase = new ProjetoFase();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public void modificarProjetoFase() {
		
		try {
			
			this.projetoFaseServico.modificarFase(this.projetoFaseModifica);
			JSFUtil.addInfoMessage("Fase modificada com sucesso.");
			this.projetoFaseModifica = new ProjetoFase();
			
		} catch (Exception e) {
			
			JSFUtil.addErrorMessage(e.getMessage());

		}
		
	}
	
	public List<ProjetoFase> listaProjetoFase() {
		
		return this.projetoFaseServico.listarProjetoFase();
		
	}	
	
	public List<ProjetoFase> listarProjetoFaseAtivo() {
		
		return this.projetoFaseServico.listarProjetoFaseAtivo();
		
	}

	public ProjetoFase getProjetoFase() {
		return projetoFase;
	}

	public void setProjetoFase(ProjetoFase projetoFase) {
		this.projetoFase = projetoFase;
	}

	public ProjetoFase getProjetoFaseModifica() {
		return projetoFaseModifica;
	}

	public void setProjetoFaseModifica(ProjetoFase projetoFaseModifica) {
		this.projetoFaseModifica = projetoFaseModifica;
	}	

}
