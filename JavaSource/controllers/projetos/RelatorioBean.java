package controllers.projetos;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.PieChartModel;

import entidades.projetos.ProjetoFase;
import entidades.projetos.SequenciaRelatorioProjeto;
import entidades.projetos.StatusProjeto;
import entidades.projetos.TipoProjeto;
import models.projetos.FaseProjetoServico;
import models.projetos.ProjetoFaseServico;
import models.projetos.ProjetoServico;
import models.projetos.SequenciaRelatorioProjetoServico;
import models.projetos.StatusProjetoServico;
import models.projetos.TipoProjetoServico;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class RelatorioBean implements Serializable {
	
	private PieChartModel graficoStatus;
	
	private PieChartModel graficoEvolucao;
	
	private PieChartModel graficoFases;
	
	private PieChartModel graficoStatusPorTipo;
	
	private PieChartModel graficoProjPreProj;
	
	private PieChartModel graficoImpactoPorTipo;

	@EJB
	private ProjetoServico projetoServico;
	
	@EJB
	private StatusProjetoServico statusProjetoServico;
	
	@EJB
	private SequenciaRelatorioProjetoServico sequenciaRelatorioProjetoServico;
	
	@EJB
	private FaseProjetoServico faseProjetoServico;
	
	@EJB
	private ProjetoFaseServico projetoFaseServico;
	
	@EJB
	private TipoProjetoServico tipoProjetoServico;
	
	@PostConstruct
	private void init() {
		
		this.criarGraficos();		
		
	}

	public RelatorioBean() {
				
	}
	
	public void criarGraficos() {
		
		/*this.criaGraficoStatus();
		this.criaGraficoEvolucao();
		this.criaGraficoFase();*/
		this.criaGraficoProjOuPreProj();
		this.criaGraficoStatusPorTipo();
		this.criaGraficoImpactoPorTipo();
		
	}
	
	public void criaGraficoStatus() {
		
		this.graficoStatus = new PieChartModel();
		
		List<StatusProjeto> listaDeStatusProjeto = this.statusProjetoServico.listarStatusAtivo();
		
		for (StatusProjeto statusProjeto : listaDeStatusProjeto) {
			
			Integer total = this.projetoServico.listarProjetosStatusEspecifico(statusProjeto).size();
			
			this.graficoStatus.set(statusProjeto.getNome(), total);
			
		}	
		
		this.graficoStatus.setTitle("Grafico Status");
		this.graficoStatus.setLegendPosition("sw");
		this.graficoStatus.setShowDataLabels(true);
		
		
	}
	
	public void criaGraficoEvolucao() {
		
		this.graficoEvolucao = new PieChartModel();
		
		List<SequenciaRelatorioProjeto> sequenciaRelatorioProjeto = this.sequenciaRelatorioProjetoServico.listarSequenciaRelatorioProjetoAtivo();
		
		this.graficoEvolucao.set("Evolucao", this.projetoServico.listarProjetoEvolucao(true, sequenciaRelatorioProjeto).size());
		this.graficoEvolucao.set("Não Evolucao", this.projetoServico.listarProjetoEvolucao(false, sequenciaRelatorioProjeto).size());
		
		this.graficoEvolucao.setTitle("Grafico Evolucao");
		this.graficoEvolucao.setLegendPosition("sw");
		this.graficoEvolucao.setShowDataLabels(true);
		
	}
	
	public void criaGraficoFase() {
		
		this.graficoFases = new PieChartModel();

		List<ProjetoFase> listaDeFases = this.projetoFaseServico.listarProjetoFaseAtivo();
		
		List<SequenciaRelatorioProjeto> sequenciaRelatorioProjeto = this.sequenciaRelatorioProjetoServico.listarSequenciaRelatorioProjetoAtivo();
		
		for (ProjetoFase projetoFase : listaDeFases) {
			
			Integer total = this.faseProjetoServico.listarFaseProjetoStatusEspecifico(projetoFase, sequenciaRelatorioProjeto).size();
			
			this.graficoFases.set(projetoFase.getNome(), total);
			
		}
		
		
		this.graficoFases.setTitle("Grafico Fases");
		this.graficoFases.setLegendPosition("sw");
		this.graficoFases.setShowDataLabels(true);
		
	}
	
	public void criaGraficoProjOuPreProj() {
		
		this.graficoProjPreProj = new PieChartModel();
		
		List<TipoProjeto> tipoProjetos = this.tipoProjetoServico.listarTipoProjetoAtivo();		
		
		for (TipoProjeto tipoProjeto : tipoProjetos) {
			
			Integer total = this.projetoServico.listarProjetosTipoProjeto(tipoProjeto).size();
			
			this.graficoProjPreProj.set(tipoProjeto.getNome(), total);
			
		}
		
		this.graficoProjPreProj.setTitle("Grafico Tipo Projeto");
		this.graficoProjPreProj.setLegendPosition("sw");
		this.graficoProjPreProj.setShowDataLabels(true);
		
	}
	
	public void criaGraficoStatusPorTipo() {
		
		this.graficoStatusPorTipo = new PieChartModel();		
		
		List<StatusProjeto> listaDeStatusProjeto = this.statusProjetoServico.listarStatusAtivo();
		
		List<TipoProjeto> tipoProjetos = this.tipoProjetoServico.listarTipoProjetoAtivo();
		
		for (StatusProjeto statusProjeto : listaDeStatusProjeto) {
			
			for (TipoProjeto tipoProjeto : tipoProjetos) {
				
				Integer total = this.projetoServico.listarProjetoPorStatusETipo(statusProjeto, tipoProjeto).size();
				
				this.graficoStatusPorTipo.set(statusProjeto.getNome() + " - " + tipoProjeto.getNome(), total);				
				
			}
			
		}
		
		this.graficoStatusPorTipo.setTitle("Grafico Tipo Projeto por Status");
		this.graficoStatusPorTipo.setLegendPosition("sw");
		this.graficoStatusPorTipo.setShowDataLabels(true);		
		
	}
	
	public void criaGraficoImpactoPorTipo() {
		
		this.graficoImpactoPorTipo = new PieChartModel();
		
		List<TipoProjeto> tipoProjetos = this.tipoProjetoServico.listarTipoProjetoAtivo();
		
		Boolean trueFalse = true;
		
		for (TipoProjeto tipoProjeto : tipoProjetos) {
			
			if (trueFalse) {
				
				Integer totalTrue = this.projetoServico.listarProjetosPorImpactoETipo(true, tipoProjeto).size();
				this.graficoImpactoPorTipo.set(tipoProjeto.getNome() + " - Impacta o CO", totalTrue);
				
				trueFalse = false;
				
			} else {
				
				Integer totalFalse = this.projetoServico.listarProjetosPorImpactoETipo(false, tipoProjeto).size();
				this.graficoImpactoPorTipo.set(tipoProjeto.getNome() + " - Não Impacta o CO", totalFalse);
				
			}
						
		}
		
		this.graficoImpactoPorTipo.setTitle("Grafico Tipo Projeto por Impacto");
		this.graficoImpactoPorTipo.setLegendPosition("sw");
		this.graficoImpactoPorTipo.setShowDataLabels(true);		
		
	}
	
	

	public PieChartModel getGraficoStatus() {
		return graficoStatus;
	}

	public void setGraficoStatus(PieChartModel graficoStatus) {
		this.graficoStatus = graficoStatus;
	}

	public PieChartModel getGraficoEvolucao() {
		return graficoEvolucao;
	}

	public void setGraficoEvolucao(PieChartModel graficoEvolucao) {
		this.graficoEvolucao = graficoEvolucao;
	}

	public PieChartModel getGraficoFases() {
		return graficoFases;
	}

	public void setGraficoFases(PieChartModel graficoFases) {
		this.graficoFases = graficoFases;
	}

	public PieChartModel getGraficoProjPreProj() {
		return graficoProjPreProj;
	}

	public void setGraficoProjPreProj(PieChartModel graficoProjPreProj) {
		this.graficoProjPreProj = graficoProjPreProj;
	}

	public PieChartModel getGraficoStatusPorTipo() {
		return graficoStatusPorTipo;
	}

	public void setGraficoStatusPorTipo(PieChartModel graficoStatusPorTipo) {
		this.graficoStatusPorTipo = graficoStatusPorTipo;
	}

	public PieChartModel getGraficoImpactoPorTipo() {
		return graficoImpactoPorTipo;
	}

	public void setGraficoImpactoPorTipo(PieChartModel graficoImpactoPorTipo) {
		this.graficoImpactoPorTipo = graficoImpactoPorTipo;
	}	

}
