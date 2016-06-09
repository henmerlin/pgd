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

	private PieChartModel grafico3;

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
		this.criaGraficoGeral();

	}

	public void criarGraficoTipoProjeto() {

		this.grafico1 = new PieChartModel();	

		List<TipoProjeto> listaTipoProjetos = this.tipoProjetoServico.listarTipoProjeto();
		
		Integer total = 0;

		for (TipoProjeto tipoProjeto : listaTipoProjetos) {
			
			Integer numero = this.projetoServico.listarProjetosRelatorio(tipoProjeto).size();			
			
			this.grafico1.set(tipoProjeto.getNome(), numero);
			
			total += numero;

		}

		this.grafico1.setTitle("Tipos de projetos (Total " + total + ")");
		this.grafico1.setLegendPosition("se");
		this.grafico1.setShowDataLabels(true);
		this.grafico1.setSeriesColors("003245, 004356, 005466, 006476, 007486, 008597, 0095A7, 005B7, 0086C7, 00C6D7");

	}

	public void criaGraficoEvolucao() {

		this.grafico2 = new PieChartModel();
		
		Integer evolucaoTrue = this.projetoServico.listarProjetosEvolucao(true).size();
		
		Integer evolucaoFalse = this.projetoServico.listarProjetosEvolucao(false).size();
		
		Integer total = evolucaoTrue + evolucaoFalse;

		this.grafico2.set("Projetos com Evoluções", evolucaoTrue);
		this.grafico2.set("Projetos sem Evoluções", evolucaoFalse);

		this.grafico2.setTitle("Projetos Evolução (Total " + total + ")");
		this.grafico2.setLegendPosition("se");
		this.grafico2.setShowDataLabels(true);
		this.grafico2.setSeriesColors("003245, 005466, 007486, 0095A7, 00B6C7");
	}

	public void criaGraficoGeral() {

		this.grafico3 = new PieChartModel();
		
		this.grafico3.set("Projetos Paralisados", this.projetoServico.listarProjetoStatusEspecifico("Paralisado").size());
		this.grafico3.set("Projetos Finalizados", this.projetoServico.listarProjetoStatusEspecifico("Concluído").size());
		this.grafico3.set("Projetos Cancelados", this.projetoServico.listarProjetoStatusEspecifico("Cancelado").size());
		this.grafico3.set("Projetos em Andamento", this.projetoServico.listarProjetoStatusEspecifico("Em andamento").size());
		this.grafico3.set("Projetos a Iniciar", this.projetoServico.listarProjetoStatusEspecifico("A iniciar").size());

		this.grafico3.setTitle("Geral (Total " + this.projetoServico.listarProjeto().size() + ")");
		this.grafico3.setLegendPosition("se");
		this.grafico3.setShowDataLabels(true);
		this.grafico3.setSeriesColors("003245, 005466, 007486, 0095A7, 00B6C7");
		
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

	public PieChartModel getGrafico3() {
		return grafico3;
	}

	public void setGrafico3(PieChartModel grafico3) {
		this.grafico3 = grafico3;
	}		

}
