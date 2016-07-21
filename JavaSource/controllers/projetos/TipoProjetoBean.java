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
	
	private TipoProjeto tipoProjetoModifica;
	
	@EJB
	private TipoProjetoServico tipoProjetoServico;
	
		
	public TipoProjetoBean() {
		
		this.tipoProjeto = new TipoProjeto();
		
		this.tipoProjetoModifica = new TipoProjeto();
		
	}
	
	public void cadastrarTipoProjeto() {
		
		try {
			
			this.tipoProjetoServico.cadastrarTipoProjeto(this.tipoProjeto);
			JSFUtil.addInfoMessage("Tipo Projeto cadastrado com sucesso.");			
			this.tipoProjeto = new TipoProjeto();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public void modificarTipoProjeto() {
		
		try {
			
			this.tipoProjetoServico.modificarTipoProjeto(this.tipoProjetoModifica);
			JSFUtil.addInfoMessage("Tipo Projeto modificado com sucesso.");
			this.tipoProjetoModifica = new TipoProjeto();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<TipoProjeto> listarTipoProjeto() {
		
		return this.tipoProjetoServico.listarTipoProjeto();
		
	}
	
	public List<TipoProjeto> listarTipoProjetoAtivo() {
		
		return this.tipoProjetoServico.listarTipoProjetoAtivo();
		
	}

	public TipoProjeto getTipoProjeto() {
		return tipoProjeto;
	}

	public void setTipoProjeto(TipoProjeto tipoProjeto) {
		this.tipoProjeto = tipoProjeto;
	}

	public TipoProjeto getTipoProjetoModifica() {
		return tipoProjetoModifica;
	}

	public void setTipoProjetoModifica(TipoProjeto tipoProjetoModifica) {
		this.tipoProjetoModifica = tipoProjetoModifica;
	}	
	
}
