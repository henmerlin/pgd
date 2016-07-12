package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.ControleUsuario;
import entidades.UsuarioEfika;
import models.ControleUsuarioServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class ControleUsuarioBean {

	private ControleUsuario controleUsuario;

	private ControleUsuario controleUsuarioModifica;

	private List<String> sistemas;

	private List<String> sistemaSelected;

	private List<String> sistemaSelectedModifica;

	@EJB
	private ControleUsuarioServico controleUsuarioServico;

	@PostConstruct
	public void init() {

		sistemas = new ArrayList<String>();
		sistemas.add("PPs");
		sistemas.add("Projetos");
		sistemas.add("Bugs");

	}

	public ControleUsuarioBean() {

		this.controleUsuario = new ControleUsuario();

		this.controleUsuarioModifica = new ControleUsuario();

		this.sistemaSelected = new ArrayList<String>();

		this.sistemaSelectedModifica = new ArrayList<String>();

	}

	public void cadastrarUsuario() {

		try {
			
			this.controleUsuarioServico.cadastrarUsuario(this.controleUsuario, this.sistemaSelected);
			JSFUtil.addInfoMessage("Controle cadastrado com sucesso.");
			this.controleUsuario = new ControleUsuario();
			this.sistemaSelected = new ArrayList<String>();


		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}
	
	public void cadastraControle() {
		
		try {
			
			this.controleUsuario = this.controleUsuarioServico.buscarControleUsuarioEspecifico(this.controleUsuario.getUsuarioEfika());
			JSFUtil.addInfoMessage("Controle para o usuário já cadastrado, por favor modifique na lista.");			
			
		} catch (Exception e) {
			
			this.cadastrarUsuario();
			
		}
		
	}
	
	
	public void modificaUsuario() {

		try {

			this.controleUsuarioServico.modificaUsuario(this.controleUsuarioModifica, this.sistemaSelectedModifica);
			JSFUtil.addInfoMessage("Controle modificado com sucesso.");
			this.controleUsuarioModifica = new ControleUsuario();

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public List<ControleUsuario> listarControleUsuario() {

		return this.controleUsuarioServico.listarControleUsuario();

	}

	public List<UsuarioEfika> listaDeUsuario() {

		return this.controleUsuarioServico.listaDeUsuario();

	}

	public ControleUsuario getControleUsuario() {
		return controleUsuario;
	}

	public void setControleUsuario(ControleUsuario controleUsuario) {
		this.controleUsuario = controleUsuario;
	}

	public ControleUsuario getControleUsuarioModifica() {
		return controleUsuarioModifica;
	}

	public void setControleUsuarioModifica(ControleUsuario controleUsuarioModifica) {
		this.controleUsuarioModifica = controleUsuarioModifica;
	}

	public List<String> getSistemas() {
		return sistemas;
	}

	public void setSistemas(List<String> sistemas) {
		this.sistemas = sistemas;
	}

	public List<String> getSistemaSelected() {
		return sistemaSelected;
	}

	public void setSistemaSelected(List<String> sistemaSelected) {
		this.sistemaSelected = sistemaSelected;
	}

	public List<String> getSistemaSelectedModifica() {
		return sistemaSelectedModifica;
	}

	public void setSistemaSelectedModifica(List<String> sistemaSelectedModifica) {
		this.sistemaSelectedModifica = sistemaSelectedModifica;
	}	

}
