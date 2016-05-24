package entidades.projetos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class StatusFaseProjeto {

	@Id
	@GeneratedValue
	private Integer id;

	private Date dataModStatus;
	
	@ManyToOne
	private FaseProjeto faseProjeto;
	
	@ManyToOne
	private Fase fase;
	
	public StatusFaseProjeto() {
		
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

	public FaseProjeto getFaseProjeto() {
		return faseProjeto;
	}

	public void setFaseProjeto(FaseProjeto faseProjeto) {
		this.faseProjeto = faseProjeto;
	}

	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}	

}
