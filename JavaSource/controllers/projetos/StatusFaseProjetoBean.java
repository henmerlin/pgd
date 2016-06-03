package controllers.projetos;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.projetos.FaseProjeto;
import entidades.projetos.StatusFaseProjeto;
import models.projetos.StatusFaseProjetoServico;

@ManagedBean
@ViewScoped
public class StatusFaseProjetoBean {

	private StatusFaseProjeto statusFaseProjeto;
	
	@EJB
	private StatusFaseProjetoServico statusFaseProjetoServico;
		
	public StatusFaseProjetoBean() {
		
		this.statusFaseProjeto = new StatusFaseProjeto();
		
	}
		
	public List<StatusFaseProjeto> listarStatusFaseProjeto() {
		
		return this.statusFaseProjetoServico.listarStatusFaseProjeto();
		
	}
	
	public List<StatusFaseProjeto> listarStatusFaseProjetoEspecifico(FaseProjeto faseProjeto) {
		
		List<StatusFaseProjeto> lista = this.statusFaseProjetoServico.listarStatusFaseProjetoEspecifico(faseProjeto);
		
		this.statusFaseProjeto = lista.get(0);
						
		return lista;
		
	}
	
	public StatusFaseProjeto getStatusFaseProjeto() {
		return statusFaseProjeto;
	}

	public void setStatusFaseProjeto(StatusFaseProjeto statusFaseProjeto) {
		this.statusFaseProjeto = statusFaseProjeto;
	}

}
