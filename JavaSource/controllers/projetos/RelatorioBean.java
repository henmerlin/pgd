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
import models.projetos.FaseProjetoServico;
import models.projetos.ProjetoFaseServico;
import models.projetos.ProjetoServico;
import models.projetos.SequenciaRelatorioProjetoServico;
import models.projetos.StatusProjetoServico;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class RelatorioBean implements Serializable {
	
	private PieChartModel graficoStatus;
	
	private PieChartModel graficoEvolucao;
	
	private PieChartModel graficoFases;

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
	
	@PostConstruct
	private void init() {
		
		this.criarGraficos();		
		
	}

	public RelatorioBean() {
				
	}
	
	public void criarGraficos() {
		
		this.criaGraficoStatus();
		this.criaGraficoEvolucao();
		this.criaGraficoFase();
		
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
		this.graficoStatus.setSeriesColors("003245, 004356, 005466, 006476, 007486, 008597, 0095A7, 005B7, 0086C7, 00C6D7");
		
		
	}
	
	public void criaGraficoEvolucao() {
		
		this.graficoEvolucao = new PieChartModel();
		
		List<SequenciaRelatorioProjeto> sequenciaRelatorioProjeto = this.sequenciaRelatorioProjetoServico.listarSequenciaRelatorioProjetoAtivo();
		
		this.graficoEvolucao.set("Evolucao", this.projetoServico.listarProjetoEvolucao(true, sequenciaRelatorioProjeto).size());
		this.graficoEvolucao.set("Não Evolucao", this.projetoServico.listarProjetoEvolucao(false, sequenciaRelatorioProjeto).size());
		
		this.graficoEvolucao.setTitle("Grafico Evolucao");
		this.graficoEvolucao.setLegendPosition("sw");
		this.graficoEvolucao.setShowDataLabels(true);
		this.graficoEvolucao.setSeriesColors("003245, 004356, 005466, 006476, 007486, 008597, 0095A7, 005B7, 0086C7, 00C6D7");
		
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
		this.graficoFases.setSeriesColors("003245, 004356, 005466, 006476, 007486, 008597, 0095A7, 005B7, 0086C7, 00C6D7");
		
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

}
