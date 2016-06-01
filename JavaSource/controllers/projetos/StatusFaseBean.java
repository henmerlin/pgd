package controllers.projetos;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.projetos.StatusFase;
import models.projetos.StatusFaseServico;

@ManagedBean
@ViewScoped
public class StatusFaseBean {

	private StatusFase statusFase;

	@EJB
	private StatusFaseServico statusFaseServico;

	public StatusFaseBean() {

		this.statusFase = new StatusFase();

	}
	
	public List<StatusFase> listarStatusFase() {
		
		return this.statusFaseServico.listarStatusFase();
		
	}

	public StatusFase getStatusFase() {
		return statusFase;
	}

	public void setStatusFase(StatusFase statusFase) {
		this.statusFase = statusFase;
	}

}
