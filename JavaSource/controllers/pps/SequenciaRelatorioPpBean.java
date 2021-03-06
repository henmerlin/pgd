package controllers.pps;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.pps.SequenciaRelatorioPp;
import models.pps.SequenciaRelatorioPpServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class SequenciaRelatorioPpBean {

	private SequenciaRelatorioPp sequenciaRelatorioPp;

	@EJB
	private SequenciaRelatorioPpServico sequenciaRelatorioPpServico;

	public SequenciaRelatorioPpBean() {

		this.sequenciaRelatorioPp = new SequenciaRelatorioPp();

	}	

	public void modificarSequencia() {

		try {

			this.sequenciaRelatorioPpServico.modificarSequencia(this.sequenciaRelatorioPp);
			JSFUtil.addInfoMessage("Sequencia modificada com sucesso.");
			this.sequenciaRelatorioPp = new SequenciaRelatorioPp();

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}
	
	public List<SequenciaRelatorioPp> listarSequencia() {

		return this.sequenciaRelatorioPpServico.listarSequencia();

	}

	public List<SequenciaRelatorioPp> listarSequenciaAtivo() {

		return this.sequenciaRelatorioPpServico.listarSequenciaAtivo();

	}
	
	public SequenciaRelatorioPp getSequenciaRelatorioPp() {
		return sequenciaRelatorioPp;
	}

	public void setSequenciaRelatorioPp(SequenciaRelatorioPp sequenciaRelatorioPp) {
		this.sequenciaRelatorioPp = sequenciaRelatorioPp;
	}

}
