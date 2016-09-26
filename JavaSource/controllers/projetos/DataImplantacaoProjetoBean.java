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
	
	private DataImplantacaoProjeto dataImplantacaoProjeto;
	
	@EJB
	private DataImplantacaoProjetoServico dataImplantacaoProjetoServico;
	
	public DataImplantacaoProjetoBean() {

		this.dataImplantacaoProjeto = new DataImplantacaoProjeto();
				
	}
	
	public void cadastrarDataImplantacaoProjeto(Projeto projeto) {
		
		try {
			
			this.dataImplantacaoProjetoServico.cadastrarDataImplantacaoProjeto(this.dataImplantacaoProjeto, projeto);
			JSFUtil.addInfoMessage("Erro ao cadastar data nova data de implantação");
			this.dataImplantacaoProjeto = new DataImplantacaoProjeto();			
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<DataImplantacaoProjeto> listarDataImplantacaoProjetoEspecificoProjeto(Projeto projeto) {
		
		return this.dataImplantacaoProjetoServico.listarDataImplantacaoProjetoEspecificoProjeto(projeto);
		
	}

	public DataImplantacaoProjeto getDataImplantacaoProjeto() {
		return dataImplantacaoProjeto;
	}

	public void setDataImplantacaoProjeto(DataImplantacaoProjeto dataImplantacaoProjeto) {
		this.dataImplantacaoProjeto = dataImplantacaoProjeto;
	}

}
