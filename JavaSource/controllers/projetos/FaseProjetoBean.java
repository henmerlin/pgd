package controllers.projetos;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.projetos.FaseProjeto;
import entidades.projetos.Projeto;
import entidades.projetos.StatusFaseProjeto;
import models.projetos.FaseProjetoServico;
import models.projetos.StatusFaseProjetoServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class FaseProjetoBean {

	private FaseProjeto faseProjeto;

	private FaseProjeto faseProjeto1;

	private StatusFaseProjeto statusFaseProjeto;

	private StatusFaseProjeto statusFaseProjeto1;

	@EJB
	private FaseProjetoServico faseProjetoServico;

	@EJB
	private StatusFaseProjetoServico statusFaseProjetoServico;

	public FaseProjetoBean() {

		this.faseProjeto = new FaseProjeto();

		this.statusFaseProjeto = new StatusFaseProjeto();
		
		this.statusFaseProjeto1 = new StatusFaseProjeto();

	}

	public void cadastrarFaseProjeto(Projeto projeto) {

		try {

			this.faseProjeto.setProjeto(projeto);

			this.faseProjetoServico.cadastrarFaseProjeto(this.faseProjeto);

			this.cadastrarStatusFaseProjeto();

			this.faseProjeto = new FaseProjeto();

			JSFUtil.addInfoMessage("Fase cadastrada com sucesso");

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public void cadastrarStatusFaseProjeto() {

		try {

			Date data = new Date();

			this.statusFaseProjeto.setDataModStatus(data);

			this.statusFaseProjeto.setFaseProjeto(this.faseProjeto);

			this.statusFaseProjetoServico.cadastrarStatusFaseProjeto(this.statusFaseProjeto);

			this.statusFaseProjeto = new StatusFaseProjeto();

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public List<FaseProjeto> listarFaseProjetoEspecifico(Projeto projeto) {

		return this.faseProjetoServico.listarFaseProjetoEspecifico(projeto);

	}

	public void modificarFase(Projeto projeto) {

		try {

			this.faseProjeto1.setProjeto(projeto);

			this.faseProjetoServico.modificarFaseProjeto(this.faseProjeto1);

			this.cadastrarStatusFaseProjeto1();

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());			

		}

	}

	public void cadastrarStatusFaseProjeto1() {

		try {

			Date data = new Date();

			this.statusFaseProjeto1.setDataModStatus(data);

			this.statusFaseProjeto1.setFaseProjeto(this.faseProjeto1);

			this.statusFaseProjetoServico.cadastrarStatusFaseProjeto(this.statusFaseProjeto1);

			this.statusFaseProjeto1 = new StatusFaseProjeto();

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public FaseProjeto getFaseProjeto() {
		return faseProjeto;
	}

	public void setFaseProjeto(FaseProjeto faseProjeto) {
		this.faseProjeto = faseProjeto;
	}

	public StatusFaseProjeto getStatusFaseProjeto() {
		return statusFaseProjeto;
	}

	public void setStatusFaseProjeto(StatusFaseProjeto statusFaseProjeto) {
		this.statusFaseProjeto = statusFaseProjeto;
	}

	public FaseProjeto getFaseProjeto1() {
		return faseProjeto1;
	}

	public void setFaseProjeto1(FaseProjeto faseProjeto1) {
		this.faseProjeto1 = faseProjeto1;
	}

	public StatusFaseProjeto getStatusFaseProjeto1() {
		return statusFaseProjeto1;
	}

	public void setStatusFaseProjeto1(StatusFaseProjeto statusFaseProjeto1) {
		this.statusFaseProjeto1 = statusFaseProjeto1;
	}

}
