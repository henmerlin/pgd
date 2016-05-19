package controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.Area;
import models.AreaServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class AreaBean {
	
	private Area area;
		
	@EJB
	private AreaServico areaServico;
	
	public AreaBean() {		
		
		this.area = new Area();
		
	}
	
	public void cadastrarArea() {
		
		try {
			
			this.areaServico.cadastrarArea(this.area);		
			
			this.area = new Area();
			
			JSFUtil.addInfoMessage("Area cadastrada com sucesso");
						
		} catch (Exception e) {
			
			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<Area> listarAreas() {
		
		return this.areaServico.listarAreas();
		
	}	

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}	

}
