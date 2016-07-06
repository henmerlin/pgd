package entidades.bugs;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pgd_bugs_detalhes_bug")
public class DetalhesBug {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Lob
	private String descricao;

	private Date dataAcao;
	
	@ManyToOne
	private Bug bug;

	@ManyToOne
	private PrioridadeBug prioridadeBug;
	
	@ManyToOne
	private ImpactoBug impactoBug;
	
	@ManyToOne
	private StatusBug statusBug;
	
	@ManyToOne
	private SistemaAfetado sistemaAfetado;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataAcao() {
		return dataAcao;
	}

	public void setDataAcao(Date dataAcao) {
		this.dataAcao = dataAcao;
	}

	public Bug getBug() {
		return bug;
	}

	public void setBug(Bug bug) {
		this.bug = bug;
	}

	public PrioridadeBug getPrioridadeBug() {
		return prioridadeBug;
	}

	public void setPrioridadeBug(PrioridadeBug prioridadeBug) {
		this.prioridadeBug = prioridadeBug;
	}

	public ImpactoBug getImpactoBug() {
		return impactoBug;
	}

	public void setImpactoBug(ImpactoBug impactoBug) {
		this.impactoBug = impactoBug;
	}

	public StatusBug getStatusBug() {
		return statusBug;
	}

	public void setStatusBug(StatusBug statusBug) {
		this.statusBug = statusBug;
	}

	public SistemaAfetado getSistemaAfetado() {
		return sistemaAfetado;
	}

	public void setSistemaAfetado(SistemaAfetado sistemaAfetado) {
		this.sistemaAfetado = sistemaAfetado;
	}	
	
}
