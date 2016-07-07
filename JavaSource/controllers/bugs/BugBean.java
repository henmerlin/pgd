package controllers.bugs;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.bugs.Bug;
import models.bugs.BugServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class BugBean {

	private Bug bug;
	
	
	@EJB
	private BugServico bugServico;
	
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

	public Bug getBug() {
		return bug;
	}

	public void setBug(Bug bug) {
		this.bug = bug;
	}	

}
