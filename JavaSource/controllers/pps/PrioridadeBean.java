package controllers.pps;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.pps.Prioridade;
import models.pps.PrioridadeServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class PrioridadeBean {

	private Prioridade prioridade;

	private Prioridade prioridadeModifica;

	@EJB
	private PrioridadeServico prioridadeServico;

	public PrioridadeBean() {

		this.prioridade = new Prioridade();

		this.prioridadeModifica = new Prioridade();

	}

	public void cadastrarPrioridade() {

		try {

			this.prioridadeServico.cadastrarPrioridade(this.prioridade);			
			JSFUtil.addInfoMessage("Prioridade cadastrada com sucesso.");
			this.prioridade = new Prioridade();

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public void modificaPrioridade() {

		try {

			this.prioridadeServico.modificaPrioridade(this.prioridadeModifica);
			JSFUtil.addInfoMessage("Prioridade modificada com sucesso.");
			this.prioridadeModifica = new Prioridade();

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public List<Prioridade> listarPrioridades() {

		return this.prioridadeServico.listarPrioridades();

	}

	public List<Prioridade> listarPrioridadesAtiva() {

		return this.prioridadeServico.listarPrioridadesAtiva();

	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}

	public Prioridade getPrioridadeModifica() {
		return prioridadeModifica;
	}

	public void setPrioridadeModifica(Prioridade prioridadeModifica) {
		this.prioridadeModifica = prioridadeModifica;
	}

}
