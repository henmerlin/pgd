package controllers.projetos;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.projetos.TipoProjeto;
import models.projetos.TipoProjetoServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class TipoProjetoBean {
	
	private TipoProjeto tipoProjeto;
	
	@EJB
	private TipoProjetoServico projetoServico;

	public TipoProjetoBean() {
		
	}
	
	public void cadastrarTipoProjeto() {
		
		try {
			
			this.projetoServico.cadastrarTipoProjeto(this.tipoProjeto);
			JSFUtil.addInfoMessage("Projeto cadastrado com sucesso.");
			
		} catch (Exception e) {
			
			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<TipoProjeto> listarTipoProjeto() {
		
		return this.projetoServico.listarTipoProjeto();
		
	}

	public TipoProjeto getTipoProjeto() {
		return tipoProjeto;
	}

	public void setTipoProjeto(TipoProjeto tipoProjeto) {
		this.tipoProjeto = tipoProjeto;
	}	

}
