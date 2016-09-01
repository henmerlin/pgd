package controllers.bugs;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.bugs.Bug;
import entidades.bugs.SistemaAfetadoBug;
import models.bugs.SistemaAfetadoBugServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class SistemaAfetadoBugBean {

	private SistemaAfetadoBug sistemaAfetadoBug;

	private SistemaAfetadoBug sistemaAfetadoBugModifica;

	@EJB
	private SistemaAfetadoBugServico sistemaAfetadoBugServico;

	public SistemaAfetadoBugBean() {

		this.sistemaAfetadoBug = new SistemaAfetadoBug();

		this.sistemaAfetadoBugModifica = new SistemaAfetadoBug();

	}

	public void cadastrarSistemaAfetadoBug(Bug bug) {

		try {

			this.sistemaAfetadoBugServico.cadastrarSistemaAfetadoBug(this.sistemaAfetadoBug, bug);
			JSFUtil.addInfoMessage("Sistema cadastrado com sucesso.");
			this.sistemaAfetadoBug = new SistemaAfetadoBug();

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public void modificarSistemaAfetadoBug() {

		try {

			this.sistemaAfetadoBugServico.modificarSistemaAfetadoBug(this.sistemaAfetadoBugModifica);
			JSFUtil.addInfoMessage("Sistema modificado com sucesso.");
			this.sistemaAfetadoBugModifica = new SistemaAfetadoBug();

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public List<SistemaAfetadoBug> listarSistemaAfetadoEspecificoBug(Bug bug, Boolean bol) {

		return this.sistemaAfetadoBugServico.listarSistemaAfetadoEspecificoBug(bug);

	}

	public String listarSistemaAfetadoEspecificoBug(Bug bug) {

		List<SistemaAfetadoBug> list = this.sistemaAfetadoBugServico.listarSistemaAfetadoEspecificoBug(bug);

		String contac = "";

		int contagem = 0;

		int contagemInicio = list.size();

		for (SistemaAfetadoBug sistemaAfetadoBug : list) {

			String barra = "";

			if (contagem != contagemInicio && contagem != 0) {

				barra = " / ";

			} else {

				barra = "";

			}			
			
			contac = contac + barra + sistemaAfetadoBug.getSistemaAfetado().getNome();
			
			contagem++;

		}

		return contac;

	}

	public SistemaAfetadoBug getSistemaAfetadoBug() {
		return sistemaAfetadoBug;
	}

	public void setSistemaAfetadoBug(SistemaAfetadoBug sistemaAfetadoBug) {
		this.sistemaAfetadoBug = sistemaAfetadoBug;
	}

	public SistemaAfetadoBug getSistemaAfetadoBugModifica() {
		return sistemaAfetadoBugModifica;
	}

	public void setSistemaAfetadoBugModifica(SistemaAfetadoBug sistemaAfetadoBugModifica) {
		this.sistemaAfetadoBugModifica = sistemaAfetadoBugModifica;
	}

}
