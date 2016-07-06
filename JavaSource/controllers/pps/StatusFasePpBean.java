package controllers.pps;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.pps.StatusFasePp;
import models.pps.SequenciaRelatorioPpServico;
import models.pps.StatusFasePpServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class StatusFasePpBean {

	private StatusFasePp statusFasePp;

	private StatusFasePp statusFasePpModifica;

	@EJB
	private StatusFasePpServico statusFasePpServico;
	
	@EJB
	private SequenciaRelatorioPpServico sequenciaRelatorioPpServico;

	public StatusFasePpBean() {

		this.statusFasePp = new StatusFasePp();

		this.statusFasePpModifica = new StatusFasePp();

	}

	public void cadastraStatusFase() {

		try {

			this.statusFasePpServico.cadastrarStatusFasePp(this.statusFasePp);
			
			this.sequenciaRelatorioPpServico.cadastrarSequencia(this.statusFasePp);
			
			JSFUtil.addInfoMessage("Status Fase cadastrado com sucesso.");
			this.statusFasePp = new StatusFasePp();

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public void modificaStatusFase() {

		try {

			this.statusFasePpServico.modificarStatusFasePp(this.statusFasePpModifica);
			JSFUtil.addInfoMessage("Status Fase modificada com sucesso.");
			this.statusFasePp = new StatusFasePp();

		} catch (Exception e) {

			JSFUtil.addErrorMessage("Erro ao modificar Status Fase");

		}

	}
	
	public List<StatusFasePp> listarStatusFasePp() {
		
		return this.statusFasePpServico.listarStatusFasePp();
		
	}

	public List<StatusFasePp> listarStatusFasePpAtivo() {

		return this.statusFasePpServico.listarStatusFasePpAtivo();

	}

	public StatusFasePp getStatusFasePp() {
		return statusFasePp;
	}

	public void setStatusFasePp(StatusFasePp statusFasePp) {
		this.statusFasePp = statusFasePp;
	}

	public StatusFasePp getStatusFasePpModifica() {
		return statusFasePpModifica;
	}

	public void setStatusFasePpModifica(StatusFasePp statusFasePpModifica) {
		this.statusFasePpModifica = statusFasePpModifica;
	}	

}
