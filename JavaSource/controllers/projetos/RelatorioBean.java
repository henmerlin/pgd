package controllers.projetos;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.PieChartModel;

import entidades.projetos.TipoProjeto;
import models.projetos.ProjetoServico;
import models.projetos.StatusFaseProjetoServico;
import models.projetos.TipoProjetoServico;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class RelatorioBean implements Serializable {

	private PieChartModel grafico1;
	
	private PieChartModel grafico2;

	@EJB
	public ProjetoServico projetoServico;

	@EJB
	public TipoProjetoServico tipoProjetoServico;

	@EJB
	public StatusFaseProjetoServico statusFaseProjetoServico;

	@PostConstruct
	public void init() {

		this.criarGrafico();

	}

	public RelatorioBean() {

	}

	public void criarGrafico() {

		this.criarGraficoTipoProjeto();
		this.criaGraficoEvolucao();

	}

	public void criarGraficoTipoProjeto() {

		this.grafico1 = new PieChartModel();
		
		/*this.grafico1.set("Projetos Finalizados", this.projetoServico.listarProjetoConcluido().size());

		this.grafico1.set("Projetos com Evoluções", this.projetoServico.listarProjetosEvolucao(true).size());
		this.grafico1.set("Projetos sem Evoluções", this.projetoServico.listarProjetosEvolucao(false).size());*/

		List<TipoProjeto> listaTipoProjetos = this.tipoProjetoServico.listarTipoProjeto();

		for (TipoProjeto tipoProjeto : listaTipoProjetos) {

			this.grafico1.set(tipoProjeto.getNome(), this.projetoServico.listarProjetosRelatorio(tipoProjeto).size());

		}
		
		this.grafico1.setTitle("Tipos de projetos em andamento");
		this.grafico1.setLegendPosition("w");
		this.grafico1.setShowDataLabels(true);

	}
	
	public void criaGraficoEvolucao() {
		
		this.grafico2 = new PieChartModel();
		
		this.grafico2.set("Projetos com Evoluções", this.projetoServico.listarProjetosEvolucao(true).size());
		this.grafico2.set("Projetos sem Evoluções", this.projetoServico.listarProjetosEvolucao(false).size());
		
		this.grafico2.setTitle("Projetos Evolução");
		this.grafico2.setLegendPosition("w");
		this.grafico2.setShowDataLabels(true);
	}

	public PieChartModel getGrafico1() {
		return grafico1;
	}

	public void setGrafico1(PieChartModel grafico1) {
		this.grafico1 = grafico1;
	}

	public PieChartModel getGrafico2() {
		return grafico2;
	}

	public void setGrafico2(PieChartModel grafico2) {
		this.grafico2 = grafico2;
	}
	

}
