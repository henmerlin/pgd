package controllers.bugs;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.bugs.Bug;
import entidades.bugs.SequenciaRelatorioBug;
import models.bugs.BugServico;
import models.bugs.SequenciaRelatorioBugServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class BugBean {

	private Bug bug;	
	
	private List<Bug> bugsSelecionados;
	
	@EJB
	private BugServico bugServico;
	
	@EJB
	private SequenciaRelatorioBugServico sequenciaRelatorioBugServico;
	
	public BugBean() {
		
		this.bug = new Bug();
				
	}
	
	public void cadastrarBug() {
		
		try {
			
			this.bugServico.cadastrarBug(this.bug);
			JSFUtil.addInfoMessage("Bug cadastrado com sucesso.");
			this.bug = new Bug();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public void modificaBug() {
		
		try {
			
			this.bugServico.modificarBug(this.bug);
			JSFUtil.addInfoMessage("Bug modificado com sucesso.");
			
		} catch (Exception e) {
			
			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<Bug> listarBugs() {
		
		return this.bugServico.listarBugs();
		
	}
	
	public Bug listarBugEspecifico() {
		
		try {
			
			this.bug = this.bugServico.listarBugEspecifico(this.bug);
			
			return this.bug;
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			return null;
			
		}
		
	}
	
	public List<Bug> listarBugEmTrabalho() {
		
		List<SequenciaRelatorioBug> listaSequencia = this.sequenciaRelatorioBugServico.listarSequenciaAtivo();
		
		return this.bugServico.listarBugPorStatus(listaSequencia);
		
	}

	public Bug getBug() {
		return bug;
	}

	public void setBug(Bug bug) {
		this.bug = bug;
	}

	public List<Bug> getBugsSelecionados() {
		return bugsSelecionados;
	}

	public void setBugsSelecionados(List<Bug> bugsSelecionados) {
		this.bugsSelecionados = bugsSelecionados;
	}	
	
}
