package controllers.projetos;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.projetos.DataImplantacao;
import entidades.projetos.Projeto;
import models.projetos.DataImplantacaoServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class DataImplementacaoBean {

	private DataImplantacao dataImplementacao;
	
	private List<DataImplantacao> listaDeDatas;

	@EJB
	private DataImplantacaoServico dataImplantacaoServico;

	public DataImplementacaoBean() {

		this.dataImplementacao = new DataImplantacao();

	}

	public List<DataImplantacao> listarDatasImplantacaoEspecifico(Projeto projeto) {
		
		this.listaDeDatas = this.dataImplantacaoServico.listarDatasImplantacaoEspecifico(projeto);

		return this.listaDeDatas;
		
	}

	public void updateDataImplantacao(Projeto projeto) {

		try {

			Date data = new Date();

			this.dataImplementacao.setDataAlteracao(data);

			this.dataImplementacao.setProjeto(projeto);

			this.dataImplantacaoServico.updateDataImplantacao(this.dataImplementacao);
			JSFUtil.addInfoMessage("Data modificada com sucesso");

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public DataImplantacao getDataImplementacao() {
		return dataImplementacao;
	}

	public void setDataImplementacao(DataImplantacao dataImplementacao) {
		this.dataImplementacao = dataImplementacao;
	}

	public List<DataImplantacao> getListaDeDatas() {
		return listaDeDatas;
	}

	public void setListaDeDatas(List<DataImplantacao> listaDeDatas) {
		this.listaDeDatas = listaDeDatas;
	}		

}
