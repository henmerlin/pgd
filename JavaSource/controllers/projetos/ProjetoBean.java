package controllers.projetos;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.projetos.DataImplantacaoProjeto;
import entidades.projetos.Projeto;
import entidades.projetos.TipoProjeto;
import models.projetos.DataImplantacaoProjetoServico;
import models.projetos.ProjetoServico;
import models.projetos.StatusFaseServico;
import models.projetos.TipoProjetoServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class ProjetoBean {

	private Projeto projeto;

	private DataImplantacaoProjeto dataImplantacao;

	@EJB
	private ProjetoServico projetoServico;

	@EJB
	private DataImplantacaoProjetoServico dataImplantacaoProjetoServico;
	
	@EJB
	public TipoProjetoServico tipoProjetoServico;
	
	@EJB
	public StatusFaseServico statusFaseServico;

	public ProjetoBean() {

		this.projeto = new Projeto();

		this.dataImplantacao = new DataImplantacaoProjeto();

	}

	public void cadastrarProjeto() {

		try {
			
			this.projeto.setStatusFase(this.statusFaseServico.listarStatusFaseEspecifico("A iniciar"));

			this.projetoServico.cadastrarProjeto(this.projeto);

			associativaDataImplantacao();

			this.projeto = new Projeto();

			JSFUtil.addInfoMessage("Projeto cadastrado com sucesso");

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public void associativaDataImplantacao() {

		try {

			this.dataImplantacao.setProjeto(this.projeto);

			this.dataImplantacao.setDescricao("Primeira data");

			this.dataImplantacaoProjetoServico.cadastrarDataImplantacao(this.dataImplantacao);

			this.dataImplantacao = new DataImplantacaoProjeto();			

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public List<Projeto> listarProjeto() {

		return this.projetoServico.listarProjeto();

	}
	
	public List<Projeto> listarProjetoAndamento() {

		return this.projetoServico.listarProjetoAndamento();

	}

	public Projeto listarProjetoEspecifico() {

		try {

			this.projeto = this.projetoServico.listarProjetoEspecifico(this.projeto);
			return this.projeto;			

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			return null;

		}

	}

	public void updaterProjeto() {		

		try {

			this.projetoServico.updaterProjeto(this.projeto);
			JSFUtil.addInfoMessage("Projeto modificado com sucesso");

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}
	
	public List<Projeto> listarProjetoConcluido() {
				
		return this.projetoServico.listarProjetoStatusEspecifico("Concluído");
		
	}
	
	public List<Projeto> listarProjetosEvolucao(Boolean evo) {
		
		return this.projetoServico.listarProjetosEvolucao(evo);
		
	}
	
	public List<Projeto> listarProjetoOutroStatus() {
		
		return this.projetoServico.listarProjetoStatusEspecifico("Concluído");
		
	}
	
	public List<Projeto> listarProjetosRelatorio(TipoProjeto tipoProjeto) {
		
		return this.projetoServico.listarProjetosRelatorio(tipoProjeto);
		
	}
	
	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public DataImplantacaoProjeto getDataImplantacao() {
		return dataImplantacao;
	}

	public void setDataImplantacao(DataImplantacaoProjeto dataImplantacao) {
		this.dataImplantacao = dataImplantacao;
	}

}
