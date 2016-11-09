package controllers.projetos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.google.gson.Gson;

import entidades.projetos.FaseProjeto;
import entidades.projetos.FaseTimeline;
import entidades.projetos.Projeto;
import models.projetos.FaseProjetoServico;

@ManagedBean
@ViewScoped
public class Grafico {
	
	private List<FaseProjeto> listaDeFases;
	
	@EJB
	private FaseProjetoServico faseProjetoServico;
	
	public Grafico() {

		
	}
	
	public void listarFaseProjetoEspecificoList(Projeto projeto) {		
		
		this.listaDeFases = this.faseProjetoServico.listarFaseProjetoEspecifico(projeto);		

	}
	
	public List<FaseTimeline> listaTimeLine() {

		List<FaseTimeline> faseTimelines = new ArrayList<FaseTimeline>();
		
		for (FaseProjeto faseProjeto : listaDeFases) {
			
			FaseTimeline timeline = new FaseTimeline();
			
			timeline.setNome(faseProjeto.getProjetoFase().getNome());
			timeline.setDataInicio(faseProjeto.getDataInicio());
			timeline.setDataFim(faseProjeto.getDataFim());
			
			faseTimelines.add(timeline);
			
		}
		
		return faseTimelines;
		
	}
	
	public String paraJson() {
		
		Gson gson = new Gson();
		
		String json = gson.toJson(this.listaTimeLine());
		
		System.out.println(json);
		
		return json;
		
	}
	
	public List<FaseProjeto> getListaDeFases() {
		return listaDeFases;
	}

	public void setListaDeFases(List<FaseProjeto> listaDeFases) {
		this.listaDeFases = listaDeFases;
	}	
			
}
