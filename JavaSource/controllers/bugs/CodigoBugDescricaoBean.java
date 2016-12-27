package controllers.bugs;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.bugs.Bug;
import entidades.bugs.CodigoBugDescricao;
import models.bugs.CodigoBugDescricaoServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class CodigoBugDescricaoBean {

	private CodigoBugDescricao codigoBugDescricao;
	
	private CodigoBugDescricao codigoBugDescricaoModifica;
	
	@EJB
	private CodigoBugDescricaoServico codigoBugDescricaoServico;
	
	public CodigoBugDescricaoBean() {
		
		this.codigoBugDescricao = new CodigoBugDescricao();
		
		this.codigoBugDescricaoModifica = new CodigoBugDescricao();
		
	}
	
	public void cadastrarDescricao(Bug bug) {
		
		try {
			
			this.codigoBugDescricaoServico.cadastrarDescricao(this.codigoBugDescricao, bug);
			JSFUtil.addInfoMessage("Descrição cadastrada com sucesso.");
			this.codigoBugDescricao = new CodigoBugDescricao();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public void modificarDescricao() {
		
		try {
			
			this.codigoBugDescricaoServico.modificarDescricao(this.codigoBugDescricaoModifica);
			JSFUtil.addInfoMessage("Descrição modificada com sucesso.");
			this.codigoBugDescricaoModifica = new CodigoBugDescricao();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<CodigoBugDescricao> listarCodigoDescricaoBugEspecifico(Bug bug, Boolean bol) {
		
		return this.codigoBugDescricaoServico.listarCodigoDescricaoBugEspecifico(bug);
		
	}
	
	public String listarCodigoDescricaoBugEspecifico(Bug bug) {
		
		List<CodigoBugDescricao> list = this.codigoBugDescricaoServico.listarCodigoDescricaoBugEspecifico(bug);
		
		String contac = "";
		
		int contagem = 0;
		
		int contagemInicio = list.size();
		
		for (CodigoBugDescricao codigoBugDescricao : list) {
			
			String barra = "";
			
			if (contagem != contagemInicio && contagem != 0) {
				
				barra = " / ";
				
			} else {
				
				barra = "";
				
			}
			
			contac = contac + barra + codigoBugDescricao.getNome();
			
			contagem++;
			
		}
		
		return contac;
		
	}

	public CodigoBugDescricao getCodigoBugDescricao() {
		return codigoBugDescricao;
	}

	public void setCodigoBugDescricao(CodigoBugDescricao codigoBugDescricao) {
		this.codigoBugDescricao = codigoBugDescricao;
	}

	public CodigoBugDescricao getCodigoBugDescricaoModifica() {
		return codigoBugDescricaoModifica;
	}

	public void setCodigoBugDescricaoModifica(CodigoBugDescricao codigoBugDescricaoModifica) {
		this.codigoBugDescricaoModifica = codigoBugDescricaoModifica;
	}	

}
