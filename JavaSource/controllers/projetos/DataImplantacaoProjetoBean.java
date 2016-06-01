package controllers.projetos;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.projetos.DataImplantacaoProjeto;
import entidades.projetos.Projeto;
import models.projetos.DataImplantacaoProjetoServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class DataImplantacaoProjetoBean {
	
	private DataImplantacaoProjeto dataImplementacao;
		
	@EJB
	private DataImplantacaoProjetoServico dataImplantacaoProjetoServico;

	public DataImplantacaoProjetoBean() {
		
		this.dataImplementacao = new DataImplantacaoProjeto();
		
	}
	
	public void validaCadastroDataImplantacao(Projeto projeto) {
		
		if (this.dataImplementacao.getData() != null && !this.dataImplementacao.getDescricao().isEmpty()){
			
			this.cadastrarDataImplantacao(projeto);
			
		}else{
			
			JSFUtil.addErrorMessage("Por favor preencha todos os campos");
			
		}
		
	}
	
	
	public void cadastrarDataImplantacao(Projeto projeto) {
		
		try {
			
			this.dataImplementacao.setProjeto(projeto);
			
			this.dataImplantacaoProjetoServico.cadastrarDataImplantacao(this.dataImplementacao);
			JSFUtil.addInfoMessage("Data modificada com sucesso");
			
		} catch (Exception e) {
			
			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<DataImplantacaoProjeto> listarDatasImplantacaoEspecifico(Projeto projeto) {
							
		return this.dataImplantacaoProjetoServico.listarDatasImplantacaoEspecifico(projeto);
		
	}

	public DataImplantacaoProjeto getDataImplementacao() {
		return dataImplementacao;
	}

	public void setDataImplementacao(DataImplantacaoProjeto dataImplementacao) {
		this.dataImplementacao = dataImplementacao;
	}

}
