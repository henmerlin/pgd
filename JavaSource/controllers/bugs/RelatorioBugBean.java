package controllers.bugs;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.PieChartModel;

import entidades.bugs.FasesBug;
import entidades.bugs.StatusBug;
import models.bugs.BugServico;
import models.bugs.DetalhesBugServico;
import models.bugs.FasesBugServico;
import models.bugs.SequenciaRelatorioBugServico;
import models.bugs.StatusBugServico;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class RelatorioBugBean implements Serializable{
	
	private PieChartModel graficoPorStatus;
	
	private PieChartModel graficoPorFases;
	
	@EJB
	private StatusBugServico statusBugServico;
	
	@EJB
	private BugServico bugServico;
	
	@EJB
	private FasesBugServico fasesBugServico;
	
	@EJB
	private DetalhesBugServico detalhesBugServico;
	
	@EJB
	private SequenciaRelatorioBugServico sequenciaRelatorioBugServico;
	
	public RelatorioBugBean() {
		
		
	}
	
	@PostConstruct
	public void init() {
		
		this.criaGraficos();
		
	}
	
	public void criaGraficos() {
		
		this.graficoStatus();
		this.graficoFases();
		
	}
	
	public void graficoStatus() {
		
		this.graficoPorStatus = new PieChartModel();
		
		List<StatusBug> listStatus = this.statusBugServico.listarStatusAtivo();
		
		for (StatusBug statusBug : listStatus) {
			
			Integer total = this.bugServico.listarBugPorFase(statusBug).size();
			
			this.graficoPorStatus.set(statusBug.getNome(), total);
			
		}
		
		this.graficoPorStatus.setTitle("Gráfico Status");
		this.graficoPorStatus.setLegendPosition("w");
		this.graficoPorStatus.setShowDataLabels(true);
		this.graficoPorStatus.setSeriesColors("003245, 004356, 005466, 006476, 007486, 008597, 0095A7, 005B7, 0086C7, 00C6D7");
		
		
	}
	
	public void graficoFases() {
		
		this.graficoPorFases = new PieChartModel();
		
		List<FasesBug> listFases = this.fasesBugServico.listarFaseBugAtivo();
				
		for (FasesBug fasesBug : listFases) {
			
			Integer total = this.detalhesBugServico.listarDetalhesBugPorFase(fasesBug).size();
			
			this.graficoPorFases.set(fasesBug.getNome(), total);
			
		}
		
		this.graficoPorFases.setTitle("Gráfico Fase");
		this.graficoPorFases.setLegendPosition("e");
		this.graficoPorFases.setShowDataLabels(true);
		this.graficoPorFases.setSeriesColors("003245, 004356, 005466, 006476, 007486, 008597, 0095A7, 005B7, 0086C7, 00C6D7");
		
	}

	public PieChartModel getGraficoPorStatus() {
		return graficoPorStatus;
	}

	public void setGraficoPorStatus(PieChartModel graficoPorStatus) {
		this.graficoPorStatus = graficoPorStatus;
	}

	public PieChartModel getGraficoPorFases() {
		return graficoPorFases;
	}

	public void setGraficoPorFases(PieChartModel graficoPorFases) {
		this.graficoPorFases = graficoPorFases;
	}

}
