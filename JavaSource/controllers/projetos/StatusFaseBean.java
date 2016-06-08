package controllers.projetos;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.projetos.StatusFase;
import models.projetos.StatusFaseServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class StatusFaseBean {

	private StatusFase statusFase;

	private StatusFase statusFaseCadastro;

	@EJB
	private StatusFaseServico statusFaseServico;

	public StatusFaseBean() {

		this.statusFase = new StatusFase();

		this.statusFaseCadastro = new StatusFase();

	}

	public void modificarCadastrarStatusFase() {

		try {

			this.statusFaseServico.modificarCadastrarStatusFase(this.statusFase);

			this.statusFase = new StatusFase();

			JSFUtil.addInfoMessage("Status modificado com sucesso");

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public void cadastrarCadastrarStatusFase() {

		try {

			this.statusFaseServico.cadastrarCadastrarStatusFase(this.statusFaseCadastro);

			this.statusFaseCadastro = new StatusFase();

			JSFUtil.addInfoMessage("Status cadastrado com sucesso");

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public List<StatusFase> listarStatusFase() {

		return this.statusFaseServico.listarStatusFase();

	}

	public List<StatusFase> listarStatusFaseAtivo() {

		return this.statusFaseServico.listarStatusFaseAtivo();

	}

	public StatusFase getStatusFase() {
		return statusFase;
	}

	public void setStatusFase(StatusFase statusFase) {
		this.statusFase = statusFase;
	}

	public StatusFase getStatusFaseCadastro() {
		return statusFaseCadastro;
	}

	public void setStatusFaseCadastro(StatusFase statusFaseCadastro) {
		this.statusFaseCadastro = statusFaseCadastro;
	}	

}
