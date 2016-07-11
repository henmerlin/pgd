package controllers.bugs;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.bugs.SequenciaRelatorioBug;
import models.bugs.SequenciaRelatorioBugServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class SequenciaRelatorioBugBean {

	private SequenciaRelatorioBug sequenciaRelatorioBug;
	
	
	@EJB
	private SequenciaRelatorioBugServico sequenciaRelatorioBugServico;
	
	public SequenciaRelatorioBugBean() {
		
		this.sequenciaRelatorioBug = new SequenciaRelatorioBug();
		
		
	}
	
	public void modificaSequencia() {
		
		try {
			
			this.sequenciaRelatorioBugServico.modificarSequencia(this.sequenciaRelatorioBug);
			JSFUtil.addInfoMessage("Sequencia modificada com sucesso.");
			this.sequenciaRelatorioBug = new SequenciaRelatorioBug();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<SequenciaRelatorioBug> listarSequencia() {
		
		return this.sequenciaRelatorioBugServico.listarSequencia();
		
	}
	
	public List<SequenciaRelatorioBug> listarSequenciaAtivo() {
		
		return this.sequenciaRelatorioBugServico.listarSequenciaAtivo();
		
	}	

	public SequenciaRelatorioBug getSequenciaRelatorioBug() {
		return sequenciaRelatorioBug;
	}

	public void setSequenciaRelatorioBug(SequenciaRelatorioBug sequenciaRelatorioBug) {
		this.sequenciaRelatorioBug = sequenciaRelatorioBug;
	}

}
