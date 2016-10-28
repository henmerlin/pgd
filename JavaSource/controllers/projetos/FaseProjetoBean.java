package controllers.projetos;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.projetos.FaseProjeto;
import entidades.projetos.Projeto;
import models.projetos.FaseProjetoServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class FaseProjetoBean {

	private FaseProjeto faseProjeto;

	private FaseProjeto faseProjetoModifica;

	private List<FaseProjeto> listaFaseProjeto;

	private List<FaseProjeto> listarSortida;

	@EJB
	private FaseProjetoServico faseProjetoServico;

	public FaseProjetoBean() {

		this.faseProjeto = new FaseProjeto();

		this.faseProjetoModifica = new FaseProjeto();

	}

	public void cadastrarFaseProjeto(Projeto projeto) {

		try {

			this.faseProjetoServico.cadastrarFaseProjeto(faseProjeto, projeto);
			JSFUtil.addInfoMessage("Fase cadastrada com sucesso.");
			this.faseProjeto = new FaseProjeto();

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public void modificaFaseProjeto() {

		try {

			this.faseProjetoServico.modificarFaseProjeto(this.faseProjetoModifica);
			JSFUtil.addInfoMessage("Fase modificada com sucesso.");
			this.faseProjetoModifica = new FaseProjeto();

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public List<FaseProjeto> listarFaseProjetoEspecifico(Projeto projeto) {

		this.listarSortida = this.faseProjetoServico.listarFaseProjetoEspecifico(projeto);		

		return this.listarSortida;

	}

	public void listarFaseProjetoEspecificoList(Projeto projeto) {

		this.listaFaseProjeto = this.faseProjetoServico.listarFaseProjetoEspecifico(projeto);		

	}

	public Double porcentagemDoProjeto(Projeto projeto) {

		List<FaseProjeto> faseProjetos = this.faseProjetoServico.listarFaseProjetoEspecifico(projeto);		

		Integer totalDeFases = faseProjetos.size();

		Integer totalValor = 0;

		for (FaseProjeto faseProjeto : faseProjetos) {

			if (faseProjeto.getPorcentagem() != null) {

				totalValor = totalValor + faseProjeto.getPorcentagem();

			}		

		}

		Double porcentagem = 0.0;

		if (totalDeFases != 0) {			

			porcentagem = (double) (totalValor / totalDeFases);

		}

		return porcentagem;

	}

	public FaseProjeto getFaseProjeto() {
		return faseProjeto;
	}

	public void setFaseProjeto(FaseProjeto faseProjeto) {
		this.faseProjeto = faseProjeto;
	}

	public FaseProjeto getFaseProjetoModifica() {
		return faseProjetoModifica;
	}

	public void setFaseProjetoModifica(FaseProjeto faseProjetoModifica) {
		this.faseProjetoModifica = faseProjetoModifica;
	}

	public List<FaseProjeto> getListarSortida() {
		return listarSortida;
	}

	public void setListarSortida(List<FaseProjeto> listarSortida) {
		this.listarSortida = listarSortida;
	}

	public List<FaseProjeto> getListaFaseProjeto() {
		return listaFaseProjeto;
	}

	public void setListaFaseProjeto(List<FaseProjeto> listaFaseProjeto) {
		this.listaFaseProjeto = listaFaseProjeto;
	}

}
