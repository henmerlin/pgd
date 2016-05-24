package entidades.projetos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class StatusProjeto {

	@Id
	@GeneratedValue
	private Integer id;

	private Date dataModStatus;
	
	@Lob
	private String justificativa;
	
	@ManyToOne
	private Fase fase;
	
	@ManyToOne
	private Projeto projeto;
		
	public StatusProjeto() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataModStatus() {
		return dataModStatus;
	}

	public void setDataModStatus(Date dataModStatus) {
		this.dataModStatus = dataModStatus;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}	

}
