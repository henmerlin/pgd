package controllers.projetos;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.projetos.DataImplantacao;
import entidades.projetos.Projeto;
import models.projetos.DataImplantacaoServico;
import models.projetos.ProjetoServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class ProjetoBean { 
	
	private Projeto projeto;
	
	private DataImplantacao dataImplantacao;
	
	@EJB
	private ProjetoServico projetoServico;
	
	@EJB
	private DataImplantacaoServico dataImplantacaoServico;
		
	public ProjetoBean() {
		
		this.projeto = new Projeto();
		
		this.dataImplantacao = new DataImplantacao();
		
	}
	
	public void cadastrarProjeto() {
		
		try {
			
			this.projetoServico.cadastrarProjeto(this.projeto);
			
			this.associativaDataImplantacao();
			
			this.projeto = new Projeto();			
			
			JSFUtil.addInfoMessage("Projeto cadastrado com sucesso.");			
			
		} catch (Exception e) {
			
			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<Projeto> listarProjeto() {
		
		return this.projetoServico.listarProjeto();
		
	}
	
	public Projeto listarProjetoEspecifico() {
		
		try {
			
			this.projeto = this.projetoServico.listarProjetoEspecifico(this.projeto);
			
			return this.projeto;
			
		} catch (Exception e) {
			
			JSFUtil.addErrorMessage(e.getMessage());
			return null;
			
		}	
		
	}
	
	public void associativaDataImplantacao() {
		
		try {
			
			Date date = new Date();
						
			this.dataImplantacao.setProjeto(this.projeto);
			
			this.dataImplantacao.setDataAlteracao(date);
			
			this.dataImplantacao.setDescricao("Primeira data");
			
			this.dataImplantacaoServico.cadastrarDataImplantacao(this.dataImplantacao);
			
			this.dataImplantacao = new DataImplantacao();
			
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

	public DataImplantacao getDataImplantacao() {
		return dataImplantacao;
	}

	public void setDataImplantacao(DataImplantacao dataImplantacao) {
		this.dataImplantacao = dataImplantacao;
	}

}
