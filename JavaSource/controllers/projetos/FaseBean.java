package controllers.projetos;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.projetos.Fase;
import models.projetos.FaseServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class FaseBean {

	private Fase fase;

	private Fase faseCadastro;

	@EJB
	private FaseServico faseServico;

	public FaseBean() {

		this.fase = new Fase();

		this.faseCadastro = new Fase();

	}

	public List<Fase> listarFases() {

		return faseServico.listarFases();

	}

	public List<Fase> listarFasesAtiva() {

		return faseServico.listarFasesAtiva();

	}

	public void modificarFase() {

		try {

			this.faseServico.modificarFase(this.fase);

			this.fase = new Fase();

			JSFUtil.addInfoMessage("Fase modificada com sucesso");

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public void cadastrarFase() {

		try {

			this.faseServico.cadastrarFase(this.faseCadastro);

			this.faseCadastro = new Fase();

			JSFUtil.addInfoMessage("Fase cadastrada com sucesso");

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	public Fase getFaseCadastro() {
		return faseCadastro;
	}

	public void setFaseCadastro(Fase faseCadastro) {
		this.faseCadastro = faseCadastro;
	}

}
