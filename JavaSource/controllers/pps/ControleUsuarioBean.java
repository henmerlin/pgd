package controllers.pps;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.UsuarioEfika;
import entidades.pps.ControleUsuario;
import models.projetos.ControleUsuarioServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class ControleUsuarioBean {

	private ControleUsuario controleUsuario;

	private ControleUsuario controleUsuarioModifica;

	@EJB
	private ControleUsuarioServico controleUsuarioPpServico;

	public ControleUsuarioBean() {

		this.controleUsuario = new ControleUsuario();

		this.controleUsuarioModifica = new ControleUsuario();

	}

	public void cadastrarUsuario() {

		try {

			this.controleUsuarioPpServico.cadastrarUsuario(this.controleUsuario);
			JSFUtil.addInfoMessage("Controle cadastrado com sucesso.");
			this.controleUsuario = new ControleUsuario();

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public void modificaUsuario() {

		try {

			this.controleUsuarioPpServico.modificaUsuario(this.controleUsuarioModifica);
			JSFUtil.addInfoMessage("Controle modificado com sucesso.");
			this.controleUsuarioModifica = new ControleUsuario();

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public List<ControleUsuario> listarControleUsuario() {

		return this.controleUsuarioPpServico.listarControleUsuario();

	}

	public List<UsuarioEfika> listaDeUsuario() {

		return this.controleUsuarioPpServico.listaDeUsuario();

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

}
