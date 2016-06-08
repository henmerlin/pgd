package controllers.projetos;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.projetos.Impacto;
import models.projetos.ImpactoServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class ImpactoBean {

	private Impacto impacto;

	private Impacto impactoCadastro;

	@EJB
	private ImpactoServico impactoServico;

	public ImpactoBean() {

		this.impacto = new Impacto();

		this.impactoCadastro = new Impacto();

	}

	public List<Impacto> listarImpacto() {

		return this.impactoServico.listarImpacto();

	}

	public List<Impacto> listarImpactoAtivo() {

		return this.impactoServico.listarImpactoAtivo();

	}

	public void modificarImpacto() {

		try {

			this.impactoServico.modificarImpacto(this.impacto);

			JSFUtil.addInfoMessage("Impacto modificado com sucesso");

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public void cadastrarImpacto() {

		try {

			this.impactoServico.cadastrarImpacto(this.impactoCadastro);

			this.impactoCadastro = new Impacto();			

			JSFUtil.addInfoMessage("Impacto cadastrado com sucesso");

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public Impacto getImpacto() {
		return impacto;
	}

	public void setImpacto(Impacto impacto) {
		this.impacto = impacto;
	}

	public Impacto getImpactoCadastro() {
		return impactoCadastro;
	}

	public void setImpactoCadastro(Impacto impactoCadastro) {
		this.impactoCadastro = impactoCadastro;
	}	

}
