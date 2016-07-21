package controllers.projetos;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.projetos.SequenciaRelatorioProjeto;
import models.projetos.SequenciaRelatorioProjetoServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class SequenciaRelatorioProjetoBean {

	private SequenciaRelatorioProjeto sequenciaRelatorioProjeto;
	
	@EJB
	private SequenciaRelatorioProjetoServico sequenciaRelatorioProjetoServico;
	
	public SequenciaRelatorioProjetoBean() {

		this.sequenciaRelatorioProjeto = new SequenciaRelatorioProjeto();			
		
	}
	
	public void modificaSequenciaRelatorioProjeto() {
		
		try {
			
			this.sequenciaRelatorioProjetoServico.modificaSequenciaRelatorioProjeto(this.sequenciaRelatorioProjeto);
			JSFUtil.addInfoMessage("Sequencia modificada com sucesso.");
			this.sequenciaRelatorioProjeto = new SequenciaRelatorioProjeto();	
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());			

		}
		
	}
	
	public List<SequenciaRelatorioProjeto> listarSequenciaRelatorioProjeto() {
		
		return this.sequenciaRelatorioProjetoServico.listarSequenciaRelatorioProjeto();
		
	}
	
	public List<SequenciaRelatorioProjeto> listarSequenciaRelatorioProjetoAtivo() {
		
		return this.sequenciaRelatorioProjetoServico.listarSequenciaRelatorioProjetoAtivo();
		
	}

	public SequenciaRelatorioProjeto getSequenciaRelatorioProjeto() {
		return sequenciaRelatorioProjeto;
	}

	public void setSequenciaRelatorioProjeto(SequenciaRelatorioProjeto sequenciaRelatorioProjeto) {
		this.sequenciaRelatorioProjeto = sequenciaRelatorioProjeto;
	}

}
